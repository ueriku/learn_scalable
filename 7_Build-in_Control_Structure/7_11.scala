import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

try {
  val f = new FileReader("input.txt")
  // ファイルを使ってからクローズする
} catch {
  case ex: FileNotFoundException => println("ファイルなしエラーを処理")
  case ex: IOException => println("I/Oエラーを処理")
}
