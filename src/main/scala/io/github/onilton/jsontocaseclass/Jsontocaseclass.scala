package io.github.onilton.jsontocaseclass

import scala.scalajs.js
import js.annotation.JSExport
import js.Dynamic.{global => g}
import org.scalajs.dom
import org.querki.jquery._
import scala.scalajs.js.JSON
import scala.util.control.NonFatal
import sri.web.ReactDOM
import components.CodeGenerator
import scala.collection.immutable.ListSet

object Jsontocaseclass extends js.JSApp {
  var alerts = Alerts()
  var generatedShas = ListSet.empty[String]
  var generatedClses: Vector[(String, Vector[ClassField])] = Vector.empty
  var changed = false

  /* Temporary callback/hack to get info from the input that is not in react */
  def regenerate(callback: (Vector[(String, Vector[ClassField])], Vector[String], Alerts) => Unit) {
    if (changed) {
      changed = false
      println("Something change -> regenarte")
      callback(generatedClses, generatedShas.toVector.reverse, alerts)
    }

    js.timers.setTimeout(500) {
      regenerate(callback)
    }
  }

  @JSExport
  override def main(): Unit = {
    val eleme = dom.document.getElementById("app")
    println(eleme.outerHTML)

    $("#test_button").click(() => {
      $("#pastejsonform textarea").value("""[{"coordinates":null,"favorited":false,"truncated":false,"created_at":"Mon Sep 03 13:24:14 +0000 2012","id_str":"242613977966850048","entities":{"urls":[],"hashtags":[],"user_mentions":[{"name":"Jason Costa","id_str":"14927800","id":14927800,"indices":[0,11],"screen_name":"jasoncosta"},{"name":"Matt Harris","id_str":"777925","id":777925,"indices":[12,26],"screen_name":"themattharris"},{"name":"ThinkWall","id_str":"117426578","id":117426578,"indices":[109,119],"screen_name":"thinkwall"}]},"in_reply_to_user_id_str":"14927800","contributors":null,"text":"@jasoncosta @themattharris Hey! Going to be in Frisco in October. Was hoping to have a meeting to talk about @thinkwall if you're around?","retweet_count":0,"in_reply_to_status_id_str":null,"id":242613977966850048,"geo":null,"retweeted":false,"in_reply_to_user_id":14927800,"place":null,"user":{"profile_sidebar_fill_color":"EEEEEE","profile_sidebar_border_color":"000000","profile_background_tile":false,"name":"Andrew Spode Miller","profile_image_url":"http://a0.twimg.com/profile_images/1227466231/spode-balloon-medium_normal.jpg","created_at":"Mon Sep 22 13:12:01 +0000 2008","location":"London via Gravesend","follow_request_sent":false,"profile_link_color":"F31B52","is_translator":false,"id_str":"16402947","entities":{"url":{"urls":[{"expanded_url":null,"url":"http://www.linkedin.com/in/spode","indices":[0,32]}]},"description":{"urls":[]}},"default_profile":false,"contributors_enabled":false,"favourites_count":16,"url":"http://www.linkedin.com/in/spode","profile_image_url_https":"https://si0.twimg.com/profile_images/1227466231/spode-balloon-medium_normal.jpg","utc_offset":0,"id":16402947,"profile_use_background_image":false,"listed_count":129,"profile_text_color":"262626","lang":"en","followers_count":2013,"protected":false,"notifications":null,"profile_background_image_url_https":"https://si0.twimg.com/profile_background_images/16420220/twitter-background-final.png","profile_background_color":"FFFFFF","verified":false,"geo_enabled":true,"time_zone":"London","description":"Co-Founder/Dev (PHP/jQuery) @justFDI. Run @thinkbikes and @thinkwall for events. Ex tech journo, helps run @uktjpr. Passion for Linux and customises everything.","default_profile_image":false,"profile_background_image_url":"http://a0.twimg.com/profile_background_images/16420220/twitter-background-final.png","statuses_count":11550,"friends_count":770,"following":null,"show_all_inline_media":true,"screen_name":"spode"},"in_reply_to_screen_name":"jasoncosta","source":"<a href=\"http://www.journotwit.com\" rel=\"nofollow\">JournoTwit</a>","in_reply_to_status_id":null},{"coordinates":{"coordinates":[121.0132101,14.5191613],"type":"Point"},"favorited":false,"truncated":false,"created_at":"Mon Sep 03 08:08:02 +0000 2012","id_str":"242534402280783873","entities":{"urls":[],"hashtags":[{"text":"twitter","indices":[49,57]}],"user_mentions":[{"name":"Jason Costa","id_str":"14927800","id":14927800,"indices":[14,25],"screen_name":"jasoncosta"}]},"in_reply_to_user_id_str":null,"contributors":null,"text":"Got the shirt @jasoncosta thanks man! Loving the #twitter bird on the shirt :-)","retweet_count":0,"in_reply_to_status_id_str":null,"id":242534402280783873,"geo":{"coordinates":[14.5191613,121.0132101],"type":"Point"},"retweeted":false,"in_reply_to_user_id":null,"place":null,"user":{"profile_sidebar_fill_color":"EFEFEF","profile_sidebar_border_color":"EEEEEE","profile_background_tile":true,"name":"Mikey","profile_image_url":"http://a0.twimg.com/profile_images/1305509670/chatMikeTwitter_normal.png","created_at":"Fri Jun 20 15:57:08 +0000 2008","location":"Singapore","follow_request_sent":false,"profile_link_color":"009999","is_translator":false,"id_str":"15181205","entities":{"url":{"urls":[{"expanded_url":null,"url":"http://about.me/michaelangelo","indices":[0,29]}]},"description":{"urls":[]}},"default_profile":false,"contributors_enabled":false,"favourites_count":11,"url":"http://about.me/michaelangelo","profile_image_url_https":"https://si0.twimg.com/profile_images/1305509670/chatMikeTwitter_normal.png","utc_offset":28800,"id":15181205,"profile_use_background_image":true,"listed_count":61,"profile_text_color":"333333","lang":"en","followers_count":577,"protected":false,"notifications":null,"profile_background_image_url_https":"https://si0.twimg.com/images/themes/theme14/bg.gif","profile_background_color":"131516","verified":false,"geo_enabled":true,"time_zone":"Hong Kong","description":"Android Applications Developer,  Studying Martial Arts, Plays MTG, Food and movie junkie","default_profile_image":false,"profile_background_image_url":"http://a0.twimg.com/images/themes/theme14/bg.gif","statuses_count":11327,"friends_count":138,"following":null,"show_all_inline_media":true,"screen_name":"mikedroid"},"in_reply_to_screen_name":null,"source":"<a href=\"http://twitter.com/download/android\" rel=\"nofollow\">Twitter for Android</a>","in_reply_to_status_id":null}]""")
      $("#pastejsonform").submit()
    })

    $("#test_button2").click(() => {
      $("#pastejsonform textarea").value("""{"results":[{"address_components":[{"long_name":"1600","short_name":"1600","types":["street_number"]},{"long_name":"Amphitheatre Pkwy","short_name":"Amphitheatre Pkwy","types":["route"]},{"long_name":"Mountain View","short_name":"Mountain View","types":["locality","political"]},{"long_name":"Santa Clara","short_name":"Santa Clara","types":["administrative_area_level_2","political"]},{"long_name":"California","short_name":"CA","types":["administrative_area_level_1","political"]},{"long_name":"United States","short_name":"US","types":["country","political"]},{"long_name":"94043","short_name":"94043","types":["postal_code"]}],"formatted_address":"1600 Amphitheatre Pkwy, Mountain View, CA 94043, USA","geometry":{"location":{"lat":37.42291810,"lng":-122.08542120},"location_type":"ROOFTOP","viewport":{"northeast":{"lat":37.42426708029149,"lng":-122.0840722197085},"southwest":{"lat":37.42156911970850,"lng":-122.0867701802915}}},"types":["street_address"]}],"status":"OK"}""")
      $("#pastejsonform").submit()
    })

    ReactDOM.render(CodeGenerator(generatedClses, regenerate _), dom.document.getElementById("app"))

    $("#pastejsonform").submit((el: dom.Element, e: org.querki.jquery.JQueryEventObject) => {
      e.preventDefault()

      generatedClses = Vector.empty
      alerts = Alerts()
      generatedShas = ListSet.empty

      val rawJson = $(e.target).find("textarea").valueString

      val parsedJson =
        try {
          JSON.parse(rawJson)
        }
        catch {
          case NonFatal(e) => alerts = alerts.includingError("The json root is invalid...")
          throw e
          //return 1
        }

      val o = (parsedJson: Any) match {
        case a: js.Array[_] =>
          println("array")
          alerts = alerts.includingWarn("The json root is an array, only the first entity will be analyse...")
          a.head.asInstanceOf[js.Object]
        case a: js.Object => println("object") ; a
        case _ =>
          alerts = alerts.includingError("The json root is not an object, cannot do anything for you...")
          throw new Exception("Not an Object or Array")
      }

      analyseObject(o, "r00tJsonObject")

      changed = true

      /* This is not redudant, it's a fix for a nasty bug that we will fix in the future */
      $("input.class_name").foreach { el =>
       // majName(el)
      }

      $("input.class_name").change({ (e: dom.Element, event: JQueryEventObject) =>
       // majName(e)
      })
    })
  }



