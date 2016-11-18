package gui;

import arreglos.Arreglo_Cine;
import clases.Cine;
import clases.Cliente;
import clases.Operaciones;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class Gui_Cine extends JFrame {
	private static final long serialVersionUID = 1L;
	Operaciones op = new Operaciones();
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private int operacion;
	private JComboBox cboProvincia;
	private JComboBox cboDepartamento;
	private JComboBox cboDistrito;
	private JDateChooser jcFechaOperaciones;
	private JComboBox cboTipoCine;
	private JLabel lblTitulo;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblDepartamento;
	private JButton btnIngresar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	public final static int INGRESAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR = 3;
	private JButton btnRegresar;
	private JButton btnAceptar;
	Arreglo_Cine ac = new Arreglo_Cine();
	private JScrollPane scrollPane;
	private JTable tblTable;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Cine frame = new Gui_Cine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui_Cine() {
		setTitle("Cine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblTitulo = new JLabel("Seleccione una Opci\u00F3n");
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBackground(Color.DARK_GRAY);

		lblCodigo = new JLabel("Codigo");

		lblNombre = new JLabel("Nombre");

		lblDepartamento = new JLabel("Departamento");

		JLabel lblProvincia = new JLabel("Provincia");

		JLabel lblDistrito = new JLabel("Distrito");

		JLabel lblFechaDeOperaciones = new JLabel("Fecha de Operaciones");

		JLabel lblTipoDeCine = new JLabel("Tipo de cine");

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);

		cboProvincia = new JComboBox();
		cboProvincia.setEnabled(false);
		cboProvincia.setModel(new DefaultComboBoxModel(new String[] { "Lima", "Arequipa", "Loreto" }));

		cboDepartamento = new JComboBox();
		cboDepartamento.setEnabled(false);
		cboDepartamento.setModel(new DefaultComboBoxModel(new String[] { "Lima", "Piura", "Arequipa", "Loreto" }));

		cboDistrito = new JComboBox();
		cboDistrito.setEnabled(false);
		cboDistrito
				.setModel(new DefaultComboBoxModel(new String[] { "Callao", "San Borja", "San Juan de Lurigancho" }));

		jcFechaOperaciones = new JDateChooser();

		cboTipoCine = new JComboBox();
		cboTipoCine.setEnabled(false);
		cboTipoCine.setModel(new DefaultComboBoxModel(new String[] { "Estandar", "Prime" }));

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operacion = INGRESAR;
				lblTitulo.setText("Ingresar Cine");
				limpiar();
				visualizarEntradas(true);
				editarEntradas(true);
				habilitarBotones(false);
				txtCodigo.setEditable(false);
				txtCodigo.setText("" + ac.codCorrelativo());
				txtCodigo.requestFocus();
			}
		});
		btnIngresar.setMargin(new Insets(0, 0, 0, 0));

		btnConsultar = new JButton("Consultar");

		btnModificar = new JButton("Modificar");

		btnEliminar = new JButton("Eliminar");

		scrollPane = new JScrollPane();

		btnRegresar = new JButton("Regresar");
		btnRegresar.setEnabled(false);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (operacion) {
				case INGRESAR:
					ingresarCine();
					break;
				case CONSULTAR:
					consultarCine();
					break;
				case MODIFICAR:
					modificarCine();
					break;
				case ELIMINAR:
					eliminarCine();
				}
			}

			private void eliminarCine() {
				// TODO Auto-generated method stub

			}

			private void modificarCine() {
				// TODO Auto-generated method stub

			}

			private void consultarCine() {
				// TODO Auto-generated method stub

			}

			private void ingresarCine() {
				String nombre,departamento,provincia,distrito,fec_afi;
				int codigo,tipo_cine;
				codigo = Integer.parseInt(txtCodigo.getText());
				nombre = txtNombre.getText().toUpperCase();
				departamento = String.valueOf(cboDepartamento.getSelectedItem());
				provincia = String.valueOf(cboProvincia.getSelectedItem());
				distrito = String.valueOf(cboDistrito.getSelectedItem());
				fec_afi= op.obtenerFecha(jcFechaOperaciones);
				tipo_cine = cboTipoCine.getSelectedIndex();
				Cine nuevo = new Cine(codigo, nombre, departamento, provincia, distrito, fec_afi, tipo_cine);
				if (nombre.length() > 0) {
					limpiar();
					txtCodigo.setText("" + ac.codCorrelativo());
					txtNombre.requestFocus();
					//ac.agregar(nuevo);
					
					mensaje("Se registro el Cine: " + txtCodigo.getText());
				} else {
					mensaje("Favor de ingresar el Nombre correcto");
					txtNombre.setText("");
					txtNombre.requestFocus();
				}

				txtCodigo.setText("" + ac.codCorrelativo());
				//listar();

			}
		});
		btnAceptar.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(28)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblCodigo)
						.addComponent(lblDepartamento).addComponent(lblProvincia).addComponent(lblDistrito)
						.addComponent(lblFechaDeOperaciones).addComponent(lblTipoDeCine)
						.addComponent(lblNombre))
				.addGap(39)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cboTipoCine, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cboDistrito, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cboProvincia, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(cboDepartamento, GroupLayout.PREFERRED_SIZE, 95,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(jcFechaOperaciones, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnIngresar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addContainerGap())
				.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnRegresar).addGap(351)
						.addComponent(btnAceptar).addGap(19)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false).addGroup(gl_contentPane
						.createSequentialGroup().addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCodigo)
								.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNombre).addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnIngresar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblDepartamento)
								.addComponent(cboDepartamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblProvincia)
								.addComponent(cboProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblDistrito)
								.addComponent(cboDistrito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(13)
								.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblFechaDeOperaciones).addGap(18)
								.addComponent(lblTipoDeCine))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(jcFechaOperaciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(21).addComponent(cboTipoCine, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE).addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(btnRegresar).addComponent(btnAceptar))));
		
		tblTable = new JTable();
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Departamento");
		modelo.addColumn("Provincia");
		modelo.addColumn("Distrito");
		modelo.addColumn("Fecha de Operaciones");
		modelo.addColumn("Tipo de cine");
		tblTable.setModel(modelo);
		scrollPane.setViewportView(tblTable);
		contentPane.setLayout(gl_contentPane);
	}
	

	void limpiar() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtNombre.requestFocus();
	}

	void visualizarEntradas(boolean x) {
		cboDepartamento.setVisible(x);
		;
		txtCodigo.setVisible(x);
		txtNombre.setVisible(x);
		cboProvincia.setVisible(x);
		cboDistrito.setVisible(x);
		cboTipoCine.setVisible(x);
	}

	void editarEntradas(boolean x) {
		cboDepartamento.setEnabled(x);
		;
		txtCodigo.setEditable(x);
		txtNombre.setEditable(x);
		cboDistrito.setEnabled(x);
		cboProvincia.setEnabled(x);
		cboTipoCine.setEnabled(x);
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
	/*void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ac.tamaño(); i++) {
			Object[] fila = {
				ac.obtener(i).getCodigo(),
				ac.obtener(i).getNombre(),
				ac.obtener(i).getDepartamento(),
				ac.obtener(i).getProvincia(),
				ac.obtener(i).getDistrito(), 
				ac.obtener(i).getFec_afi(),
				ac.obtener(i).getTipo_cine()
			};
			modelo.addRow(fila);
		}
	}*/
}
