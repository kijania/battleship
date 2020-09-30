package com.battleship.domain.model

case class Pos(x: Int, y: String)

object Pos {

  val posRegex = """(\d+)([a-jA-J])""".r
  val revertedPosRegex = """([a-jA-J])(\d+)""".r

  def apply(desc: String): Pos = {
    desc match {
      case posRegex(x, y) if x.toInt >= 1 && x.toInt <= 10 =>
        Pos(x.toInt, y.toUpperCase)
      case revertedPosRegex(y, x) if x.toInt >= 1 && x.toInt <= 10 =>
        Pos(x.toInt, y.toUpperCase)
      case _ => ??? // TODO handle error
    }
  }
}
