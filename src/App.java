import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner scc = new Scanner(System.in);
        CasaRural casas = new CasaRural();

        TablaDispersa tablas = new TablaDispersa();

        String id = casas.getCodigo();

        int opc = 0;

        do {
            System.out.println("1) Insertar una casa.\n");
            System.out.println("2) Eliminar una casa.\n");
            System.out.println("3) Mostrar una casa.\n");
            System.out.println("4) Salir.\n");

            opc = scc.nextInt();

            switch (opc) {
                case 1:
                    casas.asigna();
                    break;

                case 2:
                    tablas.eliminar(id);
                    break;
                case 3:
                    casas.muestraCodigo();
                    break;
                case 4:
                    System.out.println("Gracias por utilizar el programa!\n");
                    break;

                default:
                    break;
            }
        } while (opc != 4);
    }
}
