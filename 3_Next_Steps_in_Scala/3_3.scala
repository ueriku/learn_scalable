val oneTwoThree = List(1, 2, 3)
val FourFive = List(4, 5)
val oneToFive = oneTwoThree ::: FourFive
println(oneTwoThree + " and " + FourFive + " were not mutated.")
println("Thus, " + oneToFive + " is a new list.")
