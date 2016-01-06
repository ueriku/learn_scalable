object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles
  // バラバラに書いた場合
  /*
  def filesEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
    yield file
  def filesContaining(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
    yield file
  def filesRegex(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
    yield file
  */
  // 上の関数の共通部分を切り出すため，高階関数でヘルパ関数を作成
  def filesMatching(matcher: String => Boolean) = {
    for (file <- filesHere; if matcher(file.getName))
    yield file
  }
  // このヘルパ関数を使い，各検索関数を記述
  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))
  def filesContaining(query: String) =
    filesMatching(_.contains(query))
  def filesRegex(query: String) =
    filesMatching(_.matches(query))
  def main(args: Array[String]) {
    filesEnding(".scala").foreach(println)
    filesContaining("sc").foreach(println)
    filesRegex("^s.*").foreach(println)
  }
}
