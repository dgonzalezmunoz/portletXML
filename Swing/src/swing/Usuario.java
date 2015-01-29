package swing;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.*;
public class Usuario extends JFrame {
	
	Container cont= new Container();
	

	public Usuario() throws HeadlessException {
		
	}

	public Usuario(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Usuario(String arg0) throws HeadlessException {
		JLabel lab1 =new JLabel("Bienvenido/a " + arg0 );
		lab1.setBounds(10, 50, 100, 30);
		this.add(lab1);
		this.setBounds(100,100,300,300);
		this.setVisible(true);
	}

	public Usuario(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
