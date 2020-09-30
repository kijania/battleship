package com.battleship.infrastructure.cache
import java.util.concurrent.ConcurrentHashMap

import scala.concurrent.{ExecutionContext, Future}
import scala.jdk.CollectionConverters._

class InMemoryCache[K, V](implicit ec: ExecutionContext)
    extends CacheService[K, V] {

  private val cache =
    new ConcurrentHashMap[K, V].asScala

  override def add(key: K, value: V): Future[K] =
    Future(cache += key -> value).map(_ => key)

  override def get(key: K): Future[Option[V]] = Future(cache.get(key))
}
