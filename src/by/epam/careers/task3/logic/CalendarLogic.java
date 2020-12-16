package by.epam.careers.task3.logic;

import by.epam.careers.task3.entity.Calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalendarLogic {
    private static CalendarLogic instance;

    private CalendarLogic() {
    }

    public static CalendarLogic getInstance() {
        if (instance == null) {
            instance = new CalendarLogic();
        }
        return instance;
    }

    public List<Calendar.Day> fillCalendar(int year) {
        List<Calendar.Day> calendar = new ArrayList<Calendar.Day>();
        LocalDate date = LocalDate.of(year, 1, 1);
        while (date.getYear() == year) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                calendar.add(new Calendar.Day(date, DayOfWeek.SATURDAY.name().toLowerCase(), true));
            }
            else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                calendar.add(new Calendar.Day(date, DayOfWeek.SUNDAY.name().toLowerCase(), true));
            }
            else {
                calendar.add(new Calendar.Day(date, date.getDayOfWeek().name().toLowerCase()));
            }
            date = date.plusDays(1);
        }
        calendar.sort(Comparator.comparing(Calendar.Day::getDate));
        return calendar;
    }

    public List<Calendar.Day> removeRepeat(List<Calendar.Day> calendar) {
        List<Calendar.Day> sort = new ArrayList<Calendar.Day>(calendar);
        for (int i = 0; i < sort.size() - 1; i++) {
            if (sort.get(i).getDate().getDayOfMonth() ==
                    sort.get(i + 1).getDate().getDayOfMonth()) {
                sort.get(i).setDescription(sort.get(i).getDescription() +
                        ", " + sort.get(i + 1).getDescription());
                sort.get(i).setDayOff(true);
                sort.remove(i + 1);
                i--;
            }
        }
        return sort;
    }
}
