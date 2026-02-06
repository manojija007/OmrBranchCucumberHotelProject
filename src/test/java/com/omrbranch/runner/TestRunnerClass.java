package com.omrbranch.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.omrbranch.stepdefinition", "com.omrbranch.hooks"},
        tags = "@TC002",
        snippets = SnippetType.CAMELCASE,
        dryRun=false,
        plugin = {
                "pretty",
                "json:target/output.json"
        },
        publish = true
)

public class TestRunnerClass {

}
