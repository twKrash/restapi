package com.github.twkrash.models.db

import com.github.twkrash.models.UserEntity
import com.github.twkrash.utils.DatabaseService

/**
  * Created by mdvoryanchenko on 12/23/16.
  */

trait UserEntityTable {

  protected val databaseService: DatabaseService
  import databaseService.driver.api._

  class Users(tag: Tag) extends Table[UserEntity](tag, "users") {
    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
    def username = column[String]("username")
    def password = column[String]("password")

    def * = (id, username, password) <> ((UserEntity.apply _).tupled, UserEntity.unapply)
  }

  protected val users = TableQuery[Users]

}
