package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_PUTSoftAssertExpectedBodyTest {

    /*
https://dummy.restapiexample.com/api/v1/update/21 url'ine asagidaki
body'ye sahip bir PUT request gonderdigimizde donen response'un asagidaki gibi oldugunu test edin.

        Request Body
        {
            "status":"success",
            "data":{
                    "name":"Ahmet",
                    "salary":"1230",
                    "age":"44",
                    "id":40
                    }
        }

        Response Body

        {
        "status":"success",
        "data":{
            "status":"success",
            "data":{
                    "name":"Ahmet",
                    "salary":"1230",
                    "age":"44",
                    "id":40
                    }
               },
        "message":"Successfully! Record has been updated."
        }
             */


    @Test
    public void test01(){
        String url = "https://dummy.restapiexample.com/api/v1/update/21";


        // request body
        JSONObject data = new JSONObject();

        data.put("name","Ahmet");
        data.put("salary","1230");
        data.put("age","44");
        data.put("id",40);


        JSONObject reqBody = new JSONObject();

        reqBody.put("status","success");
        reqBody.put("data",data);


        //expected response body
        JSONObject expReqBody = new JSONObject();

        expReqBody.put("status","success");
        expReqBody.put("data",reqBody);
        expReqBody.put("message","Successfully! Record has been updated.");


        // reponse kaydetme
        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

        JsonPath resJP = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(resJP.get("status"),expReqBody.get("status"));
        softAssert.assertEquals(resJP.get("data.status"),expReqBody.getJSONObject("data").get("status"));
        softAssert.assertEquals(resJP.get("data.data.name"),expReqBody.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(resJP.get("data.data.salary"),expReqBody.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(resJP.get("data.data.age"),expReqBody.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(resJP.get("data.data.id"),expReqBody.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(resJP.get("message"),expReqBody.get("message"));

        softAssert.assertAll();
    }
}
