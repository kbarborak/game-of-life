# Game of Life (Java)

That's my personal homework from Global day of Coderetreat 2017. I know that the main objective of coderetreat isn't full
working implementation but I just wanted to try finish it :-).

## Ubiquitous language

Before diving into source code it's good idea to clarify some domain terms I use for describing my understanding of
game of life problem.

* **Life** - Basic unit of game. It represents populated place in game. Technically speaking it's live cell.
* **Population** - Set of all lives in game.
* **Generation** - Parent unit to population. It represents evolution of population. Each new state of game creates new generation.
* **Neighbour** - Representation of place around some life or another neighbour (always eight neighbours in total). Neighbour has
ability to express its position in game world same as life but neighbour isn't life.
    * **Populated neighbour** - Representation of position where is also life.
    * **Unpopulated neighbour** - Representation of position where isn't life.
* **Rule** - Game of Life has four rules but I've ended only with two rules implemented.
    * **Survival rule** - First rule is all about survival. I care only about lives so it's enough to know if life should
    continue in next generation or not. 
    * **Reproduction rule** - Second rule is about reproduction. It examines number of populated neighbours around all unpopulated
    neighbours for each life. If some of these unpopulated neighbours meet reproduction rule then new life is born. 
    
## Extending game

Extending behaviour of game is possible in many ways. The easiest way is creating new `Life` subclass and also rule (or rules) to handle
it. Next way could be implementation of own NeighbourResolver and make for example `HalloweenNeighbourResolver` that will resolve the
neighbours not by cartesian product but random generator. There is also hard way by creating custom implementation of
`GameOfLife`, `GenerationFactory` and other classes.        
