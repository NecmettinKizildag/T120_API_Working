package test;

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
    }
}
