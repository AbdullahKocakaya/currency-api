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
    CurrencyList currencyList;

    public List<Currency> getCurrencies() {
        return new ArrayList<>(currencyList.getCurrencyHashMap().values());
    }

    public Currency getCurrency(String currencyCode) {
        return currencyList.getCurrencyHashMap().get(currencyCode);
    }
}
