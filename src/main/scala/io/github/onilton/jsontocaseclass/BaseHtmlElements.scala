package io.github.onilton.jsontocaseclass

import scala.scalajs.js
import js.annotation.JSExport
import js.annotation.ScalaJSDefined
import js.Dynamic.{global => g}
import sri.universal.styles.UniversalStyleSheet
import sri.web.all.getTypedConstructor
import sri.web.all.createElementNoProps
import sri.web.ReactDOM
import sri.core.React
///
import sri.core.ReactElement
import sri.core.ReactNode
import sri.web.all.createStatelessFunctionElementWithChildren
import sri.web.all.createElement
import sri.core.ReactComponentPureRef
import sri.universal.components._
import org.scalajs.dom

object BaseHtmlElements {
  object fieldset {
    //val component = (props: String, children: ReactElement) => Text()(s"Hello Stateless ${props}",children)
    //  val component = (props: String, children: ReactElement) => React.createElement("fieldset", props, children)
    def apply()(children: ReactNode*) = React.createElement("fieldset", null, children: _*)
  }

  object div {
    def apply(className: String = "", id: String = "")(children: ReactNode*) =
      React.createElement("div", js.Dynamic.literal("className" -> className, "id" -> id), children: _*)
  }

  object form {
    def apply(className: String = "", id: String = "")(children: ReactNode*) =
      React.createElement("form", js.Dynamic.literal("className" -> className, "id" -> id), children: _*)
  }

  object label {
    def apply(className: String = "", id: String = "", forName: String = "")(children: ReactNode*) =
      React.createElement("label", js.Dynamic.literal("className" -> className, "id" -> id, "htmlFor" -> forName), children: _*)
  }

  object span {
    def apply(className: String = "", id: String = "")(children: ReactNode*) =
      React.createElement("span", js.Dynamic.literal("className" -> className, "id" -> id), children: _*)
  }

  object checkbox {
    case class Props(className: String = "", id: String = "", checked: Boolean = false)
    case class State(checked: Boolean = false)

    @ScalaJSDefined
    class Component extends ReactComponentPureRef[Props, State] {
      initialState(State())

      override def componentWillMount(): Unit = {
        setState(state.copy(checked = props.checked))
      }

      val changeHandler = (e: dom.Event) => {
        println("x state")
        println(state)
        setState(state.copy(checked = !state.checked))
      }

      def render() = {
        React.createElement("input",
          js.Dynamic.literal(
            "className" -> props.className,
            "id" -> props.id,
            "type" -> "checkbox",
            "checked" -> state.checked,
            "onChange" -> changeHandler),
          null)
      }
    }

    val ctor = getTypedConstructor(js.constructorOf[Component],classOf[Component])

    def apply(className: String = "", id: String = "", checked: Boolean = false) = {
      val props = Props(className, id, checked)
      createElement(ctor, props)
    }
  }

  object OTextInput {
    case class Props(className: String = "", initialValue: String = "")
    case class State(value: String = "")

    @ScalaJSDefined
    class Component extends ReactComponentPureRef[Props, State] {

      initialState(State())

      override def componentWillMount(): Unit = {
        setState(state.copy(value = props.initialValue))
      }

      val changeHandler = (e: dom.Event) => {
        println("state")
        println(state)
        println("props")
        println(props)

    //    println(props)
        setState(state.copy(value = e.target.asInstanceOf[dom.html.Input].value))
      }

      def render() = {
        React.createElement("input",
          js.Dynamic.literal(
            "className" -> props.className,
            "type" -> "text",
            "value" -> state.value,
            "onChange" -> changeHandler),
          null)
      }
    }

    val ctor = getTypedConstructor(js.constructorOf[Component],classOf[Component])

    def apply(className: String = "", initialValue: String = "") = {
      val props = Props(className, initialValue)
      createElement(ctor, props)
    }
  }

}