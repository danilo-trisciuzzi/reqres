import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CriarUsuario {

    @BeforeClass
    public static void habilitarLog(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void criarUsuarioComSucesso() {
        given()
                .body("{\n" +
                        "    \"name\": \"alberto\",\n" +
                        "    \"job\": \"chefe\"\n" +
                        "}")
                .contentType(ContentType.JSON)
        .when()
                .post("https://reqres.in/api/users")
        .then()
//                .log().all()
                .assertThat()
                .statusCode(201)
                .body("name",is("alberto"))
                .body("job",is("chee"))
        ;
    }
}