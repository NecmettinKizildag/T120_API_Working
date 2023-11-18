package test;

import baseUrl.herOkuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPOJO;
import pojos.BookingPOJO;
import pojos.HerOkuAppPOJO;

import static io.restassured.RestAssured.given;

public class C24_POST_POJOClass extends herOkuAppBaseURL {
    /*
https://restful-booker.herokuapp.com/booking url'ine
asagidaki body'ye sahip bir POST request gonderdigimizde
donen response'un id disinda asagidaki gibi oldugunu test edin.
                    Request body
               {
                    "firstname" : "Ali",
                    "lastname" : "Bak",
                    "totalprice" : 500,
                    "depositpaid" : false,
                    "bookingdates" : {
                             "checkin" : "2021-06-01",
                             "checkout" : "2021-06-10"
                                      },
                    "additionalneeds" : "wi-fi"
                }


                   Response Body = Expected Data
                   {
                "bookingid":24,
                "booking":{
                    "firstname":"Ali",
                    "lastname":"Bak",
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
    public void post01(){
        specHerOkuApp.pathParams("pp1","booking");

        BookingDatesPOJO bookingDates = new BookingDatesPOJO("2021-06-01","2021-06-10");

        BookingPOJO reqBody = new BookingPOJO("Ali","Bak",500,false,bookingDates,"wi-fi");


        HerOkuAppPOJO expBody = new HerOkuAppPOJO(547,reqBody);

        Response response = given().spec(specHerOkuApp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");

        HerOkuAppPOJO respPOJO = response.as(HerOkuAppPOJO.class);


        //Assert.assertEquals(expBody.getBookingid(),respPOJO.getBookingid());
        Assert.assertEquals(expBody.getBookingPOJO().getFirstname(),respPOJO.getBookingPOJO().getFirstname());
        Assert.assertEquals(expBody.getBookingPOJO().getLastname(),respPOJO.getBookingPOJO().getLastname());
        Assert.assertEquals(expBody.getBookingPOJO().getTotalprice(),respPOJO.getBookingPOJO().getTotalprice());
        Assert.assertEquals(expBody.getBookingPOJO().isDepositpaid(),respPOJO.getBookingPOJO().isDepositpaid());
        Assert.assertEquals(expBody.getBookingPOJO().getBookingdates().getCheckin(),respPOJO.getBookingPOJO().getBookingdates().getCheckin());
        Assert.assertEquals(expBody.getBookingPOJO().getBookingdates().getCheckout(),respPOJO.getBookingPOJO().getBookingdates().getCheckout());
        Assert.assertEquals(expBody.getBookingPOJO().getAdditionalneeds(),respPOJO.getBookingPOJO().getAdditionalneeds());
    }
}
