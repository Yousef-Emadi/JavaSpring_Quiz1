/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

public class Controller {

    //Fields
    private UserInterface myUI;
    private FoodMainGroup foodMainGroup;

    // Constructor
    public Controller(UserInterface myUI, FoodMainGroup foodMainGroup) {
        this.myUI = myUI;
        this.foodMainGroup = foodMainGroup;
    }

    //Methods
    public void mainController(){
        userChoice choice = myUI.getUserChoice();
        switch (choice) {
            case CALORIE_CALC -> {doCalculateCalories();}
            case REP_BY_GROUP -> {doReportByGroups();}
            case REP_BY_CALORIES -> {doReportByCalories();}
            case REP_ALL -> {doListDatabase();}
            case EXIT -> {doExit();}
        }
    }


    /** validator for data entered by user as the food group int number **/
    public boolean groupValidator(int group){
        int[] groups = {1, 2, 3, 4};
        for (int i: groups
             ) {
            if (i == group) return true;
        }
        return false;
    }

    /** validator for data entered by user as the food food amount in grams double number **/
    public boolean amountValidator(double amount){
        return amount > 0;
    }



}
