package com.battleship

import akka.actor.ActorSystem
import com.battleship.api.{ApiService, GamePlatformRoutes}
import com.battleship.domain.GamePlatform
import com.battleship.domain.model.Game
import com.battleship.infrastructure.akka.boot.AkkaHook
import com.battleship.infrastructure.akkaHttp.boot.AkkaHttpHook
import com.battleship.infrastructure.cache.InMemoryCache

import scala.concurrent.ExecutionContext

object ProductionModule {

  implicit val system: ActorSystem = ActorSystem(Config.AppName)
  implicit val ec: ExecutionContext = system.dispatcher

  private val gameCache = new InMemoryCache[Game.Id, Game]()
  private val gamePlatform = new GamePlatform(gameCache)
  private val gamePlatformRoutes = new GamePlatformRoutes(gamePlatform)
  private val apiService = new ApiService(gamePlatformRoutes)

  private val akkaHook = new AkkaHook
  private val akkaHttpHook = new AkkaHttpHook(apiService)

  val hooks = Seq(akkaHook, akkaHttpHook)
}
