package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C11_POST_ExpectedBody {

    /*
    https://restful-booker.herokuapp.com/booking url'ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response'un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : "Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }


                       Response Body - Expected Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
*/

    @Test
    public void postExp(){
        String url = "https://restful-booker.herokuapp.com/booking";


        JSONObject innerDates = new JSONObject();

        innerDates.put("checkin" , "2021-06-01");
        innerDates.put("checkout" , "2021-06-10");


        JSONObject innerPers = new JSONObject();

        innerPers.put("firstname" , "Ahmet");
        innerPers.put("lastname" , "Bulut");
        innerPers.put("totalprice" , 500);
        innerPers.put("depositpaid" , false);
        innerPers.put("bookingdates" ,innerDates);
        innerPers.put("additionalneeds" , "wi-fi");



        JSONObject reqBody = new JSONObject();

        reqBody.put("bookingid",24);
        reqBody.put("booking",innerPers);




        Response response = given().contentType(ContentType.JSON).when().body(innerPers.toString()).post(url);


        JsonPath jsonPath = response.jsonPath();

        //Assert.assertEquals(reqBody.get("bookingid"),jsonPath.get("bookingid"));
        Assert.assertEquals(reqBody.getJSONObject("booking").get("firstname"),jsonPath.get("booking.firstname"));
        Assert.assertEquals(reqBody.getJSONObject("booking").get("lastname"),jsonPath.get("booking.lastname"));
        Assert.assertEquals(reqBody.getJSONObject("booking").get("totalprice"),jsonPath.get("booking.totalprice"));
        Assert.assertEquals(reqBody.getJSONObject("booking").get("depositpaid"),jsonPath.get("booking.depositpaid"));
        Assert.assertEquals(reqBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),jsonPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(reqBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),jsonPath.get("booking.bookingdates.checkout"));
        Assert.assertEquals(reqBody.getJSONObject("booking").get("additionalneeds"),jsonPath.get("booking.additionalneeds"));


    }



}
