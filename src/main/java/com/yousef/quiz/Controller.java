/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

public class Controller {

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
