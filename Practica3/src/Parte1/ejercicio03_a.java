package Parte1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ejercicio03_a {

    static Catalogo catalogo;
    static Catalogoinsumo catalogoinsumo;
    
    public static void insertarcatalogoinsumo ( Insumo aux ) {
    	boolean enc = true ;
    	for ( Insumo nodo : catalogoinsumo.insumos ) {
    		if ( nodo.codigo.compareTo(aux.codigo) == 0) {
    			enc = false ;
    		}
    	}
    	if ( enc ) {
    		catalogoinsumo.insumos.add(aux);
    	}
    	
    }
    
    public static void actualizarcatalogoinsumo ( Insumo aux ) {
    	for ( Insumo nodo : catalogoinsumo.insumos ) {
    		if ( nodo.codigo.compareTo(aux.codigo) == 0) {
    			nodo.costo = aux.costo ;
    		}
    	}
    }
    
    public static String checarcostoinsumo ( String code ) {
    	for ( Insumo nodo : catalogoinsumo.insumos ) {
    		if ( nodo.codigo.compareTo(code) == 0 ) {
    			return nodo.costo ;
    		}
    	}
    	return null ;
    }
    
    public static void SubMenuCostoInsumos() throws IOException
    {
        String opcion="";
        String[] datosmenu= {"1.-Alta Costo","2.-Modificacion Costo","3.-Listado ","6.-Salida"};
        do {
            opcion=Libreria.desplegarMenu("\n Menu de Listado de Costo de Insumos ",datosmenu).trim();
            switch (opcion)
            {
                case "1": AltaCosto () ;break;
                case "2": ModificarCosto ();break;
                case "3": System.out.println ( ListadoCosto () );break;
                case "6": System.out.println("Esta opcion no existe");break;
                default : System.out.println("Esta opcion no existe");break;
            }
        }
        while ((opcion.compareTo("6")!=0 )&&(!opcion.isEmpty()));
    }
    
    public static void cargarcatalogocosto()
    {
    	catalogoinsumo = new Catalogoinsumo () ;
        for(Concepto nodo : catalogo.materiales)
        {
            Insumo aux = new Insumo(nodo.codigo,null);
            aux.codigo= nodo.codigo;
            aux.costo= null;
            insertarcatalogoinsumo(aux);
        }

        for(Concepto nodo : catalogo.manodeobra)
        {
            Insumo aux = new Insumo(null,null);
            aux.codigo= nodo.codigo;
            aux.costo= null;
            insertarcatalogoinsumo(aux);
        }

        for(Concepto nodo : catalogo.maquinariayequipo)
        {
            Insumo aux = new Insumo(null,null);
            aux.codigo= nodo.codigo;
            aux.costo= null;
            insertarcatalogoinsumo(aux);
        }

        for(Concepto nodo : catalogo.servicios)
        {
            Insumo aux = new Insumo(null,null);
            aux.codigo= nodo.codigo;
            aux.costo= null;
            insertarcatalogoinsumo(aux);
        }
    }
    
	public static String ListatoCostos()
	{
	    Concepto nodo;
	    String salida="";
	    for(Insumo aux : catalogoinsumo.insumos)
	        if ( aux.costo!=null)
	        {
	            nodo=BuscarConcepto(aux.codigo);
	            salida=salida+nodo.insumo+"  "+aux.costo+"\n";
	        }
	    return salida ;
	}
    
    public static void AltaCosto() throws IOException
    {
        Concepto nodo;
        String codigo, costo;
        codigo = Libreria.dialogo("Introduce el codigo del Concepto a Asignar Precio ");
        if (existe(codigo))
        {
            nodo = BuscarConcepto(codigo);
            costo = Libreria.dialogo("Introduce el costo del Insumo " + nodo.insumo);
            Insumo auxnodo = new Insumo(nodo.codigo, costo);
            actualizarcatalogoinsumo(auxnodo);
        }
        else
            System.out.println("el codigo no existe no se puede eliminar");
    }
    
    public static void ModificarCosto() throws IOException
	{
	    Concepto nodo;
	    String codigo,costo;
	    codigo = Libreria.dialogo("Introduce el codigo del Concepto a Asignar Precio ");
	    if (existe(codigo))
	    {
	        costo = checarcostoinsumo(codigo);
	        nodo = BuscarConcepto(codigo);
	        String cadena="";
	        if (costo!=null)
	            cadena="El precio actual es "+costo+" Introduce el costo del Insumo "+nodo.insumo;
	        else
	            cadena=" Introduce el costo del Insumo "+nodo.insumo;
	        costo = Libreria.dialogo(cadena);
	        Insumo aux = new Insumo(codigo,costo);
	        actualizarcatalogoinsumo(aux);
	    }
	    else
	        System.out.println("el codigo no existe no se puede actualizar");
	}
    
    public static String ListadoCosto () throws IOException {
		int index = -1 ;
    	String cadena = "           COSTOS                 \n" ;
    	if ( catalogoinsumo.insumos.size() > 0 )
	    	for (Insumo nodo : catalogoinsumo.insumos ) {
	    		if ( nodo.codigo.compareTo("0") == 0 ) {
		    		index ++ ;
		    		cadena = cadena + index + nodo.codigo + "  " + nodo.costo ;
	    		}
	    	}
    	cadena=cadena+"\n total de insumos -->"+index+"\n";
    	return cadena;
    }
    
    public static void CrearCatalogo()
    {
        catalogo = new Catalogo();
        catalogo.manodeobra = new ArrayList();
        catalogo.maquinariayequipo = new ArrayList();
        catalogo.materiales = new ArrayList();
        catalogo.servicios = new ArrayList();

        catalogoinsumo = new Catalogoinsumo();
        catalogoinsumo.insumos = new ArrayList();
    }

	public static void main(String[] args) throws IOException
	{
	    String opcion="";
	    String membrete= "Sistema de Catalogo de Insumo";
	    String[] datosmenu= {"1.-Altas","2.-Bajas","3.-Listado de Catalogo ","4.-Costo de Insumos","6.-Salida"};
	
	    CrearCatalogo();
	    do {
	        opcion=Libreria.desplegarMenu(membrete+"\n Menu de punto de Venta",datosmenu).trim();
	        switch (opcion)
	        {
	            case "1" : Altas();break;
	            case "2" : System.out.println("Bajas de Conceptos del Catalogo\n\n"); BajasConceptos();break;
	            case "3" : Listado();break;
	            case "4" : SubMenuCostoInsumos();break;
	            case "6" : System.out.println("elegiste salida");break;
	            default : System.out.println("Esta opcion no existe");
	        }
	    } while ((opcion.compareTo("6")!=0) && (!opcion.isEmpty()));
	    System.out.println("Hasta Pronto");
	    System.exit(0);
	}
    
    public static void insertarinsumo( int segmento ,Concepto nodo)
    {    switch (segmento)
         {    case 1: // materiales
                   catalogo.materiales.add(nodo);
                   break;
              case 2: // manodeobra
                   catalogo.manodeobra.add(nodo);
                   break;
              case 3: // maquinariayequipo
                   catalogo.maquinariayequipo.add(nodo);
                   break;
              case 4: // servicios
                   catalogo.servicios.add(nodo);
                   break;
         }
    }
    
    public static boolean existe(String codigo)
    {
        boolean enc=false;

        for(Concepto nodo: catalogo.materiales)
            if (nodo.codigo.compareTo(codigo)==0)
                enc=true;
        for(Concepto nodo: catalogo.manodeobra)
            if (nodo.codigo.compareTo(codigo)==0)
                enc=true;
        for(Concepto nodo: catalogo.maquinariayequipo)
            if (nodo.codigo.compareTo(codigo)==0)
                enc=true;
        for(Concepto nodo: catalogo.servicios)
            if (nodo.codigo.compareTo(codigo)==0)
                enc=true;
                
        return enc;
    }
    
    public static int existecosto ( String codigo ) {
    	int enc = 0 ;
    	for ( Insumo nodo : catalogoinsumo.insumos ) {
    		if ( nodo.codigo.compareTo(codigo) == 0 ) {
    			if ( nodo.costo.compareTo("0") == 0 ) {
    				enc = 0 ;
    			}
    			else {
    				enc = 1 ;
    			}
    		}
    		else {
    			enc = 2 ;
    		}
    	}
    	return enc ;
    }
    
    public static Concepto BuscarConcepto( String codigo)
    {
         Concepto enc=null;
         for(Concepto nodo: catalogo.materiales)
              if (nodo.codigo.compareTo(codigo)==0)
                   enc=nodo;
         for(Concepto nodo: catalogo.manodeobra)
              if (nodo.codigo.compareTo(codigo)==0)
                   enc=nodo;
         for(Concepto nodo: catalogo.maquinariayequipo)
              if (nodo.codigo.compareTo(codigo)==0)
                   enc=nodo;
         for(Concepto nodo: catalogo.servicios)
              if (nodo.codigo.compareTo(codigo)==0)
                   enc=nodo;

    return enc;
    }
    
    public static String MostrarCatalogo(int segmento)
    {    String cadena="          C A T A L O G O          \n";
         int index=0;
         if (( segmento ==0 )||(segmento==1))
         {    cadena=cadena+"               MATERIALES          \n";
              for(Concepto nodo: catalogo.materiales)
              {    index=index+1;
                   cadena=cadena+index+" .- "+nodo.codigo+"  "+nodo.insumo;
                   cadena=cadena+nodo.descripcion+"  "+nodo.unidadmedida+"\n";
              }
         }
         if (( segmento ==0 )||(segmento==2))
         {    cadena=cadena+"               MANO DE OBRA        \n";
              for(Concepto nodo: catalogo.manodeobra)
              {    index=index+1;
                   cadena=cadena+index+" .- "+nodo.codigo+"  "+nodo.insumo;
                   cadena=cadena+nodo.descripcion+"  "+nodo.unidadmedida+"\n";
              }
         }
         if (( segmento ==0 )||(segmento==3))
         {    cadena=cadena+"               MAQUINARIA Y EQUIPO \n";
              for(Concepto nodo: catalogo.maquinariayequipo)
              {    index=index+1;
                   cadena=cadena+index+" .- "+nodo.codigo+"  "+nodo.insumo;
                   cadena=cadena+nodo.descripcion+"  "+nodo.unidadmedida+"\n";
              }
         }
         if (( segmento ==0 )||(segmento==4))
         {    cadena=cadena+"               SERVICIOS           \n";
              for(Concepto nodo: catalogo.servicios)
              {    index=index+1;
                   cadena=cadena+index+" .- "+nodo.codigo+"  "+nodo.insumo;
                   cadena=cadena+nodo.descripcion+"  "+nodo.unidadmedida+"\n";
              }
         }
         cadena=cadena+"\n total de conceptos -->"+index+"\n";
    return cadena;
    }
    
    public static void RemoverConceptos(String codigo)
    {
        int pos=1;
        int enc=-1;
        Iterator<Concepto> listamateriales = catalogo.materiales.iterator();
        for(;listamateriales.hasNext();)
            if(listamateriales.next().codigo.compareTo(codigo)==0)
                listamateriales.remove();

        pos=1;
        for(Concepto nodo: catalogo.manodeobra)
        {
            pos++;
            if (nodo.codigo.compareTo(codigo)==0)
                enc=pos;
        }
        if(enc>-1)
            catalogo.manodeobra.remove(enc);

        pos=1;
        for(Concepto nodo: catalogo.maquinariayequipo)
        {
            pos++;
            if(nodo.codigo.compareTo(codigo)==0)
                enc=pos;
        }
        if(enc>-1)
            catalogo.maquinariayequipo.remove(enc);

        pos=1;
        for(Concepto nodo: catalogo.servicios)
        {
            pos++;
            if(nodo.codigo.compareTo(codigo)==0)
                enc=pos;
        }
        if(enc>-1)
            catalogo.servicios.remove(enc);
    }

    
    public static void AltasConceptos(int segmento,String ssegmento) throws IOException
    {
        Concepto nodo= new Concepto();
        Insumo nodo1 = new Insumo () ;
        System.out.println(" Segmento "+ssegmento);
        nodo.codigo=      Libreria.dialogo("Introduce el codigo del Concepto        ");
        if ( !existe(nodo.codigo.trim()) )
        {
        	nodo1.codigo = nodo.codigo ;
        	nodo1.costo = "0" ;
            nodo.insumo=      Libreria.dialogo("Introduce el nombre del Concepto        ");
            nodo.descripcion=Libreria.dialogo("Introduce  la descripcion del Concepto    ");
            nodo.unidadmedida=Libreria.dialogo("Introduce  la unidad del Concepto        ");
            insertarinsumo( segmento ,nodo);
        }
        else
            System.out.println("el codigo ya existe no se puede agregar");
    }
    
    public static void Altas() throws IOException
    {
        String opcion = "";
        String[] datosmenu = {"1.-Materiales ", "2.-Mano de Obra ", "3.-Maquinaria y Equipo ", "4.-Servicios ", "6.-Salida"};
        do {
            opcion = Libreria.desplegarMenu("\n Menu de Altas de Insumos ", datosmenu).trim();
            switch (opcion)
            {
                case "1" : AltasConceptos(1, " Materiales"); break;
                case "2" : AltasConceptos(2, " Mano de Obra"); break;
                case "3" : AltasConceptos(3, " Maquinaria y Equipo"); break;
                case "4" : AltasConceptos(4, " Servicios"); break;
                case "6" : System.out.println("elegiste salida"); break;
                default : System.out.println("Esta opcion no existe"); break;
            }
        }
        while ((opcion.compareTo("6") != 0) && (!opcion.isEmpty()));
    }
    
    public static void Listado() throws IOException
    {
    String opcion="";
    String[] datosmenu= {"1.-Materiales","2.-Mano de Obra","3.-Maquinaria y Equipo","4.-Servicios","5.-Todos","6.-Salida"};
    do {
    opcion=Libreria.desplegarMenu("\n Menu de Listado de Insumos ",datosmenu).trim();
    switch (opcion)
    {
    case "1" : System.out.println(MostrarCatalogo(1));break;
    case "2" : System.out.println(MostrarCatalogo(2));break;
    case "3" : System.out.println(MostrarCatalogo(3));break;
    case "4" : System.out.println(MostrarCatalogo(4));break;
    case "5" : System.out.println(MostrarCatalogo(0));break;
    case "6" : System.out.println("elegiste salida");break;
    default : System.out.println("Esta opcion no existe");break;
    }
    }
    while ((opcion.compareTo("6")!=0 )&&(!opcion.isEmpty()));
    }
    
    public static void BajasConceptos() throws IOException
    {
        Concepto nodo;
        String codigo,opcion;
        codigo =Libreria.dialogo("Introduce el codigo del Concepto        ");

        if ( existe(codigo) )
        {   nodo=BuscarConcepto(codigo);
            opcion=Libreria.dialogo("Deseas elimina a "+nodo.insumo+"    [Y/N]").toUpperCase().trim();
            if (opcion.compareTo("Y")==0)
            {
                RemoverConceptos(codigo);
            }
        }
        else
            System.out.println("el codigo no existe no se puede eliminar");
    }

}