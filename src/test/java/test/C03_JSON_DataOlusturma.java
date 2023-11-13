package test;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C03_JSON_DataOlusturma {
    /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":1
        }
    */

    @Test
    public void JSONData(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",1);

        System.out.println("ilk olusturdugum jsonObject = " + jsonObject);
    }

    @Test
    public void innerJSON(){
        /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.

        {
        "firstname":"Jim",
         "additionalneeds":"Breakfast",
         "bookingdates":{
                        "checkin":"2018-01-01",
                        "checkout":"2019-01-01"
                        },
        "totalprice":111,
        "depositpaid":true,
         "lastname":"Brown"
        }
         */

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        JSONObject outterJson = new JSONObject();
        outterJson.put("firstname","Jim");
        outterJson.put("additionalneeds","Breakfast");
        outterJson.put("bookingdates",bookingdates);
        outterJson.put("totalprice",111);
        outterJson.put("depositpaid",true);
        outterJson.put("lastname","Brown");

        System.out.println("outterJson = " + outterJson);
        //{
        // "firstname":"Jim",
        // "additionalneeds":"Breakfast",
        // "bookingdates":
        //     {
        //     "checkin":"2018-01-01",
        //     "checkout":"2019-01-01"
        //     },
        // "totalprice":111,
        // "depositpaid":true,
        // "lastname":"Brown"
        // }
    }
}
