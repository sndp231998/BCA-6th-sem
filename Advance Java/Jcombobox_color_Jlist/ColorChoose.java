import javax.swing.*;
import java.awt.*;

public class ColorChoose extends JFrame{
    JColorChooser cc;
    JDialog d;
    
    public ColorChoose (){
        setSize(700,500);
        setVisible(true);
        JPanel p=new JPanel();
        add(p);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
     
        cc=new JColorChooser();
        Color c=cc.showDialog(this,"Select COlor",Color.white);
       
        p.setBackground(c);

    }
    public static void main(String[] args) {
        new ColorChoose();

    }
}
