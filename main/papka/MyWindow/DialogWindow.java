package MyWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogWindow extends JDialog {

    private JTextField name = new JTextField(); // текстовое поле
    private String stringName;
    // private JButton okButton = new JButton("Ок");
    private boolean ready = false;

    public DialogWindow(JFrame jframe, String path) {

        super(jframe, "Данные скачены", true);

        JButton okButton = new JButton("Ок");
        JLabel nameWhotHappen = new JLabel("Файл: " + path);
        setLayout(new GridLayout(2, 2, 5, 5));
        setSize(400, 200);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringName = name.getText();
                setVisible(false);
                ready = true;
            }
        });

        // getContentPane().add(name);
        getContentPane().add(nameWhotHappen);
        getContentPane().add(okButton);

        setLocationRelativeTo(null); // посередине
        setVisible(true);
    }

}
