package com.akocakaya.currency.boundary;

import com.akocakaya.App;
import com.akocakaya.config.CurrencyList;
import com.akocakaya.currency.entity.Currency;
import com.akocakaya.currency.entity.TarihDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

@RunWith(BlockJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
@WebAppConfiguration
public class CurrencyServiceTest {

    @Autowired
    private WebApplicationContext wac;


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
        TarihDate tarihDate = new TarihDate();
        Currency c1 = new Currency();
        c1.setCurrencyCode("USD");
        c1.setCurrencyName("Dolar");
        c1.setForexSelling("5");
        c1.setForexBuying("5");
        c1.setBanknoteBuying("5");
        c1.setBanknoteSelling("5");

        Currency c2 = new Currency();
        c2.setCurrencyCode("USD");
        c2.setCurrencyName("Dolar");
        c2.setForexSelling("5");
        c2.setForexBuying("5");
        c2.setBanknoteBuying("5");
        c2.setBanknoteSelling("5");

        tarihDate.setCurrencies(Arrays.asList(c1, c2));
        HashMap<String, Currency> hashMap = new HashMap<>();
        hashMap.put(c1.getCurrencyCode(), c1);
        hashMap.put(c2.getCurrencyCode(), c2);

        CurrencyList list = new CurrencyList();

        HashMap<String, Currency> today = list.getCurrencyHashMap("201808/08082018");

        Assert.assertNotNull(today);
    }
}
