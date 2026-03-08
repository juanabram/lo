package Parte4;

public class Insumo {
	private String codigo ;
	private String costo ;

	public Insumo(String codigo, String costo) {
	    super();
	    this.codigo = codigo;
	    this.costo = costo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

}
