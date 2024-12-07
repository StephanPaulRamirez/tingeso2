package edu.mtisw.payrollbackend.services;

import edu.mtisw.payrollbackend.entities.LoanRequestEntity;
import edu.mtisw.payrollbackend.repositories.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class LoanRequestService {
    @Autowired
    LoanRequestRepository loanRequestRepository;

    @Autowired
    RestTemplate restTemplate;


    public LoanRequestEntity getLoanRequestById(Long id){
        return loanRequestRepository.findById(id).get();
    }

    public ArrayList<LoanRequestEntity> getLoanRequestByUserRut(String rut){
        return loanRequestRepository.findByUserRut(rut);
    }

    public LoanRequestEntity updateLoanRequest(LoanRequestEntity loanRequest) {
        ResponseEntity<LoanRequestEntity> response = restTemplate.exchange(
                "http://evaluatecredit-service/api/v1/loanEvaluation/",
                HttpMethod.PUT,
                new HttpEntity<>(loanRequest),
                LoanRequestEntity.class
        );
        return response.getBody();
    }


}
