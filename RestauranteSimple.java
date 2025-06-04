

import java.util.Random;

class Pedido extends Thread {
    private String nombre;
    private int tiempoPreparacion;

    public Pedido(String nombre, int tiempoPreparacion) {
        this.nombre = nombre;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void cancelar() {
        interrupt(); // interrumpe el hilo
    }

    @Override
    public void run() {
        System.out.println("🧑‍🍳 Preparando: " + nombre);
        try {
            for (int i = 0; i < tiempoPreparacion; i++) {
                Thread.sleep(1000); // duerme 1 segundo
                System.out.println(nombre + " - paso " + (i + 1));
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
            }
            System.out.println("✅ Pedido listo: " + nombre);
        } catch (InterruptedException e) {
            System.out.println("❌ Pedido cancelado: " + nombre);
        }
    }
}

public class RestauranteSimple {
    public static void main(String[] args) throws InterruptedException {
        Pedido p1 = new Pedido("Pizza", 5);
        Pedido p2 = new Pedido("Hamburguesa", 4);
        Pedido p3 = new Pedido("Ensalada", 3);

        // Iniciar pedidos
        p1.start();
        p2.start();
        p3.start();

        // Esperar 2 segundos
        Thread.sleep(2000);

        // Cancelar uno aleatoriamente
        Pedido[] pedidos = { p1, p2, p3 };
        int aleatorio = new Random().nextInt(3);
        Pedido elegido = pedidos[aleatorio];
        System.out.println("\n⚠️ CANCELANDO: " + elegido.getNombre() + "\n");
        elegido.cancelar();

        // Esperar a que todos terminen
        p1.join();
        p2.join();
        p3.join();

        System.out.println("\n🏁 Todos los pedidos terminaron.");
    }
}
