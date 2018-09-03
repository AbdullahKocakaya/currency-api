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

        isDateWeekend(date);

        return new SimpleDateFormat("yyyyMM/ddMMyyyy").format(isDateWeekend(date));
    }

    private String yesterday() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyy-dd-MM").format(calendar.getTime());
    }

    private Date isDateWeekend(String date) {
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        while(true) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
                calendar.add(Calendar.DATE, -1);
            else break;
        }
        return calendar.getTime();
    }
}
