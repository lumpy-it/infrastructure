package eu.lumpy.auth.repository

import org.scalacheck._
import org.scalatest.{FlatSpecLike, Matchers}
import org.scalatest.prop.PropertyChecks
import eu.lumpy.auth.model.{Email, User, UserName}

class ConversionSpec extends UserArbitraries with FlatSpecLike with Matchers {

  forAll { (dto: UserDTO) =>
    it should s"convert a dto: $dto into an User" in {
      dto.toUser should be(User(new UserName(dto._2), new Email(dto._3)))
    }
  }

}

trait UserArbitraries extends PropertyChecks {

  implicit val userDtoArbitraries: Arbitrary[UserDTO] = Arbitrary[UserDTO] {
    for {
      i <- Gen.posNum[Int]
      u <- Gen.alphaStr
      e <- Gen.alphaStr
    } yield (i, u, e)
  }

}
