package tic.tac.toe

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafxml.core.{FXMLLoader, NoDependencyResolver}
import scalafx.scene.Scene
import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.scene.image.Image
import tic.tac.toe.view.GameController

object MainApp extends JFXApp {

  // transform path of RootLayout.fxml to URI for resource location.
  val rootResource = getClass.getResource("view/Root.fxml")
  // initialize the loader object.
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  // Load root layout from fxml file.
  loader.load();
  // retrieve the root component BorderPane from the FXML
  val roots = loader.getRoot[jfxs.layout.BorderPane]
  // set application icon
  val iconImage = new Image(getClass.getResourceAsStream("image/Cherry.jpg"))

  // initialize stage
  stage = new PrimaryStage {
    title = "Cherry Tic Tac Toe"
    scene = new Scene {
      root = roots
    }
    icons.add(iconImage)

  }

  def showWelcome() = {
    val resource = getClass.getResource("view/Welcome.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showInstruction() = {
    val resource = getClass.getResource("view/Instruction.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showMode() = {
    val resource = getClass.getResource("view/Mode.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showGame() = {
    val resource = getClass.getResource("view/Game.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showAiGame() = {
    val resource = getClass.getResource("view/AIGame.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  showWelcome()
}


