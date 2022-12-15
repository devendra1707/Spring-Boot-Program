package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  ///When ever any loan related functionality is needed in FE ==> This controller will be loaded
//by dispatcher servlet
@RequestMapping(value="/loans") //http://localhost:8080/loans ==> LoanController loanObj=ioc.getLoanController();

public class LoanController {


		@RequestMapping(value="/home")
		//http://localhost:8080/loans/home ==>loanObj.homeLoanProcess();
	    public String homeLoanProcess() {
	    	return "Home Loan Processing Section";
	    }


		@RequestMapping(value="/personal") //http://localhost:8080/loans/personal
		 //http://localhost:8080/loans/personal ==> loanObj.personLoanProcess();
		public String personLoanProcess() {
			return "Personal Loan Processing Section";
		}


		@RequestMapping(value="/carloan") //http://localhost:8080/loans/carloan
		 //http://localhost:8080/loans/carloan ==> loanObj.carloanProcess();
		public String carloanProcess() {
			return "Personal Car Loan Processing Section";
		}
}