  // HERE CAN BE SOME CONFIG PLACE

  val scalaWords = List("abstract", "case", "catch", "class", "def", "do", "else", "extends", "false", "final", "finally", "for", "forSome", "if", "implicit", "import", "lazy", "match", "new", "null", "object", "override", "package", "private", "protected", "return", "sealed", "super", "this", "throw", "trait", "try", "true", "type", "val", "var", "while", "with", "yield")
  val scalaChars = List("-", "_")
  val scalaTypes = List("List", "Type", "Meta", "Result") ++ scalaWords.map(_.capitalize)

  def analyseArray(array: collection.mutable.Seq[Any], key: String, parentName: String): ClassField = {
    val field = ClassField(key, "String")
    if (isValueConsistent(array)) {
      val listField = field.copy(list = "List", preventChange = true)
      val innerTs = generateName(key)
      val generatedTs = generateName(s"${listField.list}[$innerTs]")

      array match {
        case head +: _ =>
          head match {
            case value: js.Object =>
              val sha = generateSignatureCollection(array)
              analyseObject(value, key)
              listField.copy(typescala = generatedTs, sha = sha)
            case value =>
              val innerTs = value match {
                case _: String  => "String"
                case _: Double  => "Double"
                case _: Boolean => "Boolean"
                case _: js.Date => "Date"
                case _          => "String"
              }

              val ts = generateName(s"${listField.list}[$innerTs]")
              listField.copy(typescala = ts, preventChange = false)
          }
        case _ =>
          alerts = alerts.includingError(s"the $parentName $key field is an empty array : cannot analyse :-(")
          val ts = generateName(s"${listField.list}[String]")
          listField.copy(typescala = ts, preventChange = false)
      }
    } else {
      alerts = alerts.includingError(s"the $parentName $key field is prentending an array but not consistent")
      field // If value is not consistent, just return String field
    }
  }



