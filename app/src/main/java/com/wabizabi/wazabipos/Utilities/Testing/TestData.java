package com.wabizabi.wazabipos.Utilities.Testing;

import com.wabizabi.wazabipos.Database.Instances.OpenDiscountInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenMenuInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenTableInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Database.RealmSchemas.RealmMenuItem;
import com.wabizabi.wazabipos.Database.RealmSchemas.SalesTransaction;

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

        //Salad [3]
        String[] Salad = {
                "Kani Salad",
                "Salad Wrap",
                "Sea weeds Salad"
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

        //Sushi Platter [4]
        String[] SushiPlatter = {
                "All Fried Sushi Platter",
                "Chef's Special Sushi Platter",
                "Deluxe Sushi Platter",
                "Premium Sushi Set"
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

        //Donburi [4]
        String[] Donburi = {
                "California Deluxe",
                "Krazy Volcano",
                "rainbow chirashi",
                "Teriyakidon"
        };

        //Drinks [3]
        String[] Drinks = {
                "Coke",
                "Royal",
                "Sprite"
        };

        //Dessert [1]
        String[] Dessert = {
                "Chocolate Cake"
        };

        //Others [3]
        String[] Others = {
                "Shrimp & Vegetable Tempura",
                "Shrimp Tempura"

        };
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<RealmMenuItem> products = realm.where(RealmMenuItem.class).findAll();
            if(products.isEmpty()){
                for (String category : categories) {
                    OpenMenuInstance.toCreateCategory(0, category);
                    switch (category) {
                        case "Sashimi and Nigiri": createItem(category, SashimiAndNigiri);
                            break;
                        case "Salad": createItem(category, Salad);
                            break;
                        case "Sushi Rolls": createItem(category, SushiRolls);
                            break;
                        case "Sushi Platter": createItem(category, SushiPlatter);
                            break;
                        case "Noodles": createItem(category, Noodles);
                            break;
                        case "Donburi": createItem(category, Donburi);
                            break;
                        case "Drinks": createItem(category, Drinks);
                            break;
                        case "Dessert": createItem(category, Dessert);
                            break;
                        case "Deep fried": createItem(category, Others);
                            break;
                    }

                }
            }
        }
    }
    public static void createItem(String category, String[] items){
        for(String item : items){
            OpenMenuInstance.toCreateItem(0, category, item, 100.00);
        }
    }

    public static void preloadTransactions() {
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<SalesTransaction> listOfTransactions = realm.where(SalesTransaction.class).findAll();
            if (listOfTransactions.size() < 1500) {
                List<List<String>> table = new ArrayList<>();
                DataSetA.insertInto(table);
                DataSetB.insertInto(table);
                DataSetC.insertInto(table);
                DataSetD.insertInto(table);
                DataSetE.insertInto(table);
                DataSetF.insertInto(table);
                DataSetG.insertInto(table);
                DataSetH.insertInto(table);
                DataSetI.insertInto(table);
                //TOTAL PRICE
                double totalPrice = 1000.00;

                for (List<String> items : table) {
                    List<Double> price = new ArrayList<>();
                    List<Integer> amount = new ArrayList<>();

                    for(int i = 0 ; i < items.size() ; i++){
                        price.add(100.00);
                        amount.add(1);
                    }
                    OpenTransactionsInstance.toCreateSales(items, price, amount, totalPrice);
                }

            }

        }

    }

    public static void preloadDiscounts(){
        OpenDiscountInstance.toCreateDiscount("Senior Citizen", 20);
        OpenDiscountInstance.toCreateDiscount("Junior Citizen", 10);
        OpenDiscountInstance.toCreateDiscount("Less Tax", 3);
    }

    public static void preloadTables(){
//        OpenTableInstance.toCreateTable("Table", 1);
//        OpenTableInstance.toCreateTable("Table", 2);
//        OpenTableInstance.toCreateTable("Table", 3);
//        OpenTableInstance.toCreateTable("Table", 4);
//        OpenTableInstance.toCreateTable("Table", 5);

    }

}
