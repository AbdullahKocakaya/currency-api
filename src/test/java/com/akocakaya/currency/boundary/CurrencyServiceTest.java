package com.akocakaya.currency.boundary;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyServiceTest {

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
}
