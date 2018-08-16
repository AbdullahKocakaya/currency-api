package com.akocakaya.currency.controller;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class DateFormatter {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");

    public String dateFormatter(String date) {
        if (date.equals("today")) {
            date = yesterday();
        }

        Date date1 = null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM/ddMMyyyy");

        return simpleDateFormat.format(date1);
    }

    private String yesterday() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return dateFormat.format(calendar.getTime());
    }
}
