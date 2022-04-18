package com.jpmc.social.backendcore.connectors.stepdefinitions;

import io.cucumber.java.ParameterType;

public class TypeRegistryConfiguration {

    // Setup booleanValue ParameterType for Cucumber expression
    @ParameterType(value = "true|True|TRUE|false|False|FALSE")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }
}
