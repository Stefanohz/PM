import java.util.*;

public class CredentialManager {
    private Map<String, List<String>> userPasswords;

    public CredentialManager() {
        userPasswords = new HashMap<>();
    }

    public void registerUser(String username) {
        if (!userPasswords.containsKey(username)) {
            userPasswords.put(username, new ArrayList<>());
        }
    }

    public void addPassword(String username, String password) {
        List<String> passwords = userPasswords.get(username);
        if (passwords != null) {
            passwords.add(password);
        }
    }

    public void editPassword(String username, int index, String newPassword) {
        List<String> passwords = userPasswords.get(username);
        if (passwords != null && index >= 0 && index < passwords.size()) {
            passwords.set(index, newPassword);
        }
    }

    public void deletePassword(String username, int index) {
        List<String> passwords = userPasswords.get(username);
        if (passwords != null && index >= 0 && index < passwords.size()) {
            passwords.remove(index);
        }
    }

    public List<String> getPasswordsForUser(String username) {
        return userPasswords.getOrDefault(username, new ArrayList<>());
    }
}
