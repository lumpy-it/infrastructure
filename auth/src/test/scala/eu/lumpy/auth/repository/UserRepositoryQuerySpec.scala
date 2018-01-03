package eu.lumpy.auth.repository

import cats.effect.IO
import doobie.scalatest._
import doobie.util.transactor.Transactor
import org.scalatest.FunSuite
import eu.lumpy.auth.model.UserName

// The Doobie way of testing queries using either scalatest or specs2. Here an example with the first one.
class UserRepositoryQuerySpec extends FunSuite with IOChecker {

  override def transactor: Transactor[IO] = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver", "jdbc:postgresql:users", "postgres", "postgres"
  )

  private val userRepo = new PostgresUserRepository[IO](transactor)

  test("user by name query") {
    check(userRepo.userQuery(new UserName("gvolpe")))
  }
}
