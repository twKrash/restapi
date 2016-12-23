package com.github.twkrash

import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.github.twkrash.http.HttpService
import com.github.twkrash.services.UsersService
import com.github.twkrash.utils.{Config, DatabaseService}

import scala.concurrent.ExecutionContext

/**
  * Created by Maksim Dvoryanchenko on 12/22/16.
  */
object Server extends App with Config {
  implicit val actorSystem = ActorSystem()
  implicit val executor: ExecutionContext = actorSystem.dispatcher
  implicit val log: LoggingAdapter = Logging(actorSystem, getClass)
  implicit val materializer: ActorMaterializer = ActorMaterializer()


  val databaseService = new DatabaseService(jdbcUrl, dbUser, dbPassword)

  val usersService = new UsersService(databaseService)
//  val authService = new AuthService(databaseService)(usersService)

  val httpService = new HttpService(usersService)

  Http().bindAndHandle(httpService.routes, httpHost, httpPort)
}
