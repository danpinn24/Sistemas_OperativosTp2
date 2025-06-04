# Sistemas_OperativosTp2
Trabajo Practico N2. Threads e interrupciones. 

 SISTEMAS OPERATIVOS 

 ###CONSIGNAS:

1. Desarrolle un código en el lenguaje de programación que desee (python, PHP,
C++, GO, etc.) donde se utilicen thread y se utilice alguna interrupción sobre
los threads utilizados.
2. Explique el funcionamiento del código desarrollado.
3. Agregale que en algún momento se produzca una excepción.
4. Analiza y evalúa la implementación del código realizado en el punto 1
implementado en otro lenguaje diferente.
5. Lo ves muy diferentes?. Cuál te resulto más fácil de entender?.
6. Los lenguajes que utilizaste implementan thread realmente?. Como lo hacen?.


Grupo: 
Nochetti, Ornella 
Olbeyra, Franco 
Valbuena, Agustina 
Pinna, Dana 

IDEA: Carrera en simultaneo con interrupcion. 

NOMBRE:Corredor.java

#El código es desarrollado utilizando el lenguaje de programación Java. Se crean 6 hilos(thread), cada uno representa a un corredor. Cada corredor corre 5 km y descansa un tiempo aleatorio entre 100 ms y 2099 ms entre cada km. Uno de los corredores (elegido aleatoriamente) puede tropezar y abandonar si su tiempo de descanso es múltiplo de 3( es la excepción).
Se crea una función main que contiene un arreglo de corredores. Luego, en un primer bucle for, se instancian los 6 corredores utilizando new Corredor, y se les asigna un nombre como "Corredor 1", "Corredor 2", etc., sumando 1 al índice para evitar que el nombre comience desde 0.
Después, en otro bucle for, se recorre el arreglo de corredores y se llama al método start() de cada uno, lo que inicia la ejecución de cada hilo de forma paralela.

#Se implementa el codigo utilizando el lenguaje de programación PHP. 

#El codigo implementado en Java nos resulto un poco más complejo de interpretar debido a que no estamos tan familiarizados. 

#Ambos lenguajes tanto Java como Php implementa hilos reales. 
En el caso de Java se usa el sistema nativo del sistema operativo para crear hilos (native threads). Se extender la clase Thread o implementar la interfaz Runnable.
En el caso de PHP se usan hilos reales con la extension pthreads. Esta extensión: Permite crear y ejecutar múltiples hilos que corren en paralelo real (como en Java). Cada hilo puede ejecutar código al mismo tiempo, dependiendo del procesador. Es ideal para tareas que requieren paralelismo real. Pthreads solo funciona en la versión CLI de PHP, no en servidores web normales.


///////////////////////////////////////////////


###RESTAURANTE SIMPLE: 

#Se desarrolla el programa utilizando el lenguaje de programacion Java.


#El programa crea tres pedidos: una pizza, una hamburguesa y una ensalada. Cada pedido se prepara en un hilo independiente, lo que significa que se cocinan en paralelo, no uno después del otro. Después de un rato, uno de los pedidos se cancela aleatoriamente y el resto continúa hasta terminar. Al final, el programa dice que todos los pedidos terminaron.

Clase RestauranteSimple

Es la clase principal donde está el programa que se ejecuta primero.

Dentro de esta clase se crea y controla la ejecución de los pedidos.

Crea tres objetos Pedido (Pizza, Hamburguesa, Ensalada) y los arranca para que se preparen en paralelo (cada uno en un hilo).

Luego, después de un tiempo, elige uno de esos pedidos al azar para cancelarlo.

Finalmente, espera que todos los pedidos terminen (sean cancelados o terminados) antes de cerrar el programa.

Clase Pedido

Representa un pedido de comida.

Esta clase hereda de Thread, por eso cada pedido puede ejecutarse en paralelo, como si fuera un cocinero trabajando solo.

Cada pedido tiene un nombre (por ejemplo, "Pizza") y un tiempo que indica cuánto tarda en prepararse.

En su método principal (run), simula la preparación con pausas de 1 segundo por cada paso, hasta completar el tiempo total.

Si se recibe una señal de interrupción (cuando se cancela el pedido), deja de preparar y muestra un mensaje de cancelación.



