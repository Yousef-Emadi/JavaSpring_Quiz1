/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */
/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //fields
    Scanner input = new Scanner(System.in);



    /**
     * Main menu of app
     **/
    public userChoice getUserChoice() {

        System.out.println("\nPlease, enter an option number");
        System.out.print("\n   1. Calorie calculator");
        System.out.print("\n   2. Report by food groups");
        System.out.print("\n   3. Report by food calories");
        System.out.print("\n   4. Report All foods consumed");
        System.out.print("\n   0. << Exit from application >>\n");


        int choiceNumber = input.nextInt();
        switch (choiceNumber) {
            case 1 -> {


                getFoodItemConsumed();
                return userChoice.CALORIE_CALC;
            }
            case 2 -> {
                return userChoice.REP_BY_GROUP;
            }
            case 3 -> {
                return userChoice.REP_BY_CALORIES;
            }
            case 4 -> {
                return userChoice.REP_ALL;
            }
            case 0 -> {
                return userChoice.EXIT;
            }
            default -> {
                System.out.println("Please enter an valid option number including 1, 2, 3, 4 or 0 \n");
                return userChoice.NONE;
            }
        }
    }

    public void showFood(Food food) {
        String groupText;
        switch (food.group){
            case 1 -> {groupText = "Fruits and Vegetables";}
            case 2 -> {groupText = "Meats";}
            case 3 -> {groupText = "Diary";}
            case 4 -> {groupText = "Grains";}
            default -> throw new IllegalStateException("group did not recognized");
        }
        System.out.println(
                "\n-------------------------------------" +
                        "\nFood Group: " + groupText +
                        "\nAmount: " + food.amount +
                        "\nCalories: " + food.calories +
                        "\n-------------------------------------"
        );
    }

    public List<Food> getFoodItemConsumed () {

        /** temporary list to keep food items in current user session **/
        List<Food> foodTray = new ArrayList<Food>();

        System.out.println("\nPlease, enter your consumed food group number or enter 0 to exit");
        System.out.print("\n   1. Fruits and Vegetables");
        System.out.print("\n   2. Meats");
        System.out.print("\n   3. Diary");
        System.out.print("\n   4. Grains");
        System.out.print("\n   0. << Back to main menu >>");
        int group = input.nextInt();

        System.out.print("\nPlease, enter its amount in grams: ");
        double amount = input.nextDouble();

        switch (group){
            case 1 -> {
                FruitsAndVegetables veg = new FruitsAndVegetables();
                Food food = new Food(group, amount, veg.getCaloriesConsumed(amount));
                foodTray.add(food);
            }
            case 2 -> {
                Meats meat = new Meats();
                Food food = new Food(group, amount, meat.getCaloriesConsumed(amount));
                foodTray.add(food);
            }
            case 3 -> {
                Dairy diary = new Dairy();
                Food food = new Food(group, amount, diary.getCaloriesConsumed(amount));
                foodTray.add(food);
            }
            case 4 -> {
                Grains grain = new Grains();
                Food food = new Food(group, amount, grain.getCaloriesConsumed(amount));
                foodTray.add(food);
            }
            case 0 -> {return null;}
        }
        return foodTray;

    }


    public void showTotalCaloriesConsumed(List<Food> list){
        double totalCalories = 0 ;
        for (Food i: list
        ) {
            totalCalories = totalCalories + i.calories;
        }
        System.out.println("\n Total calories consumed: " + totalCalories);
    }

}
