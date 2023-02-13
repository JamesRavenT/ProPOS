package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import com.wabizabi.wazabipos.Utilities.Libraries.Objects.CartItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class StringHelper {

    public static String limitDisplay(String string, int start, int cutoff, int end){
        String display = (string.length() < cutoff) ? string : string.substring(start, Math.min(string.length(), end)) + "...";
        return display;
    }

    public static String convertToCurrency(double price){
        String currency = "₱" + new BigDecimal(price).setScale(2, RoundingMode.HALF_UP).toString();
        return currency;
    }

    public static String shortenCurrency(double price){
        String currency = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP).toString();
        String shortenedCurrency = (currency.length() == 9)
                                 ? "₱" + currency.charAt(0) + currency.charAt(1) + "." + currency.charAt(3) + "K"
                                 : (currency.length() == 10)
                                 ? "₱" + currency.charAt(0) + currency.charAt(1) + currency.charAt(2) + "." + currency.charAt(4) + "K"
                                 : (currency.length() == 11)
                                 ? "₱" + currency.charAt(0) + "." + currency.charAt(1) + "M"
                                 : "₱" + currency;
        return shortenedCurrency;
    }
    public static String convertToCurrencyNoSign(double price){
        String currency = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP).toString() + "\n";
        return currency;
    }
    public static String convertToCurrencyNoSignNoNewLine(double price){
        String currency = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP).toString();
        return currency;
    }

    public static String trim(String string, int end){
        StringBuffer s = new StringBuffer();
        int counter = 0;
        int repetition = 0;
        for(int i = 0; i < string.length() ; i++){
            if(counter == end){
                s.append(string.substring(repetition, Math.min(string.length(), end + 1)));
                repetition += counter;
                counter = 0;
            } else {
                counter++;
            }
        }
        return s.toString();
    }

    public static String getDiscountNames(CartItem item){
       StringBuffer discountName = new StringBuffer();
       discountName.append("");
       for(Map.Entry<String, Integer> discount : item.getItemDiscounts().entrySet()){
           if(discountName.toString().equals("")){
               discountName.append("・" + discount.getKey());
           } else {
               discountName.append("\n・" + discount.getKey());
           }
       }

       return discountName.toString();
    }

    public static String getDiscountPercentage(CartItem item){
        StringBuffer discountPercentage = new StringBuffer();
        discountPercentage.append("");
        for(Map.Entry<String, Integer> discount : item.getItemDiscounts().entrySet()){
            if(discountPercentage.toString().equals("")){
                discountPercentage.append("[" + discount.getValue() + "%]");
            } else {
                discountPercentage.append("\n[" + discount.getValue() + "%]");
            }
        }
        return discountPercentage.toString();
    }

    public static String getDiscountAmount(CartItem item, int quantity){
        StringBuffer discountAmount = new StringBuffer();
        discountAmount.append("");
        double price = item.getItemPrice() * quantity;
        for(Map.Entry<String, Integer> discount : item.getItemDiscounts().entrySet()){
            double discountInDecimal = (double) discount.getValue() / 100;
            double discountPrice = price * discountInDecimal;
            String formattedPrice = convertToCurrency(discountPrice);
            if(discountAmount.toString().equals("")){
                discountAmount.append("less " + formattedPrice);
            } else {
                discountAmount.append("\n less " + formattedPrice);
            }
        }
        return  discountAmount.toString();
    }

    public static String getDiscountedTotal(CartItem item, int quantity){
        double subTotal = item.getItemPrice() * quantity;
        double finalDiscount = 0.00;
        for(Map.Entry<String, Integer> discount : item.getItemDiscounts().entrySet()){
            double discountInDecimal = (double) discount.getValue() / 100;
            finalDiscount += subTotal * discountInDecimal;
        }
        double total = subTotal - finalDiscount;
        String amount = convertToCurrency(total);
        return amount;
    }

    public static String getTableName(String order){
        String name = order.replaceAll("\\d", "");
        StringBuffer s = new StringBuffer(name);
        String tablename = s.deleteCharAt(s.length()-1).toString();
        return tablename;
    }

    public static Integer getTableNumber(String order){
        int number = Integer.parseInt(order.replaceAll("^\\D+", ""));
        return number;
    }

    public static String getTimeLapse(String year, String month, String day, String hour, String minute){

        int currentYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
        int currentMonth = Integer.parseInt(new SimpleDateFormat("M").format(new Date()));
        int currentDay = Integer.parseInt(new SimpleDateFormat("d").format(new Date()));
        int currentHour = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));
        int currentMinute = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
        int ticketYear = Integer.parseInt(year);
        int ticketMonth = Integer.parseInt(month);
        int ticketDay = Integer.parseInt(day);
        int ticketHour = Integer.parseInt(hour);
        int ticketMinute = Integer.parseInt(minute);

        String time = (currentYear > ticketYear)
                    ? currentYear - ticketYear + " year(s) ago"
                    : (currentMonth > ticketMonth)
                    ? currentMonth - ticketMonth + " month(s) ago"
                    : (currentDay > ticketDay)
                    ? currentDay - ticketDay + " day(s) ago"
                    : (currentHour > ticketHour)
                    ? currentHour - ticketHour + " hour(s) ago"
                    : (currentMinute > ticketMinute)
                    ? currentMinute - ticketMinute + " minute(s) ago"
                    : "Just Now";
        return time;
    }

    public static String getPrinterItemQty(String s){
        String text = (s.length() == 4)
                    ? s + " "
                    : (s.length() == 3)
                    ? s + "  "
                    : s + "   ";
        return text;
    }

    public static String getPrinterItemName(String s){
        String text = (s.length() == 15)
                    ? s
                    : (s.length() == 14)
                    ? s + new String(new char[1]).replace('\0', ' ')
                    : (s.length() == 13)
                    ? s + new String(new char[2]).replace('\0', ' ')
                    : (s.length() == 12)
                    ? s + new String(new char[3]).replace('\0', ' ')
                    : (s.length() == 11)
                    ? s + new String(new char[4]).replace('\0', ' ')
                    : (s.length() == 10)
                    ? s + new String(new char[5]).replace('\0', ' ')
                    : (s.length() == 9)
                    ? s + new String(new char[6]).replace('\0', ' ')
                    : (s.length() == 8)
                    ? s + new String(new char[7]).replace('\0', ' ')
                    : (s.length() == 7)
                    ? s + new String(new char[8]).replace('\0', ' ')
                    : (s.length() == 6)
                    ? s + new String(new char[9]).replace('\0', ' ')
                    : (s.length() == 5)
                    ? s + new String(new char[10]).replace('\0', ' ')
                    : (s.length() == 4)
                    ? s + new String(new char[11]).replace('\0', ' ')
                    : (s.length() == 3)
                    ? s + new String(new char[12]).replace('\0', ' ')
                    : (s.length() == 2)
                    ? s + new String(new char[13]).replace('\0', ' ')
                    : (s.length() == 1)
                    ? s + new String(new char[14]).replace('\0', ' ')
                    : s.substring(0, Math.min(s.length(), 15));
        return text;
    }

    public static String getPrinterSubAmounts(double d){
        String amount = convertToCurrencyNoSignNoNewLine(d);
        String text = (amount.length() == 7)
                    ? new String(new char[8]).replace('\0', ' ') + amount
                    : (amount.length() == 6)
                    ? new String(new char[9]).replace('\0', ' ') + amount
                    : (amount.length() == 5)
                    ? new String(new char[10]).replace('\0', ' ') + amount
                    : (amount.length() == 4)
                    ? new String(new char[11]).replace('\0', ' ') + amount
                    : new String(new char[7]).replace('\0', ' ') + amount;
        return text + "\n";
    }

    public static String getPrinterPaymentMethod(String s){
        String text = (s.length() == 1)
                    ? "  " + s + new String(new char[7]).replace('\0', ' ')
                    : (s.length() == 2)
                    ? "  " + s + new String(new char[6]).replace('\0', ' ')
                    : (s.length() == 3)
                    ? "  " + s + new String(new char[5]).replace('\0', ' ')
                    : (s.length() == 4)
                    ? "  " + s + new String(new char[4]).replace('\0', ' ')
                    : (s.length() == 5)
                    ? "  " + s + new String(new char[3]).replace('\0', ' ')
                    : (s.length() == 6)
                    ? "  " + s + new String(new char[2]).replace('\0', ' ')
                    : (s.length() == 7)
                    ? "  " + s + new String(new char[1]).replace('\0', ' ')
                    : "  " + s;
        return text;
    }

    public static String addZero(String s){
        String newString = "0" + s;
        return newString;
    }

    public static String removeZero(String s){
        char newString = s.charAt(1);
        return String.valueOf(newString);
    }
}
