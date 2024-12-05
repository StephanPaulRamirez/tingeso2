package edu.mtisw.payrollbackend.services;

import edu.mtisw.payrollbackend.entities.LoanRequestEntity;
import edu.mtisw.payrollbackend.repositories.LoanRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanRequestServiceTest {

    @Mock
    private LoanRequestRepository loanRequestRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private LoanRequestService loanRequestService;

    private LoanRequestEntity loanRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        loanRequest = new LoanRequestEntity();
        loanRequest.setId(1L);
        loanRequest.setRequestedAmount(100000.0f);
        loanRequest.setPeriod(10.0f);
        loanRequest.setInterestRate(5.0f);
        loanRequest.setClientMonthlyIncome(10000);
    }

    @Test
    void testSaveLoanRequest() {
        Long simulatedMonthlyInstallment = 5000L;
        when(restTemplate.getForObject(anyString(), eq(Long.class))).thenReturn(simulatedMonthlyInstallment);

        when(loanRequestRepository.save(any(LoanRequestEntity.class))).thenReturn(loanRequest);

        LoanRequestEntity savedLoanRequest = loanRequestService.saveLoanRequest(loanRequest);

        assertNotNull(savedLoanRequest);
        assertEquals(5000L, savedLoanRequest.getMonthlyInstallment());
        verify(loanRequestRepository, times(1)).save(loanRequest);
    }



    @Test
    void testGetLoanRequestCosts() {
        loanRequest.setPeriod(20.0f);
        loanRequest.setMonthlyInstallment(632649L);
        loanRequest.setRequestedAmount(100000000.0f);

        Long calculatedCosts = loanRequestService.getLoanRequestCosts(loanRequest);

        assertEquals(164835760, calculatedCosts);
    }

}
