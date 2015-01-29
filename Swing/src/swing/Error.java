package swing;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Error extends JFrame implements ActionListener {
	
	JButton fin;
	JLabel mensajerro;

	public Error() throws HeadlessException {
	mensajerro = new JLabel("La contraseña y el usuario no concuerdan");
	mensajerro.setForeground(Color.RED);
	mensajerro.setBounds(10,10,250,30);
	fin = new JButton("finalizar");
	fin.setBounds(50,50,100,30);
	fin.addActionListener(this);
	this.add(mensajerro);
	this.add(fin);
	this.setBounds(100,100,300,300);
	this.setLayout(null);
	this.setVisible(true);
	
	
	}

	public Error(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Error(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Error(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
          if(e.getSource()==fin){
        	  System.exit(0);
          }
		
	}

}
