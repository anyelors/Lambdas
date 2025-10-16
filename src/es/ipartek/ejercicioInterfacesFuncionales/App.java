package es.ipartek.ejercicioInterfacesFuncionales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {

    public static void main(String[] args) {

        Predicate<Producto> esPrecioMayor = p -> p.getPrecio() >= 6;

        Function<Producto, Producto> calcularDescuento = p -> {
            double descuento = ((p.getPrecio() * 5) / 100);
            return new Producto(p.getNombre(), (p.getPrecio() - descuento));
        };

        Consumer<Producto> mostrarProducto = producto -> {
            System.out.printf("Producto: %s - %.2f €\n", producto.getNombre(), producto.getPrecio());
        };

        List<Producto> productos = Arrays.asList(
                new Producto("Leche", 7.8),
                new Producto("Pan", 3.5),
                new Producto("Cafe", 2.5),
                new Producto("Zumo", 7.0),
                new Producto("Galleta", 6.5),
                new Producto("Bollo", 5.5)
        );

        for (Producto prodOrig : productos) {
            mostrarProducto.accept(prodOrig);
        }

        System.out.println();

        //Proceso de datos iperativo
        for (Producto prod : productos) {
            if (esPrecioMayor.test(prod)) {
                mostrarProducto.accept(calcularDescuento.apply(prod));
            }
        }

        System.out.println();

        productos.stream().filter(esPrecioMayor).map(calcularDescuento).forEach(mostrarProducto);
        productos.stream().filter(p -> p.getPrecio() >= 6)
                .map(p -> new Producto(p.getNombre(), (p.getPrecio() * 0.95)))
                .forEach( p -> System.out.printf("Producto: %s - %.2f €\n", p.getNombre(), p.getPrecio()));
    }
}
