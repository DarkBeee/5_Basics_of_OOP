package by.epam.careers.task3.view;

import by.epam.careers.task3.entity.Calendar;

public class CalendarView {
    private static CalendarView instance;

    private CalendarView() {
    }

    public static CalendarView getInstance() {
        if (instance == null) {
            instance = new CalendarView();
        }
        return instance;
    }

    public void print(Calendar calendar) {
        System.out.println("Календарь на " +
                calendar.getCalendar().get(0).getDate().getYear() + " год");
        for (Calendar.Day day : calendar.getCalendar()) {
            System.out.println(day.toString());
        }
    }
}
