package io.github.onilton.jsontocaseclass

import scala.scalajs.js
import js.annotation.JSExport
import js.Dynamic.{global => g}
import org.scalajs.dom
import org.querki.jquery._
import scala.scalajs.js.JSON
import scala.util.control.NonFatal
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.UndefOrOps


@js.native
trait Underscore extends js.Object {
  def keys(x: js.Dynamic): js.Dynamic = js.native
  def values(x: js.Dynamic): js.Dynamic = js.native

  def map(x: js.Dynamic, f: js.Function1[js.Dynamic, Any]): Underscore = js.native
  def map(x: js.Dynamic, f: js.Function3[js.Dynamic, js.Dynamic, js.Dynamic, Any], c: js.Dynamic): Underscore = js.native

  //_.each(o, function(value, key, list){
  def each(x: js.Dynamic, f: js.Function3[js.Dynamic, js.Dynamic, js.Dynamic, Any]): Unit = js.native
  def each(x: js.Dynamic, f: js.Function3[js.Dynamic, js.Dynamic, js.Dynamic, Any], context: js.Dynamic): Unit = js.native
  def every(x: js.Dynamic, f: js.Function, context: js.Dynamic): Boolean = js.native

  def sort(): Underscore = js.native
  def join(x: String): String = js.native
  def size(x: js.Dynamic): Int = js.native
  def isObject(x: js.Dynamic): Boolean = js.native
  def isString(x: js.Dynamic): Boolean = js.native
  def isNumber(x: js.Dynamic): Boolean = js.native
  def isBoolean(x: js.Dynamic): Boolean = js.native
  def isArray(x: js.Dynamic): Boolean = js.native
  def isDate(x: js.Dynamic): Boolean = js.native
}

@JSName("_")
@js.native
object _u extends Underscore

