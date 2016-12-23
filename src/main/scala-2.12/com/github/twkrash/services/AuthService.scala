package com.github.twkrash.services

/**
  * Created by mdvoryanchenko on 12/23/16.
  */

import com.github.twkrash.models.UserEntity
import com.github.twkrash.utils.DatabaseService

import scala.concurrent.ExecutionContext
class AuthService(val databaseService: DatabaseService)(usersService: UsersService)(implicit executionContext: ExecutionContext){

  def signIn(login: String, password: String): Unit = {
//    db.run(users.filter(u => u.username === login).result).flatMap { users =>
//      users.find(user => user.password == password) match {
//        case Some(user) => db.run(tokens.filter(_.userId === user.id).result.headOption).flatMap {
//          case Some(token) => Future.successful(Some(token))
//          case None        => createToken(user).map(token => Some(token))
//        }
//        case None => Future.successful(None)
//      }
//    }

  }

  def signUp(newUser: UserEntity): Unit = {
//    usersService.createUser(newUser).flatMap(user => createToken(user))
//    Future[Any]
  }

  def authenticate(token: String): Unit = {
    println('test)
  }
//    db.run((for {
//      token <- tokens.filter(_.token === token)
//      user <- users.filter(_.id === token.userId)
//    } yield user).result.headOption)

//  def createToken(user: UserEntity): Future[TokenEntity] = db.run(tokens returning tokens += TokenEntity(userId = user.id))

}