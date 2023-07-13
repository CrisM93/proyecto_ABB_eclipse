import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaABB extends JFrame implements KeyListener, ItemListener,
		ActionListener {

	NodoABB arbol;
	NodoABB no;

	JPanel panel1;
	JPanel panel2;

	JButton boton1;
	JButton boton2;
	JButton boton3;

	JCheckBox Casilla1;
	JCheckBox Casilla2;
	JCheckBox Casilla3;
	JCheckBox Casilla4;
	JCheckBox Casilla5;
	JCheckBox Casilla6;

	JLabel eti;

	JTextField cuadro1;
	JTextField cuadro2;
	JTextField cuadro3;
	JTextField cuadro4;
	JTextField cuadro5;
	JTextField cuadro6;
	JComboBox ListaElementos;

	private static final long serialVersionUID = 1L;

	public VentanaABB(String Title) throws HeadlessException {
		super(Title);
		setSize(400, 300);

		arbol = new NodoABB();
		no = null;
		arbol = arbol.inserta(no, 10);
		arbol = arbol.inserta(arbol, 20);
		arbol = arbol.inserta(arbol, 5);

		panel1 = new JPanel();
		panel2 = new JPanel();

		Casilla1 = new JCheckBox("Recorrido en orden");
		Casilla2 = new JCheckBox("Recorrido en preorden");
		Casilla3 = new JCheckBox("Recorrido en postorden");
		Casilla4 = new JCheckBox("Amplitud");
		Casilla5 = new JCheckBox("Máximo");
		Casilla6 = new JCheckBox("Mínimo");

		boton1 = new JButton("Insertar");
		boton1.addActionListener(this);
		boton2 = new JButton("Eliminar");
		boton2.addActionListener(this);
		boton3 = new JButton("Buscar");
		boton3.addActionListener(this);

		cuadro1 = new JTextField(10);
		cuadro2 = new JTextField(10);
		cuadro3 = new JTextField(10);
		cuadro4 = new JTextField(10);
		cuadro5 = new JTextField(10);
		cuadro6 = new JTextField(10);
		cuadro1.setEditable(false);
		cuadro2.setEditable(false);
		cuadro3.setEditable(false);
		cuadro4.setEditable(false);
		cuadro5.setEditable(false);
		cuadro6.setEditable(false);

		panel1.setLayout(new GridLayout(6, 1));
		add(panel1, BorderLayout.CENTER);
		panel1.add(Casilla1);
		panel1.add(cuadro1);
		panel1.add(Casilla2);
		panel1.add(cuadro2);
		panel1.add(Casilla3);
		panel1.add(cuadro3);
		panel1.add(Casilla4);
		panel1.add(cuadro4);
		panel1.add(Casilla5);
		panel1.add(cuadro5);
		panel1.add(Casilla6);
		panel1.add(cuadro6);
		add(panel2, BorderLayout.SOUTH);
		panel2.add(boton1);
		panel2.add(boton2);
		panel2.add(boton3);

		Casilla1.addItemListener(this);
		Casilla2.addItemListener(this);
		Casilla3.addItemListener(this);
		Casilla4.addItemListener(this);
		Casilla5.addItemListener(this);
		Casilla6.addItemListener(this);

		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// casillas de verific
		if (Casilla1.isSelected()) {
			cuadro1.setText(arbol.orden(arbol));
		} else
			cuadro1.setText(null);

		if (Casilla2.isSelected())
			cuadro2.setText(arbol.preorden(arbol));
		else
			cuadro2.setText(null);

		if (Casilla3.isSelected())
			cuadro3.setText(arbol.posorden(arbol));
		else
			cuadro3.setText(null);

		if (Casilla4.isSelected())
			 //cuadro4.setText(arbol.Amplitud(arbol));
			// else
			cuadro4.setText(null);

		if (Casilla5.isSelected())
			// cuadro5.setText((arbol.bus_max(arbol)));
			// else
			cuadro5.setText(null);

		if (Casilla6.isSelected())
			// cuadro6.setText(Integer.toString(arbol.bus_min(arbol)));
			// else
			cuadro6.setText(null);

	}

	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NodoABB a = new NodoABB();
		int dato = 0;
		String clave;

		if (e.getSource() == boton1) {
			clave = javax.swing.JOptionPane.showInputDialog("Elemento a insertar");
			NodoABB.inserta(a, dato);
			if (e.getSource() ==Casilla1) {
				cuadro1.setText(arbol.orden(arbol));
			} else
				cuadro1.setText(null);

			if (e.getSource() ==Casilla2)
				cuadro2.setText(arbol.preorden(arbol));
			else
				cuadro2.setText(null);

			if (e.getSource() ==Casilla3)
				cuadro3.setText(arbol.posorden(arbol));
			else
				cuadro3.setText(null);

			if (e.getSource() ==Casilla4)
				 //cuadro4.setText(arbol.Amplitud(arbol));
				// else
				cuadro4.setText(null);

			if (e.getSource() ==Casilla5)
				// cuadro5.setText((arbol.bus_max(arbol)));
				// else
				cuadro5.setText(null);

			if (e.getSource() ==Casilla6)
				// cuadro6.setText(Integer.toString(arbol.bus_min(arbol)));
				// else
				cuadro6.setText(null);

			
		}
		if (e.getSource() == boton2) {
			clave = javax.swing.JOptionPane.showInputDialog("Elemento a eliminar");
			a.elimina(a, dato);
			if (e.getSource() ==Casilla1) {
				cuadro1.setText(arbol.orden(arbol));
			} else
				cuadro1.setText(null);

			if (e.getSource() ==Casilla2)
				cuadro2.setText(arbol.preorden(arbol));
			else
				cuadro2.setText(null);

			if (e.getSource() ==Casilla3)
				cuadro3.setText(arbol.posorden(arbol));
			else
				cuadro3.setText(null);

			if (e.getSource() ==Casilla4)
				 //cuadro4.setText(arbol.Amplitud(arbol));
				// else
				cuadro4.setText(null);

			if (e.getSource() ==Casilla5)
				// cuadro5.setText((arbol.bus_max(arbol)));
				// else
				cuadro5.setText(null);

			if (e.getSource() ==Casilla6)
				// cuadro6.setText(Integer.toString(arbol.bus_min(arbol)));
				// else
				cuadro6.setText(null);

			
		}
		if (e.getSource() == boton3) {
			clave = javax.swing.JOptionPane.showInputDialog("Elemento a buscar");
			a.buscar(a, dato);
			if (e.getSource() ==Casilla1) {
				cuadro1.setText(arbol.orden(arbol));
			} else
				cuadro1.setText(null);

			if (e.getSource() ==Casilla2)
				cuadro2.setText(arbol.preorden(arbol));
			else
				cuadro2.setText(null);

			if (e.getSource() ==Casilla3)
				cuadro3.setText(arbol.posorden(arbol));
			else
				cuadro3.setText(null);

			if (e.getSource() ==Casilla4)
				 //cuadro4.setText(arbol.Amplitud(arbol));
				// else
				cuadro4.setText(null);

			if (e.getSource() ==Casilla5)
				// cuadro5.setText((arbol.bus_max(arbol)));
				// else
				cuadro5.setText(null);

			if (e.getSource() ==Casilla6)
				// cuadro6.setText(Integer.toString(arbol.bus_min(arbol)));
				// else
				cuadro6.setText(null);

			
		}
	}

}
