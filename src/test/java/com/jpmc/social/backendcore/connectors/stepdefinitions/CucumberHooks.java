package com.jpmc.social.backendcore.connectors.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CucumberHooks {

    private static final Logger logger = LoggerFactory.getLogger(CucumberHooks.class);

    @Before()
    public void beforeScenario(Scenario scenario) {
        logger.info("SCENARIO-->>" + scenario.getName() + " execution has started");
    }

    @After()
    public void afterScenario(Scenario scenario) {
        String status = scenario.getStatus().toString();
        if (status.equals("PASSED")) {
            logger.info("SCENARIO-->>" + scenario.getName() + "  : has successfully passed");
        } else {
            logger.info("SCENARIO-->>" + scenario.getName() + "  : has failures , Please Debug!!");
        }
    }
}
