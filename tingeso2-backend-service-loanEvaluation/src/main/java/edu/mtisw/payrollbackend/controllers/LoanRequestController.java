package edu.mtisw.payrollbackend.controllers;

import edu.mtisw.payrollbackend.entities.LoanRequestEntity;
import edu.mtisw.payrollbackend.services.LoanRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loanEvaluation")
//@CrossOrigin("*")
public class LoanRequestController {

    @Autowired
    LoanRequestService loanRequestService;

    @GetMapping("/rut/{userRut}")
    public ResponseEntity<List<LoanRequestEntity>> getLoanRequestByUserRut(@PathVariable String userRut) {
        List<LoanRequestEntity> loanRequests = loanRequestService.getLoanRequestByUserRut(userRut);
        return ResponseEntity.ok(loanRequests);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<LoanRequestEntity> getLoanRequestById(@PathVariable Long id) {
        LoanRequestEntity loanRequest = loanRequestService.getLoanRequestById(id);
        return ResponseEntity.ok(loanRequest);
    }

    @PutMapping("/")
    public ResponseEntity<LoanRequestEntity> updateLoanRequest(@RequestBody LoanRequestEntity loanRequest){
        LoanRequestEntity loanRequestUpdated = loanRequestService.updateLoanRequest(loanRequest);
        return ResponseEntity.ok(loanRequestUpdated);
    }

}
