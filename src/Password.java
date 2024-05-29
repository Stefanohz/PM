public class Password {
    private String serviceName;
    private String username;
    private String password;
    private String purpose;

    public Password(String serviceName, String username, String password, String purpose) {
        this.serviceName = serviceName;
        this.username = username;
        this.password = password;
        this.purpose = purpose;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPurpose() {
        return purpose;
    }
}
