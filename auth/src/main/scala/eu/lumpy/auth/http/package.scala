package eu.lumpy.auth

import eu.lumpy.auth.model._
import io.circe.{Encoder, Json}

package object http {

  implicit val usernameEncoder: Encoder[UserName] = Encoder.instance {
    x => Json.fromString(x.value)
  }

  implicit val emailEncoder: Encoder[Email] = Encoder.instance {
    x => Json.fromString(x.value)
  }

}
