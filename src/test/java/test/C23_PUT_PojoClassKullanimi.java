package test;

import baseUrl.jsonPlaceBaseUrl;
import org.junit.Test;
import testDatas.TestDataJSONPlace;

import java.util.HashMap;

public class C23_PUT_PojoClassKullanimi extends jsonPlaceBaseUrl {
/*
https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
 body'e sahip bir PUT request yolladigimizda donen response'in
 response body'sinin asagida verilen ile ayni oldugunu test ediniz

 Request Body

{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}

Response Body Expected

{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}
 */

    @Test
    public void put01(){
        specJsonPlace.pathParams("pp1","posts","pp2",70);


    }

}
