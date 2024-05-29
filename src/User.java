import java.util.*;

public class User {
    private String username;
    private String email;
    private String passwordHash;
    private List<String[]> passwords;

    public User(String username, String email, String passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.passwords = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void addPassword(String serviceName, String usernameForService, String password, String usage) {
        String[] newPassword = {serviceName, usernameForService, password, usage};
        passwords.add(newPassword);
    }

    public void editPassword(String serviceName, String newUsernameForService, String newPassword, String newUsage) {
        for (String[] password : passwords) {
            if (password[0].equals(serviceName)) {
                password[1] = newUsernameForService;
                password[2] = newPassword;
                password[3] = newUsage;
                return;
            }
        }
    }

    public void deletePassword(String serviceName) {
        passwords.removeIf(password -> password[0].equals(serviceName));
    }

    public List<String[]> getPasswords() {
        return new ArrayList<>(passwords);
    }
}
