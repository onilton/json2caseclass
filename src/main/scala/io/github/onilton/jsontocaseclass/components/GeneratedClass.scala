package io.github.onilton.jsontocaseclass.components

import scala.scalajs.js
import org.querki.jquery._
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.annotation.ScalaJSDefined
import sri.core._
import sri.web.all._
import sri.web.vdom.htmltags._
import io.github.onilton.jsontocaseclass.{ClassField, VCaseClass}

import scala.scalajs.js.UndefOr.any2undefOrA
import scala.scalajs.js.UndefOr.any2undefOrUnion
import scala.scalajs.js.|.from
import io.github.onilton.jsontocaseclass.components.PatchedInput.input
import scala.scalajs.js.Dynamic.{literal => json}


object GeneratedClass {
  case class Props(generatedClassName: String, fields: Vector[ClassField], updateGeneratedClass: VCaseClass => Unit)

  @ScalaJSDefined
  class Component extends ReactComponentPureRefP[Props] {

    def updateField(index: Int)(field: ClassField) = {
      println("updating field", field.typescala)
      val newFields = props.fields.updated(index, field)
      props.updateGeneratedClass((props.generatedClassName, newFields))
    }

    def updateName(e: ReactEventI) = {
      println("updating name", e.target.value)
      props.updateGeneratedClass((e.target.value, props.fields))
    }

    def render() = {
      val fields = props.fields
      val cName = props.generatedClassName

      div(className = "one_class")(
        fieldset()(
          div(className = "class_title")(input(className = "class_name", `type` = "text", onChange = updateName _ , value = cName)),
          div(className = "ul")(
            fields.zipWithIndex.map { case (field, id) =>
              GeneratedField(generatedClassName = cName, field = field, updateField(id), id.toString)
            }
          )
        ),
        InfoAlert(s"${fields.size} fields")
      )
    }
  }

  val ctor = getTypedConstructor(js.constructorOf[Component], classOf[Component])

  def apply(
      generatedClassName: String, fields: List[ClassField],
      updateGeneratedClass: VCaseClass => Unit,
      key: js.UndefOr[String] = js.undefined,
      ref: js.Function1[Component, _] = null) =  {
    val props = Props(generatedClassName, fields.toVector, updateGeneratedClass)
    createElement(ctor, props, key, ref)
  }
}

