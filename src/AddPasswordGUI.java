import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPasswordGUI extends JFrame {

    public AddPasswordGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Add Password");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Add title label
        JLabel titleLabel = new JLabel("Add Password");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panel.add(titleLabel, gbc);

        // Add service name, username, password, usage
        JLabel serviceNameLabel = new JLabel("Service Name:");
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(serviceNameLabel, gbc);

        JTextField serviceNameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(serviceNameField, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(passwordLabel, gbc);

        JTextField passwordField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        JLabel usageLabel = new JLabel("Usage:");
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(usageLabel, gbc);

        JTextField usageField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(usageField, gbc);

        // Add save button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Save the password information
                String serviceName = serviceNameField.getText();
                String username = usernameField.getText();
                String password = passwordField.getText();
                String usage = usageField.getText();

                // Save the password using PasswordFileManager
                PasswordFileManager.writePassword(serviceName, username, password, usage);

                JOptionPane.showMessageDialog(AddPasswordGUI.this, "Password saved successfully!");
            }
        });
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(saveButton, gbc);

        // Add back button
        JButton backButton = new JButton("Back to Password Management Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this window

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new PasswordManagementGUI();
                    }
                });
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
                new AddPasswordGUI();
            }
        });
    }
}
