package com.Calendar;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    //public static Reminders ArrayList taskList = new ArrayList();
    public static List<Reminders> taskList = new ArrayList<Reminders>();

    public static void main(String[] args) {

        //Creating year object.
        Services ser = new Services();
        Year year = ser.CreateYear();

        //Creating display.
        Display display = new Display();
        display.initializeCalendar(year);


    }

}
