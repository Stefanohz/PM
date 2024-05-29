import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPasswordGUI extends JFrame {

    public EditPasswordGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Edit Password");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Edit Password");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panel.add(titleLabel, gbc);


        JButton backButton = new JButton("Back to Password Management Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

                openPasswordManagementMenu();
            }
        });
        gbc.gridy++;
        panel.add(backButton, gbc);

        getContentPane().add(panel);
        setVisible(true);
    }

    private void openPasswordManagementMenu() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                Frame[] frames = Frame.getFrames();
                for (Frame frame : frames) {
                    if (frame instanceof PasswordManagementGUI) {
                        frame.setVisible(true);
                        return;
                    }
                }
                new PasswordManagementGUI();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EditPasswordGUI();
            }
        });
    }
}
