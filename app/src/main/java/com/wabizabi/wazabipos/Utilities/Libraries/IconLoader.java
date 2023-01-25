package com.wabizabi.wazabipos.Utilities.Libraries;

import android.widget.ImageView;
import android.widget.TextView;

import com.wabizabi.wazabipos.R;

public abstract class IconLoader {

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

    public static void setStockIconSelection(ImageView image, TextView name, int number){
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
}
