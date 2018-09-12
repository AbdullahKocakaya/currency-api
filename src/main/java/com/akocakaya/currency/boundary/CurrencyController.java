package com.akocakaya.currency.boundary;

import com.akocakaya.currency.controller.CurrencyService;
import com.akocakaya.currency.controller.DateFormatter;
import com.akocakaya.currency.entity.Currency;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {

    @Inject
    private CurrencyService currencyService;

    @Inject
    private DateFormatter dateFormatter;

    @CrossOrigin(origins = "*")//Access-Control-Allow-Origin http://127.0.0.1:5500
    @RequestMapping(value = "/getCurrencies/{date}")
    public List<Currency> getCurrencies(@PathVariable String date) {
        return currencyService.getCurrencies(dateFormatter.dateFormatter(date));
    }

    @CrossOrigin(origins = "*")//Access-Control-Allow-Origin http://127.0.0.1:5500
    @RequestMapping(value = "/getCurrency/{date}")
    public Currency getCurrency(@PathVariable String date, @RequestParam(value = "currencyCode") String currencyCode) {
        return currencyService.getCurrency(currencyCode, dateFormatter.dateFormatter(date));
    }
}
