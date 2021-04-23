/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

import java.util.List;

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
            case REP_ALL -> {doListDatabase();}
            case EXIT -> {doExit();}
        }
    }


    public void doCalculateCalories(){
        myUI.exitFlag = 1;
        myUI.foodBasket.clear();


            myUI.getFoodItemConsumed();


        //add food basket of user session to database
        for (Food i: myUI.foodBasket
             ) {
            foodMainGroup.foodItemsDB.add(i);
        }
        if (computeAllCaloriesConsumed(myUI.foodBasket) != 0) {
            myUI.showTotalCaloriesConsumed(computeAllCaloriesConsumed(myUI.foodBasket));
        }
        if (myUI.foodBasket.isEmpty()) myUI.emptyMessage();
    }

    public double computeAllCaloriesConsumed(List<Food> list){
        double totalCalories = 0 ;
        for (Food i: list
        ) {
            totalCalories = totalCalories + i.calories;
        }
        return totalCalories;
    }

    private void doReportByGroups() {
        int groupNumber = myUI.getGroupNumber();
        if (groupNumber != 0){
            for (Food i: foodMainGroup.foodItemsDB
            ) {
                if (i.group == groupNumber)
                    myUI.showFood(i);
            }
        }
        if (myUI.groupValidator(groupNumber) && foodMainGroup.foodItemsDB.isEmpty()) myUI.emptyMessage();

    }



    private void doListDatabase() {
        for (Food i: foodMainGroup.foodItemsDB
             ) {
            myUI.showFood(i);
        }
        if (foodMainGroup.foodItemsDB.isEmpty()) myUI.emptyMessage();
    }



    public void doExit(){
        myUI.exitMessage();
        System.exit(0);
    }

}
