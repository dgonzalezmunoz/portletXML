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
public class PanelEventosRegistrados extends JPanel{
	
	private JTable tableEventosRegistrados;
	private JLabel lblEventosRegistrados;
	private TableEventosRegistrados tableModelReg;
	private JButton btnDesRegistrar;
	
	//private TableEventos tableModelED; 
	
public PanelEventosRegistrados()
{
	setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	setLayout(new MigLayout("", "[452px]", "[55.00px][109.00][427px][48.00][][]"));
	lblEventosRegistrados = new JLabel("EVENTOS REGISTRADOS");
	lblEventosRegistrados.setFont(new Font("Tahoma", Font.BOLD, 13));
	add(lblEventosRegistrados, "cell 0 0,alignx center,aligny top");
	
	tableModelReg = new TableEventosRegistrados();
	

	
	tableEventosRegistrados = new JTable(tableModelReg);
	
	JScrollPane scrollPane = new JScrollPane(tableEventosRegistrados);
	add(scrollPane, "cell 0 2,alignx left,aligny top");
	
	btnDesRegistrar = new JButton("Desregistrar Evento");
	add(btnDesRegistrar, "cell 0 10,alignx left,aligny top");
	
}

public JTable getTableEventosRegistrados() {
	return tableEventosRegistrados;
}

public void setEventosRegistrados(List<Event> eventos)
{
	//Si tenemos eventos los insertamos en la tabla
	for (Event event : eventos) {
		tableModelReg.insertarEvento(event);
	}
}

public TableEventosRegistrados getTableModelReg() {
	return tableModelReg;
}

public void addActionListener(ActionListener actionListener)
{		
	
	btnDesRegistrar.addActionListener(actionListener);
	btnDesRegistrar.setActionCommand("desregistrar");
}

public int getSelectedRow() {

	return tableEventosRegistrados.getSelectedRow();
}

public Event getSelectedEvent(int index) {
	
	return tableModelReg.getSelectedEvent(index);
}

public void insertarEvento(Event evento)
{
	tableModelReg.insertarEvento(evento);
}

public void eliminarEvento(Event evento)
{
	tableModelReg.eliminarEvento(evento);
}









}
