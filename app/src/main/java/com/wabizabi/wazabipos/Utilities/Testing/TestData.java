package com.wabizabi.wazabipos.Utilities.Testing;

import com.wabizabi.wazabipos.Database.Instances.OpenProductsInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Database.Schemas.SalesTransaction;

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
                "Donburi",
                "Drinks",
                "Dessert",
                "Others"
        };

        //ITEMS PER CATEGORY
        //Sashimi and Nigiri [7]
        String[] SashimiAndNigiri = {
                "Salmon sashimi",
                "nigiri salmon",
                "Tuna",
                "Unagi",
                "Tako",
                "Ika",
                "Tamago"
        };

        //Salad [4]
        String[] Salad = {
                "Sea weeds Salad",
                "Salad Wrap",
                "Kani Salad",
                "Spicy Tuna Salad"
        };

        //Sushi Rolls [9]
        String[] SushiRolls = {
                "California Maki",
                "Aburi Salmon",
                "Tuna Tataki",
                "rainbow chirashi",
                "Dragon Eel",
                "California Deluxe",
                "Krazy Volcano",
                "Spicy Maguro Melt",
                "Yuzu Creamy Salmon"
        };

        //Sushi Platter [4]
        String[] SushiPlatter = {
                "WZ Sushi Platter",
                "California Deluxe",
                "Nigiri Platter",
                "Premium Sushi Set"
        };

        //Noodles [5]
        String[] Noodles = {
                "Beef Yakiudon",
                "Tantanmen",
                "Miso Ramen",
                "Tonkotsu Ramen",
                "Tantanmen Ramen"
        };

        //Donburi [4]
        String[] Donburi = {
                "Gyudon",
                "Katsudon",
                "Tendon",
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
                "sushi rolls",
                "adsffasdfsdfsdafsdfsdfsdfsad",
                "test"

        };
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<ProductsItem> products = realm.where(ProductsItem.class).findAll();
            if(products.isEmpty()){
                for (String category : categories) {
                    OpenProductsInstance.toCreateCategory(0, category);
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
                        case "Others": createItem(category, Others);
                            break;
                    }

                }
            }
        }
    }
    public static void createItem(String category, String[] items){
        for(String item : items){
            OpenProductsInstance.toCreateItem(0, category, item, 100.00);
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

}
