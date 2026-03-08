package ejemplos;

import java.util.ArrayList;
import java.util.Iterator;

public class ejemplo02_d {
    public static void main(String[] args) {
        ArrayList<String> lista= new ArrayList();
        lista.add("hola");
        lista.add("enero");
        lista.add("quesadilla");
        lista.add("Peter");

        Iterator<String> lista2 = lista.iterator();
        for(;lista2.hasNext();) 
            if (lista2.next().compareTo("Peter")==0)
                lista2.remove();

        lista.forEach((info) -> System.out.println(info));
    }
}
