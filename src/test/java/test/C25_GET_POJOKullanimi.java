package test;

import baseUrl.dummyBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyDataPOJO;
import pojos.DummyExpDataPOJO;

import static io.restassured.RestAssured.given;

public class C25_GET_POJOKullanimi extends dummyBaseURL {
/*
http://dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET
request gonderdigimizde donen response'un status code'unun 200,
content Type'inin application/json ve body'sinin asagidaki gibi
oldugunu test edin.

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
        specDummy.pathParams("first","api","second","v1","third","employee","fourth","3");

        DummyDataPOJO data = new DummyDataPOJO(3,"Ashton Cox",86000,66,"");
        DummyExpDataPOJO expDataPOJO = new DummyExpDataPOJO("success",data,"Successfully! Record has been fetched.");

        Response response = given().spec(specDummy).when().get("/{first}/{second}/{third}/{fourth}");

        //response.prettyPrint();

        DummyExpDataPOJO resPOJO = response.as(DummyExpDataPOJO.class);

        Assert.assertEquals(expDataPOJO.getStatus(),resPOJO.getStatus());
        Assert.assertEquals(expDataPOJO.getData().getId(),resPOJO.getData().getId());
        Assert.assertEquals(expDataPOJO.getData().getEmployee_name(),resPOJO.getData().getEmployee_name());
        Assert.assertEquals(expDataPOJO.getData().getEmployee_salary(),resPOJO.getData().getEmployee_salary());
        Assert.assertEquals(expDataPOJO.getData().getEmployee_age(),resPOJO.getData().getEmployee_age());
        Assert.assertEquals(expDataPOJO.getData().getProfile_image(),resPOJO.getData().getProfile_image());
        Assert.assertEquals(expDataPOJO.getMessage(),resPOJO.getMessage());
    }
}
