import game.*
import org.junit.Assert.assertTrue
import org.junit.Test

class Test {

    @Test
    fun testCardComparison() {
        assertTrue(Card(1, Suit.Bell) == Card(1, Suit.Bell))
    }

    @Test
    fun testSortHand() {
        val deck = Deck()
        val hand = Hand(deck)
        for (i in 0..11) {
            assertTrue(hand.cards[i] < hand.cards[i + 1])
        }
    }
}