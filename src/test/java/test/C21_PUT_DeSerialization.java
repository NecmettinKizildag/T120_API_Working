package test;

import baseUrl.jsonPlaceBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatas.TestDataJSONPlace;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.*;

public class C21_PUT_DeSerialization extends jsonPlaceBaseUrl {

    /*
https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
body'e sahip bir PUT request yolladigimizda donen response'in
response body'sinin asagida verilen ile ayni oldugunu test ediniz

Request Body

    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }

Expected Data :

    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
 */

    @Test
    public void put01(){
        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJSONPlace testDataJSONPlace = new TestDataJSONPlace();

        HashMap<String, Object> reqBody = testDataJSONPlace.reqBodyOlusturMAP();

        HashMap<String, Object> expBody = testDataJSONPlace.reqBodyOlusturMAP();

        Response response = given().spec(specJsonPlace).contentType(ContentType.JSON)
                            .when().body(reqBody).put("/{pp1}/{pp2}");


        HashMap<String,Object> resMAP = response.as(HashMap.class);

        Assert.assertEquals(expBody.get("title"),resMAP.get("title"));
        Assert.assertEquals(expBody.get("body"),resMAP.get("body"));
        Assert.assertEquals(expBody.get("userId"),resMAP.get("userId"));
        Assert.assertEquals(expBody.get("id"),resMAP.get("id"));
    }

}
