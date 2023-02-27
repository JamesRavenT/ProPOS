package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import static com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment08_Printer.M04F08_Printer.socket;

import com.wabizabi.wazabipos.Database.ObjectSchemas.SalesTransaction;
import com.wabizabi.wazabipos.Database.ObjectSchemas.Ticket;
import com.wabizabi.wazabipos.Modules.M04_MainActivity.Fragment01_POS.SubFragments.SubFragment03_Cart.Object.CartItem;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;


public class PrintHelper {

    static OutputStream outputStream;

    public static void printTicket(Ticket ticket) throws IOException {
        try {
            //Characters
            String linebreak = "\n";
            String space = new String(new char[5]).replace('\0', ' ');
            String line = new String(new char[32]).replace('\0', '-') + "\n";

            //Details
            double dueTotal = 0.00;
            double discountTotal = 0.00;
            int items = ticket.getItems().values().stream().mapToInt(i->i).sum();

            //Strings
            String companyName = " WABI ZABI SUSHI BAR\n\n" ;
            String billType = "   INVOICE\n";
            String order = "Order : " + ticket.getOrder() + "\n";
            String cashier = "Cashier : " + ticket.getCashier() + "\n";
            String orderType = ticket.getOrderType().toUpperCase() + "\n";
            String header = "Qty" + "  " + "Item" + space + space + space + "Price\n";

            //Buffers
            StringBuffer s = new StringBuffer("\n");
            s.append(space + companyName);
            s.append(space + space + billType);
            s.append(line);
            s.append(order);
            s.append(cashier);
            s.append(line);
            s.append(orderType);
            s.append(line);
            s.append(header);
            s.append(line);
            //For each cart item
            for(Map.Entry<CartItem, Integer> item : ticket.getItems().entrySet()){
                String quantity = StringHelper.getPrinterItemQty("x" + item.getValue());
                String name = StringHelper.getPrinterItemName(item.getKey().getItemPOSName());
                String price = StringHelper.convertToCurrencyNoSign(item.getKey().getItemPrice() * item.getValue());
                s.append(quantity);
                s.append(name);
                //Normal Items
                if(!item.getKey().getItemDiscounts().isEmpty()){
                    double discountedFee = item.getKey().getItemPrice() * item.getValue();
                    for(Map.Entry<String, Integer> discount : item.getKey().getItemDiscounts().entrySet()){
                        double subTotalPrice = item.getKey().getItemPrice() * item.getValue();
                        double discountInDecimal = (double) discount.getValue() / 100;
                        double discountedPrice = subTotalPrice * discountInDecimal;
                        discountedFee -= discountedPrice;
                    }
                    String discountedPrice = StringHelper.convertToCurrencyNoSign(discountedFee);
                    s.append(space + discountedPrice);
                } else {
                    s.append(space + price);
                }
                //Discount Items
                if(!item.getKey().getItemDiscounts().isEmpty()){
                    for(Map.Entry<String, Integer> discount : item.getKey().getItemDiscounts().entrySet()){
                        LogHelper.debug("MEOWWWWWWWWWWWWWWWWWWw");
                        double subTotalPrice = item.getKey().getItemPrice() * item.getValue();
                        double discountInDecimal = (double) discount.getValue() / 100;
                        double discountedPrice = subTotalPrice * discountInDecimal;
                        String dName = "  " + StringHelper.getPrinterItemName(discount.getKey());
                        String dPrice = "  --less " + StringHelper.convertToCurrencyNoSign(discountedPrice);
                        s.append(space);
                        s.append(dName + linebreak);
                        s.append(space);
                        s.append(dPrice);
                        discountTotal += discountedPrice;
                    }
                }
                dueTotal += item.getKey().getItemPrice() * item.getValue();
                s.append(linebreak);
            }
            String amountDue = (ticket.getOrderType().equals("Dine In"))
                             ? "  AMOUNT DUE   " + StringHelper.getPrinterSubAmounts(dueTotal + (dueTotal * 0.03) + (dueTotal * 0.05) - discountTotal)
                             : "  AMOUNT DUE   " + StringHelper.getPrinterSubAmounts(dueTotal + (dueTotal * 0.03) - discountTotal);
            String subTotal = space + "  SubTotal" + StringHelper.getPrinterSubAmounts(dueTotal);
            String tax = space + "  Tax     "  + StringHelper.getPrinterSubAmounts(dueTotal * 0.03);
            String serviceFee = (ticket.getOrderType().equals("Dine In"))
                              ? space + "  Svc Fee " + StringHelper.getPrinterSubAmounts(dueTotal * 0.05)
                              : space + "  Svc Fee " + StringHelper.getPrinterSubAmounts(0.00);
            String discounts = space + "  Discount" + StringHelper.getPrinterSubAmounts(discountTotal);
            String itemQty = "[ "+ items +" ] items in total" + linebreak;
            String dt = ticket.getDateAndTime() + linebreak;
            String footer01 = "   THIS" + space + "IS" + space + "NOT" + space + "AN\n";
            String footer02 = "  AN" + space + "OFFICIAL" + space + "RECEIPT\n";
            s.append(line);
            s.append(amountDue);
            s.append(subTotal);
            s.append(tax);
            s.append(serviceFee);
            s.append(discounts);
            s.append(line);
            s.append(itemQty);
            s.append(dt);
            s.append(line);
            s.append(linebreak);
            s.append(footer01);
            s.append(footer02);
            s.append(linebreak);
            s.append(linebreak);
            s.append(linebreak);
            s.append(linebreak);
            s.append(linebreak);

            String receipt = s.toString();
            LogHelper.debug(receipt);
            outputStream = socket.getOutputStream();
            outputStream.write(receipt.getBytes());
            LogHelper.debug("Printing Text....");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void voidTicket(Ticket ticket){
        try {
            //Characters
            String linebreak = "\n";
            String space = new String(new char[5]).replace('\0', ' ');
            String line = new String(new char[32]).replace('\0', '-') + "\n";

            //Details
            double dueTotal = 0.00;
            double discountTotal = 0.00;
            int items = ticket.getItems().values().stream().mapToInt(i->i).sum();

            //Strings
            String companyName = " WABI ZABI SUSHI BAR\n\n" ;
            String billType = "  ***** VOIDED *****\n";
            String order = "Order : " + ticket.getOrder() + "\n";
            String cashier = "Cashier : " + ticket.getCashier() + "\n";
            String orderType = ticket.getOrderType().toUpperCase() + "\n";
            String header = "Qty" + "  " + "Item" + space + space + space + "Price\n";

            //Buffers
            StringBuffer s = new StringBuffer("\n");
            s.append(space + companyName);
            s.append(space + billType);
            s.append(line);
            s.append(order);
            s.append(cashier);
            s.append(line);
            s.append(orderType);
            s.append(line);
            s.append(header);
            s.append(line);
            //For each cart item
            for(Map.Entry<CartItem, Integer> item : ticket.getItems().entrySet()){
                String quantity = StringHelper.getPrinterItemQty("x" + item.getValue());
                String name = StringHelper.getPrinterItemName(item.getKey().getItemPOSName());
                String price = StringHelper.convertToCurrencyNoSign(item.getKey().getItemPrice() * item.getValue());
                s.append(quantity);
                s.append(name);
                //Normal Items
                if(!item.getKey().getItemDiscounts().isEmpty()){
                    double discountedFee = item.getKey().getItemPrice() * item.getValue();
                    for(Map.Entry<String, Integer> discount : item.getKey().getItemDiscounts().entrySet()){
                        double subTotalPrice = item.getKey().getItemPrice() * item.getValue();
                        double discountInDecimal = (double) discount.getValue() / 100;
                        double discountedPrice = subTotalPrice * discountInDecimal;
                        discountedFee -= discountedPrice;
                    }
                    String discountedPrice = StringHelper.convertToCurrencyNoSign(discountedFee);
                    s.append(space + discountedPrice);
                } else {
                    s.append(space + price);
                }
                //Discount Items
                if(!item.getKey().getItemDiscounts().isEmpty()){
                    for(Map.Entry<String, Integer> discount : item.getKey().getItemDiscounts().entrySet()){
                        LogHelper.debug("MEOWWWWWWWWWWWWWWWWWWw");
                        double subTotalPrice = item.getKey().getItemPrice() * item.getValue();
                        double discountInDecimal = (double) discount.getValue() / 100;
                        double discountedPrice = subTotalPrice * discountInDecimal;
                        String dName = "  " + StringHelper.getPrinterItemName(discount.getKey());
                        String dPrice = "  --less " + StringHelper.convertToCurrencyNoSign(discountedPrice);
                        s.append(space);
                        s.append(dName + linebreak);
                        s.append(space);
                        s.append(dPrice);
                        discountTotal += discountedPrice;
                    }
                }
                dueTotal += item.getKey().getItemPrice() * item.getValue();
                s.append(linebreak);
            }
            String amountDue = (ticket.getOrderType().equals("Dine In"))
                    ? "  AMOUNT DUE   " + StringHelper.getPrinterSubAmounts(dueTotal + (dueTotal * 0.03) + (dueTotal * 0.05) - discountTotal)
                    : "  AMOUNT DUE   " + StringHelper.getPrinterSubAmounts(dueTotal + (dueTotal * 0.03) - discountTotal);
            String subTotal = space + "  SubTotal" + StringHelper.getPrinterSubAmounts(dueTotal);
            String tax = space + "  Tax     "  + StringHelper.getPrinterSubAmounts(dueTotal * 0.03);
            String serviceFee = (ticket.getOrderType().equals("Dine In"))
                    ? space + "  Svc Fee " + StringHelper.getPrinterSubAmounts(dueTotal * 0.05)
                    : space + "  Svc Fee " + StringHelper.getPrinterSubAmounts(0.00);
            String discounts = space + "  Discount" + StringHelper.getPrinterSubAmounts(discountTotal);
            String itemQty = "[ "+ items +" ] items in total" + linebreak;
            String dt = ticket.getDateAndTime() + linebreak;
            String footer01 = "   THIS" + space + "IS" + space + "NOT" + space + "AN\n";
            String footer02 = "  AN" + space + "OFFICIAL" + space + "RECEIPT\n";
            s.append(line);
            s.append(amountDue);
            s.append(subTotal);
            s.append(tax);
            s.append(serviceFee);
            s.append(discounts);
            s.append(line);
            s.append(itemQty);
            s.append(dt);
            s.append(line);
            s.append(linebreak);
            s.append(footer01);
            s.append(footer02);
            s.append(linebreak);
            s.append(linebreak);
            s.append(linebreak);
            s.append(linebreak);
            s.append(linebreak);

            String receipt = s.toString();
            LogHelper.debug(receipt);
            outputStream = socket.getOutputStream();
            outputStream.write(receipt.getBytes());
            LogHelper.debug("Printing Text....");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void printSalesReceipt(SalesTransaction sales) throws IOException {
        try {
            //Characters
            String linebreak = "\n";
            String space = new String(new char[5]).replace('\0', ' ');
            String line = new String(new char[32]).replace('\0', '-') + "\n";

            //Details
            double dueTotal = 0.00;
            double discountTotal = 0.00;
            int items = sales.getItems().values().stream().mapToInt(i->i).sum();

            //Strings
            String companyName = " WABI ZABI SUSHI BAR\n" ;
            String receiptNo = " #" + sales.getTransactionNo() + linebreak;
            String billType = "    SALES RECEIPT\n";
            String order = "Order : " + sales.getOrder() + "\n";
            String cashier = "Cashier : " + sales.getCashier() + "\n";
            String orderType = sales.getOrderType().toUpperCase() + "\n";
            String header = "Qty" + "  " + "Item" + space + space + space + "Price\n";

            //Buffers
            StringBuffer s = new StringBuffer("\n");
            s.append(space + companyName);
            s.append(space + space + receiptNo);
            s.append(space + billType);
            s.append(line);
            s.append(order);
            s.append(cashier);
            s.append(line);
            s.append(orderType);
            s.append(line);
            s.append(header);
            s.append(line);
            for(Map.Entry<CartItem, Integer> item : sales.getItems().entrySet()){
                String quantity = StringHelper.getPrinterItemQty("x" + item.getValue());
                String name = StringHelper.getPrinterItemName(item.getKey().getItemPOSName());
                String price = StringHelper.convertToCurrencyNoSign(item.getKey().getItemPrice() * item.getValue());
                s.append(quantity);
                s.append(name);
                if(!item.getKey().getItemDiscounts().isEmpty()){
                    double discountedFee = item.getKey().getItemPrice() * item.getValue();
                    for(Map.Entry<String, Integer> discount : item.getKey().getItemDiscounts().entrySet()){
                        double subTotalPrice = item.getKey().getItemPrice() * item.getValue();
                        double discountInDecimal = (double) discount.getValue() / 100;
                            double discountedPrice = subTotalPrice * discountInDecimal;
                            discountedFee -= discountedPrice;
                    }
                    String discountedPrice = StringHelper.convertToCurrencyNoSign(discountedFee);
                    s.append(space + discountedPrice);
                } else {
                    s.append(space + price);
                }

                if(!item.getKey().getItemDiscounts().isEmpty()){
                    for(Map.Entry<String, Integer> discount : item.getKey().getItemDiscounts().entrySet()){
                        double subTotalPrice = item.getKey().getItemPrice() * item.getValue();
                        double discountInDecimal = (double) discount.getValue() / 100;
                        double discountedPrice = subTotalPrice * discountInDecimal;
                        String dName = "  " + StringHelper.getPrinterItemName(discount.getKey());
                        String dPrice = "  --less " + StringHelper.convertToCurrencyNoSign(discountedPrice);
                        s.append(space);
                        s.append(dName + linebreak);
                        s.append(space);
                        s.append(dPrice);
                        discountTotal += discountedPrice;
                    }
                }
                dueTotal += item.getKey().getItemPrice() * item.getValue();
                s.append(linebreak);
            }
            //SUB TOTAL
            String subTotal = "  SUBTOTAL     " + StringHelper.getPrinterSubAmounts(dueTotal);
            String tax = space + "  Tax     "  + StringHelper.getPrinterSubAmounts(dueTotal * 0.03);
            String serviceFee = (sales.getOrderType().equals("Dine In"))
                    ? space + "  Svc Fee " + StringHelper.getPrinterSubAmounts(dueTotal * 0.05)
                    : space + "  Svc Fee " + StringHelper.getPrinterSubAmounts(0.00);
            String discounts = space + "  Discount" + StringHelper.getPrinterSubAmounts(discountTotal);
            //TOTAL
            String amountDue = (sales.getOrderType().equals("Dine In"))
                             ? "  TOTAL        " + StringHelper.getPrinterSubAmounts(dueTotal + (dueTotal * 0.03) + (dueTotal * 0.05) - discountTotal)
                             : "  TOTAL        " + StringHelper.getPrinterSubAmounts(dueTotal + (dueTotal * 0.03) - discountTotal);
            String method = space + StringHelper.getPrinterPaymentMethod(sales.getPaymentMethod()) + StringHelper.getPrinterSubAmounts(sales.getTotalPayment());
            String change = space + "  Change  " + StringHelper.getPrinterSubAmounts(sales.getChange()) + linebreak;
            String itemQty = "[ "+ items +" ] items in total" + linebreak;
            String dt = sales.getDateAndTime() + linebreak;
            String footer = space + " ARIGATOU GOZAIMASU!\n";
            s.append(line);
            s.append(subTotal);
            s.append(tax);
            s.append(serviceFee);
            s.append(discounts);
            s.append(line);
            s.append(amountDue);
            s.append(method);
            s.append(change);
            s.append(line);
            s.append(itemQty);
            s.append(dt);
            s.append(line);
            s.append(linebreak);
            s.append(footer);
            s.append(linebreak);
            s.append(linebreak);
            s.append(linebreak);
            s.append(linebreak);
            s.append(linebreak);

            String receipt = s.toString();
            LogHelper.debug(receipt);
            outputStream = socket.getOutputStream();
            outputStream.write(receipt.getBytes());
            LogHelper.debug("Printing Text....");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
