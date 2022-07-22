package engine

import com.google.gson.Gson
import config.ConfigInfo
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import process.Utils

import java.util.Properties


object KafkaProducerApp extends App {
  val props: Properties = new Properties()

  // config kafka
  props.put("bootstrap.servers", ConfigInfo.BOOTSTRAP_SERVER)
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)
  val listAnimal = Utils.readSampleData("src/main/scala/datasets/animal.csv")
  val gson: Gson = new Gson()
  try{
    for (i <- listAnimal.indices) {
      val record = new ProducerRecord[String, String](ConfigInfo.TOPIC_NAME, i.toString, gson.toJson(listAnimal(i)))
      val metadata = producer.send(record)
      println(s"====>>>> producer: ----> data: record(key=${record.key()} value=${record.value()}) " +
        s"meta(partition=${metadata.get().partition()} offset=${metadata.get().offset()})")
    }
  }catch {
    case e: Exception => e.printStackTrace()
  }finally {
    producer.close()
  }

}
