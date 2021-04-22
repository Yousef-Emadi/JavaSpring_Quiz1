/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

public class Dairy extends FoodGroup{

    @Override
    double getCaloriesConsumed(double amount) {
        return 42 * amount / 100;
    }
}
