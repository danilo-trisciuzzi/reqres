package teste;

import dominio.AtributosUsuario;
import dominio.BaseTeste;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CriarUsuario extends BaseTeste {

    private static final String CRIAR_USUARIO_ENDPOINT = "/user";

    @Test
    public void criarUsuarioComSucesso() {
        AtributosUsuario usuario = new AtributosUsuario("Alberto","Gerente");
        given()
                .body(usuario)
        .when()
                .post(CRIAR_USUARIO_ENDPOINT)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("name",is("Alberto"))
                .body("job",is("Gerente"))
        ;
    }
}