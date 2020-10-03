package fileMenu;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import mainUi.MainUi;

public class File_functions {
	//all the important variables
	MainUi gui;
	private String fileName;
	private String filePath;
	
	public File_functions(MainUi gui) {
		this.gui = gui;
	}
	
	//new command function
	public void newFile() {
		gui.textArea.setText("");
		gui.window.setTitle("New");
		fileName = null;
		filePath = null;
	}
	
	//open command function
	public void openFile(){
		FileDialog fd = new FileDialog(gui.window, "Choose a file", FileDialog.LOAD);
		fd.setFile("*.txt");
		fd.setVisible(true);
		
		fileName = fd.getFile();
		
		if(fileName != null) {
			gui.window.setTitle(fileName);
			filePath = fd.getDirectory();
			
			gui.textArea.setText("");
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(filePath + fileName));
				String line = null;
				while((line = br.readLine()) != null) {
					gui.textArea.append(line + "\n");
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//save function
	public void saveFile() {
		if(fileName == null) {
			saveAsFile();
		} else {
			try {
				FileWriter fr = new FileWriter(filePath + fileName);
				fr.write(gui.textArea.getText());
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//saveAs function
	public void saveAsFile() {
		FileDialog fd = new FileDialog(gui.window, "Save file as", FileDialog.SAVE);
		fd.setVisible(true);
		fileName = fd.getFile();
		filePath = fd.getDirectory();
		try {
			FileWriter fr = new FileWriter(filePath + fileName);
			fr.write(gui.textArea.getText());
			gui.window.setTitle(fileName);
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
