package tic.tac.toe.logic

abstract class GameLogic(val player1: Player, val player2: Player) {

   var board: Array[Player] = Array.fill(9)(Player.Empty)
   var currentPlayer: Player = player1

  def makeMove(index: Int): Boolean = {
    if (index >= 0 && index < board.length && board(index) == Player.Empty) {
      board(index) = currentPlayer
      currentPlayer = if (currentPlayer == player1) player2 else player1
      // Move is valid
      true
    } else {
      // Move is invalid
      false
    }
  }

  // game end situation
  def isGameOver: Boolean = {
    checkWin(player1) || checkWin(player2) || board.forall(_ != Player.Empty)
  }

  // Check the situation for winning
  def checkWin(player: Player): Boolean = {
    val winPatterns = Seq(
      Seq(0, 1, 2), Seq(3, 4, 5), Seq(6, 7, 8), // Rows
      Seq(0, 3, 6), Seq(1, 4, 7), Seq(2, 5, 8), // Columns
      Seq(0, 4, 8), Seq(2, 4, 6) // Diagonals
    )
    winPatterns.exists { pattern =>
      pattern.forall(index => board(index) == player)
    }
  }

  def getBoard: Array[Player] = board

  // To play the game again
  def restartGame(): Unit = {
    board = Array.fill(9)(Player.Empty)
    currentPlayer = player1
  }

  def getCurrentPlayer: Player = currentPlayer
}
