import org.junit.Assert.assertTrue
import org.junit.Test

class Test {

    @Test
    fun testCards() {
        assertTrue(Card(1, Suit.Blue) == Card(1, Suit.Blue))
    }
}