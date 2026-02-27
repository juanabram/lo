package Practica1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio01 {
	static Catalogo catalogo;
    static int tam;
    
    public static String mostrarmenu(String[] opciones) { 
        String cadena ="";
        for (String info:opciones)
            cadena = cadena + info + "\n";
        cadena = cadena + "Que opcion deseas";
        return cadena;
    }

    public static String dialogo(String texto) throws IOException {
        String cadena;
        System.out.println(texto + " : ");
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        cadena = lectura.readLine();
        return cadena;
    }

    public static String desplegarMenu(String Titulo1, String[] menu) throws IOException
    {
        String cadena;
        System.out.println(Titulo1 + "\n" + "\n");
        cadena = dialogo(mostrarmenu(menu));
        return cadena;
    }

    public static void main(String[] args) throws IOException
    {
    	CrearCatalogo () ;
    	String opcion = "" ;
        String membrete="Sistema de Catalogo de Insumo";
        String[] datosmenu={"1.-Altas","2.-Bajas","3.-Listado de Catalogo ","6.-Salida"};
        do {
            opcion=desplegarMenu(membrete+"\n Menu de punto de Venta",datosmenu).trim();
            switch (opcion)
            {
                case "1": Altas(); break;
                case "2": Bajas(); break;
                case "3": Listado(); break;
                case "6": System.out.println("elegiste salida"); break;
                default : System.out.println("Esta opcion no existe"); break;
            }
        }
        while ((opcion.compareTo("6")!=0)&&(!opcion.isEmpty()));
        System.out.println("Hasta Pronto");
        System.exit(0);
    }
    
    public static void Altas() throws IOException
    {
        String opcion="";
        String[] datosmenu={"1.-Materiales ","2.-Mano de Obra ","3.-Maquinaria y Equipo ","4.-Servicios ","6.-Salida"};
        do {
            opcion=desplegarMenu("\n Menu de Altas de Insumos ",datosmenu).trim();
            switch (opcion)
            {
                case "1" : AltasConceptos(1," Materiales");break;
                case "2" : AltasConceptos(2," Mano de Obra");break;
                case "3" : AltasConceptos(3," Maquinaria y Equipo");break;
                case "4" : AltasConceptos(4," Servicios");break;
                case "6" : System.out.println("Elegiste salida");break;
                default : System.out.println("Esta opcion no existe");break;
            }
        }
        while ((opcion.compareTo("6")!=0)&&(!opcion.isEmpty()));
    }

	public static void Bajas() throws IOException
	{
	    String opcion="";
	    String[] datosmenu= {"1.-Materiales ","2.-Mano de Obra ","3.-Maquinaria y Equipo ","4.-Servicios ","6.-Salida"};
	    do {
	        opcion=desplegarMenu("\n Menu de Bajas de Insumos",datosmenu).trim();
	        switch (opcion)
	        {
	            case "1" : BajasConceptos(1);break;
	            case "2" : BajasConceptos(2);break;
	            case "3" : BajasConceptos(3);break;
	            case "4" : BajasConceptos(4);break;
	            case "6" : System.out.println("elegiste salida");break;
	            default : System.out.println("Esta opcion no existe");break;
	        }
	    }
	    while ((opcion.compareTo("6")!=0 )&&(!opcion.isEmpty()));
	}

    public static void Listado() throws IOException
    {
        String opcion="";
        String[] datosmenu= {"1.-Materiales ","2.-Mano de Obra ","3.-Maquinaria y Equipo ","4.-Servicios ","5.-Todos","6.-Salida"};
        do {
            opcion=desplegarMenu("\n Menu de Listado de Insumos ",datosmenu).trim();
            switch (opcion)
            {
                case "1": System.out.println(MostrarCatalogo(1));break;
                case "2": System.out.println(MostrarCatalogo(2));break;
                case "3": System.out.println(MostrarCatalogo(3));break;
                case "4": System.out.println(MostrarCatalogo(4));break;
                case "5": System.out.println(MostrarCatalogo(0));break;
                case "6": System.out.println("elegiste salida");break;
                default: System.out.println("Esta opcion no existe");break;
            }
        }
        while ((opcion.compareTo("6")!=0) &&(!opcion.isEmpty()));
    }

    public static void CrearCatalogo()
    {
        tam = 5;
        catalogo = new Catalogo();
        catalogo.manodeobra = new Concepto[tam];
        catalogo.maquinariayequipo = new Concepto[tam];
        catalogo.materiales = new Concepto[tam];
        catalogo.servicios = new Concepto[tam];
        catalogo.posmanodeobra=-1;
        catalogo.posmaquinariayequipo=-1;
        catalogo.posmateriales=-1;
        catalogo.posservicios=-1;
    }

    public static void insertarinsumo( int segmento ,Concepto nodo)
    {
        switch (segmento)
        {
            case 1: // materiales
                if (catalogo.posmateriales<tam)
                {
                    catalogo.posmateriales++;
                    catalogo.materiales[catalogo.posmateriales]=nodo;
                }
                else
                    System.out.println("Catalogo de materiales esta lleno");
                break;
            case 2: // manodeobra
                if (catalogo.posmanodeobra<tam)
                {
                    catalogo.posmanodeobra++;
                    catalogo.manodeobra[catalogo.posmanodeobra]=nodo;
                }
                else
                    System.out.println("Catalogo de Mano de Obra esta lleno");
                break;
            case 3: // maquinariayequipo
                if (catalogo.posmaquinariayequipo<tam)
                {
                    catalogo.posmaquinariayequipo++;
                    catalogo.maquinariayequipo[catalogo.posmaquinariayequipo]=nodo;
                }
                else
                    System.out.println("Catalogo de Maquinaria y Equipo esta lleno");
                break;
            case 4: // servicios
                if (catalogo.posservicios<tam)
                {
                    catalogo.posservicios++;
                    catalogo.servicios[catalogo.posservicios]=nodo;
                }
                else
                    System.out.println("Catalogo de Servicios esta lleno");
                break;
        }
    }

    public static int[] existe(String codigo)
    {
        int[] enc= new int[]{-1,-1};

        for(int pos=0;pos <=catalogo.posmateriales;pos++)
            if (catalogo.materiales[pos].codigo.compareTo(codigo)==0)
            { enc[0]=1;enc[1]=pos;}

        for(int pos=0;pos <=catalogo.posmanodeobra;pos++)
            if (catalogo.manodeobra[pos].codigo.compareTo(codigo)==0)
            { enc[0]=2;enc[1]=pos;}

        for(int pos=0;pos <=catalogo.posmaquinariayequipo;pos++)
            if (catalogo.maquinariayequipo[pos].codigo.compareTo(codigo)==0)
            { enc[0]=3;enc[1]=pos;}

        for(int pos=0;pos <=catalogo.posservicios;pos++)
            if (catalogo.servicios[pos].codigo.compareTo(codigo)==0)
            { enc[0]=4;enc[1]=pos;}

        return enc;
    }
    
    public static Concepto BuscarConcepto( int segmento ,String codigo)
    {
        Concepto nodo=null;
        switch (segmento)
        {
            case 1: // materiales
            for(int pos=0;pos <=catalogo.posmateriales;pos++)
                if (catalogo.materiales[pos].codigo.compareTo(codigo)==0)
                    nodo=catalogo.materiales[pos];
            break;
            case 2: // manodeobra
            for(int pos=0;pos <=catalogo.posmanodeobra;pos++)
                if (catalogo.manodeobra[pos].codigo.compareTo(codigo)==0)
                    nodo=catalogo.manodeobra[pos];
            break;
            case 3: // maquinariayequipo
            for(int pos=0;pos <=catalogo.posmaquinariayequipo;pos++)
                if (catalogo.maquinariayequipo[pos].codigo.compareTo(codigo)==0)
                    nodo=catalogo.maquinariayequipo[pos];
            break;
            case 4: // servicios
            for(int pos=0;pos <=catalogo.posservicios;pos++)
                if (catalogo.servicios[pos].codigo.compareTo(codigo)==0)
                    nodo=catalogo.servicios[pos];
            break;
        }
        return nodo;
    }

    public static String MostrarCatalogo (int segmento)
    {
        String cadena="";
        int index=0;
        cadena=cadena+"                C A T A L O G O                \n";
        if (( segmento ==0 )||(segmento==1))
        {
            cadena=cadena+"                MATERIALES                \n";
            for(int pos=0;pos <catalogo.posmateriales+1;pos++)
            {
                index=index+1;
                cadena=cadena+index+" - "+catalogo.materiales[pos].codigo+"  "+catalogo.materiales[pos].insumo;
                cadena=cadena+catalogo.materiales[pos].descripcion+"  "+catalogo.materiales[pos].unidadmedida+"\n";
            }
        }
        if (( segmento ==0 )||(segmento==2))
        {
            cadena=cadena+"                MANO DE OBRA                \n";
            for(int pos=0;pos <catalogo.posmanodeobra+1;pos++)
            {
                index=index+1;
                cadena=cadena+index+" - "+catalogo.manodeobra[pos].codigo+"  "+catalogo.manodeobra[pos].insumo;
                cadena=cadena+catalogo.manodeobra[pos].descripcion+"  "+catalogo.manodeobra[pos].unidadmedida+"\n";
            }
        }
        if (( segmento ==0 )||(segmento==3))
        {
            cadena=cadena+"                MAQUINARIA Y EQUIPO                \n";
            for(int pos=0;pos <catalogo.posmaquinariayequipo+1;pos++)
            {
                index=index+1;
                cadena=cadena+index+" - "+catalogo.maquinariayequipo[pos].codigo+"  "+catalogo.maquinariayequipo[pos].insumo;
                cadena=cadena+catalogo.maquinariayequipo[pos].descripcion+"  "+catalogo.maquinariayequipo[pos].unidadmedida+"\n";
            }
        }
        if (( segmento ==0 )||(segmento==4))
        {
            cadena=cadena+"                SERVICIOS                \n";
            for(int pos=0;pos <catalogo.posservicios+1;pos++)
            {
                index=index+1;
                cadena=cadena+index+" - "+catalogo.servicios[pos].codigo+"  "+catalogo.servicios[pos].insumo;
                cadena=cadena+catalogo.servicios[pos].descripcion+"  "+catalogo.servicios[pos].unidadmedida+"\n";
            }
        }
        cadena=cadena+"\n total de conceptos -->"+index+"\n";
        return cadena;
    }
    
    public static void RemoverConceptos(int segmento, int pos)
    {
        switch (segmento)
        {
            case 1: if (pos==catalogo.posmateriales)
                        catalogo.posmateriales--;
                    else
                    {for(int ciclo=pos;ciclo <catalogo.posmateriales;ciclo++)
                        catalogo.materiales[ciclo]=catalogo.materiales[ciclo+1];
                        catalogo.posmateriales--;
                    }
                    break;
            case 2: if (pos==catalogo.posmanodeobra)
                        catalogo.posmanodeobra--;
                    else
                    {for(int ciclo=pos;ciclo <catalogo.posmanodeobra;ciclo++)
                        catalogo.manodeobra[ciclo]=catalogo.manodeobra[ciclo+1];
                        catalogo.posmanodeobra--;
                    }
                    break;
            case 3: if (pos==catalogo.posmaquinariayequipo)
                        catalogo.posmaquinariayequipo--;
                    else
                    {for(int ciclo=pos;ciclo <catalogo.posmaquinariayequipo;ciclo++)
                        catalogo.maquinariayequipo[ciclo]=catalogo.maquinariayequipo[ciclo+1];
                        catalogo.posmaquinariayequipo--;
                    }
                    break;
            case 4: if (pos==catalogo.posservicios)
                        catalogo.posservicios--;
                    else
                    {for(int ciclo=pos;ciclo <catalogo.posservicios;ciclo++)
                        catalogo.servicios[ciclo]=catalogo.servicios[ciclo+1];
                        catalogo.posservicios--;
                    }
                    break;
        }
    }

    public static void AltasConceptos(int segmento, String ssegmento) throws IOException
    {
        Concepto nodo = new Concepto();
        int[] encontrado;
        System.out.println(" Segmento " + ssegmento);
        nodo.codigo = dialogo("Introduce el codigo del Concepto ");
        encontrado = existe(nodo.codigo.trim());
        if (encontrado[0] == -1)
        {
            nodo.insumo = dialogo("Introduce el nombre del Concepto ");
            nodo.descripcion = dialogo("Introduce la descripcion del Concepto ");
            nodo.unidadmedida = dialogo("Introduce la unidad del Concepto ");
            insertarinsumo(segmento, nodo);
        }
        else
            System.out.println("el codigo ya existe no se puede agregar");
    }

    public static void BajasConceptos(int segmento) throws IOException
    {
        Concepto nodo;
        String codigo, opcion;
        int[] encontrado;

        codigo = dialogo("Introduce el codigo del Concepto ");
        encontrado = existe(codigo);

        if ( encontrado[0] > -1 )
        {
            nodo = BuscarConcepto( encontrado[0], codigo);
            opcion = dialogo("Deseas elimina a "+nodo.insumo+" [Y/N]").toUpperCase().trim();
            if (opcion.compareTo("Y")==0)
            {
                RemoverConceptos(encontrado[0],encontrado[1]);
            }
        }
        else
            System.out.println("el codigo no existe no se puede eliminar");
    }



}
