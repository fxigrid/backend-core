package com.jpmc.social.backendcore;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/test/resources/features/")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.jpmc.social.backendcore.connectors.stepdefinitions")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@User")
//@IncludeTags({"Sanity"})



public class RunCukesIT {
}
