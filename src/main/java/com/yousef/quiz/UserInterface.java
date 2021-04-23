/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        System.out.print("\n   3. Report All foods consumed");
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
                return userChoice.REP_ALL;
            }
            case 0 -> {
                return userChoice.EXIT;
            }
            default -> {
                System.out.println(">>>>> Please enter an valid option number including 1, 2, 3, 4 or 0 \n");
                return userChoice.NONE;
            }
        }
    }


    /**
     * validator for data entered by user as the food group int number
     **/
    public boolean groupValidator(int group) {
        int[] groups = {1, 2, 3, 4};
        for (int i : groups
        ) {
            if (i == group) return true;
        }
        return false;
    }

    /**
     * validator for data entered by user as the food food amount in grams double number
     **/
    public boolean amountValidator(double amount) {
        return amount > 0;
    }

    int exitFlag; //to help function to use Exit to main menu

    /**
     * temporary list to keep food items in current user session
     **/
    List<Food> foodBasket = new ArrayList<Food>();

    public List<Food> getFoodItemConsumed() {

        while (exitFlag == 1) {


            System.out.println("\nPlease, enter your consumed food group number or enter 0 to exit");
            System.out.print("\n   1. Fruits and Vegetables");
            System.out.print("\n   2. Meats");
            System.out.print("\n   3. Diary");
            System.out.print("\n   4. Grains");
            System.out.print("\n   0. << Back to main menu >>\n");
            int group = input.nextInt();


            if (group == 0) {
                exitFlag = 0; //Exit to main menu
                return foodBasket;
            }

            if (!groupValidator(group)) {
                System.out.println(">>>>> Sorry! group number must be 1, 2, 3 or 4. Please try again");
                return null;
            }


            System.out.print("\nPlease, enter its amount in grams: ");
            double amount = input.nextDouble();

            if (!amountValidator(amount)) {
                System.out.println(">>>>> Sorry! amount number must be a number greater than zero. Please try again");
                return null;
            }

            //Creating Food object for adding to basket and then sending to controller
            switch (group) {
                case 1 -> {
                    FruitsAndVegetables veg = new FruitsAndVegetables();
                    Food food = new Food(group, amount, veg.getCaloriesConsumed(amount));
                    foodBasket.add(food);
                }
                case 2 -> {
                    Meats meat = new Meats();
                    Food food = new Food(group, amount, meat.getCaloriesConsumed(amount));
                    foodBasket.add(food);
                }
                case 3 -> {
                    Dairy diary = new Dairy();
                    Food food = new Food(group, amount, diary.getCaloriesConsumed(amount));
                    foodBasket.add(food);
                }
                case 4 -> {
                    Grains grain = new Grains();
                    Food food = new Food(group, amount, grain.getCaloriesConsumed(amount));
                    foodBasket.add(food);
                }
            }

        }
        return foodBasket;

    }

    public void showFood(Food food) {
        String groupText;
        switch (food.group) {
            case 1 -> {
                groupText = "Fruits and Vegetables";
            }
            case 2 -> {
                groupText = "Meats";
            }
            case 3 -> {
                groupText = "Diary";
            }
            case 4 -> {
                groupText = "Grains";
            }
            default -> throw new IllegalStateException("group did not recognized");
        }
        System.out.println(
                "\n-----------------------------------------" +
                        "\nFood Group: " + groupText +
                        "\nAmount: " + food.amount +
                        "\nCalories: " + food.calories
        );
    }

    public void showTotalCaloriesConsumed(double totalCalories) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(3);
        System.out.println(
                "\n----------------------------------------" +
                        "\n      Total calories consumed: " + df.format(totalCalories) +
                        "\n----------------------------------------"
        );
    }

    public int getGroupNumber() {

        System.out.println("\nPlease, enter your food group number to create report or enter 0 to exit");
        System.out.print("\n   1. Fruits and Vegetables");
        System.out.print("\n   2. Meats");
        System.out.print("\n   3. Diary");
        System.out.print("\n   4. Grains");
        System.out.print("\n   0. << Back to main menu >>\n");
        int group = input.nextInt();

        if (group == 0) return 0;
        if (!groupValidator(group)) {
            System.out.println(">>>>> Sorry! group number must be 1, 2, 3 or 4. Please try again");
            return 0;
        } else return group;
    }

    public void emptyMessage() {
        System.out.println(">>>>> Food list is empty. Use \"Calorie calculator\" option. Nothing to report");
    }

    public void catchMessage() {
        System.out.println(">>>>> Sorry! This application accepts only numbers");
    }

    public void exitMessage() {
        System.out.println(">>>>> Thank you for using Food Calorie application and Good luck :)");
    }

}
