import dominio.AtributosUsuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.basePath;
import static org.hamcrest.Matchers.is;

public class CriarUsuario {

    @BeforeClass
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "https://reqres.in";
        basePath = "/api";
    }

    @Test
    public void criarUsuarioComSucesso() {
        AtributosUsuario atributosUsuario = new AtributosUsuario("Alberto","Gerente");
        given()
                .body(atributosUsuario)
//                .body("{\n" +
//                        "    \"name\": \"alberto\",\n" +
//                        "    \"job\": \"chefe\"\n" +
//                        "}")
                .contentType(ContentType.JSON)
        .when()
                .post("/users")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("name",is("Alberto"))
                .body("job",is("Gerente"))
        ;
    }
}