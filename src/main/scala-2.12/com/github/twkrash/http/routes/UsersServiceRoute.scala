package com.github.twkrash.http.routes

/**
  * Created by mdvoryanchenko on 12/22/16.
  */


import akka.http.scaladsl.server.Directives._
import com.github.twkrash.http.SecurityDirectives
import com.github.twkrash.services.UsersService

import scala.concurrent.ExecutionContext

class UsersServiceRoute(usersService: UsersService)(implicit executionContext: ExecutionContext) extends SecurityDirectives {

  //  import StatusCodes._

  val route = pathPrefix("users") {
    pathEndOrSingleSlash {
      get {
        complete("ok")
      }
    }
  }
}
