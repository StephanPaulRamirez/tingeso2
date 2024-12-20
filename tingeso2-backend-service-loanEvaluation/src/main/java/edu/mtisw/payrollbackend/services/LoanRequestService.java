package edu.mtisw.payrollbackend.services;

import edu.mtisw.payrollbackend.entities.LoanRequestEntity;
import edu.mtisw.payrollbackend.repositories.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class LoanRequestService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoanRequestRepository loanRequestRepository;

    public LoanRequestEntity getLoanRequestById(Long id){
        ResponseEntity<LoanRequestEntity> loanRequest = restTemplate.getForEntity(
                "http://followCredit-service/api/v1/loanTracking/id/"+ id, LoanRequestEntity.class);
        return loanRequest.getBody();
    }

    public ArrayList<LoanRequestEntity> getLoanRequestByUserRut(String rut){
        return restTemplate.exchange(
                "http://followCredit-service/api/v1/loanTracking/rut/" + rut,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ArrayList<LoanRequestEntity>>() {}
        ).getBody();
    }

    public LoanRequestEntity updateLoanRequest(LoanRequestEntity loanRequest) {
        return loanRequestRepository.save(loanRequest);
    }

}
