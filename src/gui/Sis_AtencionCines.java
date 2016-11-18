package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sis_AtencionCines extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnRegReserva;
	private JMenu mnCtrPago;
	private JMenu mnReportes;
	private JMenuItem mntmEmpleados;
	private JMenuItem mntmClientes;
	private JMenuItem mntmCines;
	private JMenuItem mntmSalas;
	private JMenuItem mntmPeliculas;
	private JMenuItem mntmFunciones;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sis_AtencionCines frame = new Sis_AtencionCines();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sis_AtencionCines() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 529);
		//Centrar automaticamente aplicación en el centro de pantalla
		this.setLocationRelativeTo(null);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnArchivo = new JMenu("Archivo");
				menuBar.add(mnArchivo);
			}
			{
				mnMantenimiento = new JMenu("Mantenimiento");
				menuBar.add(mnMantenimiento);
				{
					mntmEmpleados = new JMenuItem("Empleados");
					mntmEmpleados.addActionListener(this);
					mnMantenimiento.add(mntmEmpleados);
				}
				{
					mntmClientes = new JMenuItem("Clientes");
					mntmClientes.addActionListener(this);
					mnMantenimiento.add(mntmClientes);
				}
				{
					mntmCines = new JMenuItem("Cines");
					mntmCines.addActionListener(this);
					mnMantenimiento.add(mntmCines);
				}
				{
					mntmSalas = new JMenuItem("Salas");
					mntmSalas.addActionListener(this);
					mnMantenimiento.add(mntmSalas);
				}
				{
					mntmPeliculas = new JMenuItem("Peliculas");
					mntmPeliculas.addActionListener(this);
					mnMantenimiento.add(mntmPeliculas);
				}
				{
					mntmFunciones = new JMenuItem("Funciones");
					mntmFunciones.addActionListener(this);
					mnMantenimiento.add(mntmFunciones);
				}
			}
			{
				mnRegReserva = new JMenu("Registro de Reserva");
				menuBar.add(mnRegReserva);
			}
			{
				mnCtrPago = new JMenu("Control de Pago");
				menuBar.add(mnCtrPago);
			}
			{
				mnReportes = new JMenu("Reportes");
				menuBar.add(mnReportes);
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmFunciones) {
			do_mntmFunciones_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmPeliculas) {
			do_mntmPeliculas_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmSalas) {
			do_mntmSalas_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmCines) {
			do_mntmCines_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmClientes) {
			do_mntmClientes_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmEmpleados) {
			do_mntmEmpleados_actionPerformed(arg0);
		}
	}
	protected void do_mntmEmpleados_actionPerformed(ActionEvent arg0) {
		Gui_Empleado z;
		z = new Gui_Empleado(); 
		z.setLocationRelativeTo(this);
		z.setVisible(true); 
	}
	protected void do_mntmClientes_actionPerformed(ActionEvent arg0) {
		Gui_Cliente z; 
		z = new Gui_Cliente(); 
		z.setLocationRelativeTo(this);
		z.setVisible(true);
	}
	protected void do_mntmCines_actionPerformed(ActionEvent arg0) {
		Gui_Cine z; 
		z = new Gui_Cine(); 
		z.setLocationRelativeTo(this);
		z.setVisible(true);
	}
	protected void do_mntmSalas_actionPerformed(ActionEvent arg0) {
		Gui_Sala z;
		z = new Gui_Sala();
		z.setLocationRelativeTo(this);
		z.setVisible(true);
	}
	protected void do_mntmPeliculas_actionPerformed(ActionEvent arg0) {
		Gui_Pelicula z;
		z = new Gui_Pelicula();
		z.setLocationRelativeTo(this);
		z.setVisible(true);
	}
	protected void do_mntmFunciones_actionPerformed(ActionEvent arg0) {
		Gui_Funcion z;
		z = new Gui_Funcion();
		z.setLocationRelativeTo(this);
		z.setVisible(true);
	}
}
