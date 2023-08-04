import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RegistrarUsuario {
    @Test
    public void registrarUsuarioComSucesso() {
        given()
                .body("{\n" +
                        "  \"username\": \"janet.weaver@reqres.in\",\n" +
                        "  \"email\": \"janet.weaver@reqres.in\",\n" +
                        "  \"password\": \"teste123\"\n" +
                        "}")
                .contentType(ContentType.JSON)
        .when()
                .post("https://reqres.in/api/register")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("id",is(2))
                .body("token",is("QpwL5tke4Pnpja7X2"))
        ;
    }
}