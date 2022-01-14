package Application;
import java.awt.*;
import javax.swing.*;

public class MenuDemo extends JFrame {

	public MenuDemo(String title) {
		super(title);
		setBounds(300, 200, 200, 200);
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		Menu File = new Menu("File");
		File.add(new MenuItem("New"));
		File.add(new MenuItem("Open"));
		File.add(new MenuItem("Exit"));
		mb.add(File);
		Menu Edit = new Menu("Edit");
		Edit.add(new MenuItem("Copy"));
		Edit.add(new MenuItem("Cut"));
		Edit.add(new MenuItem("Paste"));
		
		Menu Option = new Menu("Option");
		Option.add(new MenuItem("First"));
		Option.add(new MenuItem("Second"));
		Option.add(new MenuItem("Third"));
		Edit.add(Option);
		Edit.add(new CheckboxMenuItem("Protected"));
		mb.add(Edit);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MenuDemo m = new MenuDemo("Menu Demo");
	}

}
