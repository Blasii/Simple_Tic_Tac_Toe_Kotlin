package tictactoe

import java.util.*

fun main() {
    // Initialize the game grid with empty spaces
    val emptyGameState = "         "
    var gameState = emptyGameState

    // Print the initial empty grid
    printGameGrid(gameState)

    // Game loop
    var currentPlayer = 'X'
    while (true) {
        // Get user's move and update the grid
        gameState = makeMove(gameState, currentPlayer)

        // Print the updated grid
        printGameGrid(gameState)

        // Check for a winner or a draw
        if (checkWinner(gameState, currentPlayer)) {
            println("$currentPlayer wins")
            break
        } else if (isGridFull(gameState)) {
            println("Draw")
            break
        }

        // Switch to the next player
        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
    }
}

fun printGameGrid(gameState: String) {
    // Print the game grid
    println("---------")
    for (i in 0 until 3) {
        print("| ")
        for (j in 0 until 3) {
            print("${gameState[i * 3 + j]} ")
        }
        println("|")
    }
    println("---------")
}

fun makeMove(gameState: String, currentPlayer: Char): String {
    val scanner = Scanner(System.`in`)
    var coordinates: Pair<Int, Int>? = null

    // Keep prompting until valid coordinates are entered
    while (coordinates == null) {
        //print("Player $currentPlayer, enter your move (row and column): ")
        val input = scanner.nextLine()

        try {
            val (row, col) = input.split(" ").map { it.toInt() }
            coordinates = Pair(row, col)

            // Check if the coordinates are valid
            if (row !in 1..3 || col !in 1..3) {
                println("Coordinates should be from 1 to 3!")
                coordinates = null
            } else if (gameState[(row - 1) * 3 + (col - 1)] != ' ') {
                println("This cell is occupied! Choose another one!")
                coordinates = null
            }
        } catch (e: NumberFormatException) {
            println("You should enter numbers!")
        }
    }

    // Update the grid with the user's move
    return updateGameState(gameState, coordinates, currentPlayer)
}

fun updateGameState(gameState: String, coordinates: Pair<Int, Int>, symbol: Char): String {
    val row = coordinates.first - 1
    val col = coordinates.second - 1

    // Convert the game state string to a mutable list for easier modification
    val mutableGameState = gameState.toMutableList()

    // Update the grid with the user's move
    mutableGameState[row * 3 + col] = symbol

    // Convert the mutable list back to a string
    return mutableGameState.joinToString("")
}

fun checkWinner(gameState: String, player: Char): Boolean {
    // Check rows, columns, and diagonals for a win
    for (i in 0 until 3) {
        if ((0 until 3).all { gameState[i * 3 + it] == player } ||
            (0 until 3).all { gameState[it * 3 + i] == player }
        ) {
            return true
        }
    }

    return (0 until 3).all { gameState[it * 3 + it] == player } ||
            (0 until 3).all { gameState[it * 3 + 2 - it] == player }
}

fun isGridFull(gameState: String): Boolean {
    return !gameState.contains(' ')
}
