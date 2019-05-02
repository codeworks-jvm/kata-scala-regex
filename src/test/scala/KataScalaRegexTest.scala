import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MatchSimpleStringTest extends FunSuite {

  lazy val kata = KataScalaRegex;

  test("should_match_exact_string") {
    //GIVEN
    val s = "SimpleString"

    //WHEN
    val result = kata.matchSimpleString(s)

    //THEN
    assert(result)
  }

  test("should_not_match_different_string") {
    //GIVEN
    val s = "notAtAllThe same..."

    //WHEN
    val result = kata.matchSimpleString(s)

    //THEN
    assert(!result)
  }

  test("should_match_containing_string") {
    //GIVEN
    val s = "this string actually contains 'SimpleString', I swear"

    //WHEN
    val result = kata.matchSimpleString(s)

    //THEN
    assert(result)
  }

  test("should_not_match_different_case") {
    //GIVEN
    val s = "simplestring"

    //WHEN
    val result = kata.matchSimpleString(s)

    //THEN
    assert(!result)
  }
}
