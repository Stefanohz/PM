import java.util.Objects;

public class PasswordUsage {
    private String serviceName;
    private String username;
    private String password;
    private String usage;

    public PasswordUsage(String serviceName, String username, String password, String usage) {
        this.serviceName = serviceName;
        this.username = username;
        this.password = password;
        this.usage = usage;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordUsage that = (PasswordUsage) o;
        return Objects.equals(serviceName, that.serviceName) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(usage, that.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName, username, password, usage);
    }

    @Override
    public String toString() {
        return "PasswordUsage{" +
                "serviceName='" + serviceName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usage='" + usage + '\'' +
                '}';
    }
}
