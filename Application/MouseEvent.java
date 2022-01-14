package Application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEvent extends JFrame implements MouseListener {

	public MouseEvent(String title) {
		super(title);
		requestFocus();
		addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
				System.exit(0);
			}
		});
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		if(e.isMetaDown()) {
			System.out.println("You right click the mouse at " + e.getX() + ", " + e.getY());
		} else {
			System.out.println("You left click the mouse at " + e.getX() + ", " + e.getY());
		}
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		System.out.println("You pressed the mouse at " + e.getX() + ", " + e.getY());
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		System.out.println("You released the mouse at " + e.getX() + ", " + e.getY());
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		System.out.println("You enter the window at " + e.getX() + ", " + e.getY());
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		System.out.println("You exit the window at " + e.getX() + ", " + e.getY());
	}
	
	public static void main(String[] args) {
		MouseEvent m = new MouseEvent("Mouse test");
		m.setBounds(100, 100, 300, 300);
		m.setVisible(true);
	}

}
