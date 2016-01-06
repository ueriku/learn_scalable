val firstArg = if (args.length > 0) args(0) else ""
val friend =
  firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
  }
println(friend)
