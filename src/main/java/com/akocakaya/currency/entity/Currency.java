package com.akocakaya.currency.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Currency")
public class Currency {

    @XmlAttribute(name = "CurrencyCode")
    private String currencyCode;

    @XmlElement(name = "CurrencyName")
    private String currencyName;

    @XmlElement(name = "ForexBuying")
    private String value;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getValue() {
        return value;
    }
}
