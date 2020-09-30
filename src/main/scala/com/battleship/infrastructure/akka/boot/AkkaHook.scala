package com.battleship.infrastructure.akka.boot

import akka.actor.ActorSystem
import com.battleship.Hook

import scala.concurrent.Await
import scala.concurrent.duration._

class AkkaHook(implicit system: ActorSystem) extends Hook {
  override def onStop(): Unit = {
    system.terminate()
    Await.result(system.whenTerminated, 15.seconds)
  }
}
