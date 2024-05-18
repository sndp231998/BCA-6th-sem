import javax.swing.*;


public class SimpleMenu extends JFrame {
    private JMenuBar menuBar;
    private JMenu fileMenu, saveAsSubMenu;
    private JMenuItem newMenuItem, openMenuItem, saveMenuItem,  jpgMenuItem, pngMenuItem, pdfMenuItem,  saveAsMenuItem;
    
    

    public SimpleMenu() {
        // Set window title
        setTitle("Simple Menu");

        // Create menu bar
        menuBar = new JMenuBar();

        // Create file menu
        fileMenu = new JMenu("File");

        // Create menu items
        newMenuItem = new JMenuItem("New");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        saveAsMenuItem = new JMenuItem("Save As");

        // Create save as sub-menu
        saveAsSubMenu = new JMenu("Save As");
        jpgMenuItem = new JMenuItem(".jpg");
        pngMenuItem = new JMenuItem(".png");
        pdfMenuItem = new JMenuItem(".pdf");

        // Add menu items to file menu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);

        // Add save as sub-menu to file menu
        fileMenu.add(saveAsSubMenu);

        // Add save as sub-menu items to save as sub-menu
        saveAsSubMenu.add(jpgMenuItem);
        saveAsSubMenu.add(pngMenuItem);
        saveAsSubMenu.add(pdfMenuItem);

        // Add menu items to menu bar
        menuBar.add(fileMenu);

        // Set menu bar
        setJMenuBar(menuBar);

        // Set window size and visibility
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SimpleMenu gui = new SimpleMenu();
    }
}
