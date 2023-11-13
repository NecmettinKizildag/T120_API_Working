package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C10_Get_ExpectedDataHazirlama {

    /*
 https://jsonplaceholder.typicode.com/posts/22 url'ine
 bir GET request yolladigimizda donen response body'sinin
 asagida verilen ile ayni oldugunu test ediniz

Response body :
 {
 "userId":3,
 "id":22,
 "title":"dolor sint quo a velit explicabo quia nam",
 "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
 }
  */

    @Test
    public void getExp(){
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // expected body hazirlama
        JSONObject expBody = new JSONObject();

        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //System.out.println(expBody.toString());


        // response kaydetme
        Response response = given().when().get(url);

        // assertion

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(expBody.get("userId"),jsonPath.get("userId"));
        Assert.assertEquals(expBody.get("id"),jsonPath.get("id"));
        Assert.assertEquals(expBody.get("title"),jsonPath.get("title"));
        Assert.assertEquals(expBody.get("body"),jsonPath.get("body"));
    }
}
