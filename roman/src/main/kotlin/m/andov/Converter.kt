package m.andov.kroman

class Converter(private var numeral: String) {

     internal object RomanConstants {
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


    init {
        if (numeral.isEmpty()) throw IllegalArgumentException("Empty numeral")
        if ("^[IVXLCDM]+$".toRegex().matches(numeral).not()) throw IllegalArgumentException("Non valid roman numeral")

        numeral = numeral.toUpperCase().reversed()
    }

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

    fun originalValue(): String {
        return this.numeral
    }

}


