package com.battleship.domain.model

case class Fleet(battleShips: Seq[BattleShip]) {}

object Fleet {
  def first: Fleet =
    Fleet(
      Seq(
        BattleShip("1A"),
        BattleShip("1D", "2D"),
        BattleShip("1G", "2G", "3G"),
        BattleShip("1J", "2J", "3J", "4J")
      )
    )
  def second: Fleet =
    Fleet(
      Seq(
        BattleShip("1A", "1B", "1C", "1D"),
        BattleShip("8D", "9D", "10D"),
        BattleShip("9G", "10G"),
        BattleShip("10J")
      )
    )
}
