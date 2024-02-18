package m.andov.kroman

class Converter(private var numeral: String) {

    private val roman = mapOf(
            "I" to 1,
            "V" to 5,
            "X" to 10,
            "L" to 50,
            "C" to 100,
            "D" to 500,
            "M" to 1000
    )

    init {
        if (numeral.isEmpty()) throw IllegalArgumentException("Empty numeral")
        if ("^[IVXLCDM]+$".toRegex().matches(numeral).not()) throw IllegalArgumentException("Non valid roman values found in the numeral")

        numeral = numeral.toUpperCase().reversed()
    }

    fun toInteger() {
        var sum: Int = 0
        var previous: Int = 0

        for (c in numeral) {
            val current = roman[c.toString()].!!
            if (current < previous) {
                sum -= current
            } else {
                sum += current
            }
            previous = current
        }
        return sum
    }
    fun originalValue(): String {
        return this.numeral
    }

}


