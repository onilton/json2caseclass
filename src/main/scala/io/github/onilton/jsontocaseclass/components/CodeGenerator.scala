package io.github.onilton.jsontocaseclass.components

import scala.scalajs.js
import org.querki.jquery._
import scala.scalajs.js.annotation.ScalaJSDefined
import sri.core._
import sri.web.all._
import sri.web.vdom.htmltags._
import io.github.onilton.jsontocaseclass.{ ClassField, Alerts, CaseClass}

import scala.scalajs.js.UndefOr.any2undefOrA
import scala.scalajs.js.|.from
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.JSName


object CodeGenerator {
  case class Props(
    clsses: Vector[CaseClass],
    dataChange: ((Vector[CaseClass], Vector[String], Alerts) => Unit) => Unit)
  case class State(clsses: Vector[CaseClass], shas: Vector[String], alerts: Alerts)


  @ScalaJSDefined
  class Component extends ReactComponentPureRef[Props, State] {
    initialState(State(clsses = Vector.empty, shas = Vector.empty, alerts = Alerts()))

    def updateGeneratedClass(classIndex: Int)(caseClass: CaseClass) = {
      println("Updating top")
      val (newName, fields) = caseClass

      val oldName = state.clsses(classIndex)._1
      if (newName != oldName) {
        val newClsses = state.clsses.updated(classIndex, caseClass)
        val updatedSha = state.shas(classIndex)

        val finalClsses = newClsses.map { case (name, fields) =>
          val newFields = fields.map { case field =>
            if (field.sha == updatedSha)
              field.updateInnerType(newName)
            else
              field
          }

          (name, newFields)
        }

        setState(state.copy(clsses = finalClsses))
      } else {
        setState(state.copy(clsses = state.clsses.updated(classIndex, caseClass)))
      }

    }

    def updateHandler(clsses: Vector[CaseClass], shas: Vector[String], alerts: Alerts) = {
      println("updateHandlerSomething change -> regenarte")
      setState(State(clsses.toVector, shas, alerts))
    }

    override def componentDidMount(): Unit = {
      println("componentDidMount")
      props.dataChange(updateHandler)
    }

    def render() = {
      val generatedCount = state.clsses.size

      val alertsPlace =
        div(id="alertplace")(
          state.alerts.errors.zipWithIndex.map { case (msg, id) => ErrorAlert(msg, key = id.toString()) },
          state.alerts.warns.zipWithIndex.map { case (msg, id) => WarnAlert(msg, key = id.toString()) },
          state.alerts.infos.zipWithIndex.map { case (msg, id) => InfoAlert(msg, key = id.toString()) },
          InfoAlert(s"${generatedCount} case classes generated")
        )

      val codeViewer = GeneratedCode(state.clsses)

      if (generatedCount > 0 ) {
        div(className="span12")(
          div(id = "optionzone")(
            form(className = "form-horizontal", id = "json_analisys_zone")(
              h2()("Json analysis"),
              alertsPlace,
              div(id = "classesplace")(
                state.clsses.zipWithIndex.map { case ((name, fields), id) =>
                  GeneratedClass(name, fields, updateGeneratedClass(id), id.toString)
                }
              )
            )
          ),
          codeViewer
        )
      } else {
        div(className="span12")(
          codeViewer
        )
      }
    }
  }

  val ctor = getTypedConstructor(js.constructorOf[Component], classOf[Component])

  def apply(
      clsses: Vector[CaseClass],
      dataChange: ((Vector[CaseClass], Vector[String], Alerts) => Unit) => Unit,
      key: js.UndefOr[String] = js.undefined,
      ref: js.Function1[Component, _] = null) = {
    val props = Props(clsses, dataChange)
    createElement(ctor, props, key = key, ref = ref)
  }
}