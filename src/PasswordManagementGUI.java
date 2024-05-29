import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordManagementGUI extends JFrame {

    public PasswordManagementGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Password Management");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Password Management");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panel.add(titleLabel, gbc);

        JButton addButton = new JButton("Add Password");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPasswordGUI();
                dispose();
            }
        });
        gbc.gridy++;
        panel.add(addButton, gbc);

        JButton editButton = new JButton("Edit Password");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditPasswordGUI();
                dispose();
            }
        });
        gbc.gridy++;
        panel.add(editButton, gbc);

        JButton deleteButton = new JButton("Delete Password");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeletePasswordGUI();
                dispose();
            }
        });
        gbc.gridy++;
        panel.add(deleteButton, gbc);

        JButton viewButton = new JButton("View Passwords"); // New button
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewPasswordsGUI(); // Open the window to view passwords
            }
        });
        gbc.gridy++;
        panel.add(viewButton, gbc);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuGUI();
                dispose();
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
                new PasswordManagementGUI();
            }
        });
    }
}
