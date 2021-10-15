package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo.currency;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepo extends JpaRepository<Currency, Long> {

    Currency findByBaseCurrency(String baseCurrency);

    Optional<Currency> findByNameCurrency(String currency);
}
