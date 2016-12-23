package com.github.twkrash.http

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.github.twkrash.http.routes.UsersServiceRoute
import com.github.twkrash.services.UsersService
import com.github.twkrash.utils.CorsSupport

import scala.concurrent.ExecutionContext

/**
  * Created by mdvoryanchenko on 12/22/16.
  */
class HttpService(usersService: UsersService)(implicit executionContext: ExecutionContext) extends CorsSupport {

  val usersRouter = new UsersServiceRoute(usersService)
//  val authRouter = new AuthServiceRoute(authService)

  val routes: Route =
    pathPrefix("api") {

      corsHandler {
        usersRouter.route
        //        ~
        //          authRouter.route
      }
    }

}
