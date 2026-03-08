package Parte4;

public class Concepto {
    private String codigo, insumo, descripcion, unidadmedida;

    public Concepto(String codigo, String insumo, String descripcion, String unidadmedida) {
        super();
        this.codigo = codigo;
        this.insumo = insumo;
        this.descripcion = descripcion;
        this.unidadmedida = unidadmedida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getInsumo() {
        return insumo;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }
    
    public String getAtributos()
    { String cadena ="";
        cadena=cadena+this.getCodigo()+" "+this.getInsumo();
        cadena=cadena+this.getDescripcion()+" "+this.getUnidadmedida();
    return cadena;
    }
    
    public String getCodigoInsumo()
    {
        String cadena ="";
        cadena=cadena+this.getCodigo()+" "+this.getInsumo();
        return cadena;
    }

    public boolean esCodigo(String codigo)
    {
      boolean es=false;
      if ( this.getCodigo().compareTo(codigo)==0)
        es=true;
      return es;
    }


}

