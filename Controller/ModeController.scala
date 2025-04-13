package tic.tac.toe.view

import tic.tac.toe.MainApp
import scalafxml.core.macros.sfxml

@sfxml
class ModeController {
  // direct players to multiple players mode
  def startGame(): Unit = {
    MainApp.showGame()
  }

  // direct players to single player mode
  def startAIGame(): Unit = {
    MainApp.showAiGame()
  }

}