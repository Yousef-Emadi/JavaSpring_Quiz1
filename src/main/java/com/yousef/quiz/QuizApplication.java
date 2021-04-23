/**
 * Quiz1 : Food Calories
 * Developed by: Yousef Emadi
 * Date: 21-APR-2021
 */

package com.yousef.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;

@SpringBootApplication
public class QuizApplication {

    public static void main(String[] args) {


//        SpringApplication.run(QuizApplication.class, args);

        UserInterface userInterface = new UserInterface();
        FoodMainGroup foodMainGroup = new FoodMainGroup() {
            @Override
            double getCaloriesConsumed(double amount) {
                return 0;
            }
        };

        Controller controller = new Controller(userInterface, foodMainGroup);


        while (true) {
            try {
                controller.mainController();
            } catch (InputMismatchException i) {
                userInterface.catchMessage();
                break;
            }

        }

    }

}
