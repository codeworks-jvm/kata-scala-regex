import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner



trait RegexTestTrait {
  val kata = KataScalaRegex
}

//----------------------------------------------------------------------------
//       matchSimpleString
//----------------------------------------------------------------------------

@RunWith(classOf[JUnitRunner])
class MatchSimpleStringTest extends FunSuite with RegexTestTrait {

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


//----------------------------------------------------------------------------
//        getMatchingGroupString
//----------------------------------------------------------------------------

@RunWith(classOf[JUnitRunner])
class GetMatchingGroupStringTest extends FunSuite with RegexTestTrait {

  test("should_return_matching_group") {
    //GIVEN
    val s = "my_string_is_hidden"
    val expectedGroup = "string"

    //WHEN
    val result = kata.getMatchingGroupString(s)

    //THEN
    assert(result.nonEmpty)
    assert(result.get == expectedGroup)
  }

  test("should_return_only_one_group") {
    //GIVEN
    val s = "my_string_is_hidden_in_other_strings"
    val expectedGroup = "string"

    //WHEN
    val result = kata.getMatchingGroupString(s)

    //THEN
    assert(result.nonEmpty)
    assert(result.get == expectedGroup)
  }

  test("should_return_None_if_no_match_occurred") {
    //GIVEN
    val s = "nothing_is_hidden"

    //WHEN
    val result = kata.getMatchingGroupString(s)

    //THEN
    assert(result.isEmpty)
  }
}


//----------------------------------------------------------------------------
//        getMatchingGroupNumber
//----------------------------------------------------------------------------

@RunWith(classOf[JUnitRunner])
class GetMatchingGroupNumberTest extends FunSuite with RegexTestTrait {

  test("should_return_matching_group") {
    //GIVEN
    val s = "I_have_99_bugs"
    val expectedGroup = "99"

    //WHEN
    val result = kata.getMatchingGroupNumber(s)

    //THEN
    assert(result.nonEmpty)
    assert(result.get == expectedGroup)
  }

  test("should_return_only_one_group") {
    //GIVEN
    val s = "I_have_99_bugs_but_this_1_is_not"
    val expectedGroup = "99"

    //WHEN
    val result = kata.getMatchingGroupNumber(s)

    //THEN
    assert(result.nonEmpty)
    assert(result.get == expectedGroup)
  }

  test("should_return_None_if_no_matching_occurred") {
    //GIVEN
    val s = "I_have_absolutely_no_bugs"

    //WHEN
    val result = kata.getMatchingGroupNumber(s)

    //THEN
    assert(result.isEmpty)
  }
}


//----------------------------------------------------------------------------
//        getMatchingGroupNumbers
//----------------------------------------------------------------------------


@RunWith(classOf[JUnitRunner])
class GetMatchingGroupNumbersTest extends FunSuite with RegexTestTrait {

  test("should_return_one_matching_group") {
    //GIVEN
    val s = "I_have_99_bugs"
    val expectedGroup = "99" :: Nil

    //WHEN
    val result = kata.getMatchingGroupNumbers(s)

    //THEN
    assert(result == expectedGroup)
  }

  test("should_return_matching_groups") {
    //GIVEN
    val s = "I_have_99_bugs_but_this_1_is_not"
    val expectedGroup = "99" :: "1" :: Nil

    //WHEN
    val result = kata.getMatchingGroupNumbers(s)

    //THEN
    assert(result == expectedGroup)
  }

  test("should_return_empty_list_if_no_matching_occurred") {
    //GIVEN
    val s = "I_have_no_bugs"

    //WHEN
    val result = kata.getMatchingGroupNumbers(s)

    //THEN
    assert(result.isEmpty)
  }
}

