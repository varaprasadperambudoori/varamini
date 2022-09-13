import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import io.restassured.*;

publc class RestUtil{
    private final Logger LOGGER = LogManager.getLogger(RestUtil.class);

    public Response setURL(String uri){
        RestAssured.baseURI = uri;
    }

}