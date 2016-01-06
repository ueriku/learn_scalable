object AssertSample {
  var assertionsEnabled = true  
  // 名前渡しパラメータなしの場合
  def myAssert(predicate: () => Boolean) =
    if (assertionsEnabled && !predicate())
      throw new AssertionError
  // 名前渡しパラメータを使った場合
  // パラメータの型として() =>ではなく=>にする
  def byNameAssert(predicate: => Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError
  def main(args: Array[String]) {
    // 名前渡しパラメータを使わない場合，
    // 空のパラメータリスト() => の指定が必要。
    // myAssert(5 > 3) と書けない
    myAssert(() => 5 > 3)
    // 名前渡しパラメータを使えば，以下のように書ける
    byNameAssert(5 > 3)
  }
}
