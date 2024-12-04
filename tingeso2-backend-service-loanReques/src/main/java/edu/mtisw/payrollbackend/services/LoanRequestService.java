package edu.mtisw.payrollbackend.services;

import edu.mtisw.payrollbackend.entities.LoanRequestEntity;
import edu.mtisw.payrollbackend.repositories.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class LoanRequestService {
    @Autowired
    LoanRequestRepository loanRequestRepository;

    @Autowired
    RestTemplate restTemplate;

    public LoanRequestEntity saveLoanRequest(LoanRequestEntity loanRequest) {

        ResponseEntity<Long> simulation = restTemplate.getForEntity(
                "http://simulate-service/api/v1/simulate/?amount=" +
                        loanRequest.getRequestedAmount() +
                         "&period=" +
                        loanRequest.getPeriod() +
                        "&rate=" +
                        loanRequest.getInterestRate(),
                Long.class);

        loanRequest.setMonthlyInstallment(simulation.getBody());
        loanRequest.setFinalCosts(getLoanRequestCosts(loanRequest));
        Long ratio = Math.round((loanRequest.getMonthlyInstallment() /
                (float)loanRequest.getClientMonthlyIncome()) * 100D);
        loanRequest.setRatio(ratio);
        return loanRequestRepository.save(loanRequest);
    }


    public Long getLoanRequestCosts(LoanRequestEntity loanRequest) {
        double period = loanRequest.getPeriod();
        long monthlyInstallment = loanRequest.getMonthlyInstallment();
        double requestedAmount = loanRequest.getRequestedAmount();

        double desgravamenInsurance = requestedAmount * 0.0003;
        long fireInsurance = 20000L;
        double administrationFee = requestedAmount * 0.01;
        double monthlyCost = monthlyInstallment + desgravamenInsurance + fireInsurance;

        double totalCost = (monthlyCost * (period * 12)) + administrationFee;

        return Math.round(totalCost);
    }


}
