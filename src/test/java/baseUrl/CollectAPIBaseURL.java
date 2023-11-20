package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class CollectAPIBaseURL {

    protected RequestSpecification specCollectAPI;

    @Before
    public void setup(){
        specCollectAPI = new RequestSpecBuilder().setBaseUri("https://api.collectapi.com").build();
    }
}