object Jsontocaseclass extends js.JSApp {
  def main(): Unit = {
    $("#caseclassform textarea").change( (e: org.querki.jquery.JQueryEventObject) => {
      val finalCode = $(e.target).value().asInstanceOf[String]
      $("#mycodeis").html(t.scala_code(finalCode))
      g.sh_highlightDocument()
    })

    $("#test_button").click(() => {
      $("#pastejsonform textarea").value("""[{"coordinates":null,"favorited":false,"truncated":false,"created_at":"Mon Sep 03 13:24:14 +0000 2012","id_str":"242613977966850048","entities":{"urls":[],"hashtags":[],"user_mentions":[{"name":"Jason Costa","id_str":"14927800","id":14927800,"indices":[0,11],"screen_name":"jasoncosta"},{"name":"Matt Harris","id_str":"777925","id":777925,"indices":[12,26],"screen_name":"themattharris"},{"name":"ThinkWall","id_str":"117426578","id":117426578,"indices":[109,119],"screen_name":"thinkwall"}]},"in_reply_to_user_id_str":"14927800","contributors":null,"text":"@jasoncosta @themattharris Hey! Going to be in Frisco in October. Was hoping to have a meeting to talk about @thinkwall if you're around?","retweet_count":0,"in_reply_to_status_id_str":null,"id":242613977966850048,"geo":null,"retweeted":false,"in_reply_to_user_id":14927800,"place":null,"user":{"profile_sidebar_fill_color":"EEEEEE","profile_sidebar_border_color":"000000","profile_background_tile":false,"name":"Andrew Spode Miller","profile_image_url":"http://a0.twimg.com/profile_images/1227466231/spode-balloon-medium_normal.jpg","created_at":"Mon Sep 22 13:12:01 +0000 2008","location":"London via Gravesend","follow_request_sent":false,"profile_link_color":"F31B52","is_translator":false,"id_str":"16402947","entities":{"url":{"urls":[{"expanded_url":null,"url":"http://www.linkedin.com/in/spode","indices":[0,32]}]},"description":{"urls":[]}},"default_profile":false,"contributors_enabled":false,"favourites_count":16,"url":"http://www.linkedin.com/in/spode","profile_image_url_https":"https://si0.twimg.com/profile_images/1227466231/spode-balloon-medium_normal.jpg","utc_offset":0,"id":16402947,"profile_use_background_image":false,"listed_count":129,"profile_text_color":"262626","lang":"en","followers_count":2013,"protected":false,"notifications":null,"profile_background_image_url_https":"https://si0.twimg.com/profile_background_images/16420220/twitter-background-final.png","profile_background_color":"FFFFFF","verified":false,"geo_enabled":true,"time_zone":"London","description":"Co-Founder/Dev (PHP/jQuery) @justFDI. Run @thinkbikes and @thinkwall for events. Ex tech journo, helps run @uktjpr. Passion for Linux and customises everything.","default_profile_image":false,"profile_background_image_url":"http://a0.twimg.com/profile_background_images/16420220/twitter-background-final.png","statuses_count":11550,"friends_count":770,"following":null,"show_all_inline_media":true,"screen_name":"spode"},"in_reply_to_screen_name":"jasoncosta","source":"<a href=\"http://www.journotwit.com\" rel=\"nofollow\">JournoTwit</a>","in_reply_to_status_id":null},{"coordinates":{"coordinates":[121.0132101,14.5191613],"type":"Point"},"favorited":false,"truncated":false,"created_at":"Mon Sep 03 08:08:02 +0000 2012","id_str":"242534402280783873","entities":{"urls":[],"hashtags":[{"text":"twitter","indices":[49,57]}],"user_mentions":[{"name":"Jason Costa","id_str":"14927800","id":14927800,"indices":[14,25],"screen_name":"jasoncosta"}]},"in_reply_to_user_id_str":null,"contributors":null,"text":"Got the shirt @jasoncosta thanks man! Loving the #twitter bird on the shirt :-)","retweet_count":0,"in_reply_to_status_id_str":null,"id":242534402280783873,"geo":{"coordinates":[14.5191613,121.0132101],"type":"Point"},"retweeted":false,"in_reply_to_user_id":null,"place":null,"user":{"profile_sidebar_fill_color":"EFEFEF","profile_sidebar_border_color":"EEEEEE","profile_background_tile":true,"name":"Mikey","profile_image_url":"http://a0.twimg.com/profile_images/1305509670/chatMikeTwitter_normal.png","created_at":"Fri Jun 20 15:57:08 +0000 2008","location":"Singapore","follow_request_sent":false,"profile_link_color":"009999","is_translator":false,"id_str":"15181205","entities":{"url":{"urls":[{"expanded_url":null,"url":"http://about.me/michaelangelo","indices":[0,29]}]},"description":{"urls":[]}},"default_profile":false,"contributors_enabled":false,"favourites_count":11,"url":"http://about.me/michaelangelo","profile_image_url_https":"https://si0.twimg.com/profile_images/1305509670/chatMikeTwitter_normal.png","utc_offset":28800,"id":15181205,"profile_use_background_image":true,"listed_count":61,"profile_text_color":"333333","lang":"en","followers_count":577,"protected":false,"notifications":null,"profile_background_image_url_https":"https://si0.twimg.com/images/themes/theme14/bg.gif","profile_background_color":"131516","verified":false,"geo_enabled":true,"time_zone":"Hong Kong","description":"Android Applications Developer,  Studying Martial Arts, Plays MTG, Food and movie junkie","default_profile_image":false,"profile_background_image_url":"http://a0.twimg.com/images/themes/theme14/bg.gif","statuses_count":11327,"friends_count":138,"following":null,"show_all_inline_media":true,"screen_name":"mikedroid"},"in_reply_to_screen_name":null,"source":"<a href=\"http://twitter.com/download/android\" rel=\"nofollow\">Twitter for Android</a>","in_reply_to_status_id":null}]""")
      $("#pastejsonform").submit()
    })

    $("#test_button2").click(() => {
      $("#pastejsonform textarea").value("""{"results":[{"address_components":[{"long_name":"1600","short_name":"1600","types":["street_number"]},{"long_name":"Amphitheatre Pkwy","short_name":"Amphitheatre Pkwy","types":["route"]},{"long_name":"Mountain View","short_name":"Mountain View","types":["locality","political"]},{"long_name":"Santa Clara","short_name":"Santa Clara","types":["administrative_area_level_2","political"]},{"long_name":"California","short_name":"CA","types":["administrative_area_level_1","political"]},{"long_name":"United States","short_name":"US","types":["country","political"]},{"long_name":"94043","short_name":"94043","types":["postal_code"]}],"formatted_address":"1600 Amphitheatre Pkwy, Mountain View, CA 94043, USA","geometry":{"location":{"lat":37.42291810,"lng":-122.08542120},"location_type":"ROOFTOP","viewport":{"northeast":{"lat":37.42426708029149,"lng":-122.0840722197085},"southwest":{"lat":37.42156911970850,"lng":-122.0867701802915}}},"types":["street_address"]}],"status":"OK"}""")
      $("#pastejsonform").submit()
    })

    $("#pastejsonform").submit((el: dom.Element, e: org.querki.jquery.JQueryEventObject) => {
      e.preventDefault()
      $("#optionzone").html("""<form class="form-horizontal" id="json_analisys_zone">"""
         +"""                 <h2>Json analysis</h2>"""
         +"""                 <div id="alertplace"></div>"""
         +"""                 <div id="classesplace"></div>"""
         +"""                 <button type="submit" class=" pull-right btn btn-primary"><i class="icon-cogs"></i> re-generate</button>"""
         +"                 </form>")

      $("#json_analisys_zone").submit((el: dom.Element, e: org.querki.jquery.JQueryEventObject) => {
          re_generate_scala(e.asInstanceOf[js.Dynamic])
      })

      val raw_json = $(e.target).find("textarea").value().asInstanceOf[String]

      val parsedJson =
        try {
          JSON.parse(raw_json)
        }
        catch {
          case NonFatal(e) => $("#alertplace").append(t.error("The json root is invalid..."))
          throw e
          //return 1
        }

      val o = parsedJson match {
        case a: js.Array[_] =>
          println("array")
          $("#alertplace").append(t.alert("The json root is an array, only the first entity will be analyse..."))
          a.head
        case a: js.Object => println("object") ; a
        case _ =>
          $("#alertplace").append(t.error("The json root is not an object, cannot do anything for you..."))
          throw new Exception("Not an Object or Array")
      }

      analyse_object(o.asInstanceOf[js.Object], "r00tJsonObject")

      $("#alertplace").append(t.info($("#classesplace div.one_class").length+" case class generated"))

      /* This may be redudant, according some tests of mine */
      $("input.class_name").each({ (el: dom.Element, i: Int) =>
        maj_name(js.Dynamic.literal("target" -> el))
      }: js.ThisFunction1[dom.Element, Int, Any])

      generate_scala($("#classesplace").asInstanceOf[js.Dynamic])

      $("input.class_name").change({ (e: JQueryEventObject) =>
        maj_name(e.asInstanceOf[js.Dynamic])
      })

      $("#classesplace input").change({ (e: JQueryEventObject) =>
        re_generate_scala(e.asInstanceOf[js.Dynamic])
      })
    })
  }

