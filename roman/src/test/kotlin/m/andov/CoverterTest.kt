import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import m.andov.kroman.Converter

class ConverterTest {
    @Test
    fun testValue() {
        val converter = Converter("X")
        assertEquals("X", converter.originalValue(), "The value method should return the numeral passed to the constructor")
    }

    @Test
    fun testReversedValue() {
        val converter = Converter("IX")
        assertEquals("XI", converter.originalValue(), "The value method should return the numeral passed to the constructor and reversed")
    }

    @Test
    fun testEmptyValue() {
        val exception = assertThrows<IllegalArgumentException> {
            Converter("")
        }
        assertEquals("Empty numeral", exception.message, "The constructor should throw an IllegalArgumentException if the numeral is empty")
    }

    @Test
    fun testInvalidValue() {
        val exception = assertThrows<IllegalArgumentException> {
            Converter("XP")
        }
        assertEquals("Non valid roman values found in the numeral", exception.message, "The constructor should throw an IllegalArgumentException if the numeral contains non valid roman values")
    }

    @Test
    fun testToInteger() {
        val converter = Converter("IX")
        assertEquals(9, converter.toInteger(), "The toInteger method should return the integer value of the numeral")
    }

}