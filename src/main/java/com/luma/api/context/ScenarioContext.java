package com.luma.api.context;

import org.apache.logging.log4j.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.SplittableRandom;

import static com.luma.ui.managers.DriverManager.logger;

public class ScenarioContext {

    private static ScenarioContext scenarioContextInstance;

    private Map<CONTEXT, Object> contextStorageMap;



    private ScenarioContext() {
        contextStorageMap = new HashMap<>();
    }

    public static ScenarioContext getInstance() {
        if (scenarioContextInstance == null) {
            scenarioContextInstance = new ScenarioContext();
        }
        return scenarioContextInstance;
    }

    public void addToStorageContext(CONTEXT contextKey, Object contextValue) {
        contextStorageMap.put(contextKey, contextValue);
        logger.log(Level.INFO, "The context was populated with [" + contextValue + "] for the key [" + contextKey + "]");
    }


    public Object getStoredValueFromContext(CONTEXT contextKey) {
        return contextStorageMap.get(contextKey);
    }


    public void cleanUpTheContextStorage() {
        contextStorageMap.clear();
        logger.log(Level.INFO, "The Scenario Context is clean");
    }
}

