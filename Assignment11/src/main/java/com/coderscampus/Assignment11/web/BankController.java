package com.coderscampus.Assignment11.web;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Controller
public class BankController {

//	@GetMapping("/transactions")
//	public String getData() {
//		return "transactions";
//	}
//	
//	@GetMapping("/transactions/{transactions")
//	public String postData(@PathVariable Integer Id) {
//		return "transactions";
//	}
	 private final TransactionRepository transactionRepository;

	    public BankController(TransactionRepository transactionRepository) {
	        this.transactionRepository = transactionRepository;
	    }

	    @GetMapping("/transactions")
	    public String getAllTransactions(Model model) {
	        List<Transaction> transactions = transactionRepository.findAll();
	        
	        // Sort transactions in ascending order by date
	        transactions.sort(Comparator.comparing(Transaction::getDate));
	        
	        model.addAttribute("transactions", transactions);
	        return "transactions";
	    }
	}


