package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {

    /*
        C1_Get_ApiSorgulama
        https://restful-booker.herokuapp.com/booking/1488 url'ine bir GET request
        gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application/json; charset=utf-8, ve Server isimli Header'in degerinin Cowboy,
        ve status Line'in HTTP/1.1 200 OK
        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
     */

    // 1- url belirleyip url adresine gidecegiz
    // 2- expected data veirlmisse expected data hazilanir
    // 3- actual data alinacak
    // 4- assetion islemi

    @Test
    public void get01(){
        String url = "https://restful-booker.herokuapp.com/booking/412";

        Response response = given().when().get(url);

        // response.prettyPrint();

        System.out.println("Status Code : "+response.getStatusCode()); // 200
        System.out.println("Content Type : "+response.getContentType()); // application/json; charset=utf-8
        System.out.println("Server Header Degeri : "+response.getHeader("Server")); // Cowboy
        System.out.println("Status Line : "+response.getStatusLine()); // HTTP/1.1 200 OK
        System.out.println("Get Time : "+response.getTime()); // 1202
        //SoftAssert softAssert = new SoftAssert();
        //softAssert.assertTrue(response.getTime()<5000);
    }
}
