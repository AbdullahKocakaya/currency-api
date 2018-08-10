package com.akocakaya.currency.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement(name = "Currency")
public class Currency {

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date today = new Date();

    @XmlAttribute(name = "CurrencyCode")
    private String currencyCode;

    @XmlElement(name = "CurrencyName")
    private String currencyName;

    @XmlElement(name = "ForexBuying")
    private String value;

    @XmlElement
    private String date = dateFormat.format(today);

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }
}
