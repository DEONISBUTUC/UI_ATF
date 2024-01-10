package com.luma.api.StepDeff;

import com.luma.api.api.methods.OrangeApiMethods;
import com.luma.api.context.ScenarioContext;

import com.luma.api.dto.DeviceDto;
import com.luma.api.dto.OrangeRequestDtoGetHomePage;
import com.luma.api.dto.OrangeResponseDtoGetHomePage;
import com.luma.api.dto.OrangeResponseDtoGetLaptopsCatalog;
import com.luma.api.templates.OrangeTemplates;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;


import java.util.ArrayList;

import static com.luma.api.context.CONTEXT.*;


public class ActionSteps {

    @When("the user navigates to the Home Page with POST request containing the following parameters:")
    public void theUserNavigatesToTheHomePageWithPOSTRequestContainingTheFollowingParameters(DataTable dataTable) {

        OrangeTemplates orangeTemplates = new OrangeTemplates();
        OrangeRequestDtoGetHomePage request = orangeTemplates.getHomePageRequest(dataTable);
        Response responseProduct = OrangeApiMethods.productCollections(request);
        OrangeResponseDtoGetHomePage homePageSpec = responseProduct.then()
                .log()
                .all()
                .extract()
                .body()
                .as(OrangeResponseDtoGetHomePage.class);

        ScenarioContext.getInstance().addToStorageContext(ORANGE_REQUEST_DTO, request);
        ScenarioContext.getInstance().addToStorageContext(ORANGE_RESPONSE_DTO, homePageSpec);
        ScenarioContext.getInstance().addToStorageContext(RESPONSE_STATUS_CODE, responseProduct.getStatusCode());

    }


    @When("the user clicks on the Laptops on the bar menu")
    public void theUserClicksOnTheLaptopsOnTheBarMenu() {

        OrangeResponseDtoGetLaptopsCatalog orangeResponseDtoGetLaptopsCatalog;
        Response responseLaptop = OrangeApiMethods.getLaptopCatalog();
        orangeResponseDtoGetLaptopsCatalog = responseLaptop.then()
                .log()
                .all()
                .extract()
                .body()
                .as(OrangeResponseDtoGetLaptopsCatalog.class);

        ScenarioContext.getInstance().addToStorageContext(ORANGE_RESPONSE_GET_LAPTOPS, orangeResponseDtoGetLaptopsCatalog);
        ScenarioContext.getInstance().addToStorageContext(RESPONSE_STATUS_CODE , responseLaptop.getStatusCode());
    }

    @When("the following product details are displayed:")
    public void theFollowingProductDetailsAreDisplayed(DataTable dataTable) {

        var actualResult = (OrangeResponseDtoGetLaptopsCatalog) ScenarioContext.getInstance().getStoredValueFromContext(ORANGE_RESPONSE_GET_LAPTOPS);
        ArrayList<DeviceDto> devices = actualResult.getDevice();
        var expectedDeviceName = dataTable.asMap().keySet().stream().toList().stream().findFirst().orElse(null);
        var expectedDevicePrice = dataTable.asMap().values().stream().toList().stream().findFirst().orElse(null);

        Assert.assertTrue("The expected device name is displayed" + expectedDeviceName, expectedDeviceName != null && devices.stream().anyMatch(device -> expectedDeviceName.equals(device.getName())));
        Assert.assertTrue("The expected device price is displayed" + expectedDevicePrice, expectedDevicePrice != null && devices.stream().anyMatch(device -> Integer.parseInt(expectedDevicePrice) == device.getPrice().getPrice()));;
    }

    @When("navigate using following values:")
    public void navigateUsingFollowingValues(DataTable dataTable) {

        OrangeTemplates orangeTemplates1 = new OrangeTemplates();
        OrangeRequestDtoGetHomePage homePageRequest = orangeTemplates1.getHomePageRequest(dataTable);

        ScenarioContext.getInstance().addToStorageContext(ORANGE_REQUEST_DTO, homePageRequest);
    }


}


