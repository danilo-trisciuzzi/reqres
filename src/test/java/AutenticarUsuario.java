import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class AutenticarUsuario {
    @Test
    public void autenticarUsuarioComSucesso() {
        given()
                .body("{\n" +
                        "  \"username\": \"janet.weaver@reqres.in\",\n" +
                        "  \"email\": \"janet.weaver@reqres.in\",\n" +
                        "  \"password\": \"teste123\"\n" +
                        "}")
                .contentType(ContentType.JSON)
        .when()
                .post("https://reqres.in/api/login")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("token",is("QpwL5tke4Pnpja7X2"))
        ;
    }
}