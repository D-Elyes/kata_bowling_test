package bowling

import org.scalatest.{FlatSpec, Matchers}

class FrameTest extends FlatSpec with Matchers {

  "A roll of 0 pins" should "return a score of 0" in
    {
      val player = Player(0,"")


      val score1 = Frame.calculRoll1(0,player)
      val score2 = Frame.calculRoll2(0,player,score1)

      score1 + score2 should be (0)

    }

  "A roll of 10 pins after a strike" should "return a score of 20" in
    {
      val player = Player(10,"strike")
      val score1 = Frame.calculRoll1(10,player)

      score1 should be (20)

    }

  "A roll of 3 and a roll of 5 after a strike" should "return a score of 16" in
  {
    val player = Player(10,"strike")


    val score1 = Frame.calculRoll1(3,player)
    val score2 = Frame.calculRoll2(5,player,score1)

    score1 + score2 should be (16)
  }

  "A roll of 1 and a roll of 2 after a spare" should "return a score of 4" in
    {
      val player = Player(10,"spare")


      val score1 = Frame.calculRoll1(1,player)
      val score2 = Frame.calculRoll2(2,player,score1)

      score1 + score2 should be (4)
    }


}