package com.akocakaya.currency.boundary;

import com.akocakaya.App;
import com.akocakaya.currency.control.CurrencyService;
import com.akocakaya.currency.control.DateFormatter;
import com.akocakaya.currency.entity.Currency;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class CurrencyServiceTest {

    @Autowired
    private CurrencyService currencyService;

    @Test
    public void is_connection_OK() throws IOException {
        // Given
        URL url = new URL("http://www.tcmb.gov.tr/kurlar/today.xml");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // When
        connection.setRequestMethod("GET");
        connection.connect();

        // Then
        Assert.assertEquals(connection.getResponseCode(), HttpStatus.OK.value());
    }

    @Test
    public void should_return_currencies() {
        List<Currency> today = currencyService.getCurrencies("201808/08082018");

        Assert.assertEquals(20, today.size());
    }

       @Test
    public void should_return_currency() {
        Currency currency = currencyService.getCurrency("EUR", "201808/08082018");

        Assert.assertEquals("EUR", currency.getCurrencyCode());
    }
}
