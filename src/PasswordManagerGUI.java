import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PasswordManagerGUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private Map<String, String> userDatabase; // Simulation of a user database with usernames and passwords

    public PasswordManagerGUI() {
        initComponents();
        userDatabase = new HashMap<>(); // Initialize the database
        // Add an example user
        userDatabase.put("admin", "admin");
    }

    private void initComponents() {
        setTitle("Password Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null); // Center the window on the screen

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.anchor = GridBagConstraints.CENTER; // Align components to the center

        // Add title label
        JLabel titleLabel = new JLabel("Password Manager");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Customize font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span two columns
        gbc.weighty = 0.2; // Increase vertical weight to move the title to the top
        panel.add(titleLabel, gbc);

        // Increment the y position for the next components
        gbc.gridy++;

        JLabel usernameTitleLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1; // Reset gridwidth to 1
        gbc.insets = new Insets(10, 10, 5, 10); // Reset insets
        panel.add(usernameTitleLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 0; // Change to 0 to center horizontally
        gbc.gridy++; // Increment y position
        gbc.insets = new Insets(5, 10, 5, 10); // Reduce top and bottom insets
        panel.add(usernameField, gbc);

        JLabel passwordTitleLabel = new JLabel("Password:");
        gbc.gridx = 0; // Change to 0 to center horizontally
        gbc.gridy++; // Increment y position
        panel.add(passwordTitleLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 0; // Change to 0 to center horizontally
        gbc.gridy++; // Increment y position
        panel.add(passwordField, gbc);

        // Add vertical space between input fields and buttons
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(Box.createVerticalStrut(10), gbc); // Reduce vertical strut size for less space

        // Create a panel for login and register buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        buttonPanel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        buttonPanel.add(registerButton);

        // Add buttonPanel to main panel
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 50, 10); // Increase bottom inset for more space
        panel.add(buttonPanel, gbc);

        getContentPane().add(panel);
        setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            // Here you could open the main menu or perform other actions after login
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
        }
    }

    private void register() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userDatabase.containsKey(username)) {
            JOptionPane.showMessageDialog(this, "Username already exists. Please choose another one.");
        } else {
            userDatabase.put(username, password);
            JOptionPane.showMessageDialog(this, "Registration successful!");
        }
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
