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
    private String forexBuying;

    @XmlElement(name = "ForexSelling")
    private String forexSelling;

    @XmlElement(name = "BanknoteBuying")
    private String banknoteBuying;

    @XmlElement(name = "BanknoteSelling")
    private String banknoteSelling;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getForexBuying() {
        return forexBuying;
    }

    public String getForexSelling() {
        return forexSelling;
    }

    public String getBanknoteBuying() {
        return banknoteBuying;
    }

    public String getBanknoteSelling() {
        return banknoteSelling;
    }

    public String getCurrencyName() {
        return currencyName;
    }
}
