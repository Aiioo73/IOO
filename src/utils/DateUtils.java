package utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static Date cleanTime(Date date) {
        return setTime( date, 0, 0, 0, 0 );
    }

    public static Date addDays(Date date, int days) {
        Date newDate = new Date(date.getTime() + 86400000L * days);
        return newDate;
    }

    public static Date addHours(Date date, int hours) {
        Date newDate = new Date(date.getTime() + 60L *60*1000 * hours);
        return newDate;
    }

    public static Date setTime( final Date date, final int hourOfDay, final int minute, final int second, final int ms )
    {
        final GregorianCalendar gc = new GregorianCalendar();
        gc.setTime( date );
        gc.set( Calendar.HOUR_OF_DAY, hourOfDay );
        gc.set( Calendar.MINUTE, minute );
        gc.set( Calendar.SECOND, second );
        gc.set( Calendar.MILLISECOND, ms );
        return gc.getTime();
    }
}
