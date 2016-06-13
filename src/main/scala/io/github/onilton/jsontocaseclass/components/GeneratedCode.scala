package io.github.onilton.jsontocaseclass.components

import scala.scalajs.js
import org.querki.jquery._
import scala.scalajs.js.annotation.ScalaJSDefined
import sri.core._
import sri.web.all._
import sri.web.vdom.htmltags._
import io.github.onilton.jsontocaseclass.{ ClassField, Alerts, CaseClass, VCaseClass}

import scala.scalajs.js.UndefOr.any2undefOrA
import scala.scalajs.js.|.from
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.JSName


object GeneratedCode {
  case class Props(clsses: Vector[CaseClass])
  case class State(tabIndex: Int = 0)

  @ScalaJSDefined
  class Component extends ReactComponentPureRef[Props, State] {
    initialState(State())

    def generatedScalaCode(): String = {
      props.clsses.map { case (name, fields) =>
        val ccontent = fields.map { f =>
          val finalType = if (f.optional) s"Option[${f.typescala}]" else f.typescala
          // TO-DO sanitizeVarname
          s"  ${f.name}: $finalType"
        }.mkString(",\n")

        s"""case class $name(\n$ccontent\n)"""
      }.mkString("\n")
    }

    def onClick(tabIndex: Int)(e: ReactEvent) {
      e.preventDefault()
      setState(State(tabIndex))
    }

    def render() = {
      val scalaCode = generatedScalaCode()

      val tabs = Vector("Pretty", "Raw")

      val tabContents = Vector(
        pre()(
          code(className="scala")(scalaCode)
        ),
        textarea(rows = 8, className = "span12", placeholder = "here is the result")(
          scalaCode
        )
      )

      form(id = "caseclassform")(
        fieldset()(
          legend()("Scala result"),
          ul(className = "nav nav-tabs")(
            tabs.zipWithIndex.map { case (name, index) =>
              val normalizedName = name.toLowerCase()

              li(className = if (state.tabIndex == index) "active" else "")(
                a(href = s"#$normalizedName", onClick = onClick(index) _ )(name)
              )
            }
          ),

          div(className = "tab-content")(
            tabContents.zipWithIndex.map { case (content, index) =>
              val normalizedName = tabs(1).toLowerCase()
              val active = if (state.tabIndex == index) "active" else ""

              div(className = s"tab-pane $active", id = normalizedName)(
               content
              )
            }
          )
        )
      )
    }
  }

  val ctor = getTypedConstructor(js.constructorOf[Component], classOf[Component])

  def apply(
      clsses: Vector[CaseClass],
      key: js.UndefOr[String] = js.undefined,
      ref: js.Function1[Component, _] = null) = {
    val props = Props(clsses)
    createElement(ctor, props, key = key, ref = ref)
  }
}