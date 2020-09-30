package com.battleship

import com.battleship.domain.InvitationUrl
import spray.json._

package object api extends DefaultJsonProtocol {

  // TODO handle exception
  lazy implicit val invitationUrlFormat: RootJsonFormat[InvitationUrl] =
    new RootJsonFormat[InvitationUrl] {
      override def read(json: JsValue): InvitationUrl =
        json.asJsObject.fields
          .get("invitationUrl")
          .map(_.convertTo[String])
          .map(InvitationUrl(_))
          .get

      override def write(obj: InvitationUrl): JsValue =
        JsObject("invitationUrl" -> obj.invitationUrl.toJson)
    }
}
