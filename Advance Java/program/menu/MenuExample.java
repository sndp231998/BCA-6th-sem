import javax.swing.*;
public class MenuExample extends JFrame{
   
                
          JMenuBar mb;
          JMenu fm,em,vm,zm;
          JMenuItem miopen,misave;
          JCheckBoxMenuItem misb;
          
          MenuExample(){
            setSize(400,300);
            setDefaultLookAndFeelDecorated(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Menu");
          //1. Menu Bar
            mb=new JMenuBar();
        //2. Menu 
            fm=new JMenu("File");
            vm=new JMenu("View");
            em=new JMenu("Edit");
            zm=new JMenu("Zoom");
            fm.setMnemonic('F');
      
            mb.add(fm);
            mb.add(em);
            mb.add(vm);

            //menu Item
        miopen=new JMenuItem("open",'o');
        misave=new JMenuItem("save",'s');

        misb=new JCheckBoxMenuItem("status Bar",false);
        
        fm.add(miopen);
        fm.add(misb);
        vm.add(misb);
        vm.add(zm);

        setJMenuBar(mb);
        setVisible(true);
          }
          public static void main(String[] args) {
            MenuExample frame=new MenuExample();
          }

        }
    



     
