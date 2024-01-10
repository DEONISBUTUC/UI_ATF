package com.luma.api.api.methods;

import com.luma.api.dto.OrangeRequestDtoGetHomePage;

import com.luma.ui.managers.ConfigPropertiesReaderManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.luma.api.paths.OrangeShopApi.GET_LAPTOP_CATALOG;
import static com.luma.api.paths.OrangeShopApi.GET_PRODUCT_COLLECTION;
import static io.restassured.RestAssured.given;


public class OrangeApiMethods {



    public static RequestSpecification spec() {
        String baseUrl = ConfigPropertiesReaderManager.getPropertyValue("baseUrl");
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static Response productCollections(OrangeRequestDtoGetHomePage body){
        String baseUrl = ConfigPropertiesReaderManager.getPropertyValue("baseUrl");
        RequestSpecification spec = spec();
        return given()
                .spec(spec)
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post(GET_PRODUCT_COLLECTION);

    }

    public static Response getLaptopCatalog (){
        String baseUrl = ConfigPropertiesReaderManager.getPropertyValue("baseUrl");
        RequestSpecification spec = spec();
        return  given()
                .spec(spec)
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .when()
                .get(GET_LAPTOP_CATALOG);

    }


}
