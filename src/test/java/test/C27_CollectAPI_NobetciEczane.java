package test;

import baseUrl.CollectAPIBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C27_CollectAPI_NobetciEczane extends CollectAPIBaseURL {


    @Test
    public void get01(){
        specCollectAPI.pathParams("1","health","2","dutyPharmacy")
                      .queryParams("ilce","Üsküdar","il","İstanbul");


        Response response = given().spec(specCollectAPI)
                .headers("authorization","apikey 3oWGvoApETmo1F6hpT9SsV:7HBRNtNcHHJTOlWVtUcOSE"
                            ,"content-type","application/json")
                .when().get("/{1}/{2}");


        response.prettyPrint();
    }
}
