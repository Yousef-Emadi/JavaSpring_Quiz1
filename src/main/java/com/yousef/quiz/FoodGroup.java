/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

import java.util.ArrayList;
import java.util.List;

/** Abstract class for all types of food **/
public abstract class FoodGroup {
    protected List<Food> foodItems = new ArrayList<>();

    //Methods
    abstract boolean addFood(Food food);
    abstract Food searchByGroup(int groupId);
    abstract Food searchByCalories(double calories);
    abstract double getCaloriesConsumed(double amount);
}
