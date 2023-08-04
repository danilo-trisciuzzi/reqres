package teste;

import dominio.AtributosUsuario;
import dominio.BaseTeste;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.basePath;
import static org.hamcrest.Matchers.is;

public class CriarUsuario extends BaseTeste {

    @Test
    public void criarUsuarioComSucesso() {
        AtributosUsuario usuario = new AtributosUsuario("Alberto","Gerente");
        given()
                .body(usuario)
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