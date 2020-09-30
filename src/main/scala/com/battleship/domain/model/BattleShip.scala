package com.battleship.domain.model

case class BattleShip(positions: Set[Pos]) {
  require(positions.nonEmpty & positions.size <= 4)
}

object BattleShip {
  def apply(positions: String*): BattleShip =
    new BattleShip(positions.toSet.map(Pos.apply))
}
