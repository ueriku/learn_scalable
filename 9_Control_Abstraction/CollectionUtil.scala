object CollectionUtil {
  // Listに負数が含まれているかどうかを返す
  // forループで書いた場合
  /*
  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums)
      if (num < 0)
        exists = true
    exists
  }
  */
  // 高階関数で書いた場合
  def containsNeg(nums: List[Int]) = nums.exists(_ < 0)
  // 奇数が含まれているかどうかを返す
  def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)
  def main(args: Array[String]) {
    println(containsNeg(List(1,2,3,4)))
    println(containsNeg(List(1,-2,3,4)))
    println(containsOdd(List(2,4,6,8)))
    println(containsOdd(List(2,4,6,8,1)))
  }
}
