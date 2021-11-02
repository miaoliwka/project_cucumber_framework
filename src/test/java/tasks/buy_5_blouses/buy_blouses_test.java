package tasks.buy_5_blouses;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/cucumber/features/buy_five_blouses.feature",
        plugin = {"pretty", "html:target/cucumber-reports.html"})

public class buy_blouses_test {
}
