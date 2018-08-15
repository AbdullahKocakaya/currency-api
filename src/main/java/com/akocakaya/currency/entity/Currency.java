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

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setForexBuying(String forexBuying) {
        this.forexBuying = forexBuying;
    }

    public void setForexSelling(String forexSelling) {
        this.forexSelling = forexSelling;
    }

    public void setBanknoteBuying(String banknoteBuying) {
        this.banknoteBuying = banknoteBuying;
    }

    public void setBanknoteSelling(String banknoteSelling) {
        this.banknoteSelling = banknoteSelling;
    }
}
