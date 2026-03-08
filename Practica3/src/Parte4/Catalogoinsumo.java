package Parte4;

import java.util.ArrayList;

public class Catalogoinsumo {
	public ArrayList < Insumo > insumos ;
	
	public Catalogoinsumo() {
	    super();
	    this.insumos = new ArrayList<Insumo>();
	}
	
    public void insertarcatalogoinsumo ( Insumo aux ) {
    	boolean enc = true ;
    	for ( Insumo nodo : this.insumos ) {
    		if ( nodo.getCodigo().compareTo(aux.getCodigo()) == 0) {
    			enc = false ;
    		}
    	}
    	if ( enc ) {
    		this.insumos.add(aux);
    	}
    	
    }
    
    public void actualizarcatalogoinsumo ( Insumo aux ) {
    	for ( Insumo nodo : this.insumos ) {
    		if ( nodo.getCodigo().compareTo(aux.getCodigo()) == 0) {
    			nodo.setCosto(aux.getCosto()) ;
    		}
    	}
    }
    
    public String checarcostoinsumo ( String code ) {
    	for ( Insumo nodo : this.insumos ) {
    		if ( nodo.getCodigo().compareTo(code) == 0 ) {
    			return nodo.getCosto() ;
    		}
    	}
    	return null ;
    }
    
    
	public String ListatoCostos(Catalogo catalogo)
	{
	    Concepto nodo;
	    String salida="";
	    for(Insumo aux : this.insumos) {
	        if ( aux.getCosto()!=null) {
	            nodo=catalogo.BuscarConcepto(aux.getCodigo());
	            salida=salida+nodo.getCodigoInsumo()+"  "+aux.getCosto()+"\n";
	        }
	    }
	    return salida ;
	}

}
