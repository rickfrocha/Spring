package cucumber_test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by ricardo on 30/08/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", format = {"pretty"})
public class CucumberBase {
}
