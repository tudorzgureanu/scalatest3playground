package com.ted.playground.scalatest

package object exceptions {

  case class UserNotFoundException(message: String) extends Exception(message)

  case class UserAlreadyExistsException(message: String) extends Exception(message)

}
