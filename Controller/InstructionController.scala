package tic.tac.toe.view

import tic.tac.toe.MainApp
import scalafxml.core.macros.sfxml

@sfxml
class InstructionController {
  // Direct player to choose the game mode
  def chooseMode(): Unit = {
    MainApp.showMode()
  }

}

