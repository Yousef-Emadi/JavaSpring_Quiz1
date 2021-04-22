/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

public class FruitsAndVegetables extends FoodGroup {

    @Override
    boolean addFood(Food food) {
        if (food != null)
            return foodItems.add(food);
        else
            return false;
    }

    @Override
    Food searchByGroup(int groupId) {
        for (Food i: foodItems
             ) {
            if (i.group == groupId) return i;
        }
        return null;
    }

    @Override
    Food searchByCalories(double calories) {
        for (Food i: foodItems
        ) {
            if (i.calories == calories) return i;
        }
        return null;
    }

    @Override
    double getCaloriesConsumed(double amount) {
        return 65 * amount / 100;
    }

}
