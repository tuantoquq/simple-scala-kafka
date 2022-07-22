package engine

import config.ConfigInfo
import org.apache.kafka.clients.consumer.KafkaConsumer

import java.time.Duration
import java.util.{Collections, Properties}
import java.util.regex.Pattern
import scala.collection.JavaConverters.{asJavaIterableConverter, iterableAsScalaIterableConverter}

object KafkaConsumerApp extends App {
  var props: Properties = new Properties()

  props.put("group.id", "group-id")
  props.put("bootstrap.servers", ConfigInfo.BOOTSTRAP_SERVER)
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("enable.auto.commit", false)

  var consumer = new KafkaConsumer(props)
  try {
    consumer.subscribe(Collections.singleton(ConfigInfo.TOPIC_NAME))
    while(true){
      val records = consumer.poll(10)
      for (record <- records.asScala){
        println(s"====>>>> consumer: ----> data: topic: (name=${record.topic()}) record(key=${record.key()} value=${record.value()}) " +
          s"meta(partition=${record.partition()} offset=${record.offset()})")
      }
    }
  } catch{
    case e: Exception => e.printStackTrace()
  } finally {
    consumer.close()
  }
}
