package test;

import baseUrl.jsonPlaceBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.TestDataJSONPlace;

import static io.restassured.RestAssured.given;

public class C18_PUT_TestDataClassKullanimi extends jsonPlaceBaseUrl {

    /*
  https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body'e sahip bir PUT
  request yolladigimizda donen response'in
  status kodunun 200, content type'inin "application/json; charset=utf-8",
  Connection header degerinin "keep-alive"
  ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

  Request Body

      {
      "title":"Ali",
      "body":"Merhaba",
      "userId":10,
      "id":70
      }

  Expected Data

      {
      "title":"Ali",
      "body":"Merhaba",
      "userId":10,
      "id":70
      }
*/

    @Test
    public void put01(){

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJSONPlace testDataJSONPlace = new TestDataJSONPlace();

        JSONObject expData = testDataJSONPlace.reqBodyOlusturJSON();

        JSONObject reqBody = testDataJSONPlace.reqBodyOlusturJSON();

        Response response = given().spec(specJsonPlace).contentType(ContentType.JSON)
                            .when().body(reqBody.toString()).put("/{pp1}/{pp2}");

        JsonPath respJS = response.jsonPath();

        Assert.assertEquals(testDataJSONPlace.okStatusKodu,response.getStatusCode());
        Assert.assertEquals(testDataJSONPlace.contentType,response.getContentType());
        Assert.assertEquals(testDataJSONPlace.connectionHeader,response.getHeader("Connection"));
        Assert.assertEquals(expData.get("title"),respJS.get("title"));
        Assert.assertEquals(expData.get("body"),respJS.get("body"));
        Assert.assertEquals(expData.get("userId"),respJS.get("userId"));
        Assert.assertEquals(expData.get("id"),respJS.get("id"));


    }
}
