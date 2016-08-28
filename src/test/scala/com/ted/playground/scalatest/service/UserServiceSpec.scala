package com.ted.playground.scalatest.service

import org.scalatest.{AsyncWordSpecLike, Matchers}

import scala.concurrent.ExecutionContext.Implicits.global

class UserServiceSpec extends AsyncWordSpecLike with Matchers {

  val userService = new UserService

  "UserService" should {
    "return an User" when {
      "searching by a valid id" in {
        val id = "11111"

        userService.findUser(id).map { user =>
          user.id shouldBe id
          user.username shouldBe "johndoe"
          user.age shouldBe 30
        }
      }
    }

    "sync test example" in {
      3 + 4 shouldBe 7
    }
  }

}
