package com.github.twkrash.http.routes

//import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import com.github.twkrash.http.SecurityDirectives
import com.github.twkrash.services.AuthService
//import com.github.twkrash.models.UserEntity

import scala.concurrent.ExecutionContext

/**
  * Created by mdvoryanchenko on 12/22/16.
  */
class AuthServiceRoute(val authService: AuthService)(implicit executionContext: ExecutionContext) extends SecurityDirectives {

//  import StatusCodes._
//  import authService._

  val route = pathPrefix("auth") {
    path("test") {
      pathEndOrSingleSlash {
        complete("Auth!")
      }
    }
  }

  private case class LoginPassword(login: String, password: String)

}
