package Application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemEvent extends JFrame implements ActionListener, ItemListener {
	
	CheckboxGroup cg;
	Checkbox Male, Female;
	List list;
	Choice choice;
	Button Exit;
	TextField display;
	Panel pn, pn1, pn2, pn3, pn4;
	
	public void GUI() {
		cg = new CheckboxGroup();
		Male = new Checkbox("Male", cg, false);
		Male.addItemListener(new ItemListener() {
			@Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                display.setText("Ban da chon " + (e.getStateChange() == 1
                        ? "Male" : "Female"));
            }
        });
		
		Female = new Checkbox("Female", cg, false);
		Female.addItemListener(new ItemListener() {
			@Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                display.setText("Ban da chon " + (e.getStateChange() == 1
                        ? "Female" : "Male"));
            }
        });
		
		list = new List(3, false);
		list.add("MS DOS");
		list.add("WINDOWS");
		list.add("LINUX");
		list.add("MAC OS");
		list.addItemListener(this);
		
		choice = new Choice();
		choice.addItem("Tiger");
		choice.addItem("Elephant");
		choice.addItem("Panther");
		choice.addItemListener(this);
		
		Exit = new Button("Exit");
		Exit.addActionListener((ActionListener) this);
		
		display = new TextField(18);
		
		pn = new Panel(new GridLayout(4,1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new FlowLayout());
		pn3 = new Panel(new FlowLayout());
		pn4 = new Panel(new FlowLayout());
		
		pn1.add(Male);
		pn1.add(Female);
		
		pn2.add(list);
		
		pn3.add(choice);
		
		pn4.add(display);
		pn4.add(Exit);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		
		add(pn);
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Exit)
			System.exit(0);
	}
	
	@Override
	public void itemStateChanged(java.awt.event.ItemEvent e) {
		
		if(e.getSource() == list) {
			if(list.getItem(list.getSelectedIndex()) == "MS DOS")
				display.setText("Ban da chon MS DOS");
			
			if(list.getItem(list.getSelectedIndex()) == "WINDOWS")
				display.setText("Ban da chon WINDOWS");
			
			if(list.getItem(list.getSelectedIndex()) == "LINUX")
				display.setText("Ban da chon LINUX");
			
			if(list.getItem(list.getSelectedIndex()) == "MAC OS")
				display.setText("Ban da chon MAC OS");
		}
			
		if(e.getSource() == choice) {
			if(choice.getSelectedItem() == "Tiger")
				display.setText("Ban da chon Tiger");
			
			if(choice.getSelectedItem() == "Elephant")
				display.setText("Ban da chon Elephant");
			
			if(choice.getSelectedItem() == "Panther")
				display.setText("Ban da chon Panther");
		}
	}
	
	public ItemEvent(String title) {
		super(title);
		GUI();
	}

	public static void main(String[] args) {
		new ItemEvent("Item Event");
	}
}
