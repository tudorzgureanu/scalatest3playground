package com.ted.playground.scalatest.service

import com.ted.playground.scalatest.exceptions.{UserAlreadyExistsException, UserNotFoundException}
import com.ted.playground.scalatest.service.UserService.User
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

    "return UserNotFoundException" when {
      "the user does not exist" in {
        val id = "1"

        recoverToSucceededIf[UserNotFoundException](userService.findUser(id))
      }
    }

    "return UserAlreadyExistsException" when {
      "adding an user with an existing username" in {
        val username = "johndoe"
        val user = User("12345", username, 25)

        recoverToExceptionIf[UserAlreadyExistsException] {
          userService.addUser(user)
        }.map { ex =>
          ex.message shouldBe s"User with username: $username already exists!"
        }

      }
    }

    "sync test example" in {
      3 + 4 shouldBe 7
    }
  }

}
