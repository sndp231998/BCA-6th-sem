import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FileChooserDisplayer implements ActionListener{
   
    JFileChooser filechooser;
    public class FileChooserExample(){
        JFrame frame=new JFrame("File Chooser Example");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultChoseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel=new JPanel();
    frame.add(panel);
    JButton open=new JButton("Open");
    JButton save=new JButton("Save");
    panel.add(open);
    panel.add(save);
    frame.setVisible(true);

    open.addActionListener(this);

    filechooser=new JFileChooser();
    }

    public static void main(String[] args){
        new FrameChooserExample();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int selectedOption=filechooser.showDialog(null,"Open MY File");
        if(selectedOption==JFileChooser.APPROVE_OPTION){
      System.out.println("Selected file is :"+filechooser.getSelectedFile().getAbsolutedPath());
        }else{
            System.out.println("Üser cancelled the dialog");
        }
    }
