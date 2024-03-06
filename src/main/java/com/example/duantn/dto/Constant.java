package com.example.duantn.dto;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Constant {
    public static Integer pageNumber = 4;

    public static Date getDateNow() throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = sdf.format(cal.getTime());
        java.util.Date ngayTao = sdf.parse(strDate);
        java.sql.Date ngayTaoSQL =  new java.sql.Date(ngayTao.getTime());
        return ngayTaoSQL;
    }
}
