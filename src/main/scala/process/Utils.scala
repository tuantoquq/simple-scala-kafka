package process

import model.Animal.{AnimalInput, AnimalModel}

import java.sql.Date

object Utils {
  def readSampleData(fileName: String): List[AnimalModel] ={
    val bufferedSource = io.Source.fromFile(fileName)
    var rsAnimals: List[AnimalModel] = List()
    for (line <- bufferedSource.getLines().drop(1)){
      val lines: Array[String] = line.split(',')
      val animal = AnimalInput.create(new Date(System.currentTimeMillis()), lines(0).toInt, lines(1), lines(2))
      rsAnimals = rsAnimals :+ animal
    }
    rsAnimals
  }

}
