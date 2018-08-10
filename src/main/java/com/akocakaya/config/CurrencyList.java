package com.akocakaya.config;

import com.akocakaya.currency.entity.Currency;
import com.akocakaya.currency.entity.TarihDate;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

@Configuration
public class CurrencyList {

    public HashMap<String, Currency> getCurrencyHashMap(String date) {

        String xmlPath = "http://www.tcmb.gov.tr/kurlar/" + date +".xml";

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TarihDate.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            TarihDate tarihDate = (TarihDate) unmarshaller.unmarshal(new URL(xmlPath));

            HashMap<String, Currency> currencyHashMap = new HashMap<>();

            for (int i = 0; i < tarihDate.getCurrencies().size(); i++) {
                currencyHashMap.put(tarihDate.getCurrencies().get(i).getCurrencyCode(), tarihDate.getCurrencies().get(i));
            }

            return currencyHashMap;

        } catch (JAXBException | MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
