package dominio;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class TesteBase {
    @BeforeClass
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "https://reqres.in";
        basePath = "/api";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();

        //Para a response, o ideal seria se todos os retornos fossem iguais, ou colocando no BeforeClass dos testes onde os retornos sejam iguais
/*        RestAssured.responseSpecification = new ResponseSpecBuilder();
                .expectStatusCode(HttpStatus.SC_OK)
                .build();*/
    }
}
