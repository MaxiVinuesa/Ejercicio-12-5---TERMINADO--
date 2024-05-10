import java.util.Scanner;

public class App {

    static public void asigna(TablaDispersa tabla, Scanner input) {

        String id, direccion;
        double precioxdia, codigoDescifrado;
        int numHabitacion, control = 1, lugar = 0, n = 10, poblacion, indiceHash, bandera = 0;

        Scanner scc = new Scanner(System.in);

        for (int i = lugar; i < n; i++) {
            if (control == 1) {
                System.out.println("Usted va a ingresar al cliente N° " + (i + 1) + "\n");
                System.out.println("Ingrese el codigo.\n");
                id = scc.nextLine();

                System.out.println("Ingrese la direccion\n");
                direccion = scc.nextLine();

                System.out.println("Ingrese el numero de habitaciones\n");
                numHabitacion = scc.nextInt();

                System.out.println("Ingrese el precio por dia\n");
                precioxdia = scc.nextDouble();

                System.out.println("Ingrese la poblacion\n");
                poblacion = scc.nextInt();

                bandera = 1;

                Dispersion d = new Dispersion();
                codigoDescifrado = d.transformaClave(id);
                indiceHash = d.dispersion(codigoDescifrado);
                indiceHash = tabla.colisiones(id);
                bandera = 1;
                CasaRural instanciaCasa = new CasaRural(poblacion, direccion, numHabitacion, precioxdia, id, bandera,
                        lugar);
                tabla.insertar(instanciaCasa, indiceHash);

                lugar = lugar + 1;

                System.out.println("¿Usted quiere seguir cargando elementos?\n");
                System.out.println("1) Si.\n");
                System.out.println("2) No.\n");
                control = scc.nextInt();
                scc.nextLine();
            } else if (control == 2) {
                break;
            }
        }

    }

    public static void main(String[] args) throws Exception {

        Scanner scc = new Scanner(System.in);

        Pausa pausas = new Pausa();

        TablaDispersa tablas = new TablaDispersa();

        int opc = 0;

        do {
            System.out.println("1) Insertar una casa.\n");
            System.out.println("2) Eliminar una casa.\n");
            System.out.println("3) Mostrar una casa.\n");
            System.out.println("4) Salir.\n");

            opc = scc.nextInt();

            switch (opc) {
                case 1:
                    asigna(tablas, scc);
                    break;

                case 2:
                    System.out.println("Ingrese la id de la casa a eliminar.\n");
                    scc.nextLine();
                    String identificador = scc.nextLine();

                    tablas.eliminar(identificador);
                    break;
                case 3:
                    tablas.muestraCodigo();
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
