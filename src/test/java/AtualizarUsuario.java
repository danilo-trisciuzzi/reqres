import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class AtualizarUsuario {
    @Test
    public void atualizarUsuarioComSucesso() {
        given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .contentType(ContentType.JSON)
        .when()
                .put("https://reqres.in/api/users/2")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("name",is("morpheus"))
                .body("job",is("zion resident"))
        ;
    }
}