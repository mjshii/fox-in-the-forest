package game

import java.util.*
import kotlin.collections.ArrayList

enum class Suit {
    Key, Moon, Bell
}

data class Card(val value: Int, val suit: Suit) : Comparable<Card> {
    override fun compareTo(other: Card) : Int {
        return (value - other.value) + 20 * (suit.ordinal - other.suit.ordinal)
    }
}

class Deck {
    private var cards = LinkedList<Card>()
    init {
        (1..11).forEach {
                value -> Suit.values().forEach { cards.add(Card(value, it)) }
        }
        cards.shuffle()
    }

    fun deal() : Card = cards.pollFirst()!!
}

data class Hand(val deck: Deck) {
    private val cards = ArrayList<Card>()
    init {
        repeat(13) { cards.add(deck.deal()) }
        cards.sort()
    }

    fun getHand() : ArrayList<Card> = cards.toMutableList() as ArrayList<Card>
    fun contains(card: Card) : Boolean = cards.contains(card)
}