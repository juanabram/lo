package Parte3;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public void insertarinsumo(int segmento, Concepto nodo)
	{
	    switch (segmento)
	    {
	        case 1: // materiales
	            this.materiales.add(nodo);
	            break;
	        case 2: // manodeobra
	            this.manodeobra.add(nodo);
	            break;
	        case 3: // maquinariayequipo
	            this.maquinariayequipo.add(nodo);
	            break;
	        case 4: // servicios
	            this.servicios.add(nodo);
	            break;
	    }
	}

	public boolean existe(String codigo)
	{
	    boolean enc=false;
	    for(Concepto nodo: this.materiales)
	        if (nodo.esCodigo(codigo))
	            enc=true;
	    for(Concepto nodo: this.manodeobra)
	        if (nodo.esCodigo(codigo))
	            enc=true;
	    for(Concepto nodo: this.maquinariayequipo)
	        if (nodo.esCodigo(codigo))
	            enc=true;
	    for(Concepto nodo: this.servicios)
	        if (nodo.esCodigo(codigo))
	            enc=true;

	    return enc;
	}

	public Concepto BuscarConcepto( String codigo)
	{
	    Concepto enc=null;
	    for(Concepto nodo: this.materiales)
	        if (nodo.esCodigo(codigo))
	            enc=nodo;
	    for(Concepto nodo: this.manodeobra)
	        if (nodo.esCodigo(codigo))
	            enc=nodo;
	    for(Concepto nodo: this.maquinariayequipo)
	        if (nodo.esCodigo(codigo))
	            enc=nodo;
	    for(Concepto nodo: this.servicios)
	        if (nodo.esCodigo(codigo))
	            enc=nodo;

	    return enc;
	}

	public String MostrarCatalogo (int segmento)
	{
	    String cadena="      C A T A L O G O                       \n";
	    int index=0;
	    if (( segmento ==0 )||(segmento==1))
	    {
	        cadena=cadena+"              MATERIALES              \n";
	        for(Concepto nodo: this.materiales)
	        {
	            index=index+1;
	            cadena=cadena+index+" .- "+nodo.getAtributos()+"\n";
	        }
	    }
	    if (( segmento ==0 )||(segmento==2))
	    {
	        cadena=cadena+"              MANO DE OBRA              \n";
	        for(Concepto nodo: this.manodeobra)
	        {
	            index=index+1;
	            cadena=cadena+index+" .- "+nodo.getAtributos()+"\n";
	        }
	    }
	    if (( segmento ==0 )||(segmento==3))
	    {
	        cadena=cadena+"              MAQUINARIA Y EQUIPO              \n";
	        for(Concepto nodo: this.maquinariayequipo)
	        {
	            index=index+1;
	            cadena=cadena+index+" .- "+nodo.getAtributos()+"\n";
	        }
	    }
	    if (( segmento ==0 )||(segmento==4))
	    {
	        cadena=cadena+"              SERVICIOS              \n";
	        for(Concepto nodo: this.servicios)
	        {
	            index=index+1;
	            cadena=cadena+index+" .- "+nodo.getAtributos()+"\n";
	        }
	    }
	    cadena=cadena+"\n total de conceptos -->"+index+"\n";
	    return cadena;
	}

	public void RemoverConceptos(String codigo)
	{
	    int pos=-1;
	    int enc=-1;
	    Iterator<Concepto> listamateriales = this.materiales.iterator();
	    for(;listamateriales.hasNext();)
	        if(listamateriales.next().esCodigo(codigo))
	            listamateriales.remove();

	    pos=-1;
	    for(Concepto nodo: this.manodeobra)
	    {
	        pos++;
	        if(nodo.esCodigo(codigo))
	            enc=pos;
	    }
	    if(enc>-1)
	        this.manodeobra.remove(enc);

	    pos=-1;
	    for(Concepto nodo: this.maquinariayequipo)
	    {
	        pos++;
	        if(nodo.esCodigo(codigo))
	            enc=pos;
	    }
	    if(enc>-1)
	        this.maquinariayequipo.remove(enc);

	    pos=-1;
	    for(Concepto nodo: this.servicios)
	    {
	        pos++;
	        if(nodo.esCodigo(codigo))
	            enc=pos;
	    }
	    if(enc>-1)
	        this.servicios.remove(enc);
	}

	public boolean esvaciocatalogo()
	{
	    boolean es = false;
	    if ( this.manodeobra.size()<1)
	        if ( this.maquinariayequipo.size()<1)
	            if ( this.materiales.size()<1)
	                if ( this.servicios.size()<1)
	                    es = true;

	    return es;
	}


}

