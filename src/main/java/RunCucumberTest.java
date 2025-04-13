import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/featurefiles"}, plugin={
        "html:target/site/cucumber-pretty.html", "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml",
        "rerun:target/cucumber-reports/rerun.txt"},glue = {"stepsMonefyApp"})
public class RunCucumberTest {

}

