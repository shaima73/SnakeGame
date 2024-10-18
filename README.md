

## Snake Game 🎮

A simple Snake Game developed in Java using Swing for the graphical user interface (GUI). The game is inspired by the classic snake game, where the player controls a snake to eat apples, growing longer while avoiding collisions with the walls or itself.

## Features

Snake grows as it eats apples.

Game Over message displayed when the snake hits the walls or itself.

Keyboard controls to move the snake:

Up: ↑ arrow key

Down: ↓ arrow key

Left: ← arrow key

Right: → arrow key


Score counter based on the number of apples eaten.


## Controls

Arrow keys: Move the snake up, down, left, or right.


## How the Game Works

- The snake starts at a small length of 6 units.

- Apples appear at random positions on the board. Each time the snake eats an apple, it grows by one unit.

- The game ends if the snake hits the walls of the game window or collides with itself.


Code Structure

The project contains the following key classes:

*1*. SnakeGamee.java: The main class that starts the game by creating an instance of the Snake class.


*2*. Snake.java: Sets up the game window, initializes the game board, and adds an icon to the window.


*3*. Panel.java: Implements the game logic and rendering using JPanel. This class includes:

- Game loop (actionPerformed method)

- Snake movement logic

- Apple generation

- Collision detection

- Game over handling



*4*. MyKeyAdapter.java (inner class): Handles the keyboard inputs to control the direction of the snake.

## Conclusion

The Snake Game project showcases fundamental Java skills, using Swing for the GUI and simple game mechanics like movement, collision detection, and input handling. It's a great way to practice Java and GUI development while building a classic game.
