     package com.cg.banking.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;

@Controller
public class BankingServicesContoller {
	@Autowired
	private BankingServices services;

	@RequestMapping("registerAccount")
	public ModelAndView registerAccount(@ModelAttribute Account account) throws InvalidAccountTypeException, InvalidAmountException, BankingServicesDownException {
		account = services.openAccount(account);
		return new ModelAndView("registrationSuccessPage", "account", account);
	}
	
	@RequestMapping("depositAmount")
	public ModelAndView depositAmount(@RequestParam long accountNo,@RequestParam float amount) throws InvalidAccountTypeException, InvalidAmountException, BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
	float account = services.depositAmount(accountNo,amount);
		return new ModelAndView("depositAmountPage", "account",account );
	}
	
	@RequestMapping("withdrawAmount")
	public ModelAndView withdrawAmount(@RequestParam long accountNo,@RequestParam float amount,@RequestParam int pinNumber) throws InvalidAccountTypeException, InvalidAmountException, BankingServicesDownException, AccountNotFoundException, AccountBlockedException, InsufficientAmountException, InvalidPinNumberException {
	float account = services.withdrawAmount(accountNo,amount,pinNumber);
		return new ModelAndView("withdrawAmountPage", "account",account );
	}
	@RequestMapping("fundTransferAmount")
	public ModelAndView fundTransfer(@RequestParam long accountNoTo,@RequestParam long accountNoFrom,@RequestParam float transferAmount,@RequestParam int pinNumber) throws InvalidAccountTypeException, InvalidAmountException, BankingServicesDownException, AccountNotFoundException, AccountBlockedException, InsufficientAmountException, InvalidPinNumberException {
	boolean account = services.fundTransfer(accountNoTo,accountNoFrom,transferAmount,pinNumber);
		return new ModelAndView("fundTransferPage", "account",account );
	}
}