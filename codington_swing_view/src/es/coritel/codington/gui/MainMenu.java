package es.coritel.codington.gui;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuListener;

@SuppressWarnings("serial")
public class MainMenu extends JMenuBar
{
	  private JMenu     file  = new JMenu("Fichero");
	  private JMenuItem salir = new JMenuItem("Salir");  
	  private JMenu gestionEventos = new JMenu("Gestion Eventos"); 
	  private JMenuItem altaEvento = new JMenuItem("Alta Evento");  
	  private JMenuItem updateEvento = new JMenuItem("Actualización Evento");  
	  private JMenuItem deleteEvento = new JMenuItem("Baja Evento");  
  

  /** Contruye el menu principal 'Fichero' con los elementos 'Nuevo' y 'Salir' */
  public MainMenu()
  {
	  	salir.setActionCommand("salir");
	   
	    file.add(gestionEventos);
	    gestionEventos.add(altaEvento);
	    gestionEventos.add(updateEvento);
	    gestionEventos.add(deleteEvento);
	    file.add(salir);
	    add(file);
  }
  
  /** Permite registrar un MenuListener para gestionar la seleccion de las distintas
   * opciones del menu.
   * @param ml {@link MenuListener} que debe gestionar eventos enviados por elementos
   * de Menu Salir.
   */
  public void addActionListener(ActionListener ml)
  {
    salir.addActionListener(ml);
  }
  
  public void setVisibleGestion(boolean visible)
  {
	 gestionEventos.setVisible(visible);
  }
}
