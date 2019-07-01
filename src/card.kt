import java.util.*

enum class Suit {
    Red, Yellow, Blue
}

data class Card(val value: Int, val suit: Suit) {
    operator fun compareTo(other: Card) : Int {
        return value - other.value
    }
}

class Deck() {
    private val MAX_VALUE = 11
    private var cards: LinkedList<Card> = LinkedList()
    init {
        for (value in 1..MAX_VALUE) {
            Suit.values().forEach { cards.add(Card(value, it)) }
        }
        cards.shuffle()
    }

    fun deal() : Card? {
        return cards.pollFirst()
    }
}

class Hand() {

}