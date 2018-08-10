package com.akocakaya.currency.control;

import com.akocakaya.config.CurrencyList;
import com.akocakaya.currency.entity.Currency;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyController {

    @Inject
    private CurrencyList currencyList;

    public List<Currency> getTodayCurrencies() {
        return new ArrayList<>(currencyList.getCurrencyHashMap("today").values());
    }

    public Currency getTodayCurrency(String currencyCode) {
        return currencyList.getCurrencyHashMap("today").get(currencyCode);
    }

    public Currency getCurrency(String currencyCode, String date) {
        return currencyList.getCurrencyHashMap(date).get(currencyCode);
    }

    public List<Currency> getCurrencies(String date) {
        return new ArrayList<>(currencyList.getCurrencyHashMap(date).values());
    }
}
