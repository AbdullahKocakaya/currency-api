package com.akocakaya.currency.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Tarih_Date")
public class TarihDate {

    @XmlElement(name = "Currency")
    private List<Currency> currencies;

    public List<Currency> getCurrencies() {
        return currencies;
    }
}
