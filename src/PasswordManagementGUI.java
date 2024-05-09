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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Cerrar solo esta ventana al salir
        setSize(700, 500);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding alrededor de los componentes
        gbc.anchor = GridBagConstraints.CENTER; // Alinear los componentes al centro

        // Agregar título
        JLabel titleLabel = new JLabel("Password Management");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Personalizar la fuente
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupar dos columnas
        gbc.weighty = 0.2; // Incrementar el peso vertical para mover el título hacia arriba
        panel.add(titleLabel, gbc);


        JButton closeButton = new JButton("Back to Main Menu");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });
        gbc.gridy++;
        panel.add(closeButton, gbc);

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
