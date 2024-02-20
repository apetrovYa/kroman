package m.andov.kroman

/**
 * This class is used to convert Roman numerals to their corresponding integer values.
 * The Roman numeral to be converted is passed as a string to the constructor.
 * The class also validates the input string to ensure it is a valid Roman numeral.
 *
 * The class uses a nested object `RomanConstants` to map Roman numerals to their integer values.
 *
 * The `toInteger` method is used to convert the Roman numeral to an integer.
 * The `originalValue` method returns the original Roman numeral string.
 *
 * @author apetrovYa
 */
class Converter(private var numeral: String) {
    /**
     * This object maps Roman numerals to their corresponding integer values.
     */
     internal object RomanConstants {
        /**
         * This method returns the integer value of a Roman numeral.
         *
         * @param romanSymbol The Roman numeral as a string.
         * @return The integer value of the Roman numeral. Returns 0 if the symbol is not a valid Roman numeral.
         */
        fun valueOf(romanSymbol: String): Int {
            return when (romanSymbol) {
                "I" -> 1
                "V" -> 5
                "X" -> 10
                "L" -> 50
                "C" -> 100
                "D" -> 500
                "M" -> 1000
                else -> 0
            }
        }
    }

    /**
     * This block initializes the Converter object.
     *
     * Pre-conditions:
     * - The input string `numeral` must not be empty.
     * - The input string `numeral` must be a valid Roman numeral, where no Roman numeral symbol (except 'M') repeats four times consecutively.
     *
     * Post-conditions:
     * - The `numeral` field is set to the reversed, uppercase version of the input string.
     *
     * @throws IllegalArgumentException If the input string is empty or not a valid Roman numeral.
     */
    init {
        if (numeral.isEmpty()) throw IllegalArgumentException("Empty numeral")
        if ("^(?!.*([IVXLCD]).*\\1\\1\\1)[IVXLCDM]+$".toRegex().matches(numeral).not()) throw IllegalArgumentException("Non valid roman numeral")

        numeral = numeral.uppercase().reversed()
    }
    /**
     * This method converts the Roman numeral to an integer.
     *
     * @return The integer value of the Roman numeral.
     */
    public  fun toInteger(): Int {
        var sum = 0
        var previous = 0

        for (c in numeral) {
            val current = RomanConstants.valueOf(c.toString())

            if(current < previous) {
                sum -= current
            } else {
                sum += current
            }

            previous = current
        }

        return sum
    }
    /**
     * This method returns the original Roman numeral string.
     *
     * @return The original Roman numeral string.
     */
    fun originalValue(): String {
        return this.numeral
    }

}


