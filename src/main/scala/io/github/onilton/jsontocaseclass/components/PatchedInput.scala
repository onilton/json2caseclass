package io.github.onilton.jsontocaseclass.components

import scala.scalajs.js
import scala.scalajs.LinkingInfo.developmentMode
import scala.scalajs.js.`|`
import scala.scalajs.js.{UndefOr => U, undefined => undefined}
import scala.reflect.ClassTag
import scala.scalajs.js.Dynamic.{literal => json}

import org.scalajs.dom

import sri.core._
import sri.web.vdom.{ addJsObjects, inlineReactElement }
import sri.web.SyntheticEvent


/* This is our workaround for the bug with
 * value: U[String | Int | Double] = undefined,
 */
object PatchedInput {
  /* this works here, but not in the general case!
   *  (see https://github.com/scala-js/scala-js/pull/2070 )
   */
  // TODO We need to find a better solution here
  implicit def UnionEvidence[A: ClassTag, B: ClassTag](ab: A | B)(implicit eva: A => js.Any, evb: B => js.Any): js.Any =
    ab match {
      case a: A => eva(a)
      case b: B => evb(b)
    }

  def input(
             name: U[String] = undefined,
             formNoValidate: U[Boolean] = undefined,
             tabIndex: U[Int] = undefined,
             is: U[String] = undefined,
             accept: U[String] = undefined,
             step: U[String] = undefined,
             classID: U[String] = undefined,
             size: U[Int] = undefined,
             readOnly: U[Boolean] = undefined,
             pattern: U[String] = undefined,
             contentEditable: U[String] = undefined,
             role: U[String] = undefined,
             checked: U[String] = undefined,
             style: U[js.Any] = undefined,
             hidden: U[Boolean] = undefined,
             height: U[Int] = undefined,
             min: U[Double] = undefined,
             ref: U[(_ <: dom.html.Element) => _] = undefined,
             placeholder: U[String] = undefined,
             inputMode: U[String] = undefined,
             autoFocus: U[Boolean] = undefined,
             key: U[String | Int] = undefined,
             formTarget: U[String] = undefined,
             htmlFor: U[String] = undefined,
             dir: U[String] = undefined,
             id: U[String] = undefined,
             autoComplete: U[String] = undefined,
             max: U[Double] = undefined,
             draggable: U[Boolean] = undefined,
             alt: U[String] = undefined,
             formMethod: U[String] = undefined,
             accessKey: U[String] = undefined,
             className: U[String] = undefined,
             src: U[String] = undefined,
             disabled: U[Boolean] = undefined,
             minLength: U[Int] = undefined,
             spellCheck: U[Boolean] = undefined,
             formEncType: U[String] = undefined,
             multiple: U[Boolean] = undefined,
             title: U[String] = undefined,
             lang: U[String] = undefined,
             `type`: U[String] = undefined,
             form: U[String] = undefined,
             required: U[Boolean] = undefined,
             capture: U[Boolean] = undefined,
             width: U[Int] = undefined,
             value: U[String | Int] = undefined,
//             value: U[String | Int | Double] = undefined,
             maxLength: U[Int] = undefined,
             contextMenu: U[String] = undefined,
             formAction: U[String] = undefined,
             list: U[String] = undefined,
             onCompositionStart: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onPaste: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onTouchEnd: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onAnimationStart: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onDrop: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onDragEnter: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onContextMenu: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onDoubleClick: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onDragOver: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onSubmit: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onMouseLeave: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onClick: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onSelect: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onInput: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onCompositionEnd: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onKeyDown: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onBlur: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onMouseMove: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onDragEnd: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onDragLeave: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onDragExit: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onTouchMove: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onCopy: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onMouseDown: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onChange: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onWheel: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onAnimationIteration: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onFocus: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onKeyUp: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onMouseEnter: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onTouchCancel: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onCompositionUpdate: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onAnimationEnd: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onTouchStart: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onDragStart: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onKeyPress: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onScroll: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onDrag: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onMouseUp: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onTransitionEnd: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             onCut: U[(_ <: SyntheticEvent[_]) => _] = undefined,
             extraAttributes: U[js.Object] = undefined) = {
    val props = json()
    onKeyDown.foreach(v => props.updateDynamic("onKeyDown")(v))
    formMethod.foreach(v => props.updateDynamic("formMethod")(v))
    min.foreach(v => props.updateDynamic("min")(v))
    onMouseUp.foreach(v => props.updateDynamic("onMouseUp")(v))
    onTouchCancel.foreach(v => props.updateDynamic("onTouchCancel")(v))
    onCompositionUpdate.foreach(v => props.updateDynamic("onCompositionUpdate")(v))
    onDragStart.foreach(v => props.updateDynamic("onDragStart")(v))
    formAction.foreach(v => props.updateDynamic("formAction")(v))
    onInput.foreach(v => props.updateDynamic("onInput")(v))
    onPaste.foreach(v => props.updateDynamic("onPaste")(v))
    onBlur.foreach(v => props.updateDynamic("onBlur")(v))
    inputMode.foreach(v => props.updateDynamic("inputMode")(v))
    minLength.foreach(v => props.updateDynamic("minLength")(v))
    max.foreach(v => props.updateDynamic("max")(v))
    onDragOver.foreach(v => props.updateDynamic("onDragOver")(v))
    autoFocus.foreach(v => props.updateDynamic("autoFocus")(v))
    onDragEnd.foreach(v => props.updateDynamic("onDragEnd")(v))
    autoComplete.foreach(v => props.updateDynamic("autoComplete")(v))
    onScroll.foreach(v => props.updateDynamic("onScroll")(v))
    title.foreach(v => props.updateDynamic("title")(v))
    onMouseDown.foreach(v => props.updateDynamic("onMouseDown")(v))
    onAnimationStart.foreach(v => props.updateDynamic("onAnimationStart")(v))
    list.foreach(v => props.updateDynamic("list")(v))
    onMouseMove.foreach(v => props.updateDynamic("onMouseMove")(v))
    onWheel.foreach(v => props.updateDynamic("onWheel")(v))
    width.foreach(v => props.updateDynamic("width")(v))
    maxLength.foreach(v => props.updateDynamic("maxLength")(v))
    contentEditable.foreach(v => props.updateDynamic("contentEditable")(v))
    value.foreach(v => props.updateDynamic("value")(v))
    onAnimationIteration.foreach(v => props.updateDynamic("onAnimationIteration")(v))
    size.foreach(v => props.updateDynamic("size")(v))
    spellCheck.foreach(v => props.updateDynamic("spellCheck")(v))
    draggable.foreach(v => props.updateDynamic("draggable")(v))
    checked.foreach(v => props.updateDynamic("checked")(v))
    onTransitionEnd.foreach(v => props.updateDynamic("onTransitionEnd")(v))
    alt.foreach(v => props.updateDynamic("alt")(v))
    role.foreach(v => props.updateDynamic("role")(v))
    onAnimationEnd.foreach(v => props.updateDynamic("onAnimationEnd")(v))
    is.foreach(v => props.updateDynamic("is")(v))
    step.foreach(v => props.updateDynamic("step")(v))
    onDrag.foreach(v => props.updateDynamic("onDrag")(v))
    lang.foreach(v => props.updateDynamic("lang")(v))
    formEncType.foreach(v => props.updateDynamic("formEncType")(v))
    onSubmit.foreach(v => props.updateDynamic("onSubmit")(v))
    onDragExit.foreach(v => props.updateDynamic("onDragExit")(v))
    name.foreach(v => props.updateDynamic("name")(v))
    pattern.foreach(v => props.updateDynamic("pattern")(v))
    onCopy.foreach(v => props.updateDynamic("onCopy")(v))
    onDragEnter.foreach(v => props.updateDynamic("onDragEnter")(v))
    onSelect.foreach(v => props.updateDynamic("onSelect")(v))
    readOnly.foreach(v => props.updateDynamic("readOnly")(v))
    id.foreach(v => props.updateDynamic("id")(v))
    src.foreach(v => props.updateDynamic("src")(v))
    onCompositionEnd.foreach(v => props.updateDynamic("onCompositionEnd")(v))
    onChange.foreach(v => props.updateDynamic("onChange")(v))
    formNoValidate.foreach(v => props.updateDynamic("formNoValidate")(v))
    contextMenu.foreach(v => props.updateDynamic("contextMenu")(v))
    hidden.foreach(v => props.updateDynamic("hidden")(v))
    key.foreach(v => props.updateDynamic("key")(v))
    onClick.foreach(v => props.updateDynamic("onClick")(v))
    classID.foreach(v => props.updateDynamic("classID")(v))
    style.foreach(v => props.updateDynamic("style")(v))
    tabIndex.foreach(v => props.updateDynamic("tabIndex")(v))
    multiple.foreach(v => props.updateDynamic("multiple")(v))
    onTouchMove.foreach(v => props.updateDynamic("onTouchMove")(v))
    placeholder.foreach(v => props.updateDynamic("placeholder")(v))
    accessKey.foreach(v => props.updateDynamic("accessKey")(v))
    onKeyUp.foreach(v => props.updateDynamic("onKeyUp")(v))
    onDrop.foreach(v => props.updateDynamic("onDrop")(v))
    ref.foreach(v => props.updateDynamic("ref")(v))
    htmlFor.foreach(v => props.updateDynamic("htmlFor")(v))
    onMouseEnter.foreach(v => props.updateDynamic("onMouseEnter")(v))
    onTouchEnd.foreach(v => props.updateDynamic("onTouchEnd")(v))
    onFocus.foreach(v => props.updateDynamic("onFocus")(v))
    onContextMenu.foreach(v => props.updateDynamic("onContextMenu")(v))
    height.foreach(v => props.updateDynamic("height")(v))
    dir.foreach(v => props.updateDynamic("dir")(v))
    onTouchStart.foreach(v => props.updateDynamic("onTouchStart")(v))
    required.foreach(v => props.updateDynamic("required")(v))
    form.foreach(v => props.updateDynamic("form")(v))
    className.foreach(v => props.updateDynamic("className")(v))
    disabled.foreach(v => props.updateDynamic("disabled")(v))
    onKeyPress.foreach(v => props.updateDynamic("onKeyPress")(v))
    `type`.foreach(v => props.updateDynamic("type")(v))
    onCompositionStart.foreach(v => props.updateDynamic("onCompositionStart")(v))
    capture.foreach(v => props.updateDynamic("capture")(v))
    onDoubleClick.foreach(v => props.updateDynamic("onDoubleClick")(v))
    formTarget.foreach(v => props.updateDynamic("formTarget")(v))
    onMouseLeave.foreach(v => props.updateDynamic("onMouseLeave")(v))
    onDragLeave.foreach(v => props.updateDynamic("onDragLeave")(v))
    onCut.foreach(v => props.updateDynamic("onCut")(v))
    accept.foreach(v => props.updateDynamic("accept")(v))
    if (extraAttributes.isDefined && extraAttributes != null) addJsObjects(props, extraAttributes.get)
    if (developmentMode) React.createElement("input", props)
    else inlineReactElement("input", props)
  }

}

//object SimpleInput {
//  case class Props(pretty: String = "anything")
//
//  @ScalaJSDefined
//  class Component extends ReactComponentPureRefP[Props] {
//
//    def render() = {
//      input(id = "something", `type` = "text", value = "anything")
//  //   input(id = "something")
//    }
//  }
//
//  val ctor = getTypedConstructor(js.constructorOf[Component], classOf[Component])
//
//
//  def apply(props: Props, key: js.UndefOr[String] = js.undefined) =  {
//    createElement(ctor, props, key = key)
//  }
//}