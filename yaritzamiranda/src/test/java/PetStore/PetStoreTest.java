package PetStore;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreTest {

    @Test
    public void addPetToStore() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        String requestBody = "{\n" +
                "  \"id\": 1995,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post("/pet").
                then().
                statusCode(200).
                body("name", equalTo("doggie"));
    }

    @Test
    public void getPetById() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        int petId = 1995; // replace with the actual pet ID

        given().
                pathParam("petId", petId).
                when().
                get("/pet/{petId}").
                then().
                statusCode(200).
                body("id", equalTo(petId));
    }

    @Test
    public void updatePetStatusAndName() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        int petId = 1995;
        String requestBody = "{\n" +
                "  \"id\": " + petId + ",\n" +
                "  \"name\": \"cat\",\n" +
                "  \"status\": \"sold\"\n" +
                "}";

        given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                put("/pet").
                then().
                statusCode(200).
                body("name", equalTo("cat")).
                body("status", equalTo("sold"));
    }
}
