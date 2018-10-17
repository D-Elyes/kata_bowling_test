package bowling

import scala.util.Random

object Frame
{
  def calculRoll1(pinsDown : Int, player : Player) : Int =
  {
    if(pinsDown == 10) {
      if (player.bonus == "strike" || player.bonus == "spare") {
        pinsDown + 10
      }
      else {
        pinsDown
      }
    }
    else
      {
        if(player.bonus =="spare")
           pinsDown*2
        else
          pinsDown
      }
  }

  def calculRoll2(pinsDown : Int, player : Player,scoreRoll1 : Int) : Int =
  {
    if(player.bonus == "strike")
      pinsDown*2 + scoreRoll1
    else
      pinsDown
  }

  def roll(r:Random, player:Player) : Player =
  {
    val roll1 = r.nextInt(10)+1
    val score1 = calculRoll1(roll1,player)
    if(roll1 == 10)
      {
        player.copy(score = Player.addScore(score1,player).score,"strike")

      }
    else
      {
        val roll2 = r.nextInt(10-roll1)+1
        val score2 = calculRoll2(roll2,player,score1)
        if(roll1+roll2 == 10)
          player.copy(score = Player.addScore(score1+score2,player).score,"spare")
        else
          player.copy(score = Player.addScore(score1+score2,player).score,"")
      }
  }
}
