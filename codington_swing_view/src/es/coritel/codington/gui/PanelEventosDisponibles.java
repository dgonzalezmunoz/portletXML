package es.coritel.codington.gui;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

import net.miginfocom.swing.MigLayout;
import es.coritel.codington.festival.domain.Event;

@SuppressWarnings("serial")
public class PanelEventosDisponibles extends JPanel{
	
	private JTable tableEventosDisponibles;
	private JLabel lblEventosDisponibles;
	private TableEventos tableModelED;
	private JButton btnRegistrar;
	//private TableEventos tableModelED; 
	
public PanelEventosDisponibles()
{
	setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	setLayout(new MigLayout("", "[600.00px]", "[55.00px][109.00][427px][48.00][][][][][][][]"));
	lblEventosDisponibles = new JLabel("EVENTOS DISPONIBLES");
	lblEventosDisponibles.setFont(new Font("Tahoma", Font.BOLD, 13));
	add(lblEventosDisponibles, "cell 0 0,alignx center,aligny top");
	
	tableModelED = new TableEventos();
	
	tableEventosDisponibles = new JTable(tableModelED);
	
	JScrollPane scrollPane = new JScrollPane(tableEventosDisponibles);
	add(scrollPane, "cell 0 2,alignx left,aligny top");
	btnRegistrar = new JButton("Registrar Evento");
	add(btnRegistrar, "cell 0 10,alignx left,aligny top");
}

public JTable getTableEventosDisponibles() {
	return tableEventosDisponibles;
}



public TableEventos getTableModelED() {
	return tableModelED;
}


public void addActionListener(ActionListener actionListener)
{		
	
	btnRegistrar.addActionListener(actionListener);
	btnRegistrar.setActionCommand("registrar");
}

public void setEventosDisponibles(List<Event> eventos) {
	//insertamos los eventos en la tabla
		for (Event event : eventos) {
			tableModelED.insertarEvento(event);
		}
	
}

public int getSelectedRow() {
	
	return tableEventosDisponibles.getSelectedRow();
}

public Event getSelectedEvent(int index)
{
	return tableModelED.getSelectedEvent(index);
}

public void actualizaAsientosEvento(Event evento, int numAsientos)
{
	tableModelED.actualizaAsientosEvento(evento, numAsientos);
}





}
