package com.akocakaya.currency.controller;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class DateFormatter {

    public String dateFormatter(String date) {
        if (date.equals("today")) {
            date = yesterday();
        }

        try {
            return new SimpleDateFormat("yyyyMM/ddMMyyyy")
                        .format(new SimpleDateFormat("yyyy-dd-MM")
                        .parse(date));
        } catch (ParseException e) {
            return e.getMessage();
        }
    }

    private String yesterday() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyy-dd-MM").format(calendar.getTime());
    }
}
