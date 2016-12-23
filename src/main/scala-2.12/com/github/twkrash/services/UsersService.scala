package com.github.twkrash.services

import com.github.twkrash.models.UserEntity
import com.github.twkrash.models.db.UserEntityTable
import com.github.twkrash.utils.DatabaseService

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by mdvoryanchenko on 12/23/16.
  */
class UsersService(val databaseService: DatabaseService)(implicit executionContext: ExecutionContext) extends UserEntityTable {

  import databaseService._
  import databaseService.driver.api._

  def getUsers(): Future[Seq[UserEntity]] = db.run(users.result)

  def getUserById(id: Long): Future[Option[UserEntity]] = db.run(users.filter(_.id === id).result.headOption)

  def getUserByLogin(login: String): Future[Option[UserEntity]] = db.run(users.filter(_.username === login).result.headOption)

//  def createUser(user: UserEntity): Future[UserEntity] = db.run(users returning users += user)
//
//  def updateUser(id: Long, userUpdate: UserEntityUpdate): Future[Option[UserEntity]] = getUserById(id).flatMap {
//    case Some(user) =>
//      val updatedUser = userUpdate.merge(user)
//      db.run(users.filter(_.id === id).update(updatedUser)).map(_ => Some(updatedUser))
//    case None => Future.successful(None)
//  }
//
//  def deleteUser(id: Long): Future[Int] = db.run(users.filter(_.id === id).delete)

}