  def analyseObject(o: js.Object, oname2: String) {
    val oname = generateName(oname2)
    val sign = generateSignature(o)

    if (generatedShas.contains(sign)) {
      // println("class already analyse")
    } else {
      val obj = o.asInstanceOf[js.Dictionary[Any]]

      if (obj.keys.size > 22) {
        alerts = alerts.includingError(s"the $oname class is exceding 22 fields, generated but it will not work, due to the Product arity limitation")
      }

      val fields = obj.map {
        case (key: String, dvalue: Any) =>
          val field = ClassField(key, "String")

          val finalField = dvalue match {
            case _: String  => field
            case _: Double  => field.copy(typescala = "Double")
            case _: Boolean => field.copy(typescala = "Boolean")
            case _: js.Date => field.copy(typescala = "Date")
            case array: js.Array[Any @unchecked] => analyseArray(array, key, oname)
            case value: js.Object =>
              val sha = generateSignature(value)
              analyseObject(value, key)
              /// if it already exists we should do something
              val f = field.copy(typescala = generateName(key), preventChange = true, sha = sha)
              f
            case _ => field // last resort, just return String field
          }

          finalField
        case (key: String, _) =>
          // when we have null as field value, treat as string
          ClassField(key, "String")
      }

      generatedClses = generatedClses :+ (oname, fields.toVector)
      generatedShas = generatedShas + sign
    }
  }

  def sanitizeVarName(name: String): String = {
    /* java's String.matches all input data */
    if (name.matches("[_a-zA-Z0-9]+") && !scalaWords.contains(name)) { // !_.contains(scala_words, name)){
      name
    } else {
      '`' + name + '`'
    }
  }

  def majName(e: dom.Element) = {
    val elem = $(e)
    val tochange = $("""div.ul input[data-signature-class="""" + elem.attr("data-signature-class") + """"]""")
    tochange.filter("""input[data-list=""]""").value(elem.valueString)
    tochange.filter("""input[data-list="List"]""").foreach { el =>
      val ee = $(el)
      ee.value(ee.attr("data-list") + "[" + elem.valueString + "]")
    }

    tochange.filter("""input[data-list="Map"]""").foreach { el =>
      val ee = $(el)
      ee.value(ee.attr("data-list") + "[Map," + elem.valueString + "]")
    }
  }

  def isValueConsistent(array: collection.mutable.Seq[Any]): Boolean = {
    def itemSignature(item: Any) = item match {
      case obj: js.Object => generateSignature(obj)
      case value => js.typeOf(value.asInstanceOf[js.Any])
    }

    val expectedItemSignatureOpt = array.headOption.map(itemSignature)
    expectedItemSignatureOpt.forall { expectedItemSignature =>
      array.forall(n => { itemSignature(n) == expectedItemSignature})
    }
  }

  def generateSignatureCollection(seq: collection.mutable.Seq[Any]): String = {
   if (seq.isEmpty) {
     "0"
   } else {
     generateSignature(seq.head.asInstanceOf[js.Object])
   }
  }

  /* TO-DO: Make generateSignature recursive to avoid clashes */
  def generateSignature(o: js.Object): String = {
    val objDict = o.asInstanceOf[js.Dictionary[Any]]
    val baseString = objDict.keys.toList.map { n => n.toLowerCase() }.sorted.mkString("|")
    g.SHA1(baseString).asInstanceOf[String]
  }

  def generateName(oname: String) = {
    val newOname = oname.capitalize
    if (scalaTypes.contains(newOname))
      newOname + "Bis"
    else
      newOname
  }
}
