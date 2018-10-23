import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Get404 extends BaseClass{

    @BeforeMethod
    public void setup(){

        client =  HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {

        client.close();
        response.close();
    }

    @Test
    public void notExistingUrlReturns404() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/nonexistingurl");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        Assert.assertEquals(actualStatus, 404);
    }
}
