args.foreach(arg => println(arg))
// コードに型を明記したければ下記のように書くこともできる
// args.foreach((arg: String) => println(arg))
// また，関数リテラルが1個の引数をとる1文から構成される場合，
// 引数を明示的に指定しなくても済むので，以下のようにも書ける
// args.foreach(println)
