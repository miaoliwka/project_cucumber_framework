package tasks.add_a_new_address;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/cucumber/features/add_new_address.feature",
        plugin = {"pretty", "html:target/cucumber-reports.html"})

public class new_address_test {
}
