package io.github.onilton.jsontocaseclass.components

import scala.scalajs.js
import sri.core._
import sri.web.all._
import sri.web.vdom.htmltags._
import io.github.onilton.jsontocaseclass.ClassField

import scala.scalajs.js.Dynamic.{literal => json}


object InfoAlert {
  val component = (msg: String) => {
    div(className="alert alert-info")(
    button(`type` = "button", className = "close", extraAttributes = json("data-dismiss" -> "alert"))("\u00D7"),
      msg
    )
  }

  def apply(props : String, key: js.UndefOr[String] = js.undefined) = createStatelessFunctionElement(component, props, key)
}