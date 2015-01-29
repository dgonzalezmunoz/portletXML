package es.coritel.codington.gui;


import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import net.miginfocom.swing.MigLayout;
import es.coritel.codington.festival.domain.Visitor;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {

	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	public LoginPanel() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setLayout(new MigLayout("", "[][][grow]", "[][]"));

		JLabel lblUsuario = new JLabel("Usuario");
		add(lblUsuario, "cell 1 0,alignx trailing");

		txtUsuario = new JTextField();
		add(txtUsuario, "cell 2 0,growx");
		txtUsuario.setColumns(12);

		JLabel lblPassword = new JLabel("Password:");
		add(lblPassword, "cell 1 1,alignx trailing");

		txtPassword = new JPasswordField();
		add(txtPassword, "cell 2 1,growx");
		txtUsuario.setColumns(12);

	}

	public Visitor getUser() {
		Visitor visitor = new Visitor();

		visitor.setUserName(txtUsuario.getText());
		visitor.setPassword(new String(txtPassword.getPassword()));

		return visitor;

	}

	/**
	 * 
	 * Para recuperar una imagen de un archivo... 
	 * @param path Ruta de la imagen 
	 * 
	 *  @return una imagen
	 */
	public ImageIcon createImage(String path) {
		URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

}
