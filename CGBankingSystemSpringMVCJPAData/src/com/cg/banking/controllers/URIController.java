package com.cg.banking.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.banking.beans.Account;

@Controller
public class URIController {
	private Account account;
	public URIController() {
		System.out.println("URIController");
	}

	@RequestMapping("/")
	public String getIndexPage() {
		return "indexPage";
	}

	@RequestMapping("/register")
	public String openAccount() {
		return "registerPage";
	}

	@RequestMapping("/deposit")
	public String depositAmount() {
		return "depositAmountPage";
	}
	
	@RequestMapping("/withdraw")
	public String withdrawAmount() {
		return "withdrawAmountPage";
	}

	@RequestMapping("/fundTransfer")
	public String fundTransferAmount() {
		return "fundTransferPage";
	}
//	
//	@RequestMapping("/getAccountDetails")
//	public String AccountDetails() {
//		return "accountDetailsPage";
//	}

	@ModelAttribute
	public Account getAccount() {
		account = new Account();
		return account;
	}
}