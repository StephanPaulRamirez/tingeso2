package edu.mtisw.payrollbackend.controllers;

import edu.mtisw.payrollbackend.services.LoanSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/simulate")
//@CrossOrigin("*")
public class LoanSimulationController {
    @Autowired
    private LoanSimulationService loanSimulationService;

    @GetMapping("/")
    public ResponseEntity<Long> simulateController(@RequestParam Float amount,
                                                   @RequestParam Float period,
                                                   @RequestParam Float rate) {
        Long fee = loanSimulationService.simulate(amount, period, rate);
        return ResponseEntity.ok(fee);
    }

}