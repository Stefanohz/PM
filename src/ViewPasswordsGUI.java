import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewPasswordsGUI extends JFrame {

    public ViewPasswordsGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("View Passwords");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JTextArea passwordsTextArea = new JTextArea();
        passwordsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(passwordsTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        List<String[]> passwords = PasswordFileManager.readPasswords();
        for (String[] password : passwords) {
            passwordsTextArea.append("Service: " + password[0] + "\n");
            passwordsTextArea.append("Username: " + password[1] + "\n");
            passwordsTextArea.append("Password: " + password[2] + "\n");
            passwordsTextArea.append("Usage: " + password[3] + "\n\n");
        }

        getContentPane().add(panel);
        setVisible(true);
    }
}
