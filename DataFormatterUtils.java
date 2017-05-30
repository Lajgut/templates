package ru.mbsl.duplexdx.utilities;

import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kirill on 18.04.2017.
 */

public class DataFormatterUtils {

    private static String startFormat = "dd/MM/yyyy";
    private static String endFormat = "yyyy/MM/dd";
    private static SimpleDateFormat formatterStart = new SimpleDateFormat(startFormat, Locale.US);
    private static SimpleDateFormat formatterEnd = new SimpleDateFormat(endFormat, Locale.US);
    private static Date date;

    /**
     * для записи даты из диалога в едит текст
     *
     * @param data
     * @param myCalendar
     */
    public static void formatTextView(TextView data, Calendar myCalendar) {

        data.setText(formatterEnd.format(myCalendar.getTime()));
    }

    /**
     * Приводим строку к дате, а дату к строке другого формата
     *
     * @param string
     * @return
     */
    public static String StringDataStringFormat(String string) {
        date = new Date();
        try {
            date = formatterStart.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatterEnd.format(date);
    }

    /**
     * для авторизации
     * @param string
     * @return
     */
    public static String AuthVkDataFormatter(String string){
        date = new Date();
        try {
            date = formatterStart.parse(string);
            return formatterEnd.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
