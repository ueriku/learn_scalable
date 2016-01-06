import java.net.URL
import java.net.MalformedURLEXception

def uniFor(path: String) =
  try {
    new URL(path)
  } catch {
    case e: MalformedURLException =>
      new URL("http://www.scala-lang.org")
  }
