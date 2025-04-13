package tic.tac.toe.view

import tic.tac.toe.MainApp
import scalafxml.core.macros.sfxml

@sfxml
class WelcomeController {
  // direct players to the instructions page
  def getInstruction(): Unit = {
    MainApp.showInstruction()
  }

  // direct players to choose the game mode
  def chooseMode(): Unit = {
    MainApp.showMode()
  }

}
