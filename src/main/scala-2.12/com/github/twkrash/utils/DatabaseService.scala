package com.github.twkrash.utils

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}

/**
  * Created by mdvoryanchenko on 12/22/16.
  */
class DatabaseService(jdbcUrl: String, dbUser: String, dbPassword: String) {
  private val hikariConfig = new HikariConfig()
  hikariConfig.setJdbcUrl(jdbcUrl)
  hikariConfig.setUsername(dbUser)
  hikariConfig.setPassword(dbPassword)

  private val dataSource = new HikariDataSource(hikariConfig)

  val driver = slick.driver.PostgresDriver

  import driver.api._

  val db = Database.forDataSource(dataSource)
  db.createSession()
}
