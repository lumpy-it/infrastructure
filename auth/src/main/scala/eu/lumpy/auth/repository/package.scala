package eu.lumpy.auth

import eu.lumpy.auth.model._

package object repository {

  type UserDTO = (Int, String, String)

  implicit class UserConversions(dto: UserDTO) {
    def toUser: User = User(
      username = new UserName(dto._2),
      email = new Email(dto._3)
    )
  }

}
