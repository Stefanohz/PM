import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GeneratePasswordGUI extends JFrame {

    public GeneratePasswordGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Generate Password");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Close only this window when exiting
        setSize(700, 500);
        setLocationRelativeTo(null); // Center the window on the screen

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.anchor = GridBagConstraints.CENTER; // Align components to the center

        // Add title label
        JLabel titleLabel = new JLabel("Generate Password");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Customize font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span two columns
        gbc.weighty = 0.2; // Increase vertical weight to move the title to the top
        panel.add(titleLabel, gbc);

        // Add label to display generated password
        JLabel passwordLabel = new JLabel("Generated Password:");
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(passwordLabel, gbc);

        JTextField passwordField = new JTextField(20);
        passwordField.setEditable(false); // Make the field read-only
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        // Add button to generate password
        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String generatedPassword = generateRandomPassword();
                passwordField.setText(generatedPassword);
            }
        });
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(generateButton, gbc);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainMenuGUI.openMainMenu();
            }
        });
        gbc.gridy++;
        panel.add(backButton, gbc);

        getContentPane().add(panel);
        setVisible(true);
    }

    private String generateRandomPassword() {
        // Define characters to be used in the password
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        // Combine all characters
        String allCharacters = upperCaseLetters + lowerCaseLetters + numbers + symbols;

        // Use Random for random number generation
        Random random = new Random();

        // Generate password of length 12
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GeneratePasswordGUI();
            }
        });
    }
}
