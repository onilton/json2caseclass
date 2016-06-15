package io.github.onilton.jsontocaseclass.components

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import sri.core.ReactComponentPureRef
import sri.core.ReactComponentPureRefP


import sri.web.all.getTypedConstructor
import sri.web.all.createElementNoProps
import sri.web.all.createElement
import sri.web.all.createStatelessFunctionElementWithChildren
import sri.web.all.createStatelessFunctionElement

//import sri.web.all._
import sri.web.all.ReactEvent
import sri.web.all.ReactEventI

import sri.web.vdom.htmltags.{input => _, _}
import io.github.onilton.jsontocaseclass.components.PatchedInput.input
import scala.scalajs.js.Dynamic.{literal => json}

import io.github.onilton.jsontocaseclass.ClassField

object GeneratedField {
  case class Props(generatedClassName: String, field: ClassField, updateField: ClassField => Unit)

  @ScalaJSDefined
  class Component extends ReactComponentPureRefP[Props] {

    def toggle(e: ReactEventI) = {
      val newClassField = props.field.copy(optional = ! props.field.optional)
      props.updateField(newClassField)
    }

    def onChange(e: ReactEventI) = {
      val newClassField = props.field.copy(typescala=e.target.value)
      props.updateField(newClassField)
    }

    def render() = {
      val field = props.field
      val cName = props.generatedClassName
      val extraAttributes = js.Dynamic.literal(
        "data-signature-class" -> field.sha,
        "data-list" -> field.list
      )

      div(className = "li control-group")(
        label(className = "keyname control-label")(field.name),
        div(className = "controls")(
          div(className = "input-append")(
            input(
              className = "typescala",
              `type` = "text",
              value = field.typescala,
              onChange = onChange _,
              disabled = field.preventChange,
              extraAttributes = extraAttributes
            ),
            span(className = "add-on")(
              input(
                className = "optional_value",
                id = s"chkbr_${cName}_${field.name}",
                `type` = "checkbox", checked = (if (field.optional) true.toString() else js.undefined ),
                onChange = toggle _),
              label(className = "label_chkbr", htmlFor = s"chkbr_${cName}_${field.name}")(" optional")
            )
          )
        )
      )
    }
  }

  val ctor = getTypedConstructor(js.constructorOf[Component], classOf[Component])

  def apply(generatedClassName: String, field: ClassField, updateField: ClassField => Unit, key: js.UndefOr[String] = js.undefined, ref: js.Function1[Component, _] = null) =  {
    val props = Props(generatedClassName, field, updateField)
    createElement(ctor, props, key, ref)
  }
}