package swing;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Container extends JFrame implements ActionListener {
	private JButton button; 
	private JButton butcontra;
	private JTextField campous;
	private JTextField campocontr;

	public Container() throws HeadlessException {
		JLabel usu= new JLabel("Usuario: ");
		usu.setBounds(10, 10, 100, 30);
		JLabel contr =new JLabel("Contraseña: ");
		contr.setBounds(10,50,100,30);
		campous = new JTextField();
		campous.setBounds(120, 10, 100, 30);
	    campocontr = new JTextField();
		campocontr.setBounds(120,50 ,100 ,30);
		butcontra =new JButton("Mostrar Contrasenya");
		butcontra.addActionListener(this);
		butcontra.setBounds(120,100,100,30);
		button = new JButton("Log");
		button.addActionListener(this);
		button.setBounds(10,100,100,30);
		
		this.setTitle("JFrame");
		
		this.setLayout(null);
		this.add(usu);
		this.add(contr); //añadimos los labes
		this.add(campous );
		this.add(campocontr);//añadimos los  textfields 
		this.add(button);
		this.add(butcontra);
		
	}
	 public void actionPerformed(ActionEvent e) {
	        if (e.getSource()==button) {
	        	if(this.campous.getText().equals(this.campocontr.getText()))
	             new Usuario(this.campous.getText());
	        	else{
	        		new Error();
	        	}
	        		
	        }
	        if(e.getSource()==butcontra){
	        	this.campocontr.setText(this.campous.getText());
	        }
	    }

	public Container(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Container(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Container(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	public JTextField getCampous() {
		return campous;
	}
	public void setCampous(JTextField campous) {
		this.campous = campous;
	}
	public JTextField getCampocontr() {
		return campocontr;
	}
	public void setCampocontr(JTextField campocontr) {
		this.campocontr = campocontr;
	}
	public static void main(String ... args){
	Container cont =new Container();
	cont.setBounds(100,100,300,300);
	cont.setVisible(true);
	
	}

}
