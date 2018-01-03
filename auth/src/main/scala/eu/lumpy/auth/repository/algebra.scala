package eu.lumpy.auth.repository

import eu.lumpy.auth.model.{User, UserName}

object algebra {

  trait UserRepository[F[_]] {
    def findUser(username: UserName): F[Option[User]]
  }

}
