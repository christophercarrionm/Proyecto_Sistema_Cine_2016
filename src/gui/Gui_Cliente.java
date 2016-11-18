package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import arreglos.Arreglo_Cliente;
import clases.Cliente;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JSpinField;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;



public class Gui_Cliente extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo;
	private JTable tblTable;

	private JLabel lblTitulo;
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblEstadoCivil;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApaterno;
	private JTextField txtAmaterno;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	
	private JComboBox comboBox;
	
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnRegresar;
	private JButton btnAceptar;
	private JButton btnConsultar;
	
	
	private int operacion;
	public final static int INGRESAR=0;
	public final static int CONSULTAR=1;
	public final static int MODIFICAR=2;
	public final static int ELIMINAR=3;

	DateFormat df = DateFormat.getDateInstance();
	
	public static void main(String[] args) {
		try {
			Gui_Cliente dialog = new Gui_Cliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Gui_Cliente() {
		setResizable(false);
		setTitle("Clientes");
		setModal(true);
		setBounds(100, 100, 787, 595);
		getContentPane().setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 353, 761, 173);
			getContentPane().add(scrollPane);
			{
				tblTable = new JTable();
				scrollPane.setViewportView(tblTable);
			}
		}
		{
			btnIngresar = new JButton("Ingresar");
			btnIngresar.setIcon(new ImageIcon(Gui_Cliente.class.getResource("/imagenes/agregar_2.png")));
			btnIngresar.setMargin(new Insets(0, 0, 0, 0));
			btnIngresar.addActionListener(this);
			btnIngresar.setBounds(641, 49, 130, 30);
			getContentPane().add(btnIngresar);
		}
		{
			btnConsultar = new JButton("Consultar");
			btnConsultar.addActionListener(this);
			btnConsultar.setBounds(641, 102, 130, 30);
			getContentPane().add(btnConsultar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(641, 152, 130, 30);
			getContentPane().add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(641, 197, 130, 30);
			getContentPane().add(btnEliminar);
		}
		{
			btnRegresar = new JButton("Regresar");
			btnRegresar.addActionListener(this);
			btnRegresar.setEnabled(false);
			btnRegresar.setBounds(10, 537, 89, 23);
			btnRegresar.setVisible(false);
			getContentPane().add(btnRegresar);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setEnabled(false);
			btnAceptar.setBounds(682, 537, 89, 23);
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
			lblTitulo.setBounds(0, 0, 784, 38);
			getContentPane().add(lblTitulo);
		}
		{
			lblCodigo = new JLabel("C\u00F3digo");
			lblCodigo.setBounds(10, 49, 116, 14);
			getContentPane().add(lblCodigo);
		}
		{
			lblNombres = new JLabel("Nombres");
			lblNombres.setBounds(10, 102, 116, 14);
			getContentPane().add(lblNombres);
		}
		{
			lblApellidoPaterno = new JLabel("Apellido Paterno");
			lblApellidoPaterno.setBounds(10, 127, 116, 14);
			getContentPane().add(lblApellidoPaterno);
		}
		{
			lblApellidoMaterno = new JLabel("Apellido Materno");
			lblApellidoMaterno.setBounds(10, 152, 116, 14);
			getContentPane().add(lblApellidoMaterno);
		}
		{
			lblEstadoCivil = new JLabel("Estado Civil");
			lblEstadoCivil.setBounds(10, 197, 116, 14);
			getContentPane().add(lblEstadoCivil);
		}
		{
			lblTelefono = new JLabel("Tel\u00E9fono");
			lblTelefono.setBounds(10, 222, 116, 14);
			getContentPane().add(lblTelefono);
		}
		{
			lblDocumento = new JLabel("Documento");
			lblDocumento.setBounds(10, 77, 116, 14);
			getContentPane().add(lblDocumento);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setBounds(10, 272, 116, 14);
			getContentPane().add(lblUsuario);
		}
		{
			lblContraseña = new JLabel("Contraseña");
			lblContraseña.setBounds(10, 303, 116, 14);
			getContentPane().add(lblContraseña);
		}
		{
			lblFecNacimiento = new JLabel("Fecha Nacimiento");
			lblFecNacimiento.setBounds(10, 176, 116, 14);
			getContentPane().add(lblFecNacimiento);
		}
		{
			lblFecAfiliacion = new JLabel("Fecha Afiliacion");
			lblFecAfiliacion.setBounds(10, 328, 116, 14);
			getContentPane().add(lblFecAfiliacion);
		}
		{
			lblDireccion = new JLabel("Direccion");
			lblDireccion.setBounds(10, 247, 116, 14);
			getContentPane().add(lblDireccion);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setBounds(129, 50, 150, 20);
			getContentPane().add(txtCodigo);
			txtCodigo.setEditable(false);
			txtCodigo.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(129, 98, 150, 20);
			getContentPane().add(txtNombre);
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
		}
		{
			txtApaterno = new JTextField();
			txtApaterno.setBounds(129, 122, 150, 20);
			getContentPane().add(txtApaterno);
			txtApaterno.setEditable(false);
			txtApaterno.setColumns(10);
		}
		{
			txtAmaterno = new JTextField();
			txtAmaterno.setBounds(129, 146, 150, 20);
			getContentPane().add(txtAmaterno);
			txtAmaterno.setEditable(false);
			txtAmaterno.setColumns(10);
		}
		{
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Soltero", "Casado", "Viudo", "Divorciado"}));
			comboBox.setToolTipText("");
			comboBox.setBounds(129, 194, 150, 20);
			comboBox.setEnabled(false);
			getContentPane().add(comboBox);
		}		
		{
			txtTelefono = new JTextField();
			txtTelefono.setBounds(129, 218, 150, 20);
			getContentPane().add(txtTelefono);
			txtTelefono.setEditable(false);
			txtTelefono.setColumns(10);
		}
		{
			txtDocumento = new JTextField();
			txtDocumento.setBounds(129, 74, 150, 20);
			getContentPane().add(txtDocumento);
			txtDocumento.setEditable(false);
			txtDocumento.setColumns(10);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setBounds(129, 266, 150, 20);
			getContentPane().add(txtUsuario);
			txtUsuario.setEditable(false);
			txtUsuario.setColumns(10);
		}
		{
			txtContraseña = new JPasswordField();
			txtContraseña.setBounds(129, 294, 150, 20);
			getContentPane().add(txtContraseña);
			txtContraseña.setEditable(false);
			txtContraseña.setColumns(10);
		}
		{
			jcFecNacimiento = new JDateChooser();
			//jcFecNacimiento.getCalendarButton().addActionListener(this);
			jcFecNacimiento.setBounds(129, 170, 150, 20);
			getContentPane().add(jcFecNacimiento);
		}
		{
			jcFecAfiliacion = new JDateChooser();
			jcFecAfiliacion.setBounds(129, 325, 150, 20);
			getContentPane().add(jcFecAfiliacion);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(129, 241, 389, 20);
			txtDireccion.setEditable(false);
			getContentPane().add(txtDireccion);
		}
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Documento");
		modelo.addColumn("Nombre");
		modelo.addColumn("A. Paterno");
		modelo.addColumn("A. Materno");
		modelo.addColumn("Fec. Nacimiento");
		modelo.addColumn("Est. Civil");
		modelo.addColumn("Telefono");
		modelo.addColumn("Dirección");
		modelo.addColumn("Fec. Afiliacion");
		modelo.addColumn("Usuario");
		modelo.addColumn("Contraseña");
		tblTable.setModel(modelo);	
		
		//visualizarEntradas(false);
		listar();
	}
	
	Arreglo_Cliente ac = new Arreglo_Cliente();
	
	private JDateChooser jcFecNacimiento;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblDocumento;
	private JTextField txtDocumento;
	private JLabel lblFecNacimiento;
	private JDateChooser jcFecAfiliacion;
	private JLabel lblFecAfiliacion;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == btnRegresar) {
			do_btnRegresar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			do_btnConsultar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			do_btnAceptar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(arg0);
		}
	}
	


	
	void ingresarEmpleado(){	
		int codigo = Codigo(),est_civl = Est_Civil();
		String nombres = Nombres(), a_paterno = A_Paterno(), a_materno = A_Materno(), usuario = Usuario(), contraseña = Contraseña(), documento = Documento(), fec_nacimiento = Fec_Nacimiento(), telefono = Telefono(), direccion = Direccion(), fec_afiliacion = Fec_Afiliacion();
		
		Cliente nuevo = new Cliente(codigo, est_civl, nombres, a_paterno, a_materno, direccion, fec_nacimiento, fec_afiliacion, telefono, documento, usuario, contraseña);

		if(nombres.length()>0){
				limpiar();
				txtCodigo.setText(""+ac.codCorrelativo());	
				txtNombre.requestFocus();
				ac.agregar(nuevo);
				mensaje("Se registro el empleado: " + Codigo());
		} else {
			mensaje("Favor de ingresar el Nombre correcto");
			txtNombre.setText("");
			txtNombre.requestFocus();
		}
		
		txtCodigo.setText(""+ac.codCorrelativo());	
		listar();
	}
	
	void limpiar(){
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApaterno.setText("");
		txtAmaterno.setText("");
		txtUsuario.setText("");
		txtContraseña.setText("");		
	}
	
	void consultarEmpleado(){
		try{	
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar Código a buscar"));
			Cliente x = ac.buscar(codigo);	
			if (x != null) {	
				visualizarEntradas(true);
				editarEntradas(false);		
				txtCodigo.setText(""+x.getCod_cliente());
				//.setText(""+x.getEstado_civil());
				txtNombre.setText(x.getNombres());
				txtApaterno.setText(x.getApe_paterno());
				txtAmaterno.setText(x.getApe_materno());
				txtDireccion.setText(x.getDireccion());
				//jcFecNacimiento.setText(x.getFec_nac());
				//jcFecAfiliacion.setText(x.getFec_afiliacion());
				txtTelefono.setText(x.getTelef());
				txtDocumento.setText(x.getDni());
				txtUsuario.setText(x.getLogin());
				txtContraseña.setText(x.getPassword());
				
			} else {
				visualizarEntradas(false);
				mensaje("El código no existe");
			}
		} catch (NumberFormatException  e) {
			visualizarEntradas(false);
			mensaje("Ingrese solo Números");
		}		
	}
	
	void modificarEmpleado(){

			int codigo = Codigo(),est_civl = Est_Civil();
			String nombres = Nombres(), a_paterno = A_Paterno(), a_materno = A_Materno(), usuario = Usuario(), contraseña = Contraseña(), 
						documento = Documento(), fec_nacimiento = Fec_Nacimiento(), telefono = Telefono(), direccion = Direccion(), fec_afiliacion = Fec_Afiliacion();
			Cliente x = ac.buscar(codigo);	
			if (x != null) {	
				visualizarEntradas(true);
				editarEntradas(true);
				x.setCod_cliente(codigo);
				x.setEstado_civil(est_civl);
				x.setApe_paterno(a_paterno);
				x.setApe_materno(a_materno);
				x.setDireccion(direccion);
				/*x.setFec_nac(fec_nacimiento);
				x.setFec_afiliacion(fec_afiliacion);*/
				x.setTelef(telefono);
				x.setDni(documento);
				x.setLogin(usuario);
				x.setPassword(contraseña);
				listar();
				visualizarEntradas(false);	
				btnAceptar.setVisible(false);
			}
	}
	void eliminarEmpleado(){
		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar Código a buscar"));
			Cliente x = ac.buscar(codigo);	
			if (x != null) {
				ac.eliminar(x);
				mensaje("Se elimino correctamente");
				listar();
			} else {
				mensaje("El código " + Codigo() + " no existe");
			}
		} catch (Exception e) {
			mensaje("Ingrese solo Números");
		}			
	}
	
	
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ac.tamaño(); i++) {
			Object[] fila = {
				ac.obtener(i).getCod_cliente(),
				ac.obtener(i).getDni(),
				ac.obtener(i).getNombres(),
				ac.obtener(i).getApe_paterno(), 
				ac.obtener(i).getApe_materno(),
				ac.obtener(i).getFec_nac(),
				ac.obtener(i).getEstado_civil(),
				ac.obtener(i).getTelef(),
				ac.obtener(i).getDireccion(),
				ac.obtener(i).getFec_afiliacion(),
				ac.obtener(i).getLogin(),
				ac.obtener(i).getPassword()
			};
			modelo.addRow(fila);
		}
	}	

	int Codigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	int T_Empleado() {
		return comboBox.getSelectedIndex();
	}	
	String Nombres() {
		return txtNombre.getText();
	}
	String A_Paterno() {
		return txtApaterno.getText();
	}
	String A_Materno() {
		return txtAmaterno.getText();
	}
	String Direccion() {
		return txtDireccion.getText();
	}	
	String Fec_Nacimiento() {
		int año = jcFecNacimiento.getCalendar().get(Calendar.YEAR);
		int mes = jcFecNacimiento.getCalendar().get(Calendar.MONTH)+1;
		int dia = jcFecNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
		String date = dia+"/"+mes+"/"+año;
		return date; 
	}
	String Fec_Afiliacion() {
		int año = jcFecNacimiento.getCalendar().get(Calendar.YEAR);
		int mes = jcFecNacimiento.getCalendar().get(Calendar.MONTH)+1;
		int dia = jcFecNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
		String date = dia+"/"+mes+"/"+año;
		return date; 
	}
	int Est_Civil() {
		return comboBox.getSelectedIndex();
	}	
	String Telefono() {
		return txtTelefono.getText();
	}	
	String Documento() {
		return txtDocumento.getText();
	}	
	String Usuario() {
		return txtUsuario.getText();
	}
	String Contraseña() {
		return txtContraseña.getText();
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void editarEntradas(boolean x){
		comboBox.setEnabled(x);;
		txtCodigo.setEditable(x);
		txtNombre.setEditable(x);
		txtApaterno.setEditable(x);
		txtAmaterno.setEditable(x);
		txtUsuario.setEditable(x);
		txtContraseña.setEditable(x);
		txtDireccion.setEditable(x);
		//jcFecNacimiento.setText(x.getFec_nac());
		//jcFecAfiliacion.setText(x.getFec_afiliacion());
		txtTelefono.setEditable(x);
		txtDocumento.setEditable(x);
	}
	void visualizarEntradas(boolean x){
		comboBox.setVisible(x);;
		txtCodigo.setVisible(x);
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
		btnIngresar.setVisible(x);
		btnConsultar.setVisible(x);
		btnModificar.setVisible(x);
		btnEliminar.setVisible(x);	
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
		visualizarEntradas(true);
		editarEntradas(false);
		habilitarBotones(true);
		lblTitulo.setText("Seleccione una Opción");			
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {
		operacion = INGRESAR;
		lblTitulo.setText("Ingresar Empleado");
		limpiar();
		visualizarEntradas(true);
		editarEntradas(true);
		habilitarBotones(false);
		txtCodigo.setEditable(false);
		txtCodigo.setText(""+ac.codCorrelativo());
		txtCodigo.requestFocus();
	}	
	protected void do_btnConsultar_actionPerformed(ActionEvent arg0) {
		operacion = CONSULTAR;
		lblTitulo.setText("Buscando Empleado");
		consultarEmpleado();	
	}
	protected void do_btnModificar_actionPerformed(ActionEvent arg0) {
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
}
