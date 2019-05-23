package com.Calendar;

import java.util.LinkedList;

public class Services {

    public Year CreateYear() {
        Year y2019 = new Year();
        y2019.isLeap = false;
        y2019.yearName = "2019";
        y2019.year = new LinkedList<Month>();



//Creating year object using linked lists.
        for (int i = 0; i < 12; i++) {
            LinkedList<Days> month = new LinkedList<>();
            for (int j = 0; j < 31; j++) {
                Days day = new Days(j + 1, i + 1);
                month.add(day);
            }
            Month mon = new Month(i + 1, month, y2019.isLeap);
            y2019.year.add(mon);
        }

        return y2019;
    }
}
