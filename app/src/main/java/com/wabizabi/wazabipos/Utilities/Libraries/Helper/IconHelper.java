package com.wabizabi.wazabipos.Utilities.Libraries.Helper;

import android.widget.ImageView;
import android.widget.TextView;

import com.wabizabi.wazabipos.R;

public abstract class IconHelper {

    public static void setMenuIcon(ImageView image, int number){
        switch(number){
            case 0:
                image.setImageResource(R.drawable.icon_products00_default);
                break;
            case 1:
                image.setImageResource(R.drawable.icon_products01_deepfried);
                break;
            case 2:
                image.setImageResource(R.drawable.icon_products02_desserts);
                break;
            case 3:
                image.setImageResource(R.drawable.icon_products03_donburi);
                break;
            case 4:
                image.setImageResource(R.drawable.icon_products04_drinks);
                break;
            case 5:
                image.setImageResource(R.drawable.icon_products05_nigiri);
                break;
            case 6:
                image.setImageResource(R.drawable.icon_products06_noodles);
                break;
            case 7:
                image.setImageResource(R.drawable.icon_products07_salad);
                break;
            case 8:
                image.setImageResource(R.drawable.icon_products08_sashimi);
                break;
            case 9:
                image.setImageResource(R.drawable.icon_products09_sushi);
                break;
            case 10:
                image.setImageResource(R.drawable.icon_products10_sushirolls);
                break;
        }
    }

    public static void setMenuIconSelection(ImageView image, TextView name, int number){
        switch(number){
            case 0:
                image.setImageResource(R.drawable.icon_products00_default);
                name.setText("Onigiri(Default)");
                break;
            case 1:
                image.setImageResource(R.drawable.icon_products01_deepfried);
                name.setText("Deep Fried");
                break;
            case 2:
                image.setImageResource(R.drawable.icon_products02_desserts);
                name.setText("Desserts");
                break;
            case 3:
                image.setImageResource(R.drawable.icon_products03_donburi);
                name.setText("Donburi");
                break;
            case 4:
                image.setImageResource(R.drawable.icon_products04_drinks);
                name.setText("Drinks");
                break;
            case 5:
                image.setImageResource(R.drawable.icon_products05_nigiri);
                name.setText("Nigiri");
                break;
            case 6:
                image.setImageResource(R.drawable.icon_products06_noodles);
                name.setText("Noodles");
                break;
            case 7:
                image.setImageResource(R.drawable.icon_products07_salad);
                name.setText("Salad");
                break;
            case 8:
                image.setImageResource(R.drawable.icon_products08_sashimi);
                name.setText("Sashimi");
                break;
            case 9:
                image.setImageResource(R.drawable.icon_products09_sushi);
                name.setText("Sushi");
                break;
            case 10:
                image.setImageResource(R.drawable.icon_products10_sushirolls);
                name.setText("Sushi Rolls");
                break;
        }
    }

    public static void setStockIcon(ImageView image, int number){
        switch(number){
            case 0:
                image.setImageResource(R.drawable.icon_stocks00_default);
                break;
            case 1:
                image.setImageResource(R.drawable.icon_stocks01_condiment00);
                break;
            case 2:
                image.setImageResource(R.drawable.icon_stocks01_condiment01);
                break;
            case 3:
                image.setImageResource(R.drawable.icon_stocks01_condiment02);
                break;
            case 4:
                image.setImageResource(R.drawable.icon_stocks01_condiment03);
                break;
            case 5:
                image.setImageResource(R.drawable.icon_stocks01_condiment04);
                break;
            case 6:
                image.setImageResource(R.drawable.icon_stocks01_condiment05);
                break;
            case 7:
                image.setImageResource(R.drawable.icon_stocks02_dairy00);
                break;
            case 8:
                image.setImageResource(R.drawable.icon_stocks02_dairy01);
                break;
            case 9:
                image.setImageResource(R.drawable.icon_stocks03_fruits00);
                break;
            case 10:
                image.setImageResource(R.drawable.icon_stocks03_fruits01);
                break;
            case 11:
                image.setImageResource(R.drawable.icon_stocks03_fruits02);
                break;
            case 12:
                image.setImageResource(R.drawable.icon_stocks03_fruits03);
                break;
            case 13:
                image.setImageResource(R.drawable.icon_stocks04_meat00);
                break;
            case 14:
                image.setImageResource(R.drawable.icon_stocks04_meat01);
                break;
            case 15:
                image.setImageResource(R.drawable.icon_stocks04_meat02);
                break;
            case 16:
                image.setImageResource(R.drawable.icon_stocks05_poultry00);
                break;
            case 17:
                image.setImageResource(R.drawable.icon_stocks05_poultry01);
                break;
            case 18:
                image.setImageResource(R.drawable.icon_stocks06_seafood00);
                break;
            case 19:
                image.setImageResource(R.drawable.icon_stocks06_seafood01);
                break;
            case 20:
                image.setImageResource(R.drawable.icon_stocks06_seafood02);
                break;
            case 21:
                image.setImageResource(R.drawable.icon_stocks07_spice00);
                break;
            case 22:
                image.setImageResource(R.drawable.icon_stocks07_spice01);
                break;
            case 23:
                image.setImageResource(R.drawable.icon_stocks07_spice02);
                break;
            case 24:
                image.setImageResource(R.drawable.icon_stocks07_spice03);
                break;
            case 25:
                image.setImageResource(R.drawable.icon_stocks08_vegetables00);
                break;
            case 26:
                image.setImageResource(R.drawable.icon_stocks08_vegetables01);
                break;
            case 27:
                image.setImageResource(R.drawable.icon_stocks08_vegetables02);
                break;
            case 28:
                image.setImageResource(R.drawable.icon_stocks08_vegetables03);
                break;
            case 29:
                image.setImageResource(R.drawable.icon_stocks08_vegetables04);
                break;
            case 30:
                image.setImageResource(R.drawable.icon_stocks08_vegetables05);
                break;
            case 31:
                image.setImageResource(R.drawable.icon_stocks08_vegetables06);
                break;
            case 32:
                image.setImageResource(R.drawable.icon_stocks09_wrappers00);
                break;
            case 33:
                image.setImageResource(R.drawable.icon_stocks09_wrappers01);
                break;
            case 34:
                image.setImageResource(R.drawable.icon_stocks09_wrappers02);
                break;
        }
    }

