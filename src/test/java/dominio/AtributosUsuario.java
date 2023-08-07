package dominio;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)

public class AtributosUsuario {
    @JsonAlias("first_name")
    private String name;
    @JsonAlias("last_name")
    private String lastName;
    private String job;
    private String username;
    private String email;
    private String password;

    public AtributosUsuario() {}

    public AtributosUsuario(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public AtributosUsuario(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //@JsonGetter("first_name")// Esse é um exemplo para adapar o getter com o nome do campo que vem no retorno
    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    //@JsonSetter("emprego") Esse é um exemplo para adapar o setter com o nome do campo que vem no retorno
    public void setJob(String job) {
        this.job = job;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
