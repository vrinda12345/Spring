package com.cg.payroll.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.payroll.beans.Associate;

@Controller
public class URIController {

	private Associate associate;

	/*@RequestMapping("/")
	public String getIndexPage() {
		return "indexPage";
	}

	@RequestMapping("/registration")
	public String getRegistrationPage() {
		return "registrationPage";
	}	

	@ModelAttribute
	public Associate getAssociate() {
		associate=new Associate();
		return associate;*/
	

	@RequestMapping(value= {"/","index"})
	public String getIndexPage() {
		return "indexPage";
	}
	@RequestMapping("/registration")
	public String getRegistrationPage() {
		return "registrationPage";
	}
	@RequestMapping("/findAssociateDetails")
		public String getFindAssociateDetailsPage() {
		return "findAssociateDetailsPage";
	}
	@ModelAttribute
	public Associate getAssociate() {
		associate=new Associate();
		return associate;
	}
}