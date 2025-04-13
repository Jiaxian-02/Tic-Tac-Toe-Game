package tic.tac.toe.view

import scalafxml.core.macros.sfxml
import javafx.scene.control.{Button, Label}
import scalafx.event.ActionEvent
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import tic.tac.toe.logic.{AiGameLogic, Player}

@sfxml
class GameController(private var button0: Button,
                     private var button1: Button,
                     private var button2: Button,
                     private var button3: Button,
                     private var button4: Button,
                     private var button5: Button,
                     private var button6: Button,
                     private var button7: Button,
                     private var button8: Button,
                     private var playerLabel: Label,
                     private var resultLabel: Label,
                     private var restartButton: Button) {

  // Create player
  private val player1 = new Player("Player 1", "X")
  private val player2 = new Player("Player 2", "O")

  // Initialize the game
  private val game = new AiGameLogic(player1, player2)

  // Initialize the buttons array
  private val buttons: Array[Button] = Array(button0, button1, button2, button3, button4, button5, button6, button7, button8)


  // Handle game board button
  def handleButtonClick(event: ActionEvent): Unit = {
    val button = event.getSource.asInstanceOf[Button]
    val index = buttons.indexOf(button)

    if (index >= 0 && index < 9 && !game.isGameOver) {
      if (game.makeMove(index)) {
        updateBoard()
        if (game.checkWin(player1)) {
          resultLabel.setText("Player 1 won!")
        } else if (game.checkWin(player2)) {
          resultLabel.setText("Player 2 won!")
        } else if (game.isGameOver) {
          resultLabel.setText("Draw T^T")
        } else {
          // Update the playerLabel for the next player's turn
          val currentPlayer = if (game.getCurrentPlayer == player1) "Player 1" else "Player 2"
          playerLabel.setText(s"$currentPlayer's turn")
        }
      } else {
        // Move is invalid, display an alert to the user
        val alert = new Alert(AlertType.Warning)
        alert.title = "Invalid Move"
        alert.contentText = "Invalid move. The selected cell is already occupied."
        alert.showAndWait()
      }
    }
  }

  // To pay the game again
  def handleRestartButtonClick(event: ActionEvent): Unit = {
    game.restartGame()
    resultLabel.setText("") // Clear the result label
    updateBoard()
    playerLabel.setText("Player 1's turn") // Set the starting player
  }

  // Update the buttons to reflect the current game state
  private def updateBoard(): Unit = {
    val board = game.getBoard

    for (i <- 0 until buttons.length) {
      val player = board(i)
      val buttonText = player.marker match {
        case "X" => "X"
        case "O" => "O"
        case _ => ""
      }
      buttons(i).setText(buttonText)
    }
  }
}

