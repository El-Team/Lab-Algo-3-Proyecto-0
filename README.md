# Proyecto 0 Septiembre – Diciembre 2018: Carrera de bicicletas

*by Prof. Fernando Torre Mora*

## 1 Introducción

La compañía de juguetes Kabushiki-gaisha Ltd está desarrollando un nuevo sistema portátil de juegos electrónicos. Debido a la devaluación de Yen, han tenido que limitar la pantalla de este dispositivo a solo texto. Usted ha sido contratado para desarrollar uno de los juegos de lanzamiento de esta cónsola en la que simulará una carrera de bicicletas. El juego debe tener soporte para 1 y 2 jugadores.

## 2 Requerimientos del programa

- El programa debe recibir como parámetros de cónsola el número de contrincantes y la longitud de la pista.
- Al inicio, el programa debe solicitar al usuario qué vehículo desea utilizar. Debe estar disponible para su elección como mínimo una bicicleta, y una bicicleta tándem (para dos personas). Se muestra una representación de la pista que indique los cambios de pendiente y rugosidad en el terreno.
- El funcionamiento principal del programa consiste en presionar una tecla para pedalear, y Enter para avanzar una unidad de tiempo. 
- Si se presiona Enter sin presionar la tecla de pedalear, la bicicleta debe seguir por inercia, perdiendo progresivamente su cadencia y rapidez. 
- Debe haber una tecla diferente para frenar, y al menos una tecla para cambiar velocidades.
- Se debe indicar en cada unidad de tiempo la posición del jugador y los contrincantes en la pista, así como el estado de la bicicleta del jugador (velocidad, rapidez, cadencia).

- Pueden pasar varios instantes de tiempo antes de que el jugador avance al siguiente caracter en el indicador de posición (es decir, se admite que la posición no sea un valor entero).


### 2.1 Modo multiplayer

- Si el usuario selecciona una bicicleta tándem, debe ser posible para dos personas interactuar con el juego.
- La velocidad de la bicicleta se calcula a partir del promedio de los pedaleos de ambos jugadores. 
- El juego debe revisar en cada instante de tiempo la diferencia entre ambas cadencias y, si divergen en menos de 10% durante más de la mitad de los instantes de tiempo que dura el juego, felicitar a los jugadores por su
sincronización.


## 3 Estructuras de datos requerida

Debe diseñar una **clase bicicleta** capaz de almacenar:

-  La frecuencia de pedaleo o cadencia
-  La velocidad de traslación o rapidez
-  El engranaje de la caja de velocidades actual o la tasa de conversión entre cadencia y rapidez

More requirements:

- Cada uno de estos valores debe ser legible por una función de acceso (getter) y modificable por una función de modificación (setter).
- Además debe diseñar una bicicleta tándem capaz de distinguir entre el esfuerzo del primer ciclista y el esfuerzo del segundo ciclista.
- También debe diseñar la pista de carreras, la cual puede variar en pendiente (afecta la tasa de conversión entre cadencia y rapidez) y rugosidad (afecta la cadencia). 
- La pista de carreras se supone es lineal (sincurvas). Puede generarse automáticamente.
- Puede diseñar tantos otros vehículos como desee para competir en la carrera. 
- Los competidores deben mantener una cadencia constante (o si se elije permitir vehículos motorizados, las revoluciones por minuto deben suponerse constantes, pudiendo ser un número aleatorio fijado al inicio) y engranaje de la caja de velocidades constante. 
- **La rapidez debe verse afectada por las condiciones del terreno.**


## 4 Entrega

Debe entregar su código en un archivo comprimido (.zip, .tgz, etc.) libre de archivos intermedios o ejecutables. Deberá subirlo al Moodle de la materia en la sección marcada como “Proyecto 0” **hasta el viernes, 12 de octubre**. Sólo deberá efectuar una entrega por grupo.
