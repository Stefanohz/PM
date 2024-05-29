import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PasswordManagerGUI extends JFrame {

    public PasswordManagerGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Password Manager - Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null); // Center the window on the screen

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.anchor = GridBagConstraints.CENTER; // Align components to the center

        // Add title label
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Customize font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span two columns
        gbc.weighty = 0.2; // Increase vertical weight to move the title to the top
        panel.add(titleLabel, gbc);

        // Add username label and field
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        // Add password label and field
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        // Add login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticateUser(username, password)) {
                    JOptionPane.showMessageDialog(PasswordManagerGUI.this, "Login successful");
                    new MainMenuGUI();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(PasswordManagerGUI.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        // Add link to registration page
        JButton registerButton = new JButton("Don't have an account? Register here");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterGUI();
            }
        });
        gbc.gridy++;
        panel.add(registerButton, gbc);

        getContentPane().add(panel);
        setVisible(true);
    }

    private boolean authenticateUser(String username, String password) {
        List<User> users = UserDatabase.readUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPasswordHash().equals(UserDatabase.hashPassword(password))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasswordManagerGUI();
            }
        });
    }
}
