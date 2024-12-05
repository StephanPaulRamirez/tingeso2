package edu.mtisw.payrollbackend.services;

import edu.mtisw.payrollbackend.entities.LoanRequestEntity;
import edu.mtisw.payrollbackend.repositories.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoanRequestService {
    @Autowired
    LoanRequestRepository loanRequestRepository;


    public LoanRequestEntity getLoanRequestById(Long id){
        return loanRequestRepository.findById(id).get();
    }

    public ArrayList<LoanRequestEntity> getLoanRequestByUserRut(String rut){
        return loanRequestRepository.findByUserRut(rut);
    }

    public LoanRequestEntity updateLoanRequest(LoanRequestEntity loanRequest) {
        return loanRequestRepository.save(loanRequest);
    }


}
