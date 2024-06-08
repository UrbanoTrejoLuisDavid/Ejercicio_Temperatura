package com.tesji.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tesji.modelo.TemperaturaModelo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmVista extends JFrame {

	private JPanel contentPane;
	private JTextField txtGrado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVista frame = new FrmVista();
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
	public FrmVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONVERTIDOR DE TEMPERATURA");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNewLabel.setBounds(135, 40, 363, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese los grados");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_1.setBounds(120, 105, 126, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione tipo de grado");
		lblNewLabel_2.setBackground(new Color(0, 0, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_2.setBounds(120, 152, 176, 17);
		contentPane.add(lblNewLabel_2);
		
		txtGrado = new JTextField();
		txtGrado.setBounds(325, 107, 113, 20);
		contentPane.add(txtGrado);
		txtGrado.setColumns(10);
		
		JComboBox cmbTipoGrado = new JComboBox();
		cmbTipoGrado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cmbTipoGrado.setModel(new DefaultComboBoxModel(new String[] {".::Seleccione::.", "Celsius", "Fahrenheit", "Kelvin"}));
		cmbTipoGrado.setBounds(325, 151, 113, 22);
		contentPane.add(cmbTipoGrado);
		
		JTextArea txtResultado = new JTextArea();
		txtResultado.setFont(new Font("Candara", Font.PLAIN, 13));
		txtResultado.setBounds(135, 202, 306, 79);
		contentPane.add(txtResultado);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				       if(cmbTipoGrado.getSelectedIndex()==0){
				           JOptionPane.showMessageDialog(rootPane,"Ingrese el tipo de grado");   
				        }
				        TemperaturaModelo obj = new  TemperaturaModelo();
				        obj.grados = Integer.parseInt(txtGrado.getText());
				        obj.tipoGrado= cmbTipoGrado.getSelectedIndex();
				        txtResultado.setText(obj.tipoGrados());
				   }catch(NumberFormatException ex){
				       JOptionPane.showMessageDialog(rootPane,"Error, la cantidad debe ser numerica");
				   }
			}
		});
		btnCalcular.setBounds(63, 305, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResultado.setText(null);
				cmbTipoGrado.setSelectedIndex(0);
				txtGrado.setText(null);
			}
		});
		btnNuevo.setBounds(233, 305, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(391, 305, 89, 23);
		contentPane.add(btnSalir);
	}
}
