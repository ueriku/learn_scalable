import java.io.FileReader
val file = new FileReader("input.txt")
try {
  // ファイルを使う
} finally {
  file.close()
}
