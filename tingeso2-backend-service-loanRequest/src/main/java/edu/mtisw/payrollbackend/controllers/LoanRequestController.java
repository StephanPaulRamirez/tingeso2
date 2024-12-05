package edu.mtisw.payrollbackend.controllers;

import edu.mtisw.payrollbackend.entities.LoanRequestEntity;
import edu.mtisw.payrollbackend.services.LoanRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loan_requests")
//@CrossOrigin("*")
public class LoanRequestController {
    @Autowired
    LoanRequestService loanRequestService;

    @PostMapping("/")
    public ResponseEntity<LoanRequestEntity> saveLoanRequest(@RequestBody LoanRequestEntity loanRequest) {
        LoanRequestEntity loanRequestNew = loanRequestService.saveLoanRequest(loanRequest);
        return ResponseEntity.ok(loanRequestNew);
    }

}
