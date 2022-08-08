# Problem Statement - 

    Simple rock paper scissors game. 

The game should be played between a player and a computer which chooses randomly. 

The player should be able to interact with the application to choose one of the available actions (Rock, Paper, Scissors). 

The interaction can happen via a terminal prompt. 

A player should be able to play any number of games in one session.


## Detail about the Implementation - 


There will be two Service - 

GameSvc - which execute the game whenever player plays the game

ComputerSvc - which plays the game as a computer. It generates its own GameToken

There are other couple of class whose details you can find below -

Player - Model Class for the player

RockPaperScissorExecutor-  which will execute the gameToken and finds which gameToken has priority over other token.

### Flow of Game-
Step 1. Game start by taking the player's name. We initialize the game here by Calling initializing the GameSvc.

Step 2. We take the player's desired token as a input. Here instead of taking String as a input, I have taken the number which is internally map to the various Tokens, Like 0 - ROCK, 1 - PAPER, 2 - SCISSOR

Step 3. we call the GameSvc's play method with the player's Desired input as a argument

Step 4. GameSvc do following things -
* Do a Precondition Check: Check if player has given the valid Input i.e. anything from {0 to 2}
* Update the playerOne Token and calls the ComputerSvc to get the computer's token and update the computer's info in PlayerTwo object
* Then it call the RockPaperScissorExecutor to execute the game to Get the final result of the Game.
* Then It prints the result of the Game

Step 5 - RockPaperScissorExecutor internally calls the GameToken Executor to find the result at each GameToken Level.

Flow Ends Here.


    
    




