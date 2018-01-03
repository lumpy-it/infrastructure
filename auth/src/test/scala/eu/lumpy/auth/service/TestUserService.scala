package eu.lumpy.auth.service

import cats.effect.IO
import eu.lumpy.auth.TestUsers.users
import eu.lumpy.auth.model.{User, UserName}
import eu.lumpy.auth.repository.algebra.UserRepository

object TestUserService {

  private val testUserRepo: UserRepository[IO] =
    (username: UserName) => IO {
      users.find(_.username.value == username.value)
    }

  val service: UserService[IO] = new UserService[IO](testUserRepo)

}
