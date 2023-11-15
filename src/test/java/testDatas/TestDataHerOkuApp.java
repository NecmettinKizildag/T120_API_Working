package testDatas;

import org.json.JSONObject;

public class TestDataHerOkuApp {
    public int okStatusKodu = 200;



    public JSONObject reqBodyOlusturJSON(){

        JSONObject innerBody = new JSONObject();

        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");


        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname","Ali");
        reqBody.put("lastname","Bak");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerBody);
        reqBody.put("additionalneeds","wi-fi");

        return reqBody;
    }

    public JSONObject expBodyOlusturJSON(){

        JSONObject expBody = new JSONObject();

        expBody.put("bookingid",24);
        expBody.put("booking",reqBodyOlusturJSON());

        return expBody;
    }
}
