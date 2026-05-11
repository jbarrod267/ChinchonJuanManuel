# Chinchón en Java

## Descripción
Este proyecto implementa el juego de cartas Chinchón en Java, permitiendo jugar partidas completas con jugadores humanos y máquinas (IA).

El objetivo del juego es ser el jugador con menos puntos al final de la partida, formando combinaciones de cartas o consiguiendo un chinchón.

---

## Objetivo del juego
- Obtener la menor cantidad de puntos posible.
- Formar combinaciones válidas.
- Ganar automáticamente si se consigue un chinchón.

---

## Elementos del juego
- Baraja española de 40 cartas:
  - Palos: OROS, COPAS, ESPADAS, BASTOS
  - Valores: 1–7, 10, 11, 12
- Se puede jugar con:
  - 1 baraja
  - 2 barajas

---

## Jugadores
- De 2 a 5 jugadores
- Tipos:
  - Humanos
  - Máquina (IA)

---

## Desarrollo de la partida

### 1. Reparto
- Cada jugador recibe 7 cartas
- Se coloca:
  - Un mazo boca abajo
  - Una carta boca arriba (descarte)

### 2. Turno de un jugador
En cada turno:

1. Roba una carta:
   - Del mazo
   - O del montón de descarte

2. Descarta una carta  
Siempre debe terminar con 7 cartas

---

## Combinaciones válidas

### Iguales
- Mínimo 3 cartas del mismo número  
Ejemplo: 3 - 3 - 3

### Escalera
- Mínimo 3 cartas consecutivas del mismo palo  
Ejemplo: 5 - 6 - 7

### Chinchón
- 7 cartas consecutivas del mismo palo  
Ejemplo: 4 – 5 – 6 – 7 – 10 – 11 – 12

---

## Cierre de ronda
Un jugador puede cerrar si:

- No es el primer turno
- Tiene 6 o 7 cartas combinadas

Casos:
- 7 cartas combinadas: se restan 10 puntos
- Chinchón: gana automáticamente la partida
- 6 cartas combinadas: queda 1 carta suelta (valor entre 1 y 5)

---

## Puntuación
Cuando un jugador cierra:

- Cada jugador suma los puntos de sus cartas no combinadas
- Valores:
  - Cartas numéricas: valor normal
  - Sota: 10
  - Caballo: 11
  - Rey: 12

---

## Fin de la partida
- Existe un límite de puntos (por defecto: 100)
- Un jugador queda eliminado si alcanza o supera ese valor
- Gana:
  - El último jugador en pie
  - O quien consiga un chinchón

---

## Estructura del proyecto

Clases principales:

- Main: punto de entrada del programa
- Game: controla la partida completa
- Round: gestiona una ronda del juego
- Player: clase abstracta de jugador
- HumanPlayer: jugador humano
- AIPlayer: jugador automático
- Deck: gestión del mazo
- Card: representación de una carta
- Suit: enumeración de palos
- CombinationHelper: lógica de combinaciones
- ConsoleInput: entrada de datos segura

---

## Inteligencia Artificial
La IA implementada es básica:
- Roba del mazo
- Cierra si puede
- Descarta una carta aleatoria

Se puede mejorar añadiendo estrategia.

---

## Ejecución

1. Compilar el proyecto:
```bash
javac ejercicio/*.java

---

## Capturas de las pruebas

### Captura 1
![Captura 1](captura 1.png)

### Captura 2
![Captura 2](captura 2.png)

### Captura 3
![Captura 3](captura 3.png)

### Captura 4
![Captura 4](captura 4.png)

### Captura 5
![Captura 5](captura 5.png)

### Captura 6
![Captura 6](captura 6.png)

### Captura 7
![Captura 7](captura 7.png)

### Captura 8
![Captura 8](captura 8.png)