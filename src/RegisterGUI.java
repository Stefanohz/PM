import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterGUI extends JFrame {

    public RegisterGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("User Registration");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Close only this window when exiting
        setSize(700, 500); // Set the correct dimensions
        setLocationRelativeTo(null); // Center the window on the screen

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.anchor = GridBagConstraints.CENTER; // Align components to the center

        // Add title label
        JLabel titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Customize font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span two columns
        gbc.weighty = 0.2; // Increase vertical weight to move the title to the top
        panel.add(titleLabel, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(emailLabel, gbc);

        JTextField emailField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        JLabel confirmEmailLabel = new JLabel("Confirm Email:");
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(confirmEmailLabel, gbc);

        JTextField confirmEmailField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(confirmEmailField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(confirmPasswordLabel, gbc);

        JPasswordField confirmPasswordField = new JPasswordField(20);
        gbc.gridx = 1;
        panel.add(confirmPasswordField, gbc);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String confirmEmail = confirmEmailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Invalid email format", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!email.equals(confirmEmail)) {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Emails do not match", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (usernameExists(username)) {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Password must be at least 8 characters long, contain at least one uppercase letter, and one symbol", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Register the user
                User newUser = new User(username, email, UserDatabase.hashPassword(password));
                UserDatabase.saveUser(newUser);
                JOptionPane.showMessageDialog(RegisterGUI.this, "User registered successfully");
                dispose();
                new PasswordManagerGUI(); // Open login page
            }
        });
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(registerButton, gbc);

        getContentPane().add(panel);
        setVisible(true);
    }

    private boolean usernameExists(String username) {
        List<User> users = UserDatabase.readUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasSymbol = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return hasUppercase && hasSymbol;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterGUI();
            }
        });
    }
}
