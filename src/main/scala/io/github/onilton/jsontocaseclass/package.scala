package io.github.onilton

package object jsontocaseclass {
  case class ClassField(
      name: String, typescala: String,
      sha: String = "", preventChange: Boolean = false,
      list: String = "", optional: Boolean = false) {
    def disabled = if (preventChange) "disabled" else ""

    def updateInnerType(innerType: String) = {
      if (list.isEmpty)
        copy(typescala = innerType)
      else
        copy(typescala = s"${list}[$innerType]")
    }
  }

  case class Alerts(errors: Vector[String] = Vector.empty, infos: Vector[String] = Vector.empty, warns:  Vector[String] = Vector.empty) {
    def includingError(error: String) = copy(errors = errors :+ error)

    def includingInfo(info: String) = copy(infos = infos :+ info)

    def includingWarn(warn: String) = copy(warns = warns :+ warn)

  }

  type CaseClass = (String, List[ClassField])
  type VCaseClass = (String, Vector[ClassField])
}