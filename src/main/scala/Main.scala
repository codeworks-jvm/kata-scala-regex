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
    ???
  }

  /**
    * We want the first groups of s matching "string"
    * @param s
    * @return a matching substring of s
    */
  def getMatchingGroupString(s: String): Option[String] = {
    ???
  }

  /**
    * We want the first groups of s matching a number
    * @param s
    * @return a matching substring of s
    */
  def getMatchingGroupNumber(s: String): Option[String] = {
    ???
  }

  /**
    * We want all the groups of s matching a number
    * @param s
    * @return a matching substring of s
    */
  def getMatchingGroupNumbers(s: String): List[String] = {
    ???
  }

}
