package com.cg.payroll.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;

@Controller
public class PayrollServicesContoller {
@Autowired
	private PayrollServices payrollServices;

@RequestMapping("/registerAssociate")
public ModelAndView registerAssociate(@Valid@ModelAttribute Associate associate,
		BindingResult result) {
	if(result.hasErrors()) return new ModelAndView("registrationPage");
	associate=payrollServices.acceptAssociateDetails(associate);
	return new ModelAndView("registrationSuccessPage","associate",associate);
	}

@RequestMapping("/associateDetails")
public ModelAndView getAssociateDetails(@RequestParam int associatedId) throws AssociateDetailsNotFoundException {
	Associate associate=payrollServices.getAssociateDetails(associatedId);
	return new ModelAndView("findAssociateDetailsPage","associate",associate);
	}
}