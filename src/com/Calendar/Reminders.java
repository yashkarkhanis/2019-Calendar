package com.Calendar;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Reminders {

    private int month;
    private int date;
    private int year;
    private String reminderName;
    private String textColor;


        public Reminders(int month,int date,int year, String reminderName,String textColor){
            this.month=month;
            this.date=date;
            this.year=year;
            this.reminderName=reminderName;
            this.textColor=textColor;
        }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public int getYear() {
        return year;
    }

    public String getReminderName() {
        return reminderName;
    }

    public String getTextColor() {
        return textColor;
    }


}
//reminders.tasklist

