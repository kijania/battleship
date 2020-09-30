package com.battleship.domain

import java.util.UUID

import com.battleship.Config
import com.battleship.domain.model.{Game, Player}
import com.battleship.infrastructure.cache.CacheService

import scala.concurrent.{ExecutionContext, Future}

class GamePlatform(cache: CacheService[Game.Id, Game])(
  implicit ec: ExecutionContext
) {
  def create(): Future[InvitationUrl] =
    cache
      .add(UUID.randomUUID(), Game(Player.first))
      .map(InvitationUrl.apply)
}

case class InvitationUrl(invitationUrl: String)

object InvitationUrl {
  def apply(id: Game.Id): InvitationUrl =
    InvitationUrl(s"${Config.Url}/game/${id.toString}/join")
}
