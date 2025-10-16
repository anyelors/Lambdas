package es.ipartek.aritmetica;

public class Calculadora {

    public static double computar( double a, double b, Aritmetica op ) {
        return op.operacion(a, b);
    }

}
