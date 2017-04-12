package pages
import scalatags.Text
import scalatags.Text.all._
import scalatags.Text.tags2.title
object Skeletons {
 val skeletonMain: Text.TypedTag[String] =
  html(
   head(
    title("Demo")
   ),
   body(
    script(src := "/assets/client-jsdeps.js"),
    script(src := "/assets/client-fastopt.js")
   )
  )
}