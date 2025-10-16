package es.ipartek;

import java.time.LocalDate;
import java.util.function.*;

public class AppEjemploFuncionales {


    public static double calcularIVA(double valor) {
        return valor * 0.16;
    }

    // Interfaz FUNCTION
    /*
    public interface Function<T, R> {
        R apply(T t);
     */
    public static Function<Double, Double> calcularIVAFuncional
            = valor -> valor * 0.16;

    public static double calcularIVA(double valor, double tasa) {
        return valor * (tasa / 100.0f);
    }

    // Interfaz BIFUNCTION
    /*
    public interface BiFunction<T, U, R> {
        R apply(T t, U u);
     */
    public static BiFunction<Double, Double, Double> calcularTasaIVAFuncional
            = (valor, tasa) -> valor * (tasa / 100.0f);


    // INTERFAZ PREDICATE
    /*
    public interface Predicate<T> {
        boolean test(T t);
     */
    public static boolean esMayorEdad(int edad) {
        return edad >= 18;
    }

    public static Predicate<Integer> esMayorEdadFuncional = edad -> edad >= 18;


    //INTERFAZ CONSUMIDOR
    /*
     public interface Consumer<T> {
        void accept(T t);
    */
    public static void mostrar(String nombre) {
        System.out.println(nombre.trim().toUpperCase());
    }

    public static Consumer<String> mostrarFuncional = valor -> {
        System.out.println(valor.trim().toUpperCase());
    };

    //INTERFAZ BiConsumer
     /*
     public interface BiConsumer<T, U> {
        void accept(T t, U u);
      */
    public static void mostrarNombreEdad(String nombre, int edad) {
        System.out.printf("%s tiene %d\n", nombre, edad);
    }

    public static BiConsumer<String, Integer> mostrarNombreEdadFuncional = (nombre, edad) -> {
        System.out.printf("%s tiene %d\n", nombre, edad);
    };

    //INTERFAZ SUMINISTRADOR
     /*
     public interface Supplier<T> {
        T get();
      */
    public static LocalDate obtenerFechaHoy() {
        return LocalDate.now();
    }

    //public static Supplier<LocalDate> obtenerFechaHoyFuncional = () -> LocalDate.now();
    public static Supplier<LocalDate> obtenerFechaHoyFuncional = LocalDate::now;

    //#############################################################################################
    public static void main(String[] args) {

        Double resultado = calcularIVA(100.0);
        System.out.println(resultado);
        resultado = calcularIVAFuncional.apply(100.0);
        System.out.println(resultado);

        System.out.println();

        resultado = calcularIVA(100.0, 16.0);
        System.out.println(resultado);
        resultado = calcularTasaIVAFuncional.apply(100.0, 16.0);
        System.out.println(resultado);

        System.out.println();

        int edad = 15;
        boolean esMayor = esMayorEdad(edad);
        System.out.println(esMayor);

        esMayor = esMayorEdadFuncional.test(edad);
        System.out.println(esMayor);

        System.out.println();

        String nombre = "Lupe";
        mostrar(nombre);
        mostrarFuncional.accept(nombre);

        System.out.println();

        mostrarNombreEdad(nombre, edad);
        mostrarNombreEdadFuncional.accept(nombre, edad);

        System.out.println();

        LocalDate fechaHoy = obtenerFechaHoy();
        System.out.println(fechaHoy);
        fechaHoy = obtenerFechaHoyFuncional.get();
        System.out.println(fechaHoy);

    }
}
