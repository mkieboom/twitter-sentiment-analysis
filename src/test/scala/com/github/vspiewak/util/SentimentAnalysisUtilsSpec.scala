package com.github.vspiewak.util

import com.github.vspiewak.util.SentimentAnalysisUtils._
import org.scalatest._

class SentimentAnalysisUtilsSpec extends FlatSpec with Matchers with OptionValues with Inside with Inspectors {

  /*
        checkSentiment("Radek is a really good football player");
        checkSentiment("Radek is a good football player");
        checkSentiment("Radek is an OK football player");
        checkSentiment("Radek is a bad football player");
        checkSentiment("Radek is a really bad football player");

        checkSentiment("Mark is a really good football player");
        checkSentiment("Mark is a good football player");
        checkSentiment("Mark is an OK football player");
        checkSentiment("Mark is a bad football player");
        checkSentiment("Mark is a really bad football player");
   */

  "A sentiment analyzis utility class" should "should detect not understood sentiment" in {

    detectSentiment("") should equal(NOT_UNDERSTOOD)

  }

  it should "should detect a negative sentiment" in {

    detectSentiment("I am feeling very sad and frustrated.") should equal(NEGATIVE)

  }

  it should "should detect a neutral sentiment" in {

    detectSentiment("I'm watching a movie") should equal(NEUTRAL)

  }

  it should "should detect a positive sentiment" in {

    detectSentiment("It was a nice experience.") should equal(POSITIVE)

  }

  it should "should detect a very positive sentiment" in {

    detectSentiment("It was a very nice experience.") should equal(VERY_POSITIVE)

  }

  /*    it("should detect a positive sentiment on 2 sentences") {

        detect("We did it guys! The boys won at the 2015 Brit Awards for best video") should equal (POSITIVE)

      }
  */

  it should "should detect a negative sentiment on a full review" in {

    detectSentiment(
      """
        |This movie doesn't care about cleverness, wit or any other kind of intelligent humor.
        |Those who find ugly meanings in beautiful things are corrupt without being charming.
        |There are slow and repetitive parts, but it has just enough spice to keep it interesting.
      """.stripMargin) should equal(NEGATIVE)

  }

}
