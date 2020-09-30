package com.battleship.domain.model

case class Game(playerA: Player, playerB: Option[Player] = None)

object Game {
  type Id = java.util.UUID
}
