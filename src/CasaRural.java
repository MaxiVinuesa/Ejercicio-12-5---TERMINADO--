public class CasaRural {

    public int poblacion;
    public String direccion;
    public int numHabitacion;
    public double precioxdia;
    public String id;
    public int lugar; // NOS GUARDA EL LUGAR DEL FOR PARA NO RENOMBRAR DATOS
    public int control;
    public boolean esAlta;
    public int bandera;

    TablaDispersa tablas = new TablaDispersa();

    public CasaRural(int poblacion, String direccion, int numHabitacion, double precioxdia, String id, int bandera,
            int lugar) {
        this.poblacion = poblacion;
        this.direccion = direccion;
        this.numHabitacion = numHabitacion;
        this.precioxdia = precioxdia;
        this.id = id;
        this.esAlta = true;
        this.bandera = bandera;
        this.lugar = lugar;
    }

    public String getCodigo() {
        return this.id;
    }

}
