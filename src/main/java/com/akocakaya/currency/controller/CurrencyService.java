package com.akocakaya.currency.controller;

import com.akocakaya.config.CurrencyList;
import com.akocakaya.currency.entity.Currency;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {

    @Inject
    private CurrencyList currencyList;

    private RestTemplate restTemplate;

    public CurrencyService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Currency getCurrency(String currencyCode, String date) {
        return currencyList.getCurrencyHashMap(date).get(currencyCode);
    }

    public List<Currency> getCurrencies(String date) {
        return new ArrayList<>(currencyList.getCurrencyHashMap(date).values());
    }
}
