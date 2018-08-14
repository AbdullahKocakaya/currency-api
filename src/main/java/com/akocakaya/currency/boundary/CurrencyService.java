package com.akocakaya.currency.boundary;

import com.akocakaya.currency.control.CurrencyController;
import com.akocakaya.currency.control.DateFormatter;
import com.akocakaya.currency.entity.Currency;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyService {

    @Inject
    private CurrencyController currencyController;

    @Inject
    private DateFormatter dateFormatter;

    @RequestMapping(value = "/getCurrencies/{date}")
    public List<Currency> getCurrencies(@PathVariable String date) {
        return currencyController.getCurrencies(dateFormatter.dateFormatter(date));
    }

    @RequestMapping(value = "/getCurrency/{date}")
    public Currency getCurrency(@PathVariable String date, @RequestParam(value = "currencyCode") String currencyCode) {
        return currencyController.getCurrency(currencyCode, dateFormatter.dateFormatter(date));
    }
}
