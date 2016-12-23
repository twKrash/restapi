package com.github.twkrash.utils

import com.typesafe.config.ConfigFactory

/**
  * Created by mdvoryanchenko on 12/22/16.
  */
trait Config {
  private val config = ConfigFactory.load()
  private val httpConfig = config.getConfig("http")
  private val databaseConfig = config.getConfig("database")

  val httpInterface = httpConfig.getString("interface")
  val httpPort = httpConfig.getInt("port")
  val httpHost = httpConfig.getString("interface")

  val jdbcUrl = databaseConfig.getString("url")
  val dbUser = databaseConfig.getString("user")
  val dbPassword = databaseConfig.getString("password")
}
