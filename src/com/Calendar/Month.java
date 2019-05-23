package com.Calendar;

import java.util.LinkedList;

public class Month {
    String monthName;
    int endDate;
    boolean isleap;


    LinkedList<Days> month;

    public Month(int MonthNo, LinkedList<Days> month, boolean isleap) {

//to check the number of days in a month.
        switch (MonthNo) {
            case 1:
                this.monthName = "January";
                this.endDate = 31;
                break;
            case 2:
                this.monthName = "February";
                if (isleap) {
                    this.endDate = 29;
                }
                this.endDate = 28;
                break;
            case 3:
                this.monthName = "March";
                this.endDate = 31;
                break;
            case 4:
                this.monthName = "April";
                this.endDate = 30;
                break;
            case 5:
                this.monthName = "May";
                this.endDate = 31;
                break;
            case 6:
                this.monthName = "June";
                this.endDate = 30;
                break;
            case 7:
                this.monthName = "July";
                this.endDate = 31;
                break;
            case 8:
                this.monthName = "August";
                this.endDate = 31;
                break;
            case 9:
                this.monthName = "September";
                this.endDate = 30;
                break;
            case 10:
                this.monthName = "October";
                this.endDate = 31;
                break;
            case 11:
                this.monthName = "November";
                this.endDate = 30;
                break;
            case 12:
                this.monthName = "December";
                this.endDate = 31;
                break;

        }

        this.month = month;


    }

}