  // HERE CAN BE SOME CONFIG PLACE

  val scala_words = List("abstract", "case", "catch", "class", "def", "do", "else", "extends", "false", "final", "finally", "for", "forSome", "if", "implicit", "import", "lazy", "match", "new", "null", "object", "override", "package", "private", "protected", "return", "sealed", "super", "this", "throw", "trait", "try", "true", "type", "val", "var", "while", "with", "yield")
  val scala_chars = List("-", "_")
  val scala_types = List("List", "Type", "Meta", "Result") ++ (for {
    oname <- scala_words
  } yield (oname.capitalize))

  case class ClassField(name: String, typescala: String, sha: String = "", preventChange: Boolean = false, list: String = "") {
    def disabled = if (preventChange) "disabled" else ""
  }

  def analyse_object(o: js.Object, oname2: String) {
    val oname = generate_name(oname2)
    val sign = generate_signature(o.asInstanceOf[js.Dynamic])
    if ($("#class_" + sign).length > 0) {
      // println("class already analyse")
    } else {
      val elem = $(t.one_class(oname, sign.asInstanceOf[String]))
      val elem_u = elem.find("div.ul")

      val obj = o.asInstanceOf[js.Dictionary[Any]]

      if (obj.keys.size > 22) {
        $("#alertplace").append(t.error("the " + oname + " class is exceding 22 fields, generated but it will not work, due to the Product arity limitation"))
      }

      obj.foreach({
        case (key: String, dvalue: Any) =>
          val field = ClassField(key, "String")

          val finalField = dvalue match {
            case _: String  => field.copy(typescala = "String")
            case _: Double  => field.copy(typescala = "Double")
            case _: Boolean => field.copy(typescala = "Boolean")
            case _: js.Date => field.copy(typescala = "Date")
            case value: js.Array[_] =>
              if (is_value_consistent(value.asInstanceOf[js.Dynamic])) {
                val listField = field.copy(list = "List", preventChange = true)
                val generated_ts = generate_name(listField.list + "[" + generate_name(key) + "]")

                if (value.isEmpty) {
                  $("#alertplace").append(t.error("the " + oname + " " + key + " field is an empty array : cannot analyse :-("))
                  listField.copy(typescala = generated_ts)
                } else {
                  val head: Any = value.head
                  head match {
                    case vv: js.Object =>
                      val sha = generate_signature_collection(value.asInstanceOf[js.Dynamic]).asInstanceOf[String]
                      analyse_object(vv, key)
                      listField.copy(typescala = generated_ts, sha = sha)
                    case vv =>
                      val ts2 = vv match {
                        case _: String  => "String"
                        case _: Double  => "Double"
                        case _: Boolean => "Boolean"
                        case _: js.Date => "Date"
                        case _          => "String"
                      }

                      val ts = generate_name(listField.list + "[" + ts2 + "]")
                      listField.copy(typescala = ts, preventChange = false)
                  }
                }
              } else {
                $("#alertplace").append(t.error("the " + oname + " " + key + " field is prentending an array but not consistent"))
                field // If value is not consistent, just return String field
              }
            case value: js.Object =>
              val sha = generate_signature(value.asInstanceOf[js.Dynamic]).asInstanceOf[String]
              analyse_object(value, key)
              field.copy(typescala = generate_name(key), preventChange = true, sha = sha)
            case _ => field // last resort, just return String field
          }
          val f = finalField
          elem_u.append(t.one_line(key, f.typescala, f.sha, f.disabled, f.list, oname))

        case (key: String, _) =>
          // when we have null as field value, treat as string
          val f = ClassField(key, "String")
          elem_u.append(t.one_line(key, f.typescala, f.sha, f.disabled, f.list, oname))
      })

      elem.append(t.info(elem_u.find(".li").length + " fields"))

      $("#classesplace").append(elem)
    }

}

