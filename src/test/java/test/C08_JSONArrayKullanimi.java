package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C08_JSONArrayKullanimi {

    /*
        {
        "firstName": "John",
        "lastName": "doe",
        "age": 26,
        "address": {
            "streetAddress": "naist street",
            "city": "Nara",
            "postalCode": "630-0192"
                    },
        "phoneNumbers": [
                        {
                            "type": "iPhone",
                            "number": "0123-4567-8888"
                        },
                        {
                            "type": "home",
                            "number": "0123-4567-8910"
                        }
                        ]
        }
 */

    @Test
    public void JSONArray(){

        JSONObject cepTel = new JSONObject();

        cepTel.put("type", "iPhone");
        cepTel.put("number", "0123-4567-8888");


        JSONObject evTel = new JSONObject();

        evTel.put("type", "home");
        evTel.put("number", "0123-4567-8910");


        JSONArray tel = new JSONArray();

        tel.put(0,cepTel);
        tel.put(1,evTel);



        JSONObject adres = new JSONObject();

        adres.put("streetAddress", "naist street");
        adres.put("city", "Nara");
        adres.put("postalCode", "630-0192");


        JSONObject personal = new JSONObject();

        personal.put("firstName", "John");
        personal.put("lastName", "doe");
        personal.put("age", 26);
        personal.put("address",adres);
        personal.put("phoneNumbers",tel);

        //System.out.println("personal = " + personal);

        System.out.println("kisi adi = " + personal.get("firstName"));
        System.out.println("kisi soyadi = " + personal.get("lastName"));
        System.out.println("kisi yasi = " + personal.get("age"));
        System.out.println("kisi adres-sokak/cadde = " + personal.getJSONObject("address").get("streetAddress"));
        System.out.println("kisi adres-sehir = " + personal.getJSONObject("address").get("city"));
        System.out.println("kisi adres-posta kodu = " + personal.getJSONObject("address").get("postalCode"));
        System.out.println("kisi telefon 1 tip = " + personal.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
        System.out.println("kisi telefon 1 numara = " + personal.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("kisi telefon 2 tip = " + personal.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
        System.out.println("kisi telefon 2 numara = " + personal.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));

    }
}
