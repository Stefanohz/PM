import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame {

    public MainMenuGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Main Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null); // Center the window on the screen

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.anchor = GridBagConstraints.CENTER; // Align components to the center

        // Add title label
        JLabel titleLabel = new JLabel("Main Menu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Customize font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span two columns
        gbc.weighty = 0.2; // Increase vertical weight to move the title to the top
        panel.add(titleLabel, gbc);

        // Add buttons for each option
        String[] options = {"Manage Passwords", "Generate Password", "Security Dashboard", "Settings", "Logout"};
        gbc.gridy++;
        for (String option : options) {
            JButton button = new JButton(option);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleOption(option);
                }
            });
            panel.add(button, gbc);
            gbc.gridy++;
        }

        getContentPane().add(panel);
        setVisible(true);
    }

    private void handleOption(String option) {
        switch (option) {
            case "Manage Passwords":
                openPasswordManagementWindow();
                break;
            case "Generate Password":
                openGeneratePasswordWindow();
                break;
            case "Security Dashboard":
                openSecurityDashboardWindow();
                break;
            case "Settings":
                openSettingsWindow();
                break;
            case "Logout":
                logout();
                break;
        }
    }

    private void openPasswordManagementWindow() {
        PasswordManagementGUI passwordManagementGUI = new PasswordManagementGUI();
        passwordManagementGUI.setVisible(true);
    }

    private void openGeneratePasswordWindow() {
        GeneratePasswordGUI generatePasswordGUI = new GeneratePasswordGUI();
        generatePasswordGUI.setVisible(true);
    }

    private void openSecurityDashboardWindow() {
        SecurityDashboardGUI securityDashboardGUI = new SecurityDashboardGUI();
        securityDashboardGUI.setVisible(true);
    }

    private void openSettingsWindow() {
        SettingsGUI settingsGUI = new SettingsGUI();
        settingsGUI.setVisible(true);
    }

    private void logout() {
        dispose(); // Close the current Main Menu window
        // Here you should open the login window again, similar to how you did it in the PasswordManagerGUI class
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasswordManagerGUI();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenuGUI();
            }
        });
    }
}
