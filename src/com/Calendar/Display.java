package com.Calendar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.View;

public class Display {
    JPanel eventHis;
    JScrollPane eventHistory;
    JPanel body;
    ArrayList<Reminders> delList = new ArrayList<>();
    JComboBox choosecolor;
    Color comboColor;
    JPanel gridpanel;
    public static int gridWidth;
    public static int gridHeight;
    int colSize;
    JRadioButton yearView;
    JRadioButton monthView;
    JRadioButton dayView;
    ButtonGroup header;
    JPanel top;

    public void initializeCalendar(Year year) {

        JFrame jframe = new JFrame("My Calendar");
        jframe.setLayout(new BorderLayout());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //TOP
        JLabel icon = new JLabel();
        JLabel yr = new JLabel("2019");
        yr.setFont(new Font("Serif", Font.BOLD, 30));
        yr.setForeground(Color.WHITE);
        yearView = new JRadioButton("Month");
        yearView.setSelected(true);
        monthView = new JRadioButton("Week");
        dayView = new JRadioButton("Day");

        header = new ButtonGroup();
        header.add(yearView);
        header.add(monthView);
        header.add(dayView);
        top = new JPanel();
        top.setLayout(new FlowLayout());
        //add components to top panel
        top.add(icon);
        top.add(yr);
        top.setSize(10, 1000);
        top.setBackground(Color.black);
        ImageIcon iconLogo = new ImageIcon("Images/scu.png");
        icon.setIcon(iconLogo);
        icon.setHorizontalAlignment(JLabel.CENTER);
        yr.setHorizontalAlignment(JLabel.RIGHT);
        top.add(yearView);
        yearView.setForeground(Color.white);
        top.add(monthView);
        yearView.setSelected(true);

        monthView.setForeground(Color.white);
        top.add(dayView);
        dayView.setForeground(Color.white);


        jframe.add(top);

        yearView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (yearView.isSelected()) {
                    displayCalendar(year, 100, 120, 7);
                }
            }
        });

        dayView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dayView.isSelected()) {
                    displayCalendar(year, 600, 800, 1);

                }
            }
        });

        monthView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (monthView.isSelected()) {
                    displayCalendar(year, 100, 625, 7);
                }
            }
        });

        if (yearView.isSelected()) {
            displayCalendar(year, 100, 120, 7);
        }
    }


    public void displayCalendar(Year year, int gridWidth, int gridHeight, int colSize) {


        Border dateBorder = BorderFactory.createLineBorder(Color.lightGray, 2);
        Border gridBorder = BorderFactory.createLineBorder(Color.BLACK, 2);

        //Frame
        JFrame jframe = new JFrame("My Calendar");
        jframe.setLayout(new BorderLayout());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //custom colours for headers and 1st of the month.
        Color week = new Color(178, 34, 34);
        Color monst = new Color(0, 128, 255);

        //Labels for week.
        JLabel sun = new JLabel("SUN");
        sun.setForeground(week);
        sun.setFont(new Font("IMPACT", Font.PLAIN, 20));

        JLabel mond = new JLabel("MON");
        mond.setForeground(week);
        mond.setFont(new Font("IMPACT", Font.PLAIN, 20));

        JLabel tue = new JLabel("TUE");
        tue.setForeground(week);
        tue.setFont(new Font("IMPACT", Font.PLAIN, 20));

        JLabel wed = new JLabel("WED");
        wed.setForeground(week);
        wed.setFont(new Font("IMPACT", Font.PLAIN, 20));

        JLabel thu = new JLabel("THU");
        thu.setForeground(week);
        thu.setFont(new Font("IMPACT", Font.PLAIN, 20));

        JLabel fri = new JLabel("FRI");
        fri.setForeground(week);
        fri.setFont(new Font("IMPACT", Font.PLAIN, 20));

        JLabel sat = new JLabel("SAT");
        sat.setForeground(week);
        sat.setFont(new Font("IMPACT", Font.PLAIN, 20));

        //Labels for header panel, image and year.


        // Panels in frame.
        JPanel mainerPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));


        JPanel head = new JPanel(new GridLayout(0, 7, 1, 0));
        head.setSize(800, 315);
        head.setBackground(Color.black);

        body = new JPanel(new GridLayout(0, colSize, 1, 1));


        // add calendar headers to head panel
        head.add(sun);
        head.add(mond);
        head.add(tue);
        head.add(wed);
        head.add(thu);
        head.add(fri);
        head.add(sat);

        sun.setHorizontalAlignment(JLabel.CENTER);
        mond.setHorizontalAlignment(JLabel.CENTER);
        tue.setHorizontalAlignment(JLabel.CENTER);
        wed.setHorizontalAlignment(JLabel.CENTER);
        thu.setHorizontalAlignment(JLabel.CENTER);
        fri.setHorizontalAlignment(JLabel.CENTER);
        sat.setHorizontalAlignment(JLabel.CENTER);
        head.setSize(1100, 400);


        //header
        JLabel eventhead = new JLabel("Customize Calendar");
        eventhead.setBounds(140, 10, 1000, 20);
        eventhead.setForeground(week);
        eventhead.setFont(new Font("IMPACT", Font.PLAIN, 20));

        //EVENT NAME
        JLabel eventName = new JLabel("Event Name:");
        eventName.setBounds(10, 50, 100, 50);
        eventName.setForeground(Color.white);

        //EVENT DATE
        JLabel eventDate = new JLabel("Event Date:");
        eventDate.setBounds(150, 50, 100, 50);
        eventDate.setForeground(Color.white);


        JLabel textcolor = new JLabel("Change text color:");
        textcolor.setBounds(10, 200, 300, 15);
        textcolor.setForeground(Color.white);


        JLabel history = new JLabel("History:");
        history.setBounds(5, 270, 100, 50);
        history.setForeground(Color.white);


        JTextField eventNameField = new JTextField();
        eventNameField.setColumns(10);
        eventNameField.setBounds(5, 100, 120, 20);


        DateFormat format = new SimpleDateFormat("mm/dd/yyyy");
        format.setLenient(false);


        JFormattedTextField eventDateField = new JFormattedTextField("MM/DD/YYYY");


        eventDateField.setColumns(10);
        eventDateField.setBounds(145, 100, 120, 20);


        choosecolor = new JComboBox();
        choosecolor.setBounds(5, 220, 310, 25);
        choosecolor.addItem("Choose color");
        choosecolor.addItem("Cyan");
        choosecolor.addItem("Blue");
        choosecolor.addItem("White");
        choosecolor.addItem("Red");
        choosecolor.addItem("Yellow");
        choosecolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (choosecolor.getSelectedItem().toString()) {
                    case "Cyan":
                        comboColor = Color.CYAN;

                        break;

                    case "Blue":
                        comboColor = Color.BLUE;

                        break;
                    case "White":
                        comboColor = Color.WHITE;

                        break;
                    case "Red":
                        comboColor = Color.RED;

                        break;
                    case "Yellow":
                        comboColor = Color.yellow;


                }
            }
        });

        JButton addEvent = new JButton("Add Event");
        addEvent.setBounds(270, 100, 100, 20);
        addEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String[] arr = eventDateField.getText().split("/");
                Reminders rem = new Reminders(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), eventNameField.getText(), choosecolor.getSelectedItem().toString());
                Calendar.taskList.add(rem);
                updateEvent();


            }
        });

        JButton deleteEvent = new JButton("Delete");
        deleteEvent.setBounds(135, 550, 100, 20);
        deleteEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSelectedCheckbox();

                ArrayList<String> deleteList = new ArrayList<>();
                deleteList = getSelectedCheckbox();
                for (int i = 0; i < Calendar.taskList.size(); i++) {
                    if (deleteList.contains(Calendar.taskList.get(i).getReminderName())) {
                        Reminders delReminder = Calendar.taskList.remove(i);
                        delList.add(delReminder);
                        updateEvent();
                    } else
                        continue;

                }


                for (Component c : body.getComponents()) {

                    for (Component cl : ((JPanel) c).getComponents()) {

                        String[] data = ((JLabel) cl).getText().split(" ");

                        int MM = 0;
                        switch (data[0]) {
                            case "Jan":
                                MM = 1;
                                break;
                            case "Feb":
                                MM = 2;
                                break;
                            case "Mar":
                                MM = 3;
                                break;
                            case "Apr":
                                MM = 4;
                                break;
                            case "May":
                                MM = 5;
                                break;
                            case "Jun":
                                MM = 6;
                                break;
                            case "Jul":
                                MM = 7;
                                break;
                            case "Aug":
                                MM = 8;
                                break;
                            case "Sep":
                                MM = 9;
                                break;
                            case "Oct":
                                MM = 10;
                                break;
                            case "Nov":
                                MM = 11;
                                break;
                            case "Dec":
                                MM = 12;
                                break;
                        }


                        int DD = Integer.valueOf(data[1]);


                        for (int i = 0; i < delList.size(); i++) {
                            if (delList.get(i).getMonth() == MM && delList.get(i).getDate() == DD) {

                                ((JPanel) c).removeAll();


                                JLabel newEvents = new JLabel("              " + data[0] + " " + data[1]);
                                if (data[1] == "1") {
                                    newEvents.setForeground(Color.blue);
                                } else newEvents.setForeground(Color.white);
                                ((JPanel) c).add(newEvents, BorderLayout.NORTH);


                            }

                        }


                        break;
                    }

                }


                /***/


            }


        });


        eventHis = new

                JPanel();
        eventHis.setLayout(new

                GridLayout(0, 1, 0, 0));
        eventHis.setPreferredSize(new

                Dimension(10, 10));
        eventHistory = new

                JScrollPane(eventHis);

        eventHistory.setBounds(15, 310, 300, 200);


        JPanel eventPanel = new JPanel();
        eventPanel.setLayout(null);
        eventPanel.setBackground(Color.black);

        eventPanel.add(eventhead);
        eventPanel.add(eventName);
        eventPanel.add(eventDate);
        eventPanel.add(eventNameField);
        eventPanel.add(eventDateField);
        eventPanel.add(addEvent);
        eventPanel.add(textcolor);
        eventPanel.add(choosecolor);
        eventPanel.add(history);
        eventPanel.add(eventHistory);
        eventPanel.add(deleteEvent);

        // loop to get first two grids blank and start from tuesday.
        body.setBorder(gridBorder);
        for (
                int i = 1;
                i < 3; i++) {
            JPanel gridpanel1 = new JPanel();
            gridpanel1.setBackground(Color.black);

            body.add(gridpanel1, BorderLayout.CENTER);

        }


        //loop to fill labels with dates via year object.

        for (
                int i = 0; i < year.year.size(); i++) {

            Month mon = year.year.get(i);

            for (int j = 0; j < mon.endDate; j++) {
                Days day = mon.month.get(j);
                gridpanel = new JPanel();
                gridpanel.setLayout(new BorderLayout());
                gridpanel.setBackground(Color.BLACK);
                gridpanel.setBorder(BorderFactory.createLineBorder(Color.white));


                String disp = mon.monthName.substring(0, 3) + " " + day.date;
                String holiday = "";


                //check if day is holiday
                if (!day.holidayName.isEmpty()) {
                    holiday = day.holidayName;
                }

                JLabel date = new JLabel(disp);
                date.setForeground(Color.white);
                gridpanel.add(date, BorderLayout.NORTH);

                JLabel holi = new JLabel(holiday);
                holi.setForeground(Color.white);
                gridpanel.add(holi, BorderLayout.CENTER);


                // if date is 1 and its a holiday

                if (j == 0) {
                    date.setForeground(monst);
                    JLabel Holiday = new JLabel(day.holidayName);
                    Holiday.setForeground(Color.orange);
                    holi.add(Holiday);


                }
                //change colour for holiday
                if (!day.holidayName.isEmpty()) {
                    date.setForeground(Color.orange);
                }
                //format the dates in the label
                date.setHorizontalAlignment(JLabel.CENTER);
                holi.setHorizontalAlignment(JLabel.CENTER);


                gridpanel.setPreferredSize(new Dimension(gridWidth, gridHeight));


                body.add(gridpanel, BorderLayout.NORTH);
                body.setBorder(gridBorder);
                body.setBackground(Color.BLACK);
            }


        }
        //add frame and panels

        JScrollPane jsScrollPane = new JScrollPane(body);

        JPanel mainerpanel = new JPanel();
        mainerpanel.setLayout(new

                BoxLayout(mainerpanel, BoxLayout.Y_AXIS));

        JPanel subMainPanel = new JPanel();
        subMainPanel.setLayout(new

                BoxLayout(subMainPanel, BoxLayout.Y_AXIS));

        jframe.add(mainerpanel);
        mainerpanel.add(top);
        mainerpanel.add(mainPanel);

        mainPanel.add(subMainPanel);
        mainPanel.add(eventPanel);

        subMainPanel.add(head);
        subMainPanel.add(jsScrollPane);


        jframe.setSize(1600, 1000);
        jframe.setVisible(true);
    }

    public void updateEvent() {

        eventHis.removeAll();
        eventHis.repaint();
        eventHis.revalidate();
        for (int i = 0; i < Calendar.taskList.size(); i++) {


            JCheckBox eventCheckBox = new JCheckBox(Calendar.taskList.get(i).getReminderName() + "," + Calendar.taskList.get(i).getMonth() + "/" + Calendar.taskList.get(i).getDate() + "/" + Calendar.taskList.get(i).getYear());
            //System.out.println("inside update event");

            eventHis.add(eventCheckBox);
        }
        ArrayList<Integer> eventList = new ArrayList<Integer>();

        for (Component c : body.getComponents()) {
            for (Component cl : ((JPanel) c).getComponents()) {

                String[] data = ((JLabel) cl).getText().split(" ");

                int MM = 0;
                switch (data[0]) {
                    case "Jan":
                        MM = 1;

                        break;
                    case "Feb":
                        MM = 2;

                        break;
                    case "Mar":
                        MM = 3;

                        break;
                    case "Apr":
                        MM = 4;

                        break;
                    case "May":
                        MM = 5;

                        break;
                    case "Jun":
                        MM = 6;

                        break;
                    case "Jul":
                        MM = 7;

                        break;
                    case "Aug":
                        MM = 8;

                        break;
                    case "Sep":
                        MM = 9;

                        break;
                    case "Oct":
                        MM = 10;

                        break;
                    case "Nov":
                        MM = 11;

                        break;
                    case "Dec":
                        MM = 12;

                        break;


                }

                int DD = Integer.valueOf(data[1]);


                for (int i = 0; i < Calendar.taskList.size(); i++) {
                    if (Calendar.taskList.get(i).getMonth() == MM && Calendar.taskList.get(i).getDate() == DD) {

                        JLabel newEvents = new JLabel(Calendar.taskList.get(i).getReminderName());
                        newEvents.setForeground(comboColor);
                        ((JPanel) c).add(newEvents, BorderLayout.NORTH);

                    }

                }


                break;
            }

        }


    }

    public ArrayList getSelectedCheckbox() {
        ArrayList<String> eventNameCheck = new ArrayList<>();
        for (
                Component c : eventHis.getComponents()) {
            if ((c instanceof JCheckBox) && ((JCheckBox) c).isSelected()) {
                String[] ReminderName1 = ((JCheckBox) c).getText().split(",");
                eventNameCheck.add(ReminderName1[0]);
            }


        }
        return eventNameCheck;

    }

}