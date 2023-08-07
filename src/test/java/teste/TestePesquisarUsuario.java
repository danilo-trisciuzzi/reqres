package teste;

import dominio.AtributosUsuario;
import dominio.TesteBase;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestePesquisarUsuario extends TesteBase {

    private static final String PESQUISAR_USUARIO_ENDPOINT = "/users/{userId}";

/*    @BeforeClass
    public static void setupAlternativo(){
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CREATED)
                .build();
    }*/

    @Test
    public void buscarUmUsuarioComSucesso() {
        given()
                .pathParam("userId",1)
        .when()
                .get(PESQUISAR_USUARIO_ENDPOINT)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id",is(1))
                .body("data.first_name",is("George"))
                .body("data.email", containsString("@reqres.in"))
                .body("support.url",is(notNullValue()))
        ;
    }

    @Test
    public void buscarUsuarioComSucesso() {
        AtributosUsuario usuario = given()
                .pathParam("userId",2)
        .when()
                .get(PESQUISAR_USUARIO_ENDPOINT)
        .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
        .extract()
                .body().jsonPath().getObject("data", AtributosUsuario.class);

        assertThat(usuario.getEmail(), containsString("@reqres.in"));
        assertThat(usuario.getName(), is("Janet"));
        assertThat(usuario.getLastName(),is("Weaver"));
    }

}