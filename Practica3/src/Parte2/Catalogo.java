package Parte2;

import java.util.ArrayList;
public class Catalogo {
	public ArrayList<Concepto> materiales ;
	public ArrayList<Concepto> manodeobra ;
	public ArrayList<Concepto> maquinariayequipo ;
	public ArrayList<Concepto> servicios ;
	
	public Catalogo() {
	    super();
	    this.materiales = new ArrayList<Concepto>();
	    this.manodeobra = new ArrayList<Concepto>();
	    this.maquinariayequipo = new ArrayList<Concepto>();
	    this.servicios = new ArrayList<Concepto>();
	}

}

