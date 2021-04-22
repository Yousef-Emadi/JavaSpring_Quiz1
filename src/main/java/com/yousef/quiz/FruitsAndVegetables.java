/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

public class FruitsAndVegetables extends FoodMainGroup {

    @Override
    double getCaloriesConsumed(double amount) {
        return 65 * amount / 100;
    }

}
