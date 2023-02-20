package com.wabizabi.wazabipos.Utilities.Testing;

import android.os.Handler;

import com.wabizabi.wazabipos.Database.Instances.OpenDiscountInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenMenuInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmSalesTransaction;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class TestData {

    public static void preloadProducts() {
        //CATEGORIES
        String[] categories = {
                "Sashimi and Nigiri",
                "Salad",
                "Sushi Rolls",
                "Sushi Platter",
                "Noodles",
                "Deep fried",
                "Donburi",
                "Drinks",
                "Dessert"
        };

        //ITEMS PER CATEGORY
        //Sashimi and Nigiri [4]
        String[] SashimiAndNigiri = {
                "California Maki",
                "nigiri salmon",
                "Salmon sashimi",
                "Tuna Sashimi"
        };

        String[] SashimiAndNigiriPOS = {
                "Cal Maki",
                "Nig salmon",
                "Sal sashimi",
                "Tuna Sashimi"
        };

        //Salad [3]
        String[] Salad = {
                "Kani Salad",
                "Salad Wrap",
                "Sea weeds Salad"
        };

        String[] SaladPOS = {
                "Kani Sld",
                "Sld Wrap",
                "SWeed Salad"
        };

        //Sushi Rolls [9]
        String[] SushiRolls = {
                "3 Cheese Crispy Kani Roll",
                "Aburi Salmon Roll",
                "Crispy Philly Roll",
                "Fried Futomaki Roll",
                "Salmon & Shrimp Tempura Roll",
                "Salmon Lovers Roll",
                "Tuna Salmon Dynamite Roll",
                "Tuna Tataki Roll",
                "Yuzu Creamy Salmon Roll"
        };

        String[] SushiRollsPOS = {
                "3 Ch.CK Roll",
                "Ab Salmon Roll",
                "Cpy Philly Roll",
                "Futomaki Roll",
                "SS Temp Roll",
                "SL Roll",
                "TS Dynamite Roll",
                "TT Roll",
                "Yuzu CS Roll"

        };

        //Sushi Platter [4]
        String[] SushiPlatter = {
                "All Fried Sushi Platter",
                "Chef's Special Sushi Platter",
                "Deluxe Sushi Platter",
                "Premium Sushi Set"
        };

        String[] SushiPlatterPOS = {
                "All FS Platter",
                "CSpcl Sushi Platter",
                "Dlx Sushi Platter",
                "Prm Sushi Set"
        };

        //Noodles [6]
        String[] Noodles = {
                "Beef Yaki Udon",
                "Gyudon",
                "Katsudon",
                "Miso Ramen",
                "Tantan Ramen",
                "Tonkotsu Ramen"
        };

        String[] NoodlesPOS = {
                "BY Udon",
                "Gyudon",
                "Katsudon",
                "M Ramen",
                "Tntn Ramen",
                "Tk Ramen"
        };

        //Donburi [4]
        String[] Donburi = {
                "California Deluxe",
                "Krazy Volcano",
                "rainbow chirashi",
                "Teriyakidon"
        };

        String[] DonburiPOS = {
                "Cal Deluxe",
                "Krzy Volcano",
                "RB Chirashi",
                "TKdon"
        };

        //Drinks [3]
        String[] Drinks = {
                "Coke",
                "Royal",
                "Sprite"
        };
        String[] DrinksPOS = {
                "Coke",
                "Royal",
                "Sprite"
        };

        //Dessert [1]
        String[] Dessert = {
                "Chocolate Cake"
        };

        String[] DessertPOS = {
                "Choco Cake"
        };

        //Others [3]
        String[] Others = {
                "Shrimp & Vegetable Tempura",
                "Shrimp Tempura"
        };

        String[] OthersPOS = {
                "S&V Tempura",
                "S Tempura"
        };


        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<RealmMenuItem> products = realm.where(RealmMenuItem.class).findAll();
            if(products.isEmpty()){
                for (String category : categories) {
                    OpenMenuInstance.toCreateCategory(0, category);
                    switch (category) {
                        case "Sashimi and Nigiri": createItem(category, SashimiAndNigiri, SashimiAndNigiriPOS);
                            break;
                        case "Salad": createItem(category, Salad, SaladPOS);
                            break;
                        case "Sushi Rolls": createItem(category, SushiRolls, SushiRollsPOS);
                            break;
                        case "Sushi Platter": createItem(category, SushiPlatter, SushiPlatterPOS);
                            break;
                        case "Noodles": createItem(category, Noodles, NoodlesPOS);
                            break;
                        case "Donburi": createItem(category, Donburi, DonburiPOS);
                            break;
                        case "Drinks": createItem(category, Drinks, DrinksPOS);
                            break;
                        case "Dessert": createItem(category, Dessert, DessertPOS);
                            break;
                        case "Deep fried": createItem(category, Others, OthersPOS);
                            break;
                    }

                }
            }
        }
    }
    public static void createItem(String category, String[] items, String[] pos){
        for(int i = 0 ; i < items.length ; i ++){
            OpenMenuInstance.toCreateItem(0, category, items[i], pos[i], 100.00);
        }
    }

    public static void preloadTransactions() {
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<RealmSalesTransaction> listOfTransactions = realm.where(RealmSalesTransaction.class).findAll();
            if (listOfTransactions.size() < 50) {
                Handler timer = new Handler();
                List<List<String>> table = new ArrayList<>();
                DataSetA.insertInto(table);
//                DataSetB.insertInto(table);
//                DataSetC.insertInto(table);
//                DataSetD.insertInto(table);
//                DataSetE.insertInto(table);
//                DataSetF.insertInto(table);
//                DataSetG.insertInto(table);
//                DataSetH.insertInto(table);
//                DataSetI.insertInto(table);
                //TOTAL PRICE
                double totalPrice = 1000.00;

                for (List<String> items : table) {
                    List<Double> price = new ArrayList<>();
                    List<Integer> amount = new ArrayList<>();
                    for(int i = 0 ; i < items.size() ; i++){
                        price.add(100.00);
                        amount.add(1);
                    }
                    timer.postDelayed(() -> {
                        OpenTransactionsInstance.toCreateTestSales(items, items, price, amount, totalPrice);
                    },5000);
                }
            }
        }
    }
}
