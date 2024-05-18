import javax.swing.*;
import java.awt.*;

public class TableExamle  {
JFrame frame=new JFrame();
    public TableExamle() {
        frame.setTitle("Table demo");

        String data[][] = {
            {"101", "sandip", "200000"},
            {"102", "john", "250000"},
            {"103", "emma", "180000"},
            {"104", "jane", "220000"},
            {"105", "michael", "190000"},
        };

        String column[] = {"Id", "Name", "Salary"};

        JTable jt = new JTable(data, column);
        JScrollPane sp = new JScrollPane(jt);

        frame.add(sp);  // Add the scroll pane to the frame's content pane

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TableExamle());
    }
}
