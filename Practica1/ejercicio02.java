package Practica1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio02 {

    static Catalogo catalogo;
    static int tam;

    public static String dialogo(String texto) throws IOException {
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(texto + " : ");
        return lectura.readLine();
    }

    public static String mostrarmenu(String[] opciones) {
        String cadena = "";
        for (String info : opciones)
            cadena += info + "\n";
        cadena += "Que opcion deseas";
        return cadena;
    }

    public static String desplegarMenu(String titulo, String[] menu) throws IOException {
        System.out.println("\n" + titulo);
        return dialogo(mostrarmenu(menu));
    }

    public static void CrearCatalogo() {

        catalogo = new Catalogo();

        catalogo.materiales = new Concepto[tam];
        catalogo.manodeobra = new Concepto[tam];
        catalogo.maquinariayequipo = new Concepto[tam];
        catalogo.servicios = new Concepto[tam];

        catalogo.posmateriales = -1;
        catalogo.posmanodeobra = -1;
        catalogo.posmaquinariayequipo = -1;
        catalogo.posservicios = -1;
    }

    public static void AltasConceptos() throws IOException {

        String codigo = dialogo("Introduce el codigo").trim();

        if (existe(codigo)) {
            System.out.println("El codigo ya existe.");
            return;
        }

        Concepto nuevo = new Concepto();

        nuevo.codigo = codigo;
        nuevo.insumo = dialogo("Introduce el nombre del insumo");
        nuevo.descripcion = dialogo("Introduce la descripcion");
        nuevo.unidadmedida = dialogo("Introduce la unidad de medida");

        int segmento = Integer.parseInt(dialogo(
                "1.Material\n2.Mano de Obra\n3.Maquinaria\n4.Servicios"));

        insertarinsumo(segmento, nuevo);
    }

    public static void insertarinsumo(int segmento, Concepto nodo) {

        switch (segmento) {

            case 1:
                if (catalogo.posmateriales < tam - 1) {
                    catalogo.materiales[++catalogo.posmateriales] = nodo;
                    System.out.println("Material agregado.");
                } else
                    System.out.println("No hay espacio en Materiales.");
                break;

            case 2:
                if (catalogo.posmanodeobra < tam - 1) {
                    catalogo.manodeobra[++catalogo.posmanodeobra] = nodo;
                    System.out.println("Mano de Obra agregada.");
                } else
                    System.out.println("No hay espacio en Mano de Obra.");
                break;

            case 3:
                if (catalogo.posmaquinariayequipo < tam - 1) {
                    catalogo.maquinariayequipo[++catalogo.posmaquinariayequipo] = nodo;
                    System.out.println("Maquinaria agregada.");
                } else
                    System.out.println("No hay espacio en Maquinaria.");
                break;

            case 4:
                if (catalogo.posservicios < tam - 1) {
                    catalogo.servicios[++catalogo.posservicios] = nodo;
                    System.out.println("Servicio agregado.");
                } else
                    System.out.println("No hay espacio en Servicios.");
                break;

            default:
                System.out.println("Segmento invalido.");
        }
    }

    public static boolean existe(String codigo) {

        return BuscarConcepto(codigo) != null;
    }

    public static Concepto BuscarConcepto(String codigo) {

        for (int i = 0; i <= catalogo.posmateriales; i++)
            if (catalogo.materiales[i] != null &&
                catalogo.materiales[i].codigo.equals(codigo))
                return catalogo.materiales[i];

        for (int i = 0; i <= catalogo.posmanodeobra; i++)
            if (catalogo.manodeobra[i] != null &&
                catalogo.manodeobra[i].codigo.equals(codigo))
                return catalogo.manodeobra[i];

        for (int i = 0; i <= catalogo.posmaquinariayequipo; i++)
            if (catalogo.maquinariayequipo[i] != null &&
                catalogo.maquinariayequipo[i].codigo.equals(codigo))
                return catalogo.maquinariayequipo[i];

        for (int i = 0; i <= catalogo.posservicios; i++)
            if (catalogo.servicios[i] != null &&
                catalogo.servicios[i].codigo.equals(codigo))
                return catalogo.servicios[i];

        return null;
    }

    public static void EliminarConcepto(String codigo) {

        for (int i = 0; i <= catalogo.posmateriales; i++)
            if (catalogo.materiales[i] != null &&
                catalogo.materiales[i].codigo.equals(codigo)) {
                RemoverConceptos(1, i);
                return;
            }

        for (int i = 0; i <= catalogo.posmanodeobra; i++)
            if (catalogo.manodeobra[i] != null &&
                catalogo.manodeobra[i].codigo.equals(codigo)) {
                RemoverConceptos(2, i);
                return;
            }

        for (int i = 0; i <= catalogo.posmaquinariayequipo; i++)
            if (catalogo.maquinariayequipo[i] != null &&
                catalogo.maquinariayequipo[i].codigo.equals(codigo)) {
                RemoverConceptos(3, i);
                return;
            }

        for (int i = 0; i <= catalogo.posservicios; i++)
            if (catalogo.servicios[i] != null &&
                catalogo.servicios[i].codigo.equals(codigo)) {
                RemoverConceptos(4, i);
                return;
            }
    }

    public static void RemoverConceptos(int segmento, int pos) {

        switch (segmento) {

            case 1:
                for (int i = pos; i < catalogo.posmateriales; i++)
                    catalogo.materiales[i] = catalogo.materiales[i + 1];
                catalogo.materiales[catalogo.posmateriales--] = null;
                break;

            case 2:
                for (int i = pos; i < catalogo.posmanodeobra; i++)
                    catalogo.manodeobra[i] = catalogo.manodeobra[i + 1];
                catalogo.manodeobra[catalogo.posmanodeobra--] = null;
                break;

            case 3:
                for (int i = pos; i < catalogo.posmaquinariayequipo; i++)
                    catalogo.maquinariayequipo[i] = catalogo.maquinariayequipo[i + 1];
                catalogo.maquinariayequipo[catalogo.posmaquinariayequipo--] = null;
                break;

            case 4:
                for (int i = pos; i < catalogo.posservicios; i++)
                    catalogo.servicios[i] = catalogo.servicios[i + 1];
                catalogo.servicios[catalogo.posservicios--] = null;
                break;
        }

        System.out.println("Concepto eliminado correctamente.");
    }

    public static void BajasConceptos() throws IOException {

        String codigo = dialogo("Introduce el codigo del Concepto").trim();

        if (existe(codigo)) {

            Concepto nodo = BuscarConcepto(codigo);

            String opcion = dialogo("Deseas eliminar a '" + nodo.insumo + "' [Y/N]")
                    .toUpperCase().trim();

            if (opcion.equals("Y"))
                EliminarConcepto(codigo);

        } else
            System.out.println("El codigo no existe.");
    }

    public static void ModificarConcepto() throws IOException {

        String codigo = dialogo("Introduce el codigo del Concepto").trim();

        if (existe(codigo)) {

            Concepto nodo = BuscarConcepto(codigo);

            System.out.println("Descripcion actual: " + nodo.descripcion);

            String opcion = dialogo("Deseas modificarla? [Y/N]")
                    .toUpperCase().trim();

            if (opcion.equals("Y")) {
                nodo.descripcion = dialogo("Nueva descripcion");
                System.out.println("Descripcion actualizada.");
            }

        } else
            System.out.println("El codigo no existe.");
    }

    public static void main(String[] args) throws IOException {

        tam = 100;
        CrearCatalogo();

        String opcion = "";
        String[] menu = {
                "1.-Altas",
                "2.-Bajas",
                "3.-Modificar",
                "6.-Salida"
        };

        do {

            opcion = desplegarMenu("SISTEMA DE CATALOGO", menu).trim();

            switch (opcion) {

                case "1":
                    AltasConceptos();
                    break;

                case "2":
                    BajasConceptos();
                    break;

                case "3":
                    ModificarConcepto();
                    break;

                case "6":
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        } while (!opcion.equals("6"));
    }
}