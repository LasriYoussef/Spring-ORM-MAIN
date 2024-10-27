package fr.afpa.orm.dto;

public class LoginUserDto {
    private String email;
    
    private String password;

    public LoginUserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoginUserDto{");
        sb.append("email=").append(email);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }
    
}