    public static void setStockIconSelection(ImageView image, TextView name, int number){
        switch(number){
            case 0:
                image.setImageResource(R.drawable.icon_stocks00_default);
                name.setText("Default");
                break;
            case 1:
                image.setImageResource(R.drawable.icon_stocks01_condiment00);
                name.setText("Condiments 00");
                break;
            case 2:
                image.setImageResource(R.drawable.icon_stocks01_condiment01);
                name.setText("Condiments 01");
                break;
            case 3:
                image.setImageResource(R.drawable.icon_stocks01_condiment02);
                name.setText("Condiments 02");
                break;
            case 4:
                image.setImageResource(R.drawable.icon_stocks01_condiment03);
                name.setText("Condiments 03");
                break;
            case 5:
                image.setImageResource(R.drawable.icon_stocks01_condiment04);
                name.setText("Condiments 04");
                break;
            case 6:
                image.setImageResource(R.drawable.icon_stocks01_condiment05);
                name.setText("Condiments 05");
                break;
            case 7:
                image.setImageResource(R.drawable.icon_stocks02_dairy00);
                name.setText("Dairy 00");
                break;
            case 8:
                image.setImageResource(R.drawable.icon_stocks02_dairy01);
                name.setText("Dairy 01");
                break;
            case 9:
                image.setImageResource(R.drawable.icon_stocks03_fruits00);
                name.setText("Fruits 00");
                break;
            case 10:
                image.setImageResource(R.drawable.icon_stocks03_fruits01);
                name.setText("Fruits 01");
                break;
            case 11:
                image.setImageResource(R.drawable.icon_stocks03_fruits02);
                name.setText("Fruits 02");
                break;
            case 12:
                image.setImageResource(R.drawable.icon_stocks03_fruits03);
                name.setText("Fruits 03");
                break;
            case 13:
                image.setImageResource(R.drawable.icon_stocks04_meat00);
                name.setText("Meat 00");
                break;
            case 14:
                image.setImageResource(R.drawable.icon_stocks04_meat01);
                name.setText("Meat 01");
                break;
            case 15:
                image.setImageResource(R.drawable.icon_stocks04_meat02);
                name.setText("Meat 02");
                break;
            case 16:
                image.setImageResource(R.drawable.icon_stocks05_poultry00);
                name.setText("Poultry 00");
                break;
            case 17:
                image.setImageResource(R.drawable.icon_stocks05_poultry01);
                name.setText("Poultry 01");
                break;
            case 18:
                image.setImageResource(R.drawable.icon_stocks06_seafood00);
                name.setText("Seafood 00");
                break;
            case 19:
                image.setImageResource(R.drawable.icon_stocks06_seafood01);
                name.setText("Seafood 01");
                break;
            case 20:
                image.setImageResource(R.drawable.icon_stocks06_seafood02);
                name.setText("Seafood 02");
                break;
            case 21:
                image.setImageResource(R.drawable.icon_stocks07_spice00);
                name.setText("Spice 00");
                break;
            case 22:
                image.setImageResource(R.drawable.icon_stocks07_spice01);
                name.setText("Spice 01");
                break;
            case 23:
                image.setImageResource(R.drawable.icon_stocks07_spice02);
                name.setText("Spice 02");
                break;
            case 24:
                image.setImageResource(R.drawable.icon_stocks07_spice03);
                name.setText("Spice 03");
                break;
            case 25:
                image.setImageResource(R.drawable.icon_stocks08_vegetables00);
                name.setText("Vegetables 00");
                break;
            case 26:
                image.setImageResource(R.drawable.icon_stocks08_vegetables01);
                name.setText("Vegetables 01");
                break;
            case 27:
                image.setImageResource(R.drawable.icon_stocks08_vegetables02);
                name.setText("Vegetables 02");
                break;
            case 28:
                image.setImageResource(R.drawable.icon_stocks08_vegetables03);
                name.setText("Vegetables 03");
                break;
            case 29:
                image.setImageResource(R.drawable.icon_stocks08_vegetables04);
                name.setText("Vegetables 04");
                break;
            case 30:
                image.setImageResource(R.drawable.icon_stocks08_vegetables05);
                name.setText("Vegetables 05");
                break;
            case 31:
                image.setImageResource(R.drawable.icon_stocks08_vegetables06);
                name.setText("Vegetables 06");
                break;
            case 32:
                image.setImageResource(R.drawable.icon_stocks09_wrappers00);
                name.setText("Wrappers 00");
                break;
            case 33:
                image.setImageResource(R.drawable.icon_stocks09_wrappers01);
                name.setText("Wrappers 01");
                break;
            case 34:
                image.setImageResource(R.drawable.icon_stocks09_wrappers02);
                name.setText("Wrappers 02");
                break;
        }
    }
}
