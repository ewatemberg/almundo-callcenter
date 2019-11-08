# Almundo Call Center

## Consigna

Exite un call center donde hay 3 tipos de empleados: operador, supervisor y director. El proceso de la atención de una llamada telefónica en primera instancia debe ser atenida por un operador, si no hay ninguno libre debe ser atendida por un supervisor, y de no haber tampoco supervisores libres debe ser atendida por un director.

### Requerimientos

- Debe existir una clase Dispatcher encargada de manejar las llamadas, y debe contener el método dispatchCall para que las asigne a los empleados disponibles.
- El método dispatchCall puede invocarse por varios hilos al mismo tiempo.
- La clase Dispatcher debe tener la capacidad de poder procesar 10 llamadas al mismo tiempo (de modo concurrente).
- Cada llamada puede durar un tiempo aleatorio entre 5 y 10 segundos.
- Debe tener un test unitario donde lleguen 10 llamadas.

### Extras/Plus

- Dar alguna solución sobre qué pasa con una llamada cuando no hay ningún empleado libre.
- Dar alguna solución sobre qué pasa con una llamada cuando entran más de 10 llamadas concurrentes.
- Agregar los tests unitarios que se crean convenientes.
- Agregar documentación de código.

### Tener en cuenta

- El proyecto debe ser creado con Maven
- De ser necesario, anexar un documento con la explicación de cómo. por qué resolvió los puntos extras, o comentarlo en las clases donde se encuentran sus tests unitarios respectivos.

## Solución
Se implementó el uso de una [PriorityBlockingQueue](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/PriorityBlockingQueue.html) para manejar las prioridades de los empleados. Como dice la documentación de este tipo, se hizo uso de la implementación de la interfaz **Comparable** para crear un criterio de priorización de los empleados. Por esta razón cree un Enumerativo que permite inicializar con un valor numerico los tipos de empleados SUPERVISOR, DIRECTOR Y OPERADOR.
Para el manejo adecuado de concurrencia utilice un [ExecutorService](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html)

La llamada fue representada por una clase, que calculaba dinamicamente el tiempo entre los parametros esperficicados (5 a 10 seg).

#### Dispatcher
Esta clase posee un constructor que recibe el total de llamadas a procesar y la lista priorizada de empleados.
El método **dispatchCall** contiene en su interior la logica de seleccion de empleados en base a esta priorización. Si no encuentra ninguno disponible interrumpira el curso del thread (frena la ejecución si la lista está vacía).
El método **asignCall** es un Runneable, que atiende la llamada y una vez finalizada volverá a insertarlo en la PriorityBlockingQueue.

