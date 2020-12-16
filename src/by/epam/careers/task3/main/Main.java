package by.epam.careers.task3.main;

import by.epam.careers.task3.entity.Calendar;
import by.epam.careers.task3.logic.CalendarLogic;
import by.epam.careers.task3.view.CalendarView;

import java.time.LocalDate;

/**Создать класс Календарь с внутренним классом, с помощью объектов которого
 * можно хранить информацию о выходных и праздничных днях.*/
public class Main {
    public static void main(String[] args) {
        CalendarLogic logic = CalendarLogic.getInstance();
        CalendarView view = CalendarView.getInstance();

        int year = 2021;
        Calendar.Day h1 = new Calendar.Day(LocalDate.of(year, 1, 1),
                "Новый год");
        Calendar.Day h2 = new Calendar.Day(LocalDate.of(year, 1, 7),
                "православное Рождество");
        Calendar.Day h3 = new Calendar.Day(LocalDate.of(year, 3, 8),
                "Международный женский день");
        Calendar.Day h4 = new Calendar.Day(LocalDate.of(year, 4, 28),
                "Радуница (по календарю православной конфессии)");
        Calendar.Day h5 = new Calendar.Day(LocalDate.of(year, 5, 1),
                "Праздник труда");
        Calendar.Day h6 = new Calendar.Day(LocalDate.of(year, 5, 9),
                "День Победы");
        Calendar.Day h7 = new Calendar.Day(LocalDate.of(year, 7, 3),
                "День Независимости Республики Беларусь");
        Calendar.Day h8 = new Calendar.Day(LocalDate.of(year, 11, 7),
                "День Октябрьской революции");
        Calendar.Day h9 = new Calendar.Day(LocalDate.of(year, 12, 25),
                "католическое Рождество", true);

        Calendar calendar = new Calendar();
        calendar.setCalendar(logic.fillCalendar(year));
        calendar.addHoliday(h1, h2, h3, h4, h5, h6, h7, h8, h9);
        view.print(calendar);
    }
}
