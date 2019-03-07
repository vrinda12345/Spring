package com.cg.banking.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.TransactionDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.exceptions.TransactionIdNotFoundException;
import com.cg.banking.util.Utility;
@Component("bankingServices")
public class BankingServicesImpl implements BankingServices {
	@Autowired
	AccountDAO accDAOServices;
	@Autowired
	TransactionDAO transDAOServices;

	@Override
	public Account openAccount(Account account)
			throws InvalidAccountTypeException, InvalidAmountException, BankingServicesDownException {

		if(! (account.getAccountType().equals("current") || account.getAccountType().equals("savings"))) 
			throw new InvalidAccountTypeException("Account type is invalid");
		account.setPinNumber(Utility.generatePin());
		account.setAccountStatus("active");
		account = accDAOServices.save(account);
		transDAOServices.save(new Transaction(account, account.getAccountBalanace(), "credited"));
		return account;
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {

		Account account = this.getAccountDetails(accountNo);
		if(this.accountStatus(account.getAccountNo()).equals("blocked"))
			throw new AccountBlockedException("Your account is blocked");
		account.setAccountBalanace(account.getAccountBalanace() + amount);
		account = accDAOServices.save(account);
		Transaction transaction = transDAOServices.save(new Transaction(account, amount, "credited"));
		if(account == null || transaction == null)
			throw new BankingServicesDownException("Bank servers down");
		else
			return account.getAccountBalanace();
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {

		Account account = this.getAccountDetails(accountNo);
		if(!this.accountStatus(account.getAccountNo()).equals("blocked"))
			if(pinNumber == account.getPinNumber())
				if(account.getAccountBalanace() - amount > 0) {
					account.setAccountBalanace(account.getAccountBalanace() - amount);	
					account = accDAOServices.save(account);
					transDAOServices.save(new Transaction(account, amount, "debited"));
					return account.getAccountBalanace();
				}
				else
					throw new InsufficientAmountException("insufficient amount");
			else
				throw new InvalidPinNumberException("Invalid Pin");
		else
			throw new AccountBlockedException("Account blocked");
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {

		this.withdrawAmount(accountNoFrom, transferAmount, pinNumber);
		this.depositAmount(accountNoTo, transferAmount);
		return true;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		return accDAOServices.findById(accountNo).orElseThrow(()->new AccountNotFoundException("This account doesn't exist."));
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		return accDAOServices.findAll();
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		return transDAOServices.findAllTransactions(accountNo);
	}

	@Override
	public Transaction getAccountTransaction(long accountNo, int transId) throws TransactionIdNotFoundException {
		return transDAOServices.findById(transId).orElseThrow(()->new TransactionIdNotFoundException("TransactionId Not Found."));
	}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		return this.getAccountDetails(accountNo).getAccountStatus();
	}

}
