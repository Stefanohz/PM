import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDatabase {

    private static final String USER_FILE = "users.txt";

    // Save a new user to the file
    public static void saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            writer.write(user.getUsername() + "," + user.getEmail() + "," + user.getPasswordHash());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read all users from the file
    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0];
                    String email = parts[1];
                    String passwordHash = parts[2];
                    users.add(new User(username, email, passwordHash));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Hash the password using a simple algorithm (you should use a better hashing algorithm in a real application)
    public static String hashPassword(String password) {
        // This is a placeholder for hashing, consider using a library like BCrypt for real applications
        return Integer.toHexString(password.hashCode());
    }

    // Verify if an email has a valid format
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
