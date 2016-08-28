package com.ted.playground.scalatest

package object exceptions {

  case class UserNotFoundException(message: String) extends Exception(message)

  case class UserAlreadyExists(message: String) extends Exception(message)

}
