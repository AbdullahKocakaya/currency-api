package com.akocakaya.currency.control;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateFormatter {

    public String dateFormatter(String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
        Date date1 = null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM/ddMMyyyy");

        return simpleDateFormat.format(date1);
    }
}
