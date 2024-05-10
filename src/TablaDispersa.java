public class TablaDispersa {
    static final int TAMTABLA = 101;
    private int numElementos;
    private double factorCarga;
    private CasaRural[] tabla;

    public TablaDispersa() {
        tabla = new CasaRural[TAMTABLA];

        for (int j = 0; j < TAMTABLA; j++) {
            tabla[j] = null;
            numElementos = 0;
            factorCarga = 0.0;
        }
    }

    public int direccion(String clave) {
        int i = 0, p;
        long d;
        d = transformaCadena(clave);
        p = (int) (d % TAMTABLA);

        while ((tabla[p] != null) && !tabla[p].getCodigo().equals(clave)) {
            i++;
            p = p + i * i;
            p = p % TAMTABLA;
        }

        return p;
    }

    long transformaCadena(String c) {
        long d;

        d = 0;

        for (int j = 0; j < Math.min(10, c.length()); j++) {
            d = d * 27 + (int) c.charAt(j);
        }
        if (d < 0) {
            d = -d;
        }
        return d;
    }

    public void insertar(CasaRural r) {
        int posicion;
        posicion = direccion(r.getCodigo());
        tabla[posicion] = r;
        numElementos++;
        factorCarga = (double) (numElementos) / TAMTABLA;

        if (factorCarga > 0.5) {
            System.out.println("El factor de carga supera el 50%.\n" + "Aumente el tamaño de la tabla.\n");

        }
    }

    public CasaRural buscar(String clave) {
        CasaRural pr;
        int posicion;
        posicion = direccion(clave);
        pr = tabla[posicion];

        if (pr != null) {
            if (!pr.esAlta) {
                pr = null;
            }
        }
        return pr;
    }

    public void eliminar(String clave) {
        int posicion;
        posicion = direccion(clave);
        if (tabla[posicion].esAlta == true) {
            tabla[posicion].esAlta = false;
            System.out.println("La casa se dio de baja con exito!\n");
        } else {
            System.out.println("No se pudo dar de baja la casa.\n");
        }
    }
}
