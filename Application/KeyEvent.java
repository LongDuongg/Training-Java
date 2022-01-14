package Application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyEvent extends JFrame implements KeyListener {

	Label lb;
	
	public KeyEvent(String title) {
		super(title);
		lb = new Label("A", lb.CENTER);
		add(lb);
		requestFocus();
		addKeyListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
				System.exit(0);
			}
		});
	}
	
	
	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
		lb.setText(String.valueOf(e.getKeyChar()));
	}

	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {	}

	@Override
	public void keyReleased(java.awt.event.KeyEvent e) { }
	
	public static void main(String[] args) {
		KeyEvent e = new KeyEvent("Key test");
		e.setBounds(100, 100, 300, 300);
		e.setVisible(true);
	}

	

}
