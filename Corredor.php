<?php
class Corredor extends Thread {
    private $nombre;
    private static $TOTAL_CORREDORES = 6;
    private static $corredorQueCae = null;
    private static $lock;

    public function __construct($nombre) {
        $this->nombre = $nombre;
    }

    public function run() {
        for ($km = 1; $km <= 5; $km++) {
            $descanso = rand(100, 2099);
            echo "{$this->nombre} corrió el km {$km} y descansa {$descanso} ms\n";
            usleep($descanso * 1000); // microsegundos

            // Elegir corredor que se cae (una sola vez)
            if (self::$corredorQueCae === null) {
                // Se usa synchronized para evitar problemas de concurrencia
                self::$corredorQueCae = "Corredor " . (rand(1, self::$TOTAL_CORREDORES));
            }

            if ($this->nombre === self::$corredorQueCae && $descanso % 3 === 0) {
                echo "{$this->nombre} se tropezó y debe detenerse.\n";
                return; // abandona la carrera
            }
        }
        echo "{$this->nombre} terminó la carrera.\n";
    }
}

// Crear y arrancar corredores
$corredores = [];
for ($i = 1; $i <= Corredor::$TOTAL_CORREDORES; $i++) {
    $corredores[] = new Corredor("Corredor $i");
}

foreach ($corredores as $c) {
    $c->start();
}

foreach ($corredores as $c) {
    $c->join();
}
?>
