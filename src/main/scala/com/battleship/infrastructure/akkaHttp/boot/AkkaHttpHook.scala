package com.battleship.infrastructure.akkaHttp.boot

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.Materializer
import com.battleship.Hook
import com.battleship.api.ApiService

class AkkaHttpHook(apiService: ApiService)(implicit val system: ActorSystem,
                                           materializer: Materializer)
    extends Hook {

  override def onStart(): Unit = {
    Http()(system).bindAndHandle(apiService.routes, "0.0.0.0", 8080)
  }
}
