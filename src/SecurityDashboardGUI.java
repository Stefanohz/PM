import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecurityDashboardGUI extends JFrame {

    public SecurityDashboardGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Security Dashboard");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Close only this window when exiting
        setSize(700, 500);
        setLocationRelativeTo(null); // Center the window on the screen

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.anchor = GridBagConstraints.CENTER; // Align components to the center

        // Add title label
        JLabel titleLabel = new JLabel("Security Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Customize font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span two columns
        gbc.weighty = 0.2; // Increase vertical weight to move the title to the top
        panel.add(titleLabel, gbc);

        // Add security summary content
        JTextArea securitySummaryTextArea = new JTextArea();
        securitySummaryTextArea.setEditable(false); // Make the field read-only
        securitySummaryTextArea.setLineWrap(true); // Wrap text to next line if it exceeds the width
        securitySummaryTextArea.setWrapStyleWord(true); // Wrap at word boundaries
        String securitySummaryText = "Security Summary:\n\n" +
                "No reused passwords found.\n" +
                "All passwords are strong.\n" +
                "No weak passwords detected.\n"; // Sample security summary text
        securitySummaryTextArea.setText(securitySummaryText);
        JScrollPane scrollPane = new JScrollPane(securitySummaryTextArea); // Add scroll pane
        scrollPane.setPreferredSize(new Dimension(600, 300)); // Set preferred size of scroll pane
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH; // Allow component to expand both horizontally and vertically
        panel.add(scrollPane, gbc);

        // Add button to return to main menu
        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this window
                MainMenuGUI.openMainMenu(); // Open main menu
            }
        });
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE; // Reset fill to default
        gbc.anchor = GridBagConstraints.CENTER; // Center the button
        panel.add(backButton, gbc);

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SecurityDashboardGUI();
            }
        });
    }
}
