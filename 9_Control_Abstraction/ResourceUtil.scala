import java.io._

object ResourceUtil {
  // fileに対して操作opを行い，finally処理でcloseする
  def withPrintWriter(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }
  def main(args: Array[String]) {
    val file = new File("date.txt")
    withPrintWriter(file) {
      writer => writer.println(new java.util.Date)
    }
  }
}
