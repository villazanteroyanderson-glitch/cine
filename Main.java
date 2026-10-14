
import java.util.Scanner;

public class Main {

    static Scanner roy = new Scanner(System.in);

    static boolean[] asientos = new boolean[10];
    static String[] productos = {"Pop Corn", "Gaseosa", "Hot Dog"};
    static double[] precios = {12.00, 8.00, 10.00};

    static int butacaComprada = -1;
    static double totalProductos = 0;
    static String detalleProductos = " ";

    public static void main(String[] args) {

        int opccion;

        do {
            System.out.println("---- BIENVENIDOS AL CINE PLANET JULIACA ----");
            System.out.println("1. Mostrar Asientos");
            System.out.println("2. Asientos Disponibles");
            System.out.println("3. Asientos Ocupados");
            System.out.println("4. Comprar una Butaca");
            System.out.println("5. Comprar Productos del Cine Planet");
            System.out.println("6. Mostrar Boleto");
            System.out.println("7. Salir");
            System.out.print("Escoge una opcion: ");
            opccion = roy.nextInt();

            switch (opccion) {

                case 1:
                    mostrarAsientos();
                    break;

                case 2:
                    mostrarDisponibles();
                    break;

                case 3:
                    mostrarOcupados();
                    break;

                case 4:
                    butaca();
                    break;

                case 5:
                    comprarProductos();
                    break;

                case 6:
                    mostrarBoleto();
                    break;

                case 7:
                    System.out.println("Gracias por visitar Cine Planet Juliaca.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opccion != 7);

        roy.close();
    }


    static void mostrarAsientos() {
        System.out.println("--- ASIENTOS DEL CINE ---");

        for (int i = 0; i < asientos.length; i++) {
            System.out.println("Asiento " + (i + 1) + ": "
                    + (asientos[i] ? "OCUPADO" : "DISPONIBLE"));
        }
    }

    static void mostrarDisponibles() {
        System.out.println("--- ASIENTOS DISPONIBLES ---");
        boolean hayDisponibles = false;

        for (int i = 0; i < asientos.length; i++) {
            if (!asientos[i]) {
                System.out.println("Asiento " + (i + 1));
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            System.out.println("No hay asientos disponibles.");
        }
    }

    static void mostrarOcupados() {
        System.out.println("--- ASIENTOS OCUPADOS ---");
        boolean hayOcupados = false;

        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i]) {
                System.out.println("Asiento " + (i + 1));
                hayOcupados = true;
            }
        }

        if (!hayOcupados) {
            System.out.println("Todavia no hay asientos ocupados.");
        }
    }

    static void butaca() {
        mostrarDisponibles();

        System.out.print("Ingrese el numero de asiento que desea comprar: ");
        int numero = roy.nextInt();

        if (numero < 1 || numero > asientos.length) {
            System.out.println("Numero de asiento no valido.");
        } else if (asientos[numero - 1]) {
            System.out.println("Este asiento ya esta ocupado.");
        } else {
            asientos[numero - 1] = true;
            butacaComprada = numero;

            System.out.println("Compra realizada correctamente.");
            System.out.println("Su asiento es el numero " + numero);
        }
    }


    static void comprarProductos() {
        int opcion;
        int cantidad;

        do {
            System.out.println("--- PRODUCTOS DEL CINE PLANET ---");
            for (int i = 0; i < productos.length; i++) {
                System.out.println((i + 1) + ". " + productos[i]
                        + " - S/ " + precios[i]);
            }
            System.out.println("4. Terminar compra");
            System.out.print("Seleccione un producto: ");
            opcion = roy.nextInt();

            if (opcion >= 1 && opcion <= 3) {
                System.out.print("Ingrese la cantidad: ");
                cantidad = roy.nextInt();

                if (cantidad > 0) {
                    double subtotal = precios[opcion - 1] * cantidad;
                    totalProductos += subtotal;

                    detalleProductos += productos[opcion - 1]
                            + " x " + cantidad
                            + " = S/ " + String.format("%.2f", subtotal)
                            + " ";

                    System.out.println("Subtotal: S/ "
                            + String.format("%.2f", subtotal));
                } else {
                    System.out.println("La cantidad debe ser mayor que cero.");
                }

            } else if (opcion != 4) {
                System.out.println("Opcion no valida.");
            }

        } while (opcion != 4);

        System.out.println("Total de productos: S/ "
                + String.format("%.2f", totalProductos));
    }


    static void mostrarBoleto() {
        System.out.println("========== BOLETO CINE PLANET ==========");

        if (butacaComprada == -1) {
            System.out.println("No ha comprado ninguna butaca.");
        } else {
            System.out.println("Cine: Cine Planet Juliaca");
            System.out.println("Butaca: " + butacaComprada);
            System.out.println("Estado: COMPRA REALIZADA");
        }

        System.out.println("--- PRODUCTOS COMPRADOS ---");

        if (detalleProductos.isEmpty()) {
            System.out.println("No compro productos.");
        } else {
            System.out.print(detalleProductos);
        }

        System.out.println("----------------------------------------");
        System.out.println("Total productos: S/ "
                + String.format("%.2f", totalProductos));
        System.out.println("========================================");
    }
}

