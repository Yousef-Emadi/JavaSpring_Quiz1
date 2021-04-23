package com.yousef.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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


        while (true){
            controller.mainController();
        }

    }

}
