import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import m.andov.kroman.Converter

class ConverterTest {

    fun testRomanConversion(romanNumeral: String, expected: Int, message: String? = null) {
        val converter = Converter(romanNumeral)
        assertEquals(expected, converter.toInteger(), message)
    }

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
        assertEquals("Empty numeral", exception.message)
    }

    @Test
    fun testInvalidValue() {
        val exception = assertThrows<IllegalArgumentException> {
            Converter("XP")
        }
        assertEquals("Non valid roman numeral", exception.message)
    }

    @Test
    fun testToIntegerSimpleValue() {
        testRomanConversion("IX", 9, "The toInteger method should return the integer value of the numeral")
    }

    @Test
    fun testToInteger() {
        testRomanConversion("MCMXC", 1990, "The toInteger method should return the integer value of the numeral")
    }

    @Test
    fun testToIntegerWithRepetitions() {
        val exception = assertThrows<IllegalArgumentException> {
            Converter("VVVV")
        }
        assertEquals("Non valid roman numeral", exception.message)
    }

    @Test
    fun testToIntegerValidRepetitions() {
        testRomanConversion("MMMM", 4000, "The toInteger method should return the integer value of the numeral")
    }
    @Test
    fun testToIntegerBigNumber() {
        testRomanConversion("MMMMCMXCIX", 4999, "The toInteger method should return the integer value of the numeral")
    }

}