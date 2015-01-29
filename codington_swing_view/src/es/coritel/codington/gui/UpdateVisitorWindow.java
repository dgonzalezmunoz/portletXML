package es.coritel.codington.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import es.coritel.codington.festival.domain.Visitor;

@SuppressWarnings("serial")
public class UpdateVisitorWindow extends JFrame
{

	private JPanel contentPane;
	PanelVisitor panelVisitor ;


	/**
	 * Create the frame.
	 */
	public UpdateVisitorWindow()
	{
		setTitle("Update Visitor"); 
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[]", "[]"));
		panelVisitor = new PanelVisitor();
		panelVisitor.setEditableFields(true);
		add(panelVisitor);
		
		// Ultimamos la configuración de la ventana y la mostramos.
		setResizable(false);
		//empaquetamos los componentes para que la ventana coja el tamaño justo que permita verlo todo bien
		pack();
		// Centramos la ventana en la pantalla
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolKit.getScreenSize();
		int x = (int) (screenSize.getWidth() - getWidth()) / 2;
		int y = (int) (screenSize.getHeight() - getHeight()) / 2;
		setLocation(x, y);
		
		//la hacemos visible
		setVisible(true);
		
	}
	
	
	public void addActionListener(ActionListener actionListener)
	{		
		
		panelVisitor.addActionListener(actionListener);
	
	}
	
	public void addActionCommand(String actionCommand)
	{
		panelVisitor.addActionCommand(actionCommand);
	}
	
	public Visitor getUpdatedVisitor()
	{
		
		return panelVisitor.getVisitor();
	}
	
	
	public void setVisitor(Visitor visitor)
	{
		panelVisitor.setVisitor(visitor);
	}
}
