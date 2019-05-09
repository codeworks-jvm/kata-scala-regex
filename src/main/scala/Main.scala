object KataScalaRegex {
  def main(a: Array[String]): Unit = {
    println("hello world")
  }

  /**
    * We want a function to know if a parameter string contains "SimpleString"
    * @param s the string to match against
    * @return true if the string matches, false otherwise
    */
  def matchSimpleString(s: String): Boolean = {
    val reg = """.*SimpleString.*""".r

    s match {
      case reg(_*) => return true
      case _ => return false
    }
  }

  /**
    * We want the first groups of s matching "string"
    * @param s
    * @return a matching substring of s
    */
  def getMatchingGroupString(s: String): Option[String] = {
    val reg = """.*(string).*""".r

    s match {
      case reg(group) => Some(group)
      case _ => None
    }
  }

  /**
    * We want the first groups of s matching a number
    * @param s
    * @return a matching substring of s
    */
  def getMatchingGroupNumber(s: String): Option[String] = {
    val reg = """.*(\d+).*""".r

    s match {
      case reg(number) => Some(number)
      case _ => None
    }
  }

  /**
    * We want all the groups of s matching a number
    * @param s
    * @return a matching substring of s
    */
  def getMatchingGroupNumbers(s: String): List[String] = {
    val reg = """(\d+)""".r
    reg.findAllMatchIn(s).map(_.toString).toList
  }

}
