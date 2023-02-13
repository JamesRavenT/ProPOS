package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

public class DateHelper {

    public static String getMonthName(String month){
        String newMonth = (month.equals("01"))
                ? "January"
                : (month.equals("02"))
                ? "February"
                : (month.equals("03"))
                ? "March"
                : (month.equals("04"))
                ? "April"
                : (month.equals("05"))
                ? "May"
                : (month.equals("06"))
                ? "June"
                : (month.equals("07"))
                ? "July"
                : (month.equals("08"))
                ? "August"
                : (month.equals("09"))
                ? "September"
                : (month.equals("10"))
                ? "October"
                : (month.equals("11"))
                ? "November"
                : (month.equals("12"))
                ? "December"
                : null;
        return newMonth;
    }

    public static String getMonthNo(String month){
        String newMonth = (month.equals("January"))
                ? "01"
                : (month.equals("February"))
                ? "02"
                : (month.equals("March"))
                ? "03"
                : (month.equals("April"))
                ? "04"
                : (month.equals("May"))
                ? "05"
                : (month.equals("June"))
                ? "06"
                : (month.equals("July"))
                ? "07"
                : (month.equals("August"))
                ? "08"
                : (month.equals("September"))
                ? "09"
                : (month.equals("October"))
                ? "10"
                : (month.equals("November"))
                ? "11"
                : (month.equals("December"))
                ? "12"
                : null;
        return newMonth;
    }

    public static String getSubMonth(String month){
        String newMonth = (month.equals("January"))
                        ? "December"
                        : (month.equals("February"))
                        ? "January"
                        : (month.equals("March"))
                        ? "February"
                        : (month.equals("April"))
                        ? "March"
                        : (month.equals("May"))
                        ? "April"
                        : (month.equals("June"))
                        ? "May"
                        : (month.equals("July"))
                        ? "June"
                        : (month.equals("August"))
                        ? "July"
                        : (month.equals("September"))
                        ? "August"
                        : (month.equals("October"))
                        ? "September"
                        : (month.equals("November"))
                        ? "October"
                        : (month.equals("December"))
                        ? "November"
                        : null;
        return newMonth;
    }

    public static String getAddMonth(String month){
        String newMonth = (month.equals("January"))
                ? "February"
                : (month.equals("February"))
                ? "March"
                : (month.equals("March"))
                ? "April"
                : (month.equals("April"))
                ? "May"
                : (month.equals("May"))
                ? "June"
                : (month.equals("June"))
                ? "July"
                : (month.equals("July"))
                ? "August"
                : (month.equals("August"))
                ? "September"
                : (month.equals("September"))
                ? "October"
                : (month.equals("October"))
                ? "November"
                : (month.equals("November"))
                ? "December"
                : (month.equals("December"))
                ? "January"
                : null;
        return newMonth;
    }

    public static Integer getDaysCount(String month){
        int days = (month.equals("February"))
                 ? 29
                 : (month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November"))
                 ? 30
                 : 31;
        return days;
    }
}
