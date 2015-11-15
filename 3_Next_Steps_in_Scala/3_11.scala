import scala.io.Source

// 引数の文字列sを何字で表示できるかを計算する
def widthOfLength(s: String) = s.length.toString.length

if (args.length > 0) {
  // ファイルの全行を変数lineに保存
  val lines = Source.fromFile(args(0)).getLines().toList
  // 最も長い文字列を変数longestLineに格納
  //   reduceLeftは，渡された関数をlinesの先頭2行に適用し，
  //   このときの結果値とlinesの次の要素とを対象として同じ関数を適用する。
  //   渡された関数は引数の文字列のうち長い方を返すので，
  //   結果として最も長い文字列が返される
  val longestLine = lines.reduceLeft(
    (a, b) => if (a.length > b.length) a else b
  )
  // 最も長い行を表示するために必要な幅
  val maxWidth = widthOfLength(longestLine)
  // 適切に整形して行を出力する
  for (line <- lines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  }
}
else
  Console.err.println("Please enter filename")
