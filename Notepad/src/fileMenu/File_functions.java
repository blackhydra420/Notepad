package fileMenu;

import mainUi.MainUi;

public class File_functions {
	MainUi gui;
	public File_functions(MainUi gui) {
		this.gui = gui;
	}
	
	//new command function
	public void newFile() {
		gui.textArea.setText("");
		gui.window.setTitle("New");
	}
}
