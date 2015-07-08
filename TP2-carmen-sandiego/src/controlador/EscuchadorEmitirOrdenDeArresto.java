package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import modelo.ModeloJuego;

public class EscuchadorEmitirOrdenDeArresto implements ActionListener {

	private ModeloJuego modelo;
	private Controlador control;
	private JComboBox sexo;
	private JComboBox cabello;
	private JComboBox senia;
	private JComboBox vehiculo;
	private JComboBox hobbie;
	
	public EscuchadorEmitirOrdenDeArresto(ModeloJuego modelo,JComboBox sexo,JComboBox cabello, JComboBox senia, JComboBox vehiculo, JComboBox hobbie) {
		this.modelo=modelo;
		this.control=control;
		this.sexo=sexo;
		this.cabello=cabello;
		this.senia=senia;
		this.vehiculo=vehiculo;
		this.hobbie=hobbie;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
			String sexo=this.sexo.getSelectedItem().toString();
			String cabello=this.cabello.getSelectedItem().toString();
			String senia=this.senia.getSelectedItem().toString();
			String vehiculo=this.vehiculo.getSelectedItem().toString();
			String hobbie=this.hobbie.getSelectedItem().toString();
			
			this.modelo.emitirOrdenDeArresto(sexo, cabello, senia, vehiculo, hobbie);
			this.modelo.ActualizarObservadores();
	}
}
