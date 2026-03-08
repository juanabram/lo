package Practica2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ejercicio01 {

    static Catalogo catalogo;

    public static void main(String[] args) throws IOException
   {   String opcion="";
    String membrete=" Sistema de Catalogo de Insumo";
    String[] datosmenu= {"1.-Altas","2.-Bajas","3.-Listado de Catalogo ","6.-Salida"};

    CrearCatalogo();
    do {
    opcion=desplegarMenu(membrete+"\n Menu de punto de Venta",datosmenu).trim();
    switch (opcion)
    {
    case "1" : Altas();break;
    case "2" : System.out.println("Bajas de Conceptos del Catalogo\n\n"); BajasConceptos();break;
    case "3" : Listado();break;
    case "6" : System.out.println("elegiste salida");break;
    default : System.out.println("Esta opcion no existe");break;

    }
    }
    while ((opcion.compareTo("6")!=0 )&&(!opcion.isEmpty()));
    System.out.println("Hasta Pronto");
    System.exit(0);
    }
    
    public static String mostrarmenu(String[] opciones)
    { String cadena ="";
      for (String info:opciones)
        cadena=cadena+info+"\n";
      cadena=cadena+"Que opcion deseas";
      return cadena;
    }

    public static String dialogo(String texto) throws IOException
    {String cadena;
    System.out.println(texto+" : ");
    BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
    cadena = lectura.readLine();
    return cadena;
    }

    public static String desplegarMenu(String Titulo1,String[] menu) throws IOException
    { String cadena;
    System.out.println(Titulo1+"\n"+"\n");
    cadena=dialogo(mostrarmenu(menu));
    return cadena;
    }

    public static void CrearCatalogo()
    {
        catalogo = new Catalogo();
        catalogo.manodeobra = new ArrayList();
        catalogo.maquinariayequipo = new ArrayList();
        catalogo.materiales = new ArrayList();
        catalogo.servicios = new ArrayList();
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
    {   int pos=-1;
        int enc=-1;
        for(Concepto nodo: catalogo.materiales)
            {   pos++;
                if (nodo.codigo.compareTo(codigo)==0)
                    enc=pos;
            }
        if(enc>-1)
            catalogo.materiales.remove(enc);
        pos=-1;
        for(Concepto nodo: catalogo.manodeobra)
            {   pos++;
                if (nodo.codigo.compareTo(codigo)==0)
                    enc=pos;
            }
        if(enc>-1)
            catalogo.manodeobra.remove(enc);
        pos=-1;
        for(Concepto nodo: catalogo.maquinariayequipo)
            {   pos++;
                if (nodo.codigo.compareTo(codigo)==0)
                    enc=pos;
            }
        if(enc>-1)
            catalogo.maquinariayequipo.remove(enc);
        pos=-1;
        for(Concepto nodo: catalogo.servicios)
            {   pos++;
                if (nodo.codigo.compareTo(codigo)==0)
                    enc=pos;
            }
        if(enc>-1)
            catalogo.servicios.remove(enc);
    }
    
    public static void AltasConceptos(int segmento,String ssegmento) throws IOException
    {
        Concepto nodo= new Concepto();
        int[] encontrado;
        System.out.println(" Segmento "+ssegmento);
        nodo.codigo=      dialogo("Introduce el codigo del Concepto        ");
        if ( !existe(nodo.codigo.trim()) )
        {
            nodo.insumo=      dialogo("Introduce el nombre del Concepto        ");
            nodo.descripcion=dialogo("Introduce  la descripcion del Concepto    ");
            nodo.unidadmedida=dialogo("Introduce  la unidad del Concepto        ");
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
            opcion = desplegarMenu("\n Menu de Altas de Insumos ", datosmenu).trim();
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
    opcion=desplegarMenu("\n Menu de Listado de Insumos ",datosmenu).trim();
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
        int[] encontrado;
        codigo =dialogo("Introduce el codigo del Concepto        ");

        if ( existe(codigo) )
        {   nodo=BuscarConcepto(codigo);
            opcion=dialogo("Deseas elimina a "+nodo.insumo+"    [Y/N]").toUpperCase().trim();
            if (opcion.compareTo("Y")==0)
            {
                RemoverConceptos(codigo);
            }
        }
        else
            System.out.println("el codigo no existe no se puede eliminar");
    }

}