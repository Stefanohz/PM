import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePasswordGUI extends JFrame {

    public DeletePasswordGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Delete Password");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Close only this window when exiting
        setSize(700, 500);
        setLocationRelativeTo(null); // Center the window on the screen

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.anchor = GridBagConstraints.CENTER; // Align components to the center

        // Add components for deleting an existing password
        // For example: text field for password name, confirmation message, etc.

        // Add button to confirm deleting the password
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to delete the password from the database
                // You can access the value entered by the user in the text field and delete the corresponding password from the database
                // Don't forget to validate the input before deleting
            }
        });
        gbc.gridy++;
        panel.add(deleteButton, gbc);

        // Add button to return to Password Management Menu
        JButton backButton = new JButton("Back to Password Management Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this window
                // Reopen the PasswordManagementGUI window
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
                new DeletePasswordGUI();
            }
        });
    }
}
