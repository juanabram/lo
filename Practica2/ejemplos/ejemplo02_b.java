package ejemplos;

import java.util.ArrayList;
public class ejemplo02_b {
    public static void main(String[] args)
    {
        ArrayList<String> variable = new ArrayList<String>();
        String v1,v2,v3,v4,v5;
        v1="ANTONIO GUZMAN IRIS LUCERO";
        v2="CANTO MARTINEZ BRYAN ROBERTO";
        v3="CASTILLO FLORES MELISSA";
        v4 = "CERVANTES DE LA ROSA ANGEL ALEJANDRO";
        variable.add(v1);
        variable.add(v2);
        variable.add(v3);
        variable.add(v4);
        mostrar(variable);
    }

    public static void mostrar(ArrayList arreglo)
    {
        for (Object info : arreglo)
            System.out.println(info.getClass()+" "+info.toString());
        System.out.println("\n se va eliminar el ultimo elemento");
        arreglo.remove(arreglo.size()-1); // elimina el ultimo elemento del arraylist
        for (Object info : arreglo)
            System.out.println(info.getClass()+" "+info.toString());
        System.out.println("\n se va Todos los elemento");
        arreglo.clear(); // Elimina todos los elementos del arraylist
        if (arreglo.isEmpty())
            System.out.println("el arreglo esta vacio");
    }
}
