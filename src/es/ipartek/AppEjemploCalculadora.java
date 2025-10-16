package es.ipartek;

import es.ipartek.aritmetica.Calculadora;

public class AppEjemploCalculadora {

    public static void main(String[] args) {

        double resultado;
        /*
        resultado = Calculadora.computar(10.0, 20.0, new Aritmetica() {
            @Override
            public double operacion(double a, double b) {
                return a * b;
            }
        });
        */

        resultado = Calculadora.computar(10.0, 20.0, (a, b) -> ( a > b ) ? a : b );
        System.out.println(resultado);

    }

}
