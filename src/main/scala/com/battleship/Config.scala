package com.battleship

import com.typesafe.config.ConfigFactory

object Config {

  private val config = ConfigFactory.load()

  val Url: String = "localhost:8080"

  val AppName: String = "BattleShip"
}
