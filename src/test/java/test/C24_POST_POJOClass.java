package test;

import baseUrl.herOkuAppBaseURL;
import org.junit.Test;
import pojos.BookingDatesPOJO;
import pojos.BookingPOJO;

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

    }
}
