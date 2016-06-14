package io.github.onilton

import scala.scalajs.js
import scala.scalajs.js.RegExp
import scala.scalajs.js.UndefOr
import org.scalajs.dom.Node
import js.annotation._
import js.|

package object hljs {
  @js.native
  trait IHighlightResultBase extends js.Object {
    var relevance: Double = js.native
    var language: String = js.native
    var value: String = js.native
  }

  @js.native
  trait IAutoHighlightResult extends IHighlightResultBase {
    var second_best: IAutoHighlightResult = js.native
  }

  @js.native
  trait IHighlightResult extends IHighlightResultBase {
    var top: ICompiledMode = js.native
  }

  @js.native
  trait HLJSStatic extends js.Object {
    def inherit(parent: Object, obj: Object): Object = js.native
    var IDENT_RE: String = js.native
    var UNDERSCORE_IDENT_RE: String = js.native
    var NUMBER_RE: String = js.native
    var C_NUMBER_RE: String = js.native
    var BINARY_NUMBER_RE: String = js.native
    var RE_STARTERS_RE: String = js.native
    var BACKSLASH_ESCAPE: IMode = js.native
    var APOS_STRING_MODE: IMode = js.native
    var QUOTE_STRING_MODE: IMode = js.native
    var PHRASAL_WORDS_MODE: IMode = js.native
    var C_LINE_COMMENT_MODE: IMode = js.native
    var C_BLOCK_COMMENT_MODE: IMode = js.native
    var HASH_COMMENT_MODE: IMode = js.native
    var NUMBER_MODE: IMode = js.native
    var C_NUMBER_MODE: IMode = js.native
    var BINARY_NUMBER_MODE: IMode = js.native
    var CSS_NUMBER_MODE: IMode = js.native
    var REGEX_MODE: IMode = js.native
    var TITLE_MODE: IMode = js.native
    var UNDERSCORE_TITLE_MODE: IMode = js.native
  }

  @js.native
  trait IModeBase extends js.Object {
    var className: String = js.native
    var aliases: js.Array[String] = js.native
    var begin: String | RegExp = js.native
    var end: String | RegExp = js.native
    var case_insensitive: Boolean = js.native
    var beginKeyword: String = js.native
    var endsWithParent: Boolean = js.native
    var lexems: String = js.native
    var illegal: String = js.native
    var excludeBegin: Boolean = js.native
    var excludeEnd: Boolean = js.native
    var returnBegin: Boolean = js.native
    var returnEnd: Boolean = js.native
    var starts: String = js.native
    var subLanguage: String = js.native
    var subLanguageMode: String = js.native
    var relevance: Double = js.native
    var variants: js.Array[IMode] = js.native
  }

  @js.native
  trait IMode extends IModeBase {
    var keywords: js.Any = js.native
    var contains: js.Array[IMode] = js.native
  }

  @js.native
  trait ICompiledMode extends IModeBase {
    var compiled: Boolean = js.native
    var contains: js.Array[ICompiledMode] = js.native
    var keywords: Object = js.native
    var terminators: RegExp = js.native
    var terminator_end: String = js.native
  }

  @js.native
  trait IOptions extends js.Object {
    var classPrefix: String = js.native
    var tabReplace: String = js.native
    var useBR: Boolean = js.native
    var languages: js.Array[String] = js.native
  }

  @JSName("hljs")
  @js.native
  object Hljs extends js.Object {
    def highlight(name: String, value: String, ignore_illegals: UndefOr[Boolean] = js.undefined, continuation: UndefOr[Boolean] = js.undefined): IHighlightResult = js.native
    def highlightAuto(value: String, languageSubset: UndefOr[js.Array[String]] = js.undefined): IAutoHighlightResult = js.native
    def fixMarkup(value: String): String = js.native
    def highlightBlock(block: Node): Unit = js.native
    def configure(options: IOptions): Unit = js.native
    def initHighlighting(): Unit = js.native
    def initHighlightingOnLoad(): Unit = js.native
    def registerLanguage(name: String, language: js.Function1[HLJSStatic, IModeBase]): Unit = js.native
    def listLanguages(): js.Array[String] = js.native
    def getLanguage(name: String): IMode = js.native
    def inherit(parent: Object, obj: Object): Object = js.native
    def COMMENT(begin: String | RegExp, end: String | RegExp, inherits: IModeBase): IMode = js.native
    var IDENT_RE: String = js.native
    var UNDERSCORE_IDENT_RE: String = js.native
    var NUMBER_RE: String = js.native
    var C_NUMBER_RE: String = js.native
    var BINARY_NUMBER_RE: String = js.native
    var RE_STARTERS_RE: String = js.native
    var BACKSLASH_ESCAPE: IMode = js.native
    var APOS_STRING_MODE: IMode = js.native
    var QUOTE_STRING_MODE: IMode = js.native
    var PHRASAL_WORDS_MODE: IMode = js.native
    var C_LINE_COMMENT_MODE: IMode = js.native
    var C_BLOCK_COMMENT_MODE: IMode = js.native
    var HASH_COMMENT_MODE: IMode = js.native
    var NUMBER_MODE: IMode = js.native
    var C_NUMBER_MODE: IMode = js.native
    var BINARY_NUMBER_MODE: IMode = js.native
    var CSS_NUMBER_MODE: IMode = js.native
    var REGEX_MODE: IMode = js.native
    var TITLE_MODE: IMode = js.native
    var UNDERSCORE_TITLE_MODE: IMode = js.native
  }

}
