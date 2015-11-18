/*
 * 有理数（分数）を表すクラス。
 * 分子nと分母dをパラメータとして作成される。
 */
class Rational(n: Int, d: Int) {
  // 分母が0であってはならない
  require(d != 0)
  // 分子と分母の最大公約数
  private val g = gcd(n.abs, d.abs)
  // 分子と分母のフィールド
  val numer: Int = n / g
  val denom: Int = d / g
  // 分母を省略すると分母を1として作成する補助コンストラクタ
  def this(n: Int) = this(n, 1)

  // 加算メソッド
  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom, 
      denom * that.denom
    )
  def + (i: Int): Rational =
    new Rational(numer + i * denom, denom)

  // 減算メソッド
  def - (that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )
  def - (i: Int): Rational =
    new Rational(numer - i * denom, denom)

  // 乗算メソッド
  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)
  def * (i: Int): Rational =
    new Rational(numer * i, denom)

  // 除算メソッド
  def / (that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)
  def / (i: Int): Rational =
    new Rational(numer, denom * i)

  // 出力表示
  override def toString = numer +"/"+ denom  
  // 最大公約数を返す
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
