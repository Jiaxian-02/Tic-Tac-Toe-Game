package tic.tac.toe.logic

object Player {
  val Empty: Player = new Player("Empty", "")
}

class Player(val name: String, val marker: String)

