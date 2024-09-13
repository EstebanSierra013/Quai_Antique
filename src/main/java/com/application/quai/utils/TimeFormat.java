package com.application.quai.utils;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {

  public Date toDate( String strDate ){
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
    Date newDate = null;
    try {
      newDate = df.parse(strDate);      
    } catch (ParseException e) {
      System.err.println(e);
    }
    return newDate;
  }

  public Time toHour( String strTime ){
    Time newHour = null;
    try {
      newHour = Time.valueOf(strTime);      
    } catch (Exception e) {
      System.err.println(e);
    } 
    return newHour;
  }
}
