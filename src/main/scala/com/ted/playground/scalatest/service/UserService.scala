package com.ted.playground.scalatest.service

import com.ted.playground.scalatest.exceptions._
import com.ted.playground.scalatest.service.UserService.User

import scala.concurrent.Future
import scala.util.{Failure, Success}

//Don't even dare to implement this way, it's just for showcase purposes.
class UserService {

  private var users: Seq[User] = Seq(User("11111", "johndoe", 30))

  def findUser(id: String): Future[User] = Future.fromTry {
    Thread.sleep(3000)
    users.find(_.id == id) match {
      case Some(user) => Success(user)
      case _ => Failure(UserNotFoundException(s"User with id: $id not found"))
    }
  }

  def updateUser(user: User): Future[User] = ???

  def addUser(user: User): Future[User] = Future.fromTry {
    if (users.exists(_.username == user.username))
      Failure(UserAlreadyExists(s"User with ${user.username} username already exists"))
    else {
      users :+= user
      Success(user)
    }

  }
}

object UserService {

  case class User(id: String, username: String, age: Int)

}