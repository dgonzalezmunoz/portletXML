package es.coritel.codington.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JOptionPane;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.services.EventService;
import es.coritel.codington.festival.services.VisitorService;

public class EventManager extends WindowAdapter implements ActionListener {

	private MainWindow main;
	private EventService eventService = new EventService();
	private VisitorService visitorService = new VisitorService();
	private UpdateVisitorWindow visitorWindow = null;

	public EventManager(MainWindow main) {
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		

		try {

			if (event.getActionCommand().equals("mostrarDatosVisitor")) {
				// Mostramos la ventana de actualización de datos
				visitorWindow = new UpdateVisitorWindow();
				visitorWindow.setVisitor(main.getVisitor());
				visitorWindow.addActionListener(this);
				visitorWindow.addActionCommand("actualizar");
			} else if (event.getActionCommand().equals("actualizar")) {

				// Obtenemos el visitante actualizado
				Visitor visitor = visitorWindow.getUpdatedVisitor();
				// Actualizamos el visitante en la bbdd
				visitorService.updateVisitorDetails(visitor);
				// establecemos los valores del visitante actualizado en la
				// ventana principal
				main.setVisitor(visitor);
				// Cerramos la veentan axiliar
				visitorWindow.dispose();

			} else if (event.getActionCommand().equals("registrar")) {

				int rowSelected = main.getSelectedRowEventDisponibles();

				// Comprobamos si se ha seleccionado un evento de la tabla de
				// eventos disponibles
				if (rowSelected != -1) {
					// Obtnemos el evento seleccionado
					Event evento = main
							.getSelectedEventDisponibles(rowSelected);

			
					//Obtenemos el visitante
					Visitor visitor = main.getVisitor();

					// Registramos al visitante en en el evento
					eventService.registerEvent(visitor, evento);

					// Añadimos el evento a la lista de eventos
					// registrados
					main.insertarEventoRegistrado(evento);

					// actualizamos el numero de asientos
					main.actualizaAsientosEventoDisponible(evento, -1);

				} else {
					// Si no se ha seleccionado ninguno mostramos ventana de
					// error
					JOptionPane.showMessageDialog(main,
							"No se ha seleccionado ningún evento");

				}
			} else if (event.getActionCommand().equals("desregistrar")) {

				int rowSelected = main.getSelectedRowEventRegistrados();

				// Comprobamos si se ha seleccionado un evento de la tabla de
				// eventos disponibles
				if (rowSelected != -1) {
					// Obtnemos el evento seleccionado
					Event evento = main
							.getSelectedEventRegistrados(rowSelected);

					// Obtenemos el visitante
					Visitor visitor = main.getVisitor();

					// Nos desregistramos del evento
					eventService.unregisterEvent(visitor, evento);

					// eliminamos el evento de la lista de eventos
					// registrados
					main.eliminarEventoRegistrado(evento);

					// actualizamos el numero de asientos
					main.actualizaAsientosEventoDisponible(evento, +1);

				} else {
					// Si no se ha seleccionado ninguno mostramos ventana de
					// error
					JOptionPane.showMessageDialog(main,
							"No se ha seleccionado ningún evento");

				}
			}

			else if (event.getActionCommand().equals("salir")) {
				main.dispose();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(main, e.getMessage());

		}
	}

}
