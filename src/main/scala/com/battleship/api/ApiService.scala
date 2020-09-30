package com.battleship.api

import akka.http.scaladsl.server.{Directives, Route}

class ApiService(gamePlatformService: GamePlatformRoutes) extends Directives {

  val routes: Route =
    gamePlatformService.routes
}