  def sanitize_var_name(name: String): String = {
    /* java's String.matches all input data */
    if (name.matches("[_a-zA-Z0-9]+") && !scala_words.contains(name)) { // !_.contains(scala_words, name)){
      return name
    } else {
      return '`' + name + '`'
    }
  }

  def generate_scala(el: js.Dynamic): Unit = {
    var content = ""

    _u.each(el.find(".one_class"), (ovalue: js.Dynamic, key: js.Dynamic, list: js.Dynamic) => {
       var value = $(ovalue.asInstanceOf[dom.Element])
       var props = _u.map(value.find(".li").asInstanceOf[js.Dynamic], { (ov: js.Dynamic, k: js.Dynamic, l: js.Dynamic) =>
          var v = $(ov.asInstanceOf[dom.Element])
          var sst = v.find("input.typescala").value().asInstanceOf[String]
           if (v.find("""input.optional_value[type="checkbox"]""").prop("checked").orNull.asInstanceOf[Boolean]) {
              sst = "Option["+sst+"]"
           }
          //return keyword do not work as expected :P
          "  " + sanitize_var_name(v.find("label.keyname").text()) + ": " + sst
       }, this.asInstanceOf[js.Dynamic])
       content += t.one_scala_cclass(value.find("input.class_name").value().asInstanceOf[String], props.join(",\n")) + "\n"
    }, this.asInstanceOf[js.Dynamic])

    $("#caseclassform textarea").value(content)
    $("#mycodeis").html(t.scala_code(content))

    g.sh_highlightDocument()
  }

