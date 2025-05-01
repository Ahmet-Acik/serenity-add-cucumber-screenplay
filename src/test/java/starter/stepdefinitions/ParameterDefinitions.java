package starter.stepdefinitions;

    import io.cucumber.java.Before;
    import io.cucumber.java.ParameterType;
    import net.serenitybdd.screenplay.Actor;
    import net.serenitybdd.screenplay.actors.OnStage;
    import net.serenitybdd.screenplay.actors.OnlineCast;

    public class ParameterDefinitions {

        // Define a custom Cucumber parameter type for mapping actor names in feature files to Actor objects
        @ParameterType(".*")
        public Actor actor(String actorName) {
            // Create or retrieve an Actor instance with the given name
            return OnStage.theActorCalled(actorName);
        }

        // This method is executed before each scenario to set up the "stage" for the actors
        @Before
        public void setTheStage() {
            // Initialize the "stage" with an OnlineCast, which manages the actors
            OnStage.setTheStage(new OnlineCast());
        }
    }