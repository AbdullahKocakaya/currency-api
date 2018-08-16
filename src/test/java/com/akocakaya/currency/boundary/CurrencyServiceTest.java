package com.akocakaya.currency.boundary;

import com.akocakaya.App;
import com.akocakaya.config.CurrencyList;
import com.akocakaya.currency.controller.CurrencyService;
import com.akocakaya.currency.entity.Currency;
import com.akocakaya.currency.entity.TarihDate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.client.ResponseCreator;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
//@RestClientTest(CurrencyList.class)
@AutoConfigureMockMvc
public class CurrencyServiceTest {

    @Autowired
    private CurrencyService currencyService;

    //@Autowired
  //  private MockRestServiceServer server;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://www.tcmb.gov.tr/kurlar/today.xml"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("asd"));
    }

    //@Before
    public void setUp() throws IOException {
        String xml =
                "<Tarih_Date Tarih=\"22.06.2018\" Date=\"06/22/2018\"  Bulten_No=\"2018/120\" >" +
                "   <Currency CrossOrder=\"0\" Kod=\"USD\" CurrencyCode=\"USD\">" +
                "      <Unit>1</Unit>" +
                "      <Isim>ABD DOLARI</Isim>" +
                "      <CurrencyName>US DOLLAR</CurrencyName>" +
                "      <ForexBuying>4.7077</ForexBuying>" +
                "      <ForexSelling>4.7162</ForexSelling>" +
                "      <BanknoteBuying>4.7044</BanknoteBuying>" +
                "      <BanknoteSelling>4.7233</BanknoteSelling>" +
                "      <CrossRateUSD/>" +
                "      <CrossRateOther/>" +
                "   </Currency>" +
                "</Tarih_Date>";

        XmlMapper mapper = new XmlMapper();

        Currency currency = mapper.readValue(xml, Currency.class);

       // this.server.expect((RequestMatcher) currencyService.getCurrencies("201808/08082018")).andRespond((ResponseCreator) currency);
    }

    //@Test
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

   // @Test
    public void should_return_currencies() {
        List<Currency> today = currencyService.getCurrencies("201808/08082018");

        Assert.assertEquals(20, today.size());
    }

    //@Test
    public void should_return_currency() {
        Currency currency = currencyService.getCurrency("EUR", "201808/08082018");

        Assert.assertEquals("EUR", currency.getCurrencyCode());
    }
}
