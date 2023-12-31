package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C12_GET_SoftAssert {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET request
gonderdigimizde donen response'un asagidaki gibi oldugunu test edin.

    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
 */
    
    @Test
    public void get01(){
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        
        JSONObject innerBody = new JSONObject();
        
        innerBody.put("id",3);
        innerBody.put("employee_name","Ashton Cox");
        innerBody.put("employee_salary",86000);
        innerBody.put("employee_age",66);
        innerBody.put("profile_image","");
        
        
        JSONObject expBody = new JSONObject();
        
        expBody.put("status","success");
        expBody.put("data",innerBody);
        expBody.put("message","Successfully! Record has been fetched.");


        Response response = given().when().get(url);

        JsonPath jsonPath = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals(expBody.get("status"),jsonPath.get("status"));
        softAssert.assertEquals(expBody.getJSONObject("data").get("id"),jsonPath.get("data.id"));
        softAssert.assertEquals(expBody.getJSONObject("data").get("employee_name"),jsonPath.get("data.employee_name"));
        softAssert.assertEquals(expBody.getJSONObject("data").get("employee_salary"),jsonPath.get("data.employee_salary"));
        softAssert.assertEquals(expBody.getJSONObject("data").get("employee_age"),jsonPath.get("data.employee_age"));
        softAssert.assertEquals(expBody.getJSONObject("data").get("profile_image"),jsonPath.get("data.profile_image"));
        softAssert.assertEquals(expBody.get("message"),jsonPath.get("message"));

    }
}
