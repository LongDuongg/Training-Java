package Application;
import javax.swing.*;
import java.awt.*;

public class Demo extends JFrame {

	public static void main(String[] args) {
		Demo d = new Demo();
		d.setTitle("Chao you !!");
		d.setBounds(500, 500, 500, 500);
		d.setLayout(new FlowLayout());
		d.add(new JButton("OK"));
		d.add(new JButton("Cancel"));
		
		d.add(new JLabel("Day la Label"));
		d.add(new JTextField("Moi ban nhap vao"));
		d.add(new JTextArea(5,30));
		
		d.add(new Checkbox("Sport"));
		d.add(new Checkbox("Music"));
		d.add(new Checkbox("Travel"));
		CheckboxGroup cg = new CheckboxGroup();
		d.add(new Checkbox("Female", cg, true));
		d.add(new Checkbox("Male", cg, false));
		
		Choice ch = new Choice();
		ch.addItem("Sport");
		ch.addItem("Music");
		ch.addItem("Travel");
		d.add(ch);
		
		List list = new List(3, false);
		list.add("Music");
		list.add("Travel");
		list.add("Game");
		list.add("Telen");
		d.add(list);
		
		d.setVisible(true);// show()
	}

}
