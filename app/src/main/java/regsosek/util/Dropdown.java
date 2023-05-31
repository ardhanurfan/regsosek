package regsosek.util;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Dropdown {
    JComboBox<String> comboBox;
    JLabel titleLabel;

    public Dropdown(UI ui, int bgNum, String[] val, int x, int y, String title, boolean isPrimary) {
        if (isPrimary) {
            primary(ui, bgNum, val, x, y, title);
        } else {
            seccondary(ui, bgNum, val, x, y, title);
        }
        setNull();
    }

    public void primary(UI ui, int bgNum, String[] val, int x, int y, String title) {
        titleLabel = new JLabel(title);
        titleLabel.setBounds(x, y, 180, 22);
        titleLabel.setBackground(null);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(ui.font(16));
        ui.bgPanel[bgNum].add(titleLabel);

        comboBox = new JComboBox<>(val);
        comboBox.setBounds(x + 180, y, 70, 30);
        comboBox.setBackground(Color.white);
        comboBox.setFont(ui.font(16));
        ui.bgPanel[bgNum].add(comboBox);
    }

    public void seccondary(UI ui, int bgNum, String[] val, int x, int y, String title) {
        titleLabel = new JLabel(title);
        titleLabel.setBounds(x, y, 180, 16);
        titleLabel.setBackground(null);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(ui.font(12));
        ui.bgPanel[bgNum].add(titleLabel);

        comboBox = new JComboBox<>(val);
        comboBox.setBounds(x, y + 20, 70, 30);
        comboBox.setBackground(Color.white);
        comboBox.setFont(ui.font(16));
        ui.bgPanel[bgNum].add(comboBox);
    }

    public String getValue() {
        return (String) comboBox.getSelectedItem();
    }

    public void addActionListener(ActionListener ac) {
        comboBox.addActionListener(ac);
    }

    public void setVisible(boolean v) {
        comboBox.setVisible(v);
        titleLabel.setVisible(v);
        if (!v) {
            setNull();
        }
    }

    public void setNull() {
        comboBox.setSelectedIndex(-1);
    }
}
