package SandboxAPITest;

import com.api.Constants;
import io.restassured.RestAssured;
import static com.api.Constants.*;
import static com.api.JsonToPojo.convertFromJsonObj;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.io.File;
import java.lang.reflect.Field;

public class SandboxTest {
    private static final Logger LOGGER= LogManager.getLogger(SandboxTest.class);
    String user="c598a04a-5c04-4dad-a5b5-d5dfc66e5feb";
    String password = "5f791fce-154f-4d7f-ba7a-a4b44212a146";
    //program mini token
    String token = "27e5e431-8459-4421-a00f-379624c9a5ad";
    //static PrintStream log;

        @Rule
        public TestWatcher watcher = new TestWatcher() {
            @Override
            protected void failed(Throwable e, Description description) {
                System.out.println("I AM RIGHT HERE!");
                LOGGER.error(""+description.getDisplayName()+" failed "+e.getMessage());
                super.failed(e, description);
            }
        };

    @BeforeClass
    public static void setup(){
        RestAssured.baseURI=BASEURI;
        //log = IoBuilder.forLogger(SandboxTest.class).setLevel(Level.ALL).buildPrintStream();
        //System.setOut(log);
        //ToLogger
        //RestAssured.config = RestAssured.config().logConfig(new LogConfig());
        LOGGER.info("Setup base uri");
    }

    @Test
    public void createProgramSource(){
        System.out.println(RestAssured.baseURI);
        JSONObject json = new JSONObject();
        json.put("name","Program Mini");
        RequestSpecification req = RestAssured.given()
                .auth().basic(user,password);

        Response res = req.header("Content-Type","application/json")
                .body(json.toString())
                .post(CREATEPROGRAMSOURCE);

        JSONObject responseJSON = new JSONObject(res.body().asString());
        String name = findVariableName(CREATEPROGRAMSOURCE).toLowerCase();
        makePojo(name,responseJSON);
        Assert.assertEquals(201,res.getStatusCode());
        LOGGER.info("Pass createProgramSource\nStatus Code : "+res.getStatusCode()
                +" Payload: "+res.getBody().prettyPrint());
    }

    @Test
    public void getProgramSource(){
        System.out.println(RestAssured.baseURI);
        JSONObject json = new JSONObject();
        json.put("name","Program Mini");
        RequestSpecification req = RestAssured.given()
                .auth().basic(user,password);

        Response res = req.accept(ContentType.JSON).get(GETPROGRAMSOURCE +token);

        JSONObject responseJSON = new JSONObject(res.body().asString());
        makePojo(findVariableName(GETPROGRAMSOURCE).toLowerCase(),responseJSON);
        String name = findVariableName(GETPROGRAMSOURCE).toLowerCase();
        File file = new File(POJO_SOURCE +POJO_FOLDER+"/"+name+"Pojo.java");
        System.out.println(POJO_SOURCE+POJO_FOLDER+name+"Pojo.java");
        Assert.assertEquals(200,res.getStatusCode());
        LOGGER.info("Pass getProgramSource\nStatus Code : "+res.getStatusCode()
                +" Payload: "+res.getBody().prettyPrint());
        //LOGGER.log(Level.FATAL,"Status Code: "+res.getStatusCode()+"\nPayload: "+res.getBody().prettyPrint());
    }
    @Test
    public void createUser(){
        JSONObject json = new JSONObject();
        String firstName="GoodFirstName";
        String lastName="BadLastName";
        String status="active";
        String email="randomemail@fakeemail.com";
        String phoneNum="(123)-456-6789";

        json.put("first_name",firstName);
        json.put("last_name",lastName);
        json.put("active",status);
        json.put("email",email);
        json.put("phone",phoneNum);
        RequestSpecification req = RestAssured.given()
                .auth().basic(user,password);
        Response res = req.body(json.toString()).post(CREATEUSER);
        JSONObject responseJSON = new JSONObject(res.body().asString());
        makePojo(findVariableName(CREATEUSER).toLowerCase(),responseJSON);
        Assert.assertEquals(201,res.getStatusCode());

        LOGGER.info("Create User\tStatus Code: "+res.getStatusCode()
        +"\nPayload: "+res.getBody().prettyPrint());
    }
    public String findVariableName(String value){
        String name="";
        //Field[] f = Constants.class.getDeclaredFields();
        for(Field fieldName: Constants.class.getDeclaredFields()){
            try{
                if(fieldName.get(this).equals(value)){
                    name = fieldName.getName();
                }

            }catch (Exception e ){
                e.printStackTrace();
            }
        }
        return name;
    }
    public void makePojo(String endpointName, JSONObject json){
        File file = new File(POJO_SOURCE +POJO_FOLDER+"/"+endpointName+"ResPojo.java");
        System.out.println(POJO_SOURCE+POJO_FOLDER+endpointName+"ResPojo.java");
        if(!file.exists()){
            System.out.println("file doesn't exist");
            convertFromJsonObj(json,
                    new File(POJO_SOURCE),
                    POJO_FOLDER.replace("/","."),
                    endpointName+"ResPojo");
            LOGGER.info("Created Pojo for Create Program Source");
        }else{
            LOGGER.info("Pojo found.");
            System.out.println("Found the file!");
        }
    }
}

