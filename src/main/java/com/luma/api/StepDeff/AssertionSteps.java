package com.luma.api.StepDeff;

import com.luma.api.api.methods.OrangeApiMethods;
import com.luma.api.context.ScenarioContext;
import com.luma.api.dto.*;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static com.luma.api.context.CONTEXT.*;


public class AssertionSteps {

    @Then("the response status code is '{}'")
    public void theResponseStatusCodeIs(int code) {
        Assert.assertEquals("Status code mismatch", code, ScenarioContext.getInstance().getStoredValueFromContext(RESPONSE_STATUS_CODE));
    }

    @Then("'Most Popular' and 'Recently Viewed' products are displayed")
    public void mostPopularAndRecentlyViewedProductsAreDisplayed() {

        OrangeResponseDtoGetHomePage apiResponse = (OrangeResponseDtoGetHomePage) ScenarioContext.getInstance()
                .getStoredValueFromContext(ORANGE_RESPONSE_DTO);
        var mostPopularProductsDto = apiResponse.getMostPopularProducts();
        var recentlyViewedProductsDto = apiResponse.getRecentlyViewedProducts();

        Assertions.assertEquals("Cele mai vizualizate", mostPopularProductsDto.getListInfo().getName());
        Assertions.assertEquals("Recently Viewed Products", recentlyViewedProductsDto.getListInfo().getName());
    }

    @Then("the user is redirected to the Laptops page")
    public void theUserIsRedirectedToTheLaptopsPage() {

        var apiResponseLaptops = OrangeApiMethods.getLaptopCatalog();
        var actualStatusCode = apiResponseLaptops.getStatusCode();
        var responseContainItems = (OrangeResponseDtoGetLaptopsCatalog) ScenarioContext.getInstance().getStoredValueFromContext(ORANGE_RESPONSE_GET_LAPTOPS);

        Assertions.assertEquals(200, actualStatusCode);
        Assertions.assertEquals("Laptopuri", responseContainItems.getName());


    }
}




