package com.akocakaya.currency.boundary;

import com.akocakaya.currency.control.CurrencyController;
import com.akocakaya.currency.entity.Currency;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyService {

    @Inject
    CurrencyController currencyController;

    @RequestMapping(value = "/getCurrencies")
    public List<Currency> getCurrencies() {
        return currencyController.getCurrencies();
    }

    @RequestMapping(value = "/getCurrency")
    public Currency getCurrency(@RequestParam(value = "currencyCode") String currencyCode) {
        return currencyController.getCurrency(currencyCode);
    }
}
