public class Dispersion {
    static final int M = 1024;

    static final double R = 0.6180334;

    static long transformaClave(String clave) {
        long d;

        d = 0;

        for (int j = 0; j < Math.min(clave.length(), 10); j++) {
            d = d * 27 + (int) clave.charAt(j);
        }

        if (d < 0) {
            d = -d;
        }
        return d;
    }

    static int dispersion(long x) {
        double t;

        int v;

        t = R * x - Math.floor(R * x);

        v = (int) (M * t);

        return v;
    }

}
