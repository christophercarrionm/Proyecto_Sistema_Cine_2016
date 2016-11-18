package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.Arreglo_Butaca;
import arreglos.Arreglo_Sala;
import clases.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Gui_Butaca extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtcodigo;
	private JTextField txtnfila;
	private JTextField txtncolumna;
	private JTable table;
	private JTable tblTable;
	private DefaultTableModel modelo;
	private Arreglo_Butaca ab = new Arreglo_Butaca("Files/butaca.txt");
	private Arreglo_Sala as = new Arreglo_Sala("Files/sala.txt");
	private JComboBox cboSala;
	private JButton btnIngresar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JButton btnRegresar;
	private JButton btnAceptar;
	public final static int INGRESAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR = 3;
	private int operacion;
	private JComboBox cboEstado;
	private Operaciones op = new Operaciones();
	private JLabel lblTitulo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Gui_Butaca dialog = new Gui_Butaca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Gui_Butaca() {
		setTitle("Butaca");
		setModal(true);
		setBounds(100, 100, 589, 635);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(26, 92, 71, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblCodigoDeSala = new JLabel("Codigo de sala");
		lblCodigoDeSala.setBounds(26, 127, 84, 14);
		contentPanel.add(lblCodigoDeSala);
		
		JLabel lblNFila = new JLabel("N\u00B0 Fila");
		lblNFila.setBounds(26, 164, 46, 14);
		contentPanel.add(lblNFila);
		
		JLabel lblNColumna = new JLabel("N\u00B0 Columna");
		lblNColumna.setBounds(26, 202, 71, 14);
		contentPanel.add(lblNColumna);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(26, 244, 46, 14);
		contentPanel.add(lblEstado);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(142, 89, 86, 20);
		contentPanel.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnfila = new JTextField();
		txtnfila.setBounds(142, 161, 86, 20);
		contentPanel.add(txtnfila);
		txtnfila.setColumns(10);
		
		cboSala = new JComboBox();
		cboSala.setBounds(142, 124, 84, 17);
		contentPanel.add(cboSala);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Reservado", "Disponible"}));
		cboEstado.setEditable(true);
		cboEstado.setBounds(142, 241, 86, 20);
		contentPanel.add(cboEstado);
		
		
		txtncolumna = new JTextField();
		txtncolumna.setBounds(142, 199, 86, 20);
		contentPanel.add(txtncolumna);
		txtncolumna.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operacion = INGRESAR;
				lblTitulo.setText("Ingresar Butaca");
				limpiar();
				visualizarEntradas(true);
				editarEntradas(true);
				habilitarBotones(false);
				txtcodigo.setEditable(false);
				txtcodigo.setText("" + ab.codCorrelativo());
				txtcodigo.requestFocus();
				/*op.agregarSala(cboSala);*/
			}
		});
		btnIngresar.setBounds(456, 88, 89, 23);
		contentPanel.add(btnIngresar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacion = CONSULTAR;
				lblTitulo.setText("Buscando Butaca");
				consultarButaca();
			}
		});
		btnConsultar.setBounds(456, 137, 89, 23);
		contentPanel.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacion = MODIFICAR;
				lblTitulo.setText("Modificar Butaca");
				consultarButaca();
				editarEntradas(true);
				habilitarBotones(true);	
				txtcodigo.setEditable(false);
				txtnfila.requestFocus();
			}
		});
		btnModificar.setBounds(456, 193, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacion = ELIMINAR;
				lblTitulo.setText("Eliminar Butaca");
				eliminarButaca();
			}
		});
		btnEliminar.setBounds(456, 240, 89, 23);
		contentPanel.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 294, 553, 238);
		contentPanel.add(scrollPane);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcodigo.setText("");
				txtnfila.setText("");
				cboSala.setSelectedIndex(0);;
				txtcodigo.setEditable(false);
				visualizarEntradas(false);
				editarEntradas(false);
				habilitarBotones(true);
				lblTitulo.setText("Seleccione una Opción");	
			}
		});
		btnRegresar.setBounds(10, 562, 102, 23);
		contentPanel.add(btnRegresar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (operacion) {
				case INGRESAR:
					ingresarButaca();
					break;
				case CONSULTAR:
					consultarButaca();
					break;
				case MODIFICAR:
					modificarButaca();
					break;
				case ELIMINAR:
					eliminarButaca();
				}
			}
		});
		btnAceptar.setBounds(460, 562, 89, 23);
		contentPanel.add(btnAceptar);
		
		tblTable = new JTable();
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("CodigoSala");
		modelo.addColumn("N° Fila");
		modelo.addColumn("N° Columna");
		modelo.addColumn("Estado");
		tblTable.setModel(modelo);
		scrollPane.setViewportView(tblTable);
		
		lblTitulo = new JLabel("Seleccione una Opci\u00F3n");
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBackground(Color.DARK_GRAY);
		lblTitulo.setBounds(0, 0, 573, 25);
		contentPanel.add(lblTitulo);
		
		
		visualizarEntradas(false);
		listar();
	}
	
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ab.tamaño(); i++) {
			Object[] fila = {
				ab.obtener(i).getCodigo(),
				ab.obtener(i).getCodigo_sala(),
				ab.obtener(i).getNumero_fila(),
				ab.obtener(i).getNumero_columna(),
				ab.obtener(i).getEstado()
			};
			modelo.addRow(fila);
		}
	}
	void visualizarEntradas(boolean x) {
		cboSala.setVisible(x);
		;
		cboEstado.setVisible(x);
		txtnfila.setVisible(x);
		txtcodigo.setVisible(x);
		txtncolumna.setVisible(x);
	}
	void limpiar() {
		txtcodigo.setText("");
		txtnfila.setText("");
		txtncolumna.setText("");
		txtnfila.requestFocus();
	}
	void editarEntradas(boolean x) {
		cboSala.setEnabled(x);
		;
		txtcodigo.setEditable(x);
		txtnfila.setEditable(x);
		cboEstado.setEnabled(x);
		txtncolumna.setEditable(x);
		
	}
	void habilitarBotones(boolean x) {
		btnIngresar.setVisible(x);
		btnConsultar.setVisible(x);
		btnModificar.setVisible(x);
		btnEliminar.setVisible(x);
		if (operacion == INGRESAR) {
			btnRegresar.setEnabled(!x);
			btnRegresar.setVisible(!x);
			btnAceptar.setEnabled(!x);
			btnAceptar.setVisible(!x);
		}
		if (operacion == MODIFICAR) {
			btnAceptar.setEnabled(x);
			btnAceptar.setVisible(x);
		}
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	int Codigo(){
		return Integer.parseInt(txtcodigo.getText());
	}
	void eliminarButaca(){
		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar Código a buscar"));
			Butaca x = ab.buscar(codigo);	
			if (x != null) {
				ab.eliminar(x);
				ab.grabarButaca();
				mensaje("Se elimino correctamente");
				listar();
			} else {
				mensaje("El código " + Codigo() + " no existe");
			}
		} catch (Exception e) {
			mensaje("Ingrese solo Números");
		}			
	}
	int Codigo_sala(){
		return (int) cboSala.getSelectedItem();
	}
	int NFila(){
		return Integer.parseInt(txtnfila.getText());
	}
	int NColumna(){
		return Integer.parseInt(txtncolumna.getText());
	}
	int Estado(){
		return cboEstado.getSelectedIndex();
	}
	void modificarButaca(){
		
		int codigo = Codigo(),
			codigo_sala = Codigo_sala(),
			numero_fila = NFila(),
			numero_columna = NColumna(),
			estado = Estado();
		Butaca x = ab.buscar(codigo);	
		if (x != null) {	
			visualizarEntradas(true);
			editarEntradas(true);
			x.setCodigo(codigo);
			x.setCodigo_sala(codigo_sala);
			x.setNumero_fila(numero_fila);
			x.setNumero_columna(numero_columna);
			x.setEstado(estado);
			ab.grabarButaca();
			mensaje("Se modifico correctamente");
			listar();
			visualizarEntradas(false);	
			btnAceptar.setVisible(false);
		}
		
}
	void consultarButaca(){
		try{	
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar Código a buscar"));
			Butaca x = ab.buscar(codigo);	
			if (x != null) {	
				visualizarEntradas(true);
				editarEntradas(false);		
				txtcodigo.setText(""+x.getCodigo());
				cboSala.setSelectedItem(x.getCodigo_sala());
				txtnfila.setText(x.getNumero_fila()+"");
				txtncolumna.setText(x.getNumero_columna()+"");
				/*cboEstado.setSelectedItem(op.estado(x.getEstado()));*/				
			} else {
				visualizarEntradas(false);
				mensaje("El código no existe");
			}
		} catch (NumberFormatException  e) {
			visualizarEntradas(false);
			mensaje("Ingrese solo Números");
		}
	}
	void ingresarButaca() {
		int codigo,codigo_sala,numero_fila,numero_columna,estado;
		codigo = Integer.parseInt(txtcodigo.getText());
		codigo_sala = (int) cboSala.getSelectedItem();
		numero_fila = Integer.parseInt(txtnfila.getText());
		numero_columna = Integer.parseInt(txtncolumna.getText());
		estado = cboEstado.getSelectedIndex();
		Butaca nuevo = new Butaca(codigo, codigo_sala, numero_fila, numero_columna, estado);
		if (numero_fila > 0) {
			//limpiar();
			//txtCodigo.setText("" + ac.codCorrelativo());
			txtnfila.requestFocus();
			ab.agregar(nuevo);
			ab.grabarButaca();
			mensaje("Se registro el Butaca: " + txtcodigo.getText());
		} else {
			mensaje("Favor de ingresar el numero correcto");
			txtnfila.setText("");
			txtnfila.requestFocus();
		}
		txtcodigo.setText(""+ab.codCorrelativo());	
		listar();

	}
}
