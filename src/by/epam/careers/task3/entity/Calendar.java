package by.epam.careers.task3.entity;

import by.epam.careers.task3.logic.CalendarLogic;

import java.time.LocalDate;
import java.util.*;


public class Calendar {
    private List<Day> calendar;

    {
        calendar = new ArrayList<Day>();
    }

    public Calendar() {
    }

    public Calendar(List<Day> calendar) {
        this.calendar = calendar;
    }

    public void addHoliday(Day day) {
        calendar.add(day);
        CalendarLogic logic = CalendarLogic.getInstance();
        calendar.sort(Comparator.comparing(Calendar.Day::getDate));
        setCalendar(logic.removeRepeat(calendar));
    }

    public void addHoliday(Day ... days) {
        Collections.addAll(calendar, days);
        CalendarLogic logic = CalendarLogic.getInstance();
        calendar.sort(Comparator.comparing(Calendar.Day::getDate));
        setCalendar(logic.removeRepeat(calendar));

    }

    public List<Day> getCalendar() {
        return calendar;
    }

    public void setCalendar(List<Day> calendar) {
        this.calendar = calendar;
    }

    public static class Day {
        private LocalDate date;
        private String description;
        private boolean isDayOff;

        public Day() {
        }

        public Day(LocalDate date, String description) {
            this.date = date;
            this.description = description;
        }

        public Day(LocalDate date, String description, boolean isDayOff) {
            this.date = date;
            this.description = description;
            this.isDayOff = isDayOff;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isDayOff() {
            return isDayOff;
        }

        public void setDayOff(boolean dayOff) {
            isDayOff = dayOff;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Day day = (Day) o;
            return isDayOff == day.isDayOff &&
                    Objects.equals(date, day.date) &&
                    Objects.equals(description, day.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(date, description, isDayOff);
        }

        @Override
        public String toString() {
            return date.getDayOfMonth() +  " " + date.getMonth() + " " +
                    date.getYear() + " - " + description + ", day off " + isDayOff;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar1 = (Calendar) o;
        return Objects.equals(calendar, calendar1.calendar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calendar);
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "calendar=" + calendar +
                '}';
    }
}
