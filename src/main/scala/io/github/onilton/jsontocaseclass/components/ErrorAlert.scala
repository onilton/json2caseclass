package io.github.onilton.jsontocaseclass.components

import scala.scalajs.js
import sri.core._
import sri.web.all._
import sri.web.vdom.htmltags._
import io.github.onilton.jsontocaseclass.ClassField

import scala.scalajs.js.Dynamic.{literal => json}


object ErrorAlert {
  val component = (msg: String) => {
    div(className = "alert alert-error")(
    button(`type` = "button", className = "close", extraAttributes = json("data-dismiss" -> "alert"))("\u00D7"),
      i(className = "icon-warning-sign")()," ", msg
    )
  }

  def apply(props : String) = createStatelessFunctionElement(component, props)
}