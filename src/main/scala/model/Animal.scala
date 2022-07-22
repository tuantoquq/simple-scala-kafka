package model

import java.sql.Date

object Animal {
  case class AnimalModel (
                         var id: Int,
                         var name: String,
                         var feature: String,
                         var createDate: Date
                         )

  object AnimalInput {
    def create(
              date: Date,
              id: Int,
              name: String,
              feature: String
              ): AnimalModel ={
      val animal = AnimalModel(id, name, feature, date)
      animal
    }
    def printAnimalInformation(animal: AnimalModel): Unit ={
      println(s"${animal.id} -- ${animal.name} -- ${animal.feature} -- ${animal.createDate}")
    }
  }
}
