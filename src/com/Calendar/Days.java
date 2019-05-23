package com.Calendar;

public class Days {
    String holidayName;
    int date;
    int MonthNum;

    public Days(int date, int MonthNum) {
// to set which days are holidays
        this.date = date;
        this.MonthNum = MonthNum;
        if (MonthNum == 1 && date == 1)
            holidayName = "New Year's Day";
        else if (MonthNum == 1 && date == 21)
            holidayName = " Martin Luther King,Jr. Birthday";
        else if (MonthNum == 2 && date == 18)
            holidayName = "Washington's Birthday";
        else if (MonthNum == 5 && date == 27)
            holidayName = "Memorial Day";
        else if (MonthNum == 7 && date == 4)
            holidayName = "Independence Day";
        else if (MonthNum == 9 && date == 2)
            holidayName = "Labor Day";
        else if (MonthNum == 10 && date == 14)
            holidayName = "Columbus Day";
        else if (MonthNum == 11 && date == 11)
            holidayName = "Veterans Day";
        else if (MonthNum == 11 && date == 28)
            holidayName = "Thanksgiving Day";
        else if (MonthNum == 12 && date == 25)
            holidayName = "Christmas Day";
        else holidayName = "";
    }

}
