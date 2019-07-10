package game

object Evaluate {
    fun points(numTricks: Int): Int {
        return when (numTricks) {
            in 0..3, in 7..9 -> 6
            in 4..6 -> numTricks - 3
            else -> 0
        }
    }

    /**
     * @return true if the first card wins, false if the second card wins
     */
    fun winner(first: Card, second: Card, trump: Suit) : Boolean {
        val firstValue = first.value
        val secondValue = second.value
        val firstSuit = if (firstValue == 9 && secondValue != 9) trump else first.suit
        val secondSuit = if (secondValue == 9 && firstValue != 9) trump else second.suit

        return if (firstSuit == secondSuit) {
            firstValue > secondValue
        } else secondSuit !== trump
    }
}