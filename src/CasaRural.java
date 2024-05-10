import java.util.Scanner;

public class CasaRural {

    private int poblacion;
    private String direccion;
    public int numHabitacion;
    public double precioxdia;
    private String id;
    private int lugar = 0; // NOS GUARDA EL LUGAR DEL FOR PARA NO RENOMBRAR DATOS
    private int control = 0;
    public boolean esAlta;

    public CasaRural() {
        esAlta = true;
    }

    public void asigna() {

        Scanner scc = new Scanner(System.in);

        int n = 10;
        for (int i = this.lugar; i < n; i++) {
            if (this.control == 0) {
                System.out.println("Usted va a ingresar al cliente N° " + i + 1 + "\n");
                System.out.println("Ingrese el codigo.\n");
                this.id = scc.nextLine();
                scc.nextLine();

                System.out.println("Ingrese la direccion\n");
                this.direccion = scc.nextLine();
                scc.nextLine();

                System.out.println("Ingrese el numero de habitaciones\n");
                this.numHabitacion = scc.nextInt();
                scc.nextLine();

                System.out.println("Ingrese el precio por dia\n");
                this.precioxdia = scc.nextDouble();
                scc.nextLine();

                System.out.println("Ingrese la poblacion\n");
                this.poblacion = scc.nextInt();
                scc.nextLine();

                Dispersion d = new Dispersion();

                long codigoDescifrado = d.transformaClave(id);
                int indiceHash = d.dispersion(codigoDescifrado);

                this.lugar = this.lugar + 1;

                System.out.println("¿Usted quiere seguir cargando elementos?\n");
                System.out.println("0) Si.\n");
                System.out.println("1) No.\n");
                this.control = scc.nextInt();
            } else if (this.control == 1) {
                break;
            }
        }

    }

    public String getCodigo() {
        return this.id;
    }

    public void muestraCodigo() {
        System.out.println("CASA RURAL: " + this.id + ".\n");
        System.out.println("POBLACION: " + this.poblacion + ".\n");
        System.out.println("DIRECCION: " + this.direccion + ".\n");
        System.out.println("PRECIO POR DIA: " + this.precioxdia + ".\n");
    }

}
