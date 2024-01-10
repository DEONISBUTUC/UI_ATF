package com.luma.ui.context;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private static final Logger logger = LogManager.getLogger(TestContext.class);

    private static TestContext testContextInstance;

    private final Map<String, String> testContextStorage;


    private TestContext(){
        testContextStorage = new HashMap<>();
    }

    public static TestContext getInstance(){
        if(testContextInstance == null){
            testContextInstance = new TestContext();
        }
        return testContextInstance;
    }

    public void addToStorageContext(String contextKey, String contextValue){
        testContextStorage.put(contextKey, contextValue);
        logger.log(Level.INFO, "The Test context was populated with [" + contextValue + "] for the key ["
                + contextKey + "]");
    }

    public String getStoredValueFromContext(String contextKey){
        return testContextStorage.get(contextKey);
    }

}
