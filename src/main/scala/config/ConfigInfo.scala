package config

import com.typesafe.config.{Config, ConfigFactory}

import java.io.File

object ConfigInfo extends Serializable {
  val config: Config = ConfigFactory.parseFile(new File("config.properties"))
  val TOPIC_NAME: String = config.getString("kafka.topic.name")
  val BOOTSTRAP_SERVER: String = config.getString("kafka.bootstrap-server")
}
