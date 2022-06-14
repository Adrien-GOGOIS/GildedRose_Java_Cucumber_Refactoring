package com.gildedrose;

import static org.junit.Assert.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {
    private final List<Item> items = new ArrayList<>();
    private GildedRose app;

    @Given("The {string} is sellIn {int} and quality {int}")
    public void the_item_is(String string , int sellIn, int quality) {
        items.add(new Item(string, sellIn, quality));
        app = new GildedRose(items);
    }
    @When("I update the sellIn and the quality of 1 day")
    public void i_update_the_sell_in_and_the_quality() {
        app.updateQuality();
    }
    @Then("I should get item sellIn {int} and quality {int}")
    public void i_should_get_item_sellIn(int expectedSellIn, int expectedQuality) {
        assertEquals(expectedSellIn, app.items.get(0).sellIn);
        assertEquals(expectedQuality, app.items.get(0).quality);
    }

}

