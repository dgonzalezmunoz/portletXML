package es.coritel.codington.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.services.EventService;
import es.coritel.codington.festival.services.VisitorService;

/**
 * Clase de arranque de la aplicación y splash screen.
 * 
 * @author Accenture Technology Solutions (ATS)
 * @version 1.0
 */
@SuppressWarnings("serial")
public final class LoginWindow extends JFrame implements ActionListener {
	LoginPanel loginPanel = null;

	/**
	 * Crea y posiciona el contenido de la ventana
	 */
	private LoginWindow() throws IOException {
		// Si la ventana se cierra la aplicación termina
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Texto
		JLabel label = new JLabel(
				"<html><h2><span>Codington Festival Login</span></h2></html>");

		// Configuramos el contenido de la ventana
		getContentPane().setLayout(
				new MigLayout("", "[][grow][]", "[][grow][][65.00]"));
		getContentPane().add(label, "cell 1 0,grow");

		// Boton 'Iniciar' y asignación de un manejador de eventos
		JButton bIniciar = new JButton("Login");
		bIniciar.addActionListener(this);
		loginPanel = new LoginPanel();
		getContentPane().add(loginPanel, "cell 1 1,grow");
		getContentPane().add(bIniciar, "cell 1 2");

		
		// Empaquetamos los componentes de la ventana a su tamaÃ±o preferido
		pack();

		// Centramos la ventana en la pantalla
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolKit.getScreenSize();
		int x = (int) (screenSize.getWidth() - getWidth()) / 2;
		int y = (int) (screenSize.getHeight() - getHeight()) / 2;
		setLocation(x, y);

		// Ultimamos la configuración de la ventana y la mostramos.
		setResizable(false);
		setVisible(true);
		
	}

	/**
	 * Gestiona la pulsación del botón 'Iniciar' para que arranque la ventana
	 * principal de la aplicación.
	 * 
	 * @param args
	 */
	@Override
	public final void actionPerformed(ActionEvent event) {
		try {

			
			VisitorService sv = new VisitorService();
			EventService se = new EventService();
			
			// Obtnemos el usuario
			Visitor visitor = loginPanel.getUser();
			

			Visitor visitorFound = sv.searchVisitor(visitor);
			if ((visitorFound != null)
					&& (visitorFound.getPassword()
							.equals(visitor.getPassword()))) {

				//Obtenemos los eventos disponibles
				List<Event> events = se.getAllEvents();
				//Obtenemos los eventos para los cuales está registrado el usuario
				List<Event> eventsReg=sv.showRegisteredEvents(visitorFound);
				
				
				// Abrimios la ventana principal de la aplicación
				MainWindow main = new MainWindow();
				//Establecemos el visitante
				main.setVisitor(visitorFound);
				//Establecemos los eventos Registrados
				main.setEventsRegistrados(eventsReg);
				//Establecemos los eventos Disponibles
				main.setEventsDisponibles(events);

				// Liberamos la ventana actual
				setVisible(false);
				dispose();
			} else {
				JOptionPane.showMessageDialog(this,
						"Usuario/Passworod Invalida");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	/**
	 * Inicia la ejecución de la interfaz gráfica del programa 
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		new LoginWindow();
	}

}
