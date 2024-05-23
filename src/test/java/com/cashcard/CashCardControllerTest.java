package com.cashcard;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class CashCardControllerTest {

    @Test
    public void findById_returns_cashcard_given_id() {
        Long requestedId = 0L;
        String name = "Nesrin";
        double amount = 100.00;

        CashCardRepository mockCashCardRepository = Mockito.mock(CashCardRepository.class);
        when(mockCashCardRepository.findByIdAndOwner(requestedId, name))
                .thenReturn(new CashCard(requestedId, amount, name));

        CashCardController classInTest = new CashCardController(mockCashCardRepository);

        Principal principal = Mockito.mock(Principal.class);
        when(principal.getName()).thenReturn(name);

        ResponseEntity<CashCard> response = classInTest.findById(requestedId, principal);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        CashCard cashCard = response.getBody();
        assertThat(cashCard.id()).isEqualTo(requestedId);
        assertThat(cashCard.owner()).isEqualTo(name);
        Mockito.verify(mockCashCardRepository, Mockito.times(1)).
                findByIdAndOwner(requestedId, name);
    }

    @Test
    public void findById_returns_notfound_when_id_notfound() {
        CashCardRepository mockCashCardRepository = Mockito.mock(CashCardRepository.class);
        when(mockCashCardRepository.findByIdAndOwner(anyLong(), anyString()))
                .thenReturn(null);

        CashCardController classInTest = new CashCardController(mockCashCardRepository);
        Principal principal = Mockito.mock(Principal.class);
        when(principal.getName()).thenReturn("");
        ResponseEntity<CashCard> response = classInTest.findById(0L, principal);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(404));

    }

}