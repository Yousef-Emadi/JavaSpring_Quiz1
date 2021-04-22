/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

/** Class to create food objects **/
public class Food {

    //Fields
    int group;
    double amount;
    double calories;

    //Constructor
    public Food(int group, double amount, double calories) {
        this.group = group;
        this.amount = amount;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Food{" +
                "group= " + group +
                ", amount= " + amount +
                ", calories= " + calories +
                '}';
    }
}
