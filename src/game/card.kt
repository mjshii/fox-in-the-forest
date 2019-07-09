package game

import java.util.*
import kotlin.collections.ArrayList

enum class Suit {
    Key, Moon, Bell
}

data class Card(val value: Int, val suit: Suit) : Comparable<Card> {
    override fun compareTo(other: Card) : Int {
        return (value + 20 * suit.ordinal) - (other.value + 20 * other.suit.ordinal)
    }
}

class Deck {
    private var cards = LinkedList<Card>()
    init {
        for (value in 1..11) {
            Suit.values().forEach { cards.add(Card(value, it)) }
        }
        cards.shuffle()
    }

    fun deal() : Card {
        return cards.pollFirst()!!
    }
}

data class Hand(val deck: Deck) {
    val cards = ArrayList<Card>()
    init {
        repeat(13) { cards.add(deck.deal()) }
        cards.sort()
    }

    fun getDeepCopy() : ArrayList<Card> {
        val cloned = ArrayList<Card>()
        cards.forEach{ cloned.add(Card(it.value, it.suit)) }
        return cloned
    }
}