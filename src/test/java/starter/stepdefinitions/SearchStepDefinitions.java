package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;

public class SearchStepDefinitions {

    // Step definition for the Given step: sets up the actor to navigate to the search home page
    @Given("{actor} is researching things on the internet")
    public void researchingThings(Actor actor) {
        // The actor navigates to the search home page
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    // Step definition for the When step: performs a search for the specified term
    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        // The actor attempts to look for information about the given term
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }

    // Step definition for the Then step: verifies that the page title contains the search term
    @Then("{actor} should see information about {string}")
    public void should_see_information_about(Actor actor, String term) {
        // The actor ensures that the web page title contains the expected term, ignoring case
        actor.attemptsTo(
                Ensure.that(TheWebPage.title()).containsIgnoringCase(term)
        );
    }
}