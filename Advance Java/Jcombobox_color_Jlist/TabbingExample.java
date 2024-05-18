import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TabbingExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        frame.add(button1);
        frame.add(button2);

        button1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (e.getKeyChar() == '\t') {
                    button2.requestFocus();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        button2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (e.getKeyChar() == '\t') {
                    button1.requestFocus();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
