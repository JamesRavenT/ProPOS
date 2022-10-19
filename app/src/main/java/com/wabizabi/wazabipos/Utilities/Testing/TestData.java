package com.wabizabi.wazabipos.Utilities.Testing;

import com.wabizabi.wazabipos.Database.Instances.OpenProductsInstance;
import com.wabizabi.wazabipos.Database.Instances.OpenTransactionsInstance;
import com.wabizabi.wazabipos.Database.Schemas.ProductsItem;
import com.wabizabi.wazabipos.Database.Schemas.TransactionsOfSales;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class TestData {

    public static void preloadProducts() {
        //CATEGORIES
        String[] categories = {
                "Sashimi and Nigiri",
                "Deep Fried",
                "Sushi Rolls",
                "Sushi Platter",
                "Noodles",
                "Donburi",
                "Drinks",
                "Dessert"
        };

        //ITEMS PER CATEGORY
        String[] SashimiAndNigiri = {
                "Salmon",
                "Tuna",
                "Shime saba",
                "Unagi",
                "Tako",
                "Ika",
                "Tamago"
        };

        //Deep fried
        String[] DeepFried = {
                "Seaweed Salad",
                "Salad Wrap",
                "Kani Salad",
                "Spicy Tuna Salad"
        };

        //Sushi Rolls
        String[] SushiRolls = {
                "California Maki",
                "Spicy Shrimp Tempura Roll",
                "Aburi Salmon",
                "Salmon Lovers Roll",
                "Tuna Tataki",
                "Rainbow Roll",
                "Dragon Eel",
                "Crispy Spicy Tuna",
                "Crispy Philly",
                "Fried Futomaki",
                "California Deluxe",
                "Krazy Volcano",
                "Salmon and Shrimp Tempura Roll",
                "Tuna Salmon Dynamite Roll",
                "Spicy Maguro Melt",
                "3 Cheese Crispy Kani Roll",
                "Yuzu Creamy Salmon"
        };

        //Sushi Platter
        String[] SushiPlatter = {
                "WZ Sushi Platter",
                "All Fried Sushi Platter",
                "All California Sushi Platter",
                "Deluxe Sushi Platter",
                "Nigiri Platter",
                "Premium Sushi Set"
        };

        String[] Noodles = {
                "Miso Ramen",
                "Tonkotsu Ramen",
                "Tantanmen",
                "Beef Yakiudon"
        };

        //Donburi
        String[] Donburi = {
                "Tendon",
                "Katsudon",
                "Gyudon",
                "Teriyakidon"
        };

        //Drinks
        String[] Drinks = {
                "Cucumber Lemonade",
                "Strawberry Red Tea",
                "Coke",
                "Coke Zero",
                "Royal",
                "Sprite",
                "Pineapple Juice",
                "4 Seasons",
                "Bottled Water"
        };

        //Dessert
        String[] Dessert = {
                "Chocolate Cake"
        };
        try(Realm realm = Realm.getDefaultInstance()){
            RealmResults<ProductsItem> products = realm.where(ProductsItem.class).findAll();
            if(products.isEmpty()){
                for (String category : categories) {
                    OpenProductsInstance.toCreateCategory(0, category);
                    switch (category) {
                        case "Sashimi and Nigiri": createItem(category, SashimiAndNigiri);
                            break;
                        case "Deep Fried": createItem(category, DeepFried);
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
            RealmResults<TransactionsOfSales> listOfTransactions = realm.where(TransactionsOfSales.class).findAll();
            if (listOfTransactions.size() < 100) {
                List<List<String>> table = new ArrayList<>();
                DataSetZ.insertInto(table);

                //TOTAL PRICE
                double totalPrice = 1000.00;

                //DATE AND TIME
                DateFormat currentTime = new SimpleDateFormat("h:mm a");
                DateFormat currentMonth = new SimpleDateFormat("MMM");
                DateFormat currentDay = new SimpleDateFormat("d");
                DateFormat currentYear = new SimpleDateFormat("yyyy");
                String time = currentTime.format(new Date());
                String month = currentMonth.format(new Date());
                String day = currentDay.format(new Date());
                String year = currentYear.format(new Date());

                for (List<String> items : table) {
                    List<Double> price = new ArrayList<>();
                    List<Integer> amount = new ArrayList<>();

                    for(int i = 0 ; i < items.size() ; i++){
                        price.add(100.00);
                        amount.add(1);
                    }
                    OpenTransactionsInstance.toCreateSalesTransaction(items, price, amount, totalPrice, time, month, day, year);
                }

            }

        }

    }

}
