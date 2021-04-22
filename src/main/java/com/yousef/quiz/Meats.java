/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

public class Meats extends FoodMainGroup {

    @Override
    double getCaloriesConsumed(double amount) {
        return 143 * amount / 100;
    }
}
