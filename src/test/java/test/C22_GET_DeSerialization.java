package test;

import baseUrl.dummyBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatas.TestDataJSONPlace;
import testDatas.testDataDummy;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class C22_GET_DeSerialization extends dummyBaseURL {

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
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        testDataDummy testDataDummy = new testDataDummy();

        HashMap<String,Object> expBody = testDataDummy.dataOlusturMAP();

        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        HashMap<String,Object> respMAP = response.as(HashMap.class);

        Assert.assertEquals(testDataDummy.okStatusKodu,response.getStatusCode());
        Assert.assertEquals(testDataDummy.contentType,response.getContentType());
        Assert.assertEquals(expBody.get("status"),respMAP.get("status"));
        Assert.assertEquals(expBody.get("message"),respMAP.get("message"));

        Assert.assertEquals(((Map)(expBody.get("data"))).get("id"),((Map)(respMAP.get("data"))).get("id"));
        Assert.assertEquals(((Map)(expBody.get("data"))).get("employee_name"),((Map)(respMAP.get("data"))).get("employee_name"));
        Assert.assertEquals(((Map)(expBody.get("data"))).get("employee_salary"),((Map)(respMAP.get("data"))).get("employee_salary"));
        Assert.assertEquals(((Map)(expBody.get("data"))).get("employee_age"),((Map)(respMAP.get("data"))).get("employee_age"));
        Assert.assertEquals(((Map)(expBody.get("data"))).get("profile_image"),((Map)(respMAP.get("data"))).get("profile_image"));

    }

}
