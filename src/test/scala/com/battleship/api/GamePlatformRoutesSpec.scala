package com.battleship.api

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.battleship.Config
import com.battleship.domain.{GamePlatform, InvitationUrl}
import com.battleship.domain.model.Game
import com.battleship.domain.model.Game.Id
import com.battleship.infrastructure.cache.CacheService
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._

import scala.concurrent.Future

class GamePlatformRoutesSpec
    extends AnyFlatSpec
    with Matchers
    with ScalatestRouteTest {
  it must "create and return invitation url" in new FixtureWithCacheStub {
    Post("/game") ~> routes ~> check {
      status mustBe StatusCodes.OK
      val url = responseAs[InvitationUrl].invitationUrl
      url.startsWith(s"${Config.Url}/game/") mustBe true
      url.endsWith("/join") mustBe true
    }
  }

  class FixtureWithCacheStub {
    val cacheStub: CacheService[Id, Game] = new CacheService[Id, Game] {
      override def add(key: Id, value: Game): Future[Id] =
        Future.successful(key)
      override def get(key: Id): Future[Option[Game]] = Future.successful(None)
    }

    val routes
      : Route = new GamePlatformRoutes(new GamePlatform(cacheStub)).routes
  }
}
