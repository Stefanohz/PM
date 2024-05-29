import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsGUI extends JFrame {

    public SettingsGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Settings");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Close only this window when exiting
        setSize(700, 500);
        setLocationRelativeTo(null); // Center the window on the screen

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.anchor = GridBagConstraints.CENTER; // Align components to the center

        // Add title label
        JLabel titleLabel = new JLabel("Settings");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Customize font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span two columns
        gbc.weighty = 0.2; // Increase vertical weight to move the title to the top
        panel.add(titleLabel, gbc);

        // Add settings options
        JButton changePasswordButton = new JButton("Change Master Password");
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle change password action
                JOptionPane.showMessageDialog(SettingsGUI.this, "Change Master Password");
            }
        });
        gbc.gridy++;
        panel.add(changePasswordButton, gbc);

        JButton multiFactorAuthButton = new JButton("Multi-Factor Authentication Setup");
        multiFactorAuthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(SettingsGUI.this, "Multi-Factor Authentication Setup");
            }
        });
        gbc.gridy++;
        panel.add(multiFactorAuthButton, gbc);

        JButton accountSettingsButton = new JButton("Account Settings");
        accountSettingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle account settings action
                JOptionPane.showMessageDialog(SettingsGUI.this, "Account Settings");
            }
        });
        gbc.gridy++;
        panel.add(accountSettingsButton, gbc);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this window
                MainMenuGUI.openMainMenu(); // Open main menu
            }
        });
        gbc.gridy++;
        panel.add(backButton, gbc);

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SettingsGUI();
            }
        });
    }
}
