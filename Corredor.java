import java.util.Random;

public class Corredor extends Thread {
    private String nombre;
    private static final int TOTAL_CORREDORES = 6;
    private static String corredorQueCae;
    private static final Random random = new Random();

    public Corredor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            for (int km = 1; km <= 5; km++) {
                int descanso = random.nextInt(2000) + 100; // entre 100 y 2100 ms
                System.out.println(nombre + " corrió el km " + km + " y descansa " + descanso + "ms");
                Thread.sleep(descanso);

                // El corredor que se cae es elegido aleatoriamente una sola vez
                if (corredorQueCae == null) {
                    int corredorCaidaIndex = random.nextInt(TOTAL_CORREDORES) + 1;
                    corredorQueCae = "Corredor " + corredorCaidaIndex;
                }

                // Se cae si es el corredor seleccionado y el descanso es múltiplo de 3
                if (nombre.equals(corredorQueCae) && descanso % 3 == 0) {
                    throw new Exception(nombre + " se tropezó y debe detenerse.");
                }
            }
            System.out.println(nombre + " terminó la carrera.");
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Corredor[] corredores = new Corredor[TOTAL_CORREDORES];

        // Crear 6 corredores con nombres "Corredor 1" a "Corredor 6"
        for (int i = 0; i < TOTAL_CORREDORES; i++) {
            corredores[i] = new Corredor("Corredor " + (i + 1));
        }

        // Arrancar las carreras
        for (Corredor c : corredores) {
            c.start();
        }
    }
}


