package com.battleship

import org.slf4j.LoggerFactory
import ProductionModule.hooks

object Boot extends App {
  val logger = LoggerFactory.getLogger(this.getClass)
  logger.info(s"${Config.AppName} is starting...")

  scala.sys.addShutdownHook {
    hooks.foreach(_.onStop())
  }

  hooks.foreach(_.onStart())
}

abstract class Hook {
  def onStart(): Unit = {}
  def onStop(): Unit = {}
}
