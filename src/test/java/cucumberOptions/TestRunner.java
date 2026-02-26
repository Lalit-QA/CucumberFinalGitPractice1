package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
	//	features="src/test/java/features/Login.feature",
		glue="stepDefination",stepNotifications=true,
        plugin= {"pretty","html:target/cucumber.html"})     
    //    plugin= {"pretty","html:target/cucumber.json"})   
//glue --> binds stepDefination with features
//stepNotifications=true --->To get when then in granular level there is one update we need to add 
//in glue ---> mention the package name i.e stepDefination
//in glue -->if mention file name i.e "loginStepDefination" then we will encounter error
//features="src/test/java/features", --> will select all feature files present in features package
//If features="src/test/java/features/Login.feature", --->will select only Login.feature present in features package
//plugin= {"pretty","html:target/cucumber.html"})     
//above preety plugin --> cannot used in testNG runner --> will cause error
//in testRunner --> in preety plugin selenium verion 4 if we dont give ".html" then report will not generate-mandatory to give "html" extension
//in testRunner -->And if we want to generate reports in json --> give "json" extension
public class TestRunner {

}
