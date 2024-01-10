package com.luma.ui.managers;

import com.github.javafaker.Faker;
import com.luma.ui.context.CONTEXT;
import com.luma.ui.context.ScenarioContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class RandomDataGenerator {
    private static final Logger logger = LogManager.getLogger(RandomDataGenerator.class);
    private static final Faker fakerObject = new Faker();

    public static String getRandomFirstName() {
        return fakerObject.name().firstName();
    }

    public static String getRandomLastName() {
        return fakerObject.name().lastName();
    }

    public static String getRandomEmail() {
        return fakerObject.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return String.valueOf(fakerObject.internet().password(8, 20, true, true, true));
    }

    public static String dataSubstitution(String value) {
        String result = value;
        switch (value.toUpperCase()) {
            case "RANDOMFIRSTNAME":
                result = getRandomFirstName();
                break;
            case "RANDOMEMAIL":
                result = getRandomEmail();
                ScenarioContext.getInstance().addToStorageContext(CONTEXT.EMAIL, result);
                break;
            case "RANDOMLASTNAME":
                result = getRandomLastName();
                break;
            case "RANDOMPASSWORD":
                result = getRandomPassword();
                ScenarioContext.getInstance().addToStorageContext(CONTEXT.PASSWORD, result);
                System.out.println(result);
                break;
            case "RANDOMCONFIRMPASSWORD":
                result = ScenarioContext.getInstance().getStoredValueFromContext(CONTEXT.PASSWORD);
                System.out.println(result);
                break;
        }
        logger.log(Level.INFO, "Generated " + value + ": " + result);
        return result;
    }


}






