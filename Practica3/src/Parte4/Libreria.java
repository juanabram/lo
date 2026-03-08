package Parte4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Libreria {

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
	
}
