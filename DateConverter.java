package ru.mbsl.duplexdx.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Fedor on 21.04.2017.
 * Date converter class
 */

public class DateConverter {
    private static final String TAG = DateConverter.class.getSimpleName();

    public static String getDateServerFormat(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH);
        return format.format(date);
    }

    /**
     * parse server time from string to Date
     *
     * @param date - input server time
     * @return - date like Date format
     */
    public static Date getDateServerFormat(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);

        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * convert server time to user useful format
     *
     * @param date - time from server
     * @return Date like a string in short format dd.MM.yyyy  HH:mm
     */
    public static CharSequence getFullDate(String date) {
        return new SimpleDateFormat("dd.MM.yyyy  HH:mm", Locale.ENGLISH).format(getDateServerFormat(date).getTime() + 3 *60 *60 *1000) ;
    }
    public static String getFullDate(Date date) {
        return new SimpleDateFormat("dd.MM.yyyy  HH:mm", Locale.ENGLISH).format(date.getTime()) ;
    }

    /**
     * convert server time to user useful format
     * @param date- time from server
     * @return Date like a string in short format dd.MM.yyyy
     */

    public static CharSequence getShortDate(String date) {
        return new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(getDateServerFormat(date).getTime());
    }

    public static CharSequence getShortDate(Calendar bdDate) {
        return new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(bdDate.getTime());
    }

    /**
     * convert server time to user useful format
     * @param time - time from server
     * @return - time like a string in short format HH:MM
     */
    public static String getShortTimeHHMM(Calendar time) {
        return new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(time.getTime());
    }

    public static String getShortTimeHHMM(String time) {
        Date date = getDateServerFormat(time);
        return new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(date.getTime());
    }

}
