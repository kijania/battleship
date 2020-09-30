package com.battleship.infrastructure.cache

import scala.concurrent.Future

abstract class CacheService[K, V] {
  def add(key: K, value: V): Future[K]
  def get(key: K): Future[Option[V]]
}
