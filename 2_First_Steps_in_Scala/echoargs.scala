// whileループの説明のためのプログラムであり，
// Scalaの最良のスタイルを示すものではないことに注意
var i = 0
while (i < args.length) {
  if (i != 0)
    print(" ")
  print(args(i))
  i += 1
}
println()
