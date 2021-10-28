package zadania.zadanie1;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/cucumber/features/presta-shop.feature",
        plugin = {"pretty", "html:target/cucumber-reports.html"})

public class zadanie1Test {
}
