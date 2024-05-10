public class Dispersion {

    int M = 1024;
    double R = 0.6180334;

    public double transformaClave(String clave) {
        double num = 0;
        for (int i = 0; i < Math.min(clave.length(), 10); i++) {
            num = num * 27 + (int) clave.charAt(i);
        }
        if (num < 0) {
            num = -num;
        }
        System.out.println("La clave pasada a numero entero es: " + num);
        return num;
    }

    public int dispersion(double x) {
        double t;

        int v;

        t = R * x - Math.floor(R * x);

        v = (int) (M * t);

        return v;
    }

    public int dispersion(double claveDescifrada, int M) {
        int hash = 0;
        double auxiliardecimal = 0;

        auxiliardecimal = claveDescifrada * R - Math.floor(R * claveDescifrada);

        hash = (int) (M * auxiliardecimal);

        System.out.println("La clave hasheada es: " + hash);
        return hash;
    }

}