  def maj_name(e: js.Dynamic) = {
    var elem = $(e.target.asInstanceOf[org.querki.jquery.JQueryEventObject])
    var tochange = $("""div.ul input[data-signature-class="""" + elem.attr("data-signature-class") + """"]""")
    tochange.filter("""input[data-list=""]""").value(elem.value().asInstanceOf[String])
    tochange.filter("""input[data-list="List"]""").each({ (el: dom.Element) =>
      var ee = $(el)
      ee.value(ee.attr("data-list") + "[" + elem.value() + "]")
    }: js.ThisFunction0[dom.Element, Any])

    tochange.filter("""input[data-list="Map"]""").each({ (el: dom.Element) =>
      var ee = $(el)
      ee.value(ee.attr("data-list") + "[Map," + elem.value() + "]")
    }: js.ThisFunction0[dom.Element, Any])
  }

  def re_generate_scala(e: js.Dynamic) {
      e.preventDefault()
      generate_scala($("#classesplace").asInstanceOf[js.Dynamic])
  }

  def is_value_consistent(o: js.Dynamic): Boolean = {
    if (_u.size(o) == 0) {
      return true
    } else {
      val newO = if (!_u.isArray(o)) _u.values(o) else o
      var n = dynToArray(o)(0)
      var nn = if (_u.isObject(n)) generate_signature(n) else js.typeOf(n)
      return _u.every(o, (n: js.Dynamic) => if (_u.isObject(n)) generate_signature(n) else js.typeOf(n) == nn, this.asInstanceOf[js.Dynamic])
    }
  }

  def generate_signature_collection(o: js.Dynamic): js.Dynamic = {
   if(_u.size(o) == 0) {
      return 0.asInstanceOf[js.Dynamic]
   } else {
     val newO = if(!_u.isArray(o)) _u.values(o) else o
     return generate_signature(dynToArray(newO)(0))
   }
  }

  def dynToArray(o: js.Dynamic): js.Array[js.Dynamic] = o.asInstanceOf[js.Array[js.Dynamic]]

  def generate_signature(o: js.Dynamic) = {
    if (_u.isObject(o)) {
       val finalArray = _u.map(_u.keys(o), (n: js.Dynamic) => n.toLowerCase() )
       val finalString = finalArray.sort().join("|")
       js.Dynamic.global.SHA1(finalString)
    } else {
       js.Dynamic.global.SHA1(_u.map(o, (n: js.Dynamic) => js.typeOf(n)).sort().join("|"))
    }
  }

  def generate_name(oname: String) = {
    val newOname = oname.capitalize
    if (scala_types.contains(newOname))
      newOname + "Bis"
    else
      newOname
  }

  object t {
    def alert(value: String) = s"""<div class="alert">
      <button type="button" class="close" data-dismiss="alert">&times;</button>
      <i class="icon-warning-sign"></i> $value
      </div>"""
    def error(value: String) =  s"""<div class="alert alert-error">
      <button type="button" class="close" data-dismiss="alert">&times;</button>
      <i class="icon-warning-sign"></i> $value
      </div>"""
    def info(value: String) = s"""<div class="alert alert-info">
      <button type="button" class="close" data-dismiss="alert">&times;</button>
      $value
      </div>"""
    def one_line(name: String, typescala: String, sha: String, disabled: String, list: String, oname: String) =
      s"""<div class="li control-group">
      <label class="keyname control-label">$name</label>
      <div class="controls">
      <div class="input-append"><input class="typescala" $disabled type="text" data-signature-class="$sha" data-list="$list" value="$typescala" />
       <span class="add-on">
         <input class="optional_value" type="checkbox" value="" id="chkb_${oname}_$name" /><label class="label_chkbr" for="chkb_${oname}_$name"> optional</label>
       </span>
      </div>
      </div>
      </div>
      """
    def one_class(oname: String, sha: String) = s"""<div id="class_$sha" class="one_class">
      <fieldset>
      <div class="class_title"><i class="icon-leaf"></i> <input class="class_name" data-signature-class="$sha" type="text" value="$oname" /></div>
      <div class="ul"></div>
      </fieldset>
      </div>"""

    def one_scala_cclass(cname: String, ccontent: String) = s"""case class $cname(\n$ccontent\n)"""
    //one_scala_props : _.template('<%= pname %>\:<%= ptype %>'),
    def scala_code(code: String) = s"""<pre class="sh_scala">$code</pre>"""
  }

}
