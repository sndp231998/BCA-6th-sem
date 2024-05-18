import javax.swing.*;
class Practic{
    public static void main(String[] args) {
    
     JFrame f=new JFrame("sandip");

     JLabel l1=new JLabel("Enter number:");
     l1.setBounds(100,100,200,50);
     f.add(l1);

    JTextField t1=new JTextField();
    t1.setBounds(200, 100, 200,50);
    f.add(t1);


    JLabel l2=new JLabel("Enter Sec num:");
    l2.setBounds(100,150,200,50);
    f.add(l2);


    JTextField t2=new JTextField();
    t2.setBounds(200, 150, 200,50);
    f.add(t2);


     f.setLayout(null);
     f.setVisible(true);
     f.setSize(700, 600);
        
    }
}