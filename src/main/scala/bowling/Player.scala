package bowling

case class Player(score : Int,bonus : String)

object Player
{
  def addScore(newScore : Int,player : Player) : Player =
  {
    player.copy(score = player.score+newScore)
  }
}
