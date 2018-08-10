package com.akocakaya.currency.boundary;

import com.akocakaya.currency.control.CurrencyController;
import com.akocakaya.currency.entity.Currency;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyService {

    @Inject
    CurrencyController currencyController;

    @RequestMapping(value = "/getTodayCurrencies")
    public List<Currency> getTodayCurrencies() {
        return currencyController.getTodayCurrencies();
    }

    @RequestMapping(value = "/getTodayCurrency")
    public Currency getTodayCurrency(@RequestParam(value = "currencyCode") String currencyCode) {
        return currencyController.getTodayCurrency(currencyCode);
    }

    @RequestMapping(value = "/getCurrencies/{date}")
    public List<Currency> getCurrencies(@PathVariable String date) {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
        Date date1 = null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM/ddMMyyyy");
        String urlDate = simpleDateFormat.format(date1);

        return currencyController.getCurrencies(urlDate);
    }

    @RequestMapping(value = "/getCurrency/{date}")
    public Currency getCurrency(@PathVariable String date, @RequestParam(value = "currencyCode") String currencyCode) {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
        Date date1 = null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM/ddMMyyyy");
        String urlDate = simpleDateFormat.format(date1);

        return currencyController.getCurrency(currencyCode, urlDate);
    }
}
