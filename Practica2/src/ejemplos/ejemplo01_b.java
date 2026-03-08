package ejemplos;

import java.util.ArrayList;
public class ejemplo01_b {
    public static void main(String[] args)
    {
        ArrayList variable = new ArrayList();
        String v1;
        int v2;
        double v3;
        long v4 ;
        v1="hola";
        v2=3;
        v3=4.5;
        v4 = 12121;
        variable.add(v1);
        variable.add(v2);
        variable.add(v3);
        variable.add(0,v4); //inserta el dato al principio de la lista
        for (Object info : variable)
            System.out.println(info.getClass() + " " +info.toString());
    }
}
