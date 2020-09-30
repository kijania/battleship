package com.battleship.api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.{Directives, Route}
import com.battleship.domain.GamePlatform
import spray.json._

class GamePlatformRoutes(gamePlatform: GamePlatform)
    extends Directives
    with SprayJsonSupport {
  val routes: Route = pathPrefix("game") {
    post {
      pathEnd {
        onSuccess(gamePlatform.create()) { invitationUrl =>
          complete(invitationUrl.toJson)
        }
      }
    }
  }
}
