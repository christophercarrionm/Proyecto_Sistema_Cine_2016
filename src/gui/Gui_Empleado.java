package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import arreglos.Arreglo_Empleado;
import clases.Empleado;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class Gui_Empleado extends JDialog implements ActionListener, KeyListener {
	
	
	private static final long serialVersionUID = 1L;
	private JTable tblTable;
	private JLabel lblTitulo;
	private TableRowSorter trsFiltro;
	private DefaultTableModel modelo;	
	private JPasswordField passwordField;
	
	private JLabel lblCodigo;
	private JLabel lblDocumento;	
	private JLabel lblNombres;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblTipoEmpleado;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	
	private JTextField txtCodigo;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtApaterno;
	private JTextField txtAmaterno;
	private JComboBox cboTempleado;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
		
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnConsultar;
	
	private JButton btnAceptar;	
	private JButton btnRegresar;
	
	private int operacion;
	public final static int INGRESAR=0;
	public final static int CONSULTAR=1;
	public final static int MODIFICAR=2;
	public final static int ELIMINAR=3;
	
	
	public static void main(String[] args) {
		/*try {
			Gui_Empleado dialog = new Gui_Empleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Empleado frame = new Gui_Empleado();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

	public Gui_Empleado() {
		setResizable(false);
		setTitle("Empleados");
		setModal(true);
		setBounds(100, 100, 641, 567);
		getContentPane().setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 303, 612, 191);
			getContentPane().add(scrollPane);
			{
				tblTable = new JTable();
				scrollPane.setViewportView(tblTable);
				tblTable.setEnabled(false);
				tblTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						txtCodigo.setText("");
						txtDocumento.setText("");
						txtNombre.setText("");
						txtApaterno.setText("");
						txtAmaterno.setText("");
						txtUsuario.setText("");
						txtContraseña.setText("");
					    int row = tblTable.rowAtPoint(e.getPoint());
					   	txtCodigo.setText(tblTable.getValueAt(row, 0).toString());
					   	txtDocumento.setText(tblTable.getValueAt(row, 1).toString());
					  	txtNombre.setText(tblTable.getValueAt(row, 2).toString());
					   	txtApaterno.setText(tblTable.getValueAt(row, 3).toString());
					   	txtAmaterno.setText(tblTable.getValueAt(row, 4).toString());
					   	txtUsuario.setText(tblTable.getValueAt(row, 6).toString());
					   	txtContraseña.setText(tblTable.getValueAt(row, 7).toString());
					}
				});			
				
			}
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.setMargin(new Insets(0, 0, 0, 0));
			btnGuardar.addActionListener(this);
			btnGuardar.setBounds(492, 93, 130, 30);
			btnGuardar.setVisible(false);
			getContentPane().add(btnGuardar);
		}
		{
			btnConsultar = new JButton("Consultar");
			btnConsultar.addActionListener(this);
			btnConsultar.setBounds(492, 136, 130, 30);
			getContentPane().add(btnConsultar);
		}
		{
			btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(this);
			btnActualizar.setBounds(492, 177, 130, 30);
			btnActualizar.setVisible(false);
			getContentPane().add(btnActualizar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(492, 218, 130, 30);
			btnEliminar.setVisible(false);
			getContentPane().add(btnEliminar);
		}
		{
			btnRegresar = new JButton("Regresar");
			btnRegresar.addActionListener(this);
				btnRegresar.setBounds(331, 167, 89, 23);
			btnRegresar.setVisible(false);
			getContentPane().add(btnRegresar);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(331, 117, 89, 23);
			btnAceptar.setVisible(false);
			getContentPane().add(btnAceptar);
		}
		{
			lblTitulo = new JLabel("Seleccione una Opci\u00F3n");
			lblTitulo.setBackground(Color.DARK_GRAY);
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setOpaque(true);
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBounds(0, 0, 724, 38);
			getContentPane().add(lblTitulo);
		}
		{
			lblCodigo = new JLabel("C\u00F3digo Empleado");
			lblCodigo.setBounds(10, 53, 116, 14);
			getContentPane().add(lblCodigo);
		}
		{
			lblNombres = new JLabel("Nombres");
			lblNombres.setBounds(10, 101, 116, 14);
			getContentPane().add(lblNombres);
		}
		{
			lblApellidoPaterno = new JLabel("Apellido Paterno");
			lblApellidoPaterno.setBounds(10, 126, 116, 14);
			getContentPane().add(lblApellidoPaterno);
		}
		{
			lblApellidoMaterno = new JLabel("Apellido Materno");
			lblApellidoMaterno.setBounds(10, 151, 116, 14);
			getContentPane().add(lblApellidoMaterno);
		}
		{
			lblTipoEmpleado = new JLabel("Tipo Empleado");
			lblTipoEmpleado.setBounds(10, 176, 116, 14);
			getContentPane().add(lblTipoEmpleado);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setBounds(10, 201, 116, 14);
			getContentPane().add(lblUsuario);
		}
		{
			lblContraseña = new JLabel("Contraseña");
			lblContraseña.setBounds(10, 226, 116, 14);
			getContentPane().add(lblContraseña);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setBounds(129, 50, 150, 20);
			getContentPane().add(txtCodigo);
			txtCodigo.setVisible(false);
			txtCodigo.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(129, 101, 150, 20);
			getContentPane().add(txtNombre);
			txtNombre.setVisible(false);
			txtNombre.setColumns(10);
		}
		{
			txtApaterno = new JTextField();
			txtApaterno.setBounds(129, 126, 150, 20);
			getContentPane().add(txtApaterno);
			txtApaterno.setVisible(false);
			txtApaterno.setColumns(10);
		}
		{
			txtAmaterno = new JTextField();
			txtAmaterno.setBounds(129, 151, 150, 20);
			getContentPane().add(txtAmaterno);
			txtAmaterno.setVisible(false);
			txtAmaterno.setColumns(10);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setBounds(129, 201, 150, 20);
			getContentPane().add(txtUsuario);
			txtUsuario.setVisible(false);
			txtUsuario.setColumns(10);
		}
		{
			txtContraseña = new JPasswordField();
			txtContraseña.setBounds(129, 226, 150, 20);
			getContentPane().add(txtContraseña);
			txtContraseña.setVisible(false);
			txtContraseña.setColumns(10);
		}
		{
			cboTempleado = new JComboBox();
			cboTempleado.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Supervisor", "Cajero"}));
			cboTempleado.setToolTipText("");
			cboTempleado.setBounds(129, 176, 150, 20);
			cboTempleado.setVisible(false);
			getContentPane().add(cboTempleado);
		}		
		{
			txtDocumento = new JTextField();
			txtDocumento.setBounds(129, 75, 150, 20);
			getContentPane().add(txtDocumento);
			txtDocumento.setVisible(false);
			txtDocumento.setColumns(10);
		}
		{
			lblDocumento = new JLabel("Documento");
			lblDocumento.setBounds(10, 76, 116, 14);
			getContentPane().add(lblDocumento);
		}		
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Documento");
		modelo.addColumn("Nombre");
		modelo.addColumn("A. Paterno");
		modelo.addColumn("A. Materno");
		modelo.addColumn("T. Empleado");
		modelo.addColumn("Usuario");
		modelo.addColumn("Contraseña");
		tblTable.setModel(modelo);
		{
			separator = new JSeparator();
			separator.setBounds(10, 259, 612, 2);
			getContentPane().add(separator);
		}
		{
			lblBuscarPor = new JLabel("Buscar por");
			lblBuscarPor.setBounds(10, 272, 116, 14);
			lblBuscarPor.setVisible(false);
			getContentPane().add(lblBuscarPor);
		}
		{
			cboBuscarPor = new JComboBox();
			cboBuscarPor.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo Empleado", "Documento", "Nombres"}));
			cboBuscarPor.setBounds(129, 272, 150, 20);
			cboBuscarPor.setVisible(false);
			getContentPane().add(cboBuscarPor);
		}
		{
			txtBuscarPor = new JTextField();
			txtBuscarPor.addKeyListener(this);
			txtBuscarPor.setBounds(289, 272, 333, 20);
			getContentPane().add(txtBuscarPor);
			txtBuscarPor.setVisible(false);
			txtBuscarPor.setColumns(10);
		}
		{
			btnNuevo = new JButton("Nuevo");
			btnNuevo.addActionListener(this);
			btnNuevo.setBounds(492, 49, 130, 30);
			getContentPane().add(btnNuevo);
		}
	
		visualizarEntradas(false);
		listar();
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(arg0);
		}

		if (arg0.getSource() == btnRegresar) {
			do_btnRegresar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			do_btnConsultar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			do_btnAceptar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(arg0);
		}
	}	
	
	Arreglo_Empleado ae = new Arreglo_Empleado("Files/empleados.txt");
	private JSeparator separator;
	private JLabel lblBuscarPor;
	private JComboBox cboBuscarPor;
	private JTextField txtBuscarPor;
	private JButton btnNuevo;

	protected void do_btnAceptar_actionPerformed(ActionEvent arg0) {
		switch (operacion) {
		case INGRESAR:
			ingresarEmpleado(); 
			break;
		case CONSULTAR:
			consultarEmpleado();
			break;
		case MODIFICAR:
			modificarEmpleado();
			break;
		case ELIMINAR:
			eliminarEmpleado();
		}
	}
	protected void do_btnRegresar_actionPerformed(ActionEvent arg0) {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApaterno.setText("");
		txtAmaterno.setText("");
		txtCodigo.setEditable(false);
		visualizarEntradas(false);
		editarEntradas(false);
		habilitarBotones(true);
		lblTitulo.setText("Seleccione una Opción");			
	}
	protected void do_btnGuardar_actionPerformed(ActionEvent arg0) {
		switch (operacion) {
		case INGRESAR:
			ingresarEmpleado(); 
			break;
		case CONSULTAR:
			consultarEmpleado();
			break;
		case MODIFICAR:
			modificarEmpleado();
			break;
		case ELIMINAR:
			eliminarEmpleado();
		}
	}	
	protected void do_btnConsultar_actionPerformed(ActionEvent arg0) {
		operacion = CONSULTAR;
		lblTitulo.setText("Buscando Empleado");
		consultarEmpleado();	
	}
	protected void do_btnActualizar_actionPerformed(ActionEvent arg0) {
		operacion = MODIFICAR;
		lblTitulo.setText("Modificar Empleado");
		consultarEmpleado();
		editarEntradas(true);
		habilitarBotones(true);	
		txtCodigo.setEditable(false);
		txtNombre.requestFocus();
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
		operacion = ELIMINAR;
		lblTitulo.setText("Modificar Empleado");
		eliminarEmpleado();
	}	

	int leerCodigo() { 
		return Integer.parseInt(txtCodigo.getText());
	}
	String leerDocumento() {
		return txtDocumento.getText();
	}
	String leerNombres() {
		return txtNombre.getText();
	}
	String leerA_Paterno() {
		return txtApaterno.getText();
	}
	String leerA_Materno() {
		return txtAmaterno.getText();
	}	
	int leerT_Empleado() {
		return cboTempleado.getSelectedIndex();
	}	
	String leerUsuario() {
		return txtUsuario.getText();
	}
	String leerContraseña() {
		return txtContraseña.getText();
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}	

	
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ae.tamaño(); i++) {
			Object[] fila = {
				ae.obtener(i).getCodigo(),
				ae.obtener(i).getDocumento(),
				ae.obtener(i).getNombres(),
				ae.obtener(i).getA_paterno(),
				ae.obtener(i).getA_materno(), 
				ae.obtener(i).getT_empleado(),
				ae.obtener(i).getUsuario(),
				ae.obtener(i).getContraseña()
			};
			modelo.addRow(fila);
		}
	}	
	
	
	void limpiar(){
		txtDocumento.setText("");
		txtNombre.setText("");
		txtApaterno.setText("");
		txtAmaterno.setText("");
		txtUsuario.setText("");
		txtContraseña.setText("");
	}
	
	
	void ingresarEmpleado(){	
		int codigo = leerCodigo(),t_empleado = leerT_Empleado();
		String documento = leerDocumento(), nombres = leerNombres(), a_paterno = leerA_Paterno(), a_materno = leerA_Materno(), usuario = leerUsuario(), contraseña = leerContraseña();
		
		Empleado nuevo = new Empleado(codigo, documento, nombres, a_paterno, a_materno, t_empleado, usuario, contraseña);

		if(documento.length()>0){
				//
				//txtCodigo.setText(""+ae.codCorrelativo());	
				txtNombre.requestFocus();
				ae.agregar(nuevo);
				ae.grabarEmpleados();
				limpiar();
				mensaje("Se registro el empleado: " + leerCodigo());
		} else {
			mensaje("Favor de ingresar el Nombre correcto");
			txtNombre.setText("");
			txtNombre.requestFocus();
		}
		
		/*txtCodigo.setText(""+ae.codCorrelativo());*/	
		txtDocumento.requestFocus();
		listar();
	}
	

	
	void consultarEmpleado(){
		habilitarConsultas(true);
		/*try{	
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar Código a buscar"));
			Empleado x = ae.buscar(codigo);	
			if (x != null) {	
				visualizarEntradas(true);
				editarEntradas(false);		
				txtCodigo.setText(""+x.getCodigo());
				txtDocumento.setText(x.getDocumento());
				txtNombre.setText(x.getNombres());
				txtApaterno.setText(x.getA_paterno());
				txtAmaterno.setText(x.getA_materno());
				txtUsuario.setText(x.getUsuario());
				txtContraseña.setText(x.getContraseña());					
			} else {
				visualizarEntradas(false);
				mensaje("El código no existe");
			}
		} catch (NumberFormatException  e) {
			visualizarEntradas(false);
			mensaje("Ingrese solo Números");
		}*/
		
	}
	
	void modificarEmpleado(){
			int codigo = leerCodigo(),t_empleado = leerT_Empleado();
			String documento = leerDocumento(), nombres = leerNombres(), a_paterno = leerA_Paterno(), a_materno = leerA_Materno(), usuario = leerUsuario(), contraseña = leerContraseña();
		
			Empleado x = ae.buscar(codigo);	
			if (x != null) {	
				visualizarEntradas(true);
				editarEntradas(true);
				x.setDocumento(documento);
				x.setNombres(nombres);
				x.setA_paterno(a_paterno);
				x.setA_materno(a_materno);
				x.setUsuario(usuario);
				x.setContraseña(contraseña);
				ae.grabarEmpleados();
				mensaje("Se modifico correctamente");
				listar();
				visualizarEntradas(false);	
				btnAceptar.setVisible(false);
			}
	}
	void eliminarEmpleado(){
		try {
			/*int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar Código a buscar"));*/
			int codigo = leerCodigo();
			Empleado x = ae.buscar(codigo);	
			if (x != null) {
				ae.eliminar(x);
				ae.grabarEmpleados();
				mensaje("Se elimino correctamente");
				listar();
			} else {
				mensaje("El código " + leerCodigo() + " no existe");
			}
		} catch (Exception e) {
			mensaje("Ingrese solo Números");
		}			
	}
	
	public void filtro() {
        int columnaABuscar = 0;
        if (cboBuscarPor.getSelectedItem() == "Código Empleado") {
            columnaABuscar = 0;
        }
        if (cboBuscarPor.getSelectedItem().toString() == "Documento") {
            columnaABuscar = 1;
        }
        if (cboBuscarPor.getSelectedItem() == "Nombres") {
            columnaABuscar = 2;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txtBuscarPor.getText(), columnaABuscar));
    }

	void editarEntradas(boolean x){
		cboTempleado.setEnabled(x);;
		txtCodigo.setEditable(x);
		txtDocumento.setEditable(x);
		txtNombre.setEditable(x);
		txtApaterno.setEditable(x);
		txtAmaterno.setEditable(x);
		txtUsuario.setEditable(x);
		txtContraseña.setEditable(x);
	}
	void visualizarEntradas(boolean x){
		cboTempleado.setVisible(x);;
		txtCodigo.setVisible(x);
		txtDocumento.setVisible(x);
		txtNombre.setVisible(x);
		txtApaterno.setVisible(x);
		txtAmaterno.setVisible(x);
		txtUsuario.setVisible(x);
		txtContraseña.setVisible(x);
	}
	void habilitarRespuestas(boolean x){
		btnAceptar.setEnabled(!x);
		btnAceptar.setVisible(!x);
		btnRegresar.setEnabled(!x);
		btnRegresar.setVisible(!x);
	}
	void habilitarBotones(boolean x){
		/*btnGuardar.setVisible(x);
		btnConsultar.setVisible(x);
		btnActualizar.setVisible(x);
		btnEliminar.setVisible(x);*/	
		if(operacion == INGRESAR){
			btnRegresar.setEnabled(!x);
			btnRegresar.setVisible(!x);
			btnAceptar.setEnabled(!x);
			btnAceptar.setVisible(!x);
		} 
		if (operacion == MODIFICAR){
			btnAceptar.setEnabled(x);
			btnAceptar.setVisible(x);			
		}
	}
	void habilitarConsultas(boolean x){
		lblBuscarPor.setVisible(x);
		cboBuscarPor.setVisible(x);
		txtBuscarPor.setVisible(x);
		txtBuscarPor.setEditable(x);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtBuscarPor) {
			do_txtBuscarPor_keyTyped(e);
		}
	}
	
	protected void do_txtBuscarPor_keyTyped(KeyEvent e) {
		txtBuscarPor.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscarPor.getText());
                txtBuscarPor.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(tblTable.getModel());
        tblTable.setRowSorter(trsFiltro);
		
	}
	protected void do_btnNuevo_actionPerformed(ActionEvent arg0) {
		operacion = INGRESAR;
		lblTitulo.setText("Ingresar Empleado");
		limpiar();
		btnConsultar.setVisible(false);
		btnNuevo.setEnabled(false);
		btnGuardar.setVisible(true);
		visualizarEntradas(true);
		editarEntradas(true);
		habilitarBotones(false);
		txtCodigo.setEditable(false);
		txtCodigo.setText(""+ae.codCorrelativo());
		txtDocumento.requestFocus();		
	}
}
