package com.battleship.domain.model

case class Player(fleet: Fleet, shots: Set[Pos])

object Player {
  val first: Player = Player(Fleet.first, Set.empty)
  val second: Player = Player(Fleet.second, Set.empty)
}
