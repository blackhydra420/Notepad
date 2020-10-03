package mainUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import fileMenu.File_functions;

public class MainUi implements ActionListener{
	
	//all the variables
	public JFrame window;
	public JTextArea textArea;
	public JScrollPane scrollPane;
	public JMenuBar menuBar;
	public JMenu menuFile, menuEdit, menuFormat;
	public JMenuItem fNew, fOpen, fSave, fSaveAs, fExit;
	
	//creating instance of all the functional class
	File_functions file = new File_functions(this);
	
	//Constructor to build the ui
	public MainUi() {
		createWindow();
		createMenuBar();
		addFileMenu();
		createTextArea();
		
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainUi();
	}
	
	public void createWindow() {
		window = new JFrame("Notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//menu bar
		public void createMenuBar() {
			menuBar = new JMenuBar();
			window.setJMenuBar(menuBar);
			
			//add file to the menu
			menuFile = new JMenu("File");
			menuBar.add(menuFile);
		}
		
		//all the file menu
		public void addFileMenu() {
			fNew = new JMenuItem("New");
			menuFile.add(fNew);
			menuFile.addActionListener(this);
			menuFile.setActionCommand("New");
			
			
			fOpen = new JMenuItem("Open");
			menuFile.add(fOpen);
			
			fSave = new JMenuItem("Save");
			menuFile.add(fSave);
			
			fSaveAs = new JMenuItem("SaveAs");
			menuFile.add(fSaveAs);
			
			fExit = new JMenuItem("Exit");
			menuFile.add(fExit);
		}
	
	//textArea
	public void createTextArea() {
		textArea = new JTextArea();
		window.add(textArea);
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.out.print(command);
		switch (command) {
			case "New": file.newFile();  break;
		}
	}
}