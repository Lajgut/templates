package ru.mbsl.duplexdx.utilities;

import android.util.Log;

/**
 * Created by Kirill on 19.04.2017.
 */

public class MsgConsole {

    public static void printlnDebug(String msg) {

        Log.d("debug_tag", "---------------ОТЛАДОЧНОЕ СООБЩЕНИЕ---------------");
        Log.d("debug_tag", "---------------------" + msg + "---------------------");
        Log.d("debug_tag", "---------------------------------------------------");
    }

    public static void printlnErr(String msg) {

        Log.d("error_message", "<---------------СООБЩЕНИЕ ОБ ОШИБКЕ--------------->");
        Log.d("error_message", "<---------------------" + msg + "--------------------->");
        Log.d("error_message", "<--------------------------------------------------->");
    }

    public static void printlnErr(Throwable e) {

        Log.d("error_throwable", "<---------------СООБЩЕНИЕ ОБ ОШИБКЕ--------------->");
        Log.d("error_throwable", "<---------------------" + e + "--------------------->");
        Log.d("error_throwable", "<--------------------------------------------------->");
    }
}
