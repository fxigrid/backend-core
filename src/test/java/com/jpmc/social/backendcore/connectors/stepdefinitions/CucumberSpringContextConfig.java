package com.jpmc.social.backendcore.connectors.stepdefinitions;

import com.jpmc.social.backendcore.config.ApplicationConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

// Integrate the Cucumber tests with the Spring Application Context
@CucumberContextConfiguration
@ContextConfiguration(classes = ApplicationConfig.class)
public class CucumberSpringContextConfig {
}
