import scala.collection.mutable.Map

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

// ChecksumAccumaltorクラスのコンパニオンオブジェクト
object ChecksumAccumulator {
  // 既に計算したチェックサムのキャッシュ
  // ※一般的にはWeakHashMapのような弱いMapを使用し，
  //  メモリ残量が減ってきたときにキャッシュ内のエントリを
  //  ガベージコレクションできるようにすべきである。
  private val cache = Map[String, Int]()

  // 文字列のチェックサムを計算する。
  // キャッシュに既に計算された値があればそれを返す。
  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}
