package stepDefinitions;

import io.cucumber.java.en.*;

public class Deneme {
    @Given("user in the related webpage")
    public void user_in_the_related_webpage() {
        System.out.println("webpage");
    }
    @Given("cursor on the element")
    public void cursor_on_the_element() {
        System.out.println("cursor");
    }
    @When("drag and drop the element to another place")
    public void drag_and_drop_the_element_to_another_place() {
        System.out.println("drag-drop");
    }
    @Then("elements must be switched")
    public void elements_must_be_switched() {
        System.out.println("check");
    }
}
