/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;
import java.util.ArrayList;
import java.util.List;

/** Abstract class for all types of food **/
public abstract class FoodMainGroup {

    //Fields
    protected List<Food> foodItems = new ArrayList<>();



    /** Abstract Method **/
    abstract double getCaloriesConsumed(double amount);



    /** Non-Abstract Methods **/
    protected boolean addFood(Food food) {
        if (food != null)
            return foodItems.add(food);
        else
            return false;
    }

    protected Food searchByGroup(int groupId) {
        for (Food i: foodItems
        ) {
            if (i.group == groupId) return i;
        }
        return null;
    }

    protected Food searchByCalories(double calories) {
        for (Food i: foodItems
        ) {
            if (i.calories == calories) return i;
        }
        return null;
    }

}
