package dominio;

public class AtributosUsuario {
    private String name;
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

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

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

}
