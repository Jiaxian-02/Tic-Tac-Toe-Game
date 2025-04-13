package tic.tac.toe.logic

class AiGameLogic(player1: Player, player2: Player) extends GameLogic(player1, player2) {

  override def makeMove(index: Int): Boolean = {
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

  // Implement minimax algorithm
  private def minimax(board: Array[Player], depth: Int, isMaximizing: Boolean): Int = {
    // Check the states
    if (checkWin(player2)) return 1
    if (checkWin(player1)) return -1
    if (board.forall(_ != Player.Empty)) return 0

    if (isMaximizing) {
      var maxEval = Int.MinValue
      for (i <- board.indices) {
        if (board(i) == Player.Empty) {
          board(i) = player2
          val eval = minimax(board, depth + 1, false)
          board(i) = Player.Empty
          maxEval = Math.max(maxEval, eval)
        }
      }
      maxEval
    } else {
      var minEval = Int.MaxValue
      for (i <- board.indices) {
        if (board(i) == Player.Empty) {
          board(i) = player1
          val eval = minimax(board, depth + 1, true)
          board(i) = Player.Empty
          minEval = Math.min(minEval, eval)
        }
      }
      minEval
    }
  }

  // Find the best move for the AI to block user from winning
  private def findBestMove(): Int = {
    var bestMove = -1
    var bestScore = Int.MinValue
    for (i <- board.indices) {
      if (board(i) == Player.Empty) {
        board(i) = player2
        val score = minimax(board, 0, false)
        board(i) = Player.Empty
        if (score > bestScore) {
          bestScore = score
          bestMove = i
        }
      }
    }
    bestMove
  }

  // AI place the marker after user done
  def handleAIMove(): Unit = {
    val bestMove = findBestMove()
    if (bestMove != -1) {
      board(bestMove) = player2
      currentPlayer = player1
    }
  }
}

