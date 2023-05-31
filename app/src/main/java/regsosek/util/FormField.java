package regsosek.util;

import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;

public class FormField {
    JTextField form;
    JLabel titleLabel;
    int maks;

    public FormField(UI ui, int bgNum, int maks, int x, int y, String title, boolean isPrimary) {
        if (isPrimary) {
            primary(ui, bgNum, maks, x, y, title);
        } else {
            seccondary(ui, bgNum, maks, x, y, title);
        }
    }

    public void primary(UI ui, int bgNum, int maks, int x, int y, String title) {
        titleLabel = new JLabel(title);
        titleLabel.setBounds(x, y, 180, 22);
        titleLabel.setBackground(null);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(ui.font(16));
        ui.bgPanel[bgNum].add(titleLabel);

        form = new JTextField();
        form.setBounds(x + 180, y, 20 * (maks > 16 ? 16 : maks), 30);
        form.setBackground(Color.white);
        form.setFont(ui.font(16));
        form.setHorizontalAlignment(SwingConstants.LEFT);
        form.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        ((AbstractDocument) form.getDocument()).setDocumentFilter(new LimitDocumentFilter(maks));
        ui.bgPanel[bgNum].add(form);

        this.maks = maks;
    }

    public void seccondary(UI ui, int bgNum, int maks, int x, int y, String title) {
        titleLabel = new JLabel(title);
        titleLabel.setBounds(x, y, 180, 16);
        titleLabel.setBackground(null);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(ui.font(12));
        ui.bgPanel[bgNum].add(titleLabel);

        form = new JTextField();
        form.setBounds(x, y + 20, 20 * (maks > 7 ? 7 : maks), 30);
        form.setBackground(Color.white);
        form.setFont(ui.font(16));
        form.setHorizontalAlignment(SwingConstants.LEFT);
        form.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        ((AbstractDocument) form.getDocument()).setDocumentFilter(new LimitDocumentFilter(maks));
        ui.bgPanel[bgNum].add(form);

        this.maks = maks;
    }

    public String getValue() {
        return form.getText();
    }

    public void setVisible(boolean v) {
        form.setVisible(v);
        titleLabel.setVisible(v);
        if (!v) {
            setNull();
        }
    }

    public void setNull() {
        // kalau di limit tidak mau ""
        ((AbstractDocument) form.getDocument()).setDocumentFilter(null);
        form.setText(null);
        ((AbstractDocument) form.getDocument()).setDocumentFilter(new LimitDocumentFilter(maks));
    }

    public class LimitDocumentFilter extends DocumentFilter {

        private int limit;

        public LimitDocumentFilter(int limit) {
            if (limit <= 0) {
                throw new IllegalArgumentException("Limit can not be <= 0");
            }
            this.limit = limit;
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            int currentLength = fb.getDocument().getLength();
            int overLimit = (currentLength + text.length()) - limit - length;
            if (overLimit > 0) {
                text = text.substring(0, text.length() - overLimit);
            }
            if (text.length() > 0) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

    }
}
