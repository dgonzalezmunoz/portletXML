package es.coritel.codington.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.Visitor;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanel panelPrincipal;
	
	private MainMenu menu;
	private PanelVisitor panelUsuario;
	private PanelEventosRegistrados panelEventosRegistrados;
	private PanelEventosDisponibles panelEventosDisponibles;




	private JLabel lblBienvenido;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainWindow() {

		
		//Establecemos el manejador de eventos de la ventana
		EventManager eventManager = new EventManager(this);
		
		
		setTitle("Codington Festival Registration");
		

		// Se establece que al cerrar la ventana se salga de la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(500, 500);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new MigLayout("", "[826.00,grow]",
				"[113.00][][224.00][][178.00][grow][][]"));

		Border exteriorBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border etchBorder = BorderFactory.createEtchedBorder();
		Border compundBorder = BorderFactory.createCompoundBorder(
				exteriorBorder, etchBorder);

		// Establece el menu
		menu = new MainMenu();
		setJMenuBar(menu);
		menu.addActionListener(eventManager);

		panelPrincipal.setBorder(compundBorder);
		
		//Bienvenida
		lblBienvenido = new JLabel("Bienvenido/a ");
		
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblBienvenido, "cell 0 0,grow");
		lblBienvenido.setText(lblBienvenido.getText()); //+ visitor.getUserName());
		
		//PANEL USUARIO
		// Creamos el panel donde se visializa la información del Visitante
		panelUsuario = new PanelVisitor();
		// Informamos de los datos del visitante en el panel
		//panelUsuario.setVisitor(visitor);	
		panelUsuario.setEditableFields(false);
	
		
		//Le asignamos nuestra instancia de EventManager como action listener
		panelUsuario.addActionListener(eventManager);
		panelUsuario.addActionCommand("mostrarDatosVisitor");	
		
		// Lo añadimos a la ventana principal
		panelPrincipal.add(panelUsuario, "cell 0 1,grow");
		
		//EVENTOS REGISTRADOS
		//Creamos el panel que contiene los eventos registrados
		panelEventosRegistrados = new PanelEventosRegistrados();
		panelEventosRegistrados.addActionListener(eventManager);
		//Lo añadimos a la ventan principal
		panelPrincipal.add(panelEventosRegistrados, "cell 0 2,grow");
		
		//EVENTOS DISPONIBLES
		//Creamos el panel que contiene los eventos Disponible
		panelEventosDisponibles = new PanelEventosDisponibles();
		//Le asignamos nuestra instancia de EventManager como action listener
		panelEventosDisponibles.addActionListener(eventManager);	
		//Lo añadimos a la ventan principal
		panelPrincipal.add(panelEventosDisponibles, "cell 0 4,grow");
		
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


	public void setVisitor(Visitor visitor)
	{
		lblBienvenido.setText(lblBienvenido.getText() + visitor.getUserName());
		panelUsuario.setVisitor(visitor);
		
		if (visitor.isAdmin())
		{
			menu.setVisibleGestion(true);
		}
		else
		{
			menu.setVisibleGestion(false);
		}
			
	}
	
	public Visitor getVisitor()
	{
		return panelUsuario.getVisitor();
	}
	
	public void setEventsDisponibles(List<Event> eventos)
	{
		panelEventosDisponibles.setEventosDisponibles(eventos);
	}
	
	public void setEventsRegistrados(List<Event> eventos)
	{
		panelEventosRegistrados.setEventosRegistrados(eventos);
	}
	
	public int getSelectedRowEventDisponibles()
	{
		return panelEventosDisponibles.getSelectedRow();
	}
	
	public Event getSelectedEventDisponibles(int index)
	{
		return panelEventosDisponibles.getSelectedEvent(index);
	}

	public int getSelectedRowEventRegistrados()
	{
		return panelEventosRegistrados.getSelectedRow();
	}
	
	public Event getSelectedEventRegistrados(int index)
	{
		return panelEventosRegistrados.getSelectedEvent(index);
	}

	public void insertarEventoRegistrado(Event evento) {
		
		panelEventosRegistrados.insertarEvento(evento);
		
	}

	public void eliminarEventoRegistrado(Event evento) {
		
		panelEventosRegistrados.eliminarEvento(evento);
		
	}

	public void actualizaAsientosEventoDisponible(Event evento, int numAsientos) {
		panelEventosDisponibles.actualizaAsientosEvento(evento, numAsientos);
		
	}
}

