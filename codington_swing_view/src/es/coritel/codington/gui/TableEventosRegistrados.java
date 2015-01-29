package es.coritel.codington.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import es.coritel.codington.festival.domain.Event;

public class TableEventosRegistrados implements TableModel {

	private List<Event> eventos = new ArrayList<Event>();
	private List<TableModelListener> listeners = new ArrayList<TableModelListener>();
	
	public TableEventosRegistrados()
	{
		
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return eventos.size();
	}

	@Override
	public int getColumnCount() {
		// Devolvemos el numero de columnas de la tabla
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// Definimos nombres de las columnas de la tabla
		 switch (columnIndex)

		    {

		      case 0:

		        return "Identificadro";

		      case 1:

		        return "Nombre Evento";

		      case 2:

		        return "Descripción";

		      case 3:

		        return "Lugar";

		      case 4:

		        return "Duración";

		      case 5:

		        return "Tipo Evento";
		     
		      
		      default:

		        return null;

		    }
		 
	
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// Establecemos clase de las columns de la tabla
		switch (columnIndex)

	    {

	      case 0:

	        return Integer.class;

	      case 1:

	        return String.class;

	      case 2:

	        return String.class;

	      case 3:

	        return String.class;

	      case 4:

	        return String.class;

	      case 5:

	        return String.class;

	      default:

	        return Object.class;

	    }
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// La tabla no será editable
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Obtenemos el evento e la fila a tratar
		
		    Event event = eventos.get(rowIndex);

		    // Se obtendra el cliente seleccionado según el numero de fila

		    switch (columnIndex)

		    {

		      case 0:

		        return event.getEventId();

		      case 1:

		        return event.getName();

		      case 2:

		        return event.getDescription();

		      case 3:

		        return event.getPlace();

		      case 4:

		        return event.getDuration();

		      case 5:

		        return event.getEventType();


		      default:

		        return null;

		    }
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// No editable no tenemos sque implementarlo
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		 // Añade el suscriptor a la lista de suscriptores

	    listeners.add(l);
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		 listeners.remove(l);
	}
	
	/**

	   * Metodo que inserta en la tabla

	   */

	  public void insertarEvento(Event evento)

	  {

	    // Añade el cliente al modelo

	    eventos.add(evento);

	    // Avisa a los suscriptores creando un TableModelEvent...

	    TableModelEvent tableModelEvent;

	    tableModelEvent = new TableModelEvent(this, this.getRowCount() - 1, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS,

	        TableModelEvent.INSERT);

	    // ... y avisando a los suscriptores

	    avisaSuscriptores(tableModelEvent);

	  }
	private void avisaSuscriptores(TableModelEvent tableModelEvent) {
		 int i;

		    for (i = 0; i < listeners.size(); i++)

		    {

		      ((TableModelListener) listeners.get(i)).tableChanged(tableModelEvent);

		    }
		
	}
	
	public Event getSelectedEvent(int index)
	{
		return eventos.get(index);
	}
	public void eliminarEvento(Event evento) {
		
		eventos.remove(evento);
		  // Avisa a los suscriptores creando un TableModelEvent...

	    TableModelEvent tableModelEvent;

	    tableModelEvent = new TableModelEvent(this, this.getRowCount() - 1, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS,

	        TableModelEvent.DELETE);

	    // ... y avisando a los suscriptores
	    avisaSuscriptores(tableModelEvent);
		
	}


}
