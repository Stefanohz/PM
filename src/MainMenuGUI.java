import javax.swing.*;
import java.awt.*;

public class MainMenuGUI extends JFrame {

    private static MainMenuGUI instance;

    public MainMenuGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Main Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Main Menu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panel.add(titleLabel, gbc);

        String[] options = {"Manage Passwords", "Generate Password", "Security Dashboard", "Settings", "Logout"};
        gbc.gridy++;
        for (String option : options) {
            JButton button = new JButton(option);
            button.addActionListener(e -> handleOption(option));
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
        dispose();
        SwingUtilities.invokeLater(() -> new PasswordManagerGUI());
    }

    public static void openMainMenu() {
        if (instance == null) {
            instance = new MainMenuGUI();
        }
        instance.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenuGUI::openMainMenu);
    }
}
