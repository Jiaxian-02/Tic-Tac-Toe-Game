package tic.tac.toe.view

import tic.tac.toe.MainApp
import scalafxml.core.macros.sfxml
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.ButtonType

@sfxml
class RootController{
  // direct players back to the main page
  def backMainPage(): Unit = {
    MainApp.showWelcome()
  }

  // direct players back to the instructions page
  def backInstruction(): Unit = {
    MainApp.showInstruction()
  }

  // enable the user to exit game
  def handleClose(): Unit = {
    val confirmationAlert = new Alert(AlertType.Confirmation) {
      title = "Confirmation"
      headerText = "Are you sure you want to exit?"
      contentText = "Press OK to exit or Cancel to stay."
    }
    val result = confirmationAlert.showAndWait()

    result match {
      case Some(ButtonType.OK) =>
        System.exit(0)
      case _ =>
      // Do nothing when user click cancel
    }
  }

}