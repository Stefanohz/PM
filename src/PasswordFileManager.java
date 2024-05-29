import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordFileManager {

    private static final String FILE_PATH = "passwords.txt";

    public static void writePassword(String serviceName, String username, String password, String usage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(serviceName + "," + username + "," + password + "," + usage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> readPasswords() {
        List<String[]> passwords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                passwords.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passwords;
    }

    // Otros métodos para actualizar y eliminar contraseñas
}
