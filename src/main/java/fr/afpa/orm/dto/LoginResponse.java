package fr.afpa.orm.dto;

public class LoginResponse {
    private String token;

    private long expiresIn;

    public LoginResponse(long expiresIn, String token) {
        this.expiresIn = expiresIn;
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
    public String getToken() {
        return token;
    
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoginResponse{");
        sb.append("token=").append(token);
        sb.append(", expiresIn=").append(expiresIn);
        sb.append('}');
        return sb.toString();
    }


}