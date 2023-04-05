# ColorfulSnakeOI2022
My solution for the problem was published at XXX Polish Olympiad in Informatics.
[Task available here (polish).](https://sio2.mimuw.edu.pl/c/oi30-1/p/kol/ "Task available here (polish).")

**Why this contest?**  
When I was in high school, I used to participate in Polish Olympiad every year. I enjoy thinking about possible solutions and improvements.

**Way of thinking**. 
I'm not the best at copywriting, but the main idea of the algorithm is absolutely easy so I hope that I can help you understand my solution.

[Snake.java](https://github.com/borawskiD/ColorfulSnakeOI2022/blob/master/src/com/company/Snake.java)  
Every object of this class represents one part of a snake. It's important to easily move every element because test cases include a huge amount of moves in every direction.
I didn't put any logic of moving inside the class, because I prefer to separate mechanical classes from data classes.

Every object has 3 fields: x_pos, y_pos, and value.

[Task.java](https://github.com/borawskiD/ColorfulSnakeOI2022/blob/master/src/com/company/Task.java)  

The main class of the algorithm where I store logic. My solution can be summarized in a few steps.

 1. Get parameters of input.
 2. Generate a board filled with starting values (0).
 3. Add treats by a user.
 4. Put the snake inside the board [starting position = (0,0)].
 5. Continue parsing input step by step. I used a switch-case to improve readability. "P" means move right, "L" means move left, "G" means move up, "D" means move down, and "Z" means display value of the snake (or its absence) at a specific place in the board.
 6. When the "top" of the snake gets into a treat, we need to extend the length of the animal.
 7. Stop when all orders have been executed.

**Problems**  
I had spent a huge part of my time thinking and implementing the movement of the snake. It is easy to understand and draw it on paper, but when you want to implement it and be aware of edge cases, it takes time.
