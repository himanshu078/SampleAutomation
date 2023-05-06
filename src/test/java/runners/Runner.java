package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
       // features = "src/test/resources/features",
        features = "src/test/resources/features",
        tags = "@RegisterError", // @Login
        glue = "stepdefinitions"
)
public class Runner {}
