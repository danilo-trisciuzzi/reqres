package teste;

import dominio.AtributosUsuario;
import dominio.BaseTeste;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AtualizarUsuario extends BaseTeste {

    @Test
    public void atualizarUsuarioComSucesso() {
        AtributosUsuario usuario = new AtributosUsuario("morpheus","zion resident");
        given()
                .body(usuario)
                .contentType(ContentType.JSON)
        .when()
                .put("/users/2")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("name",is("morpheus"))
                .body("job",is("zion resident"))
                .body("updatedAt",is(notNullValue()))
        ;
    }
}