package es.coritel.codington.gui;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import net.miginfocom.swing.MigLayout;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DomainException;

@SuppressWarnings("serial")
public class PanelVisitor extends JPanel{
	
	
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtDni;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAddress;


	private JButton btnActualizarDatos;
	private Visitor visitor;

	
	
	public PanelVisitor()
	{
		
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new MigLayout("", "[][99.00,grow][98.00]", "[][][][][][][]"));
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNombre, "cell 0 1,alignx trailing");
		
		txtFirstName = new JTextField();
		
		add(txtFirstName, "cell 1 1");
		txtFirstName.setColumns(50);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblApellido, "cell 0 2,alignx trailing");
		
		txtLastName = new JTextField();
		
		add(txtLastName, "cell 1 2");
		txtLastName.setColumns(50);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblDni, "cell 0 3,alignx trailing");
		
		txtDni = new JTextField();
		
		add(txtDni, "cell 1 3");
		txtDni.setColumns(50);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblEmail, "cell 0 4,alignx trailing");
		
		txtEmail = new JTextField();
		
		add(txtEmail, "cell 1 4");
		txtEmail.setColumns(50);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTelefono, "cell 0 5,alignx trailing");
		
		txtPhone = new JTextField();
		
		add(txtPhone, "cell 1 5");
		txtPhone.setColumns(50);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblAddress, "cell 0 6,alignx trailing");
		
		txtAddress= new JTextField();
		
		add(txtAddress, "cell 1 6");
		txtAddress.setColumns(50);
		
		btnActualizarDatos = new JButton("Actualizar Datos");
		btnActualizarDatos.setActionCommand("actualizar");
		add(btnActualizarDatos, "cell 2 6,alignx trailing");
		
		
	}
	/** 
	 * Metodo que establece el visitante que se mostrará en las caja de texto
	 * 
	 * @param visitor
	 */
	public void setVisitor(Visitor visitor)
	{
		this.visitor = visitor;
		
		txtFirstName.setText(visitor.getFirstName());
		txtLastName.setText(visitor.getLastName());
		txtEmail.setText(visitor.getEmail());
		txtDni.setText(visitor.getDni());
		txtPhone.setText(visitor.getPhoneNumber());
		txtAddress.setText(visitor.getAddress());	
	}
	
	/**
	 * Metodo que devuelve un visitante con la información de los campos de texto
	 * 
	 * @return visitor 
	 * 
	 * @throws DomainException
	 */
	public Visitor getVisitor() throws DomainException
	{
		Visitor visitor = new Visitor(this.visitor);
		visitor.setFirstName(txtFirstName.getText());
		visitor.setLastName(txtLastName.getText());
		visitor.setDni(txtDni.getText());
		visitor.setEmail(txtEmail.getText());	
		visitor.setPhoneNumber(txtPhone.getText());
		visitor.setAddress(txtAddress.getText());
		
		return visitor;
	}
	/**
	 * Método que estable el actionListener del botón Actualizar datos
	 * 
	 * @param actionListener
	 */
	public void addActionListener(ActionListener actionListener)
	{				
		btnActualizarDatos.addActionListener(actionListener);
		
	}
	/**
	 * Método que establece el actionCommand del botón Actualizar
	 * 
	 * @param actionCommand
	 */
	public void addActionCommand(String actionCommand)
	{
		btnActualizarDatos.setActionCommand(actionCommand);
	}
	
	public void setEditableFields(boolean editable)
	{
		txtFirstName.setEditable(editable);
		txtLastName.setEditable(editable);
		txtDni.setEditable(editable);
		txtEmail.setEditable(editable);
		txtPhone.setEditable(editable);
		txtAddress.setEditable(editable);
	}
}
