package edu.mtisw.payrollbackend.services;

import edu.mtisw.payrollbackend.entities.LoanRequestEntity;
import edu.mtisw.payrollbackend.repositories.LoanRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanRequestServiceTest {

    @Mock
    private LoanRequestRepository loanRequestRepository;

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
    void testGetLoanRequestById_Success() {
        when(loanRequestRepository.findById(1L)).thenReturn(Optional.of(loanRequest));

        LoanRequestEntity found = loanRequestService.getLoanRequestById(1L);

        assertNotNull(found);
        verify(loanRequestRepository, times(1)).findById(1L);
    }

    @Test
    void testGetLoanRequestById_NotFound() {
        when(loanRequestRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> loanRequestService.getLoanRequestById(1L));
    }

    @Test
    void testGetLoanRequestByUserRut() {
        ArrayList<LoanRequestEntity> loanRequests = new ArrayList<>();
        loanRequests.add(loanRequest);
        when(loanRequestRepository.findByUserRut("12345678-9")).thenReturn(loanRequests);

        List<LoanRequestEntity> result = loanRequestService.getLoanRequestByUserRut("12345678-9");

        assertEquals(1, result.size());
        verify(loanRequestRepository, times(1)).findByUserRut("12345678-9");
    }

    @Test
    void testUpdateLoanRequest() {
        when(loanRequestRepository.save(any(LoanRequestEntity.class))).thenReturn(loanRequest);

        LoanRequestEntity updated = loanRequestService.updateLoanRequest(loanRequest);

        assertNotNull(updated);
        verify(loanRequestRepository, times(1)).save(loanRequest);
    }


}
