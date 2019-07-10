import game.*
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.test.assertFalse

class Test {

    @Test
    fun testCardComparison() {
        assertTrue(Card(1, Suit.Bell) == Card(1, Suit.Bell))
    }

    @Test
    fun testCheatingAttempts() {
        val deck = Deck() ; val hand = Hand(deck)
        val receivedHand = hand.getHand()
        val cheat = Card(0, Suit.Bell)

        receivedHand.add(cheat)
        receivedHand[0] = cheat

        assertFalse(hand.getHand().contains(cheat))
    }
}