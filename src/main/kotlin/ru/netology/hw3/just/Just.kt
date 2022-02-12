package ru.netology.hw3.just

fun main() {
    val secAgo = 588677
    println(agoToText(secAgo))
}

fun agoToText(secAgo: Int): String {
    var stringToPrint = ""
    when (secAgo) {
        in 0..60 -> stringToPrint = "был(а) только что"
        in 61..60*60 -> stringToPrint = "был(а) в сети " +
                secAgo/60 + " " +
                intTimeValueToStringTimeWord(secAgo/60,"минут","минуту","минуты") +
                " назад"
        in (60 * 60 + 1)..(24 * 60 * 60) -> stringToPrint = "был(а) в сети " +
                secAgo/(60*60) + " " +
                intTimeValueToStringTimeWord(secAgo/3600,"часов","час","часа") +
                " назад"
        in ((24 * 60 * 60) + 1)..(3 * 24 * 60 * 60) -> stringToPrint = "был(а) в сети на днях"
        in ((3 * 24 * 60 * 60) +1)..Int.MAX_VALUE -> stringToPrint = "был(а) в сети давно"
    }
    return stringToPrint
}

fun intTimeValueToStringTimeWord(timeValue: Int, WordFor0: String, WordFor1: String, WordFor2: String): String {
    var wordToPrint = ""
    when (droppingDigitsAboveSecond(timeValue)) {
        0, in 5..20, in 25..30, in 35..40, in 45..50, in 55..60,
        in 65..70, in 75..80, in 85..90, in 95..99
          -> wordToPrint = WordFor0
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54,
        in 62..64, in 72..74, in 82..84, in 92..94
            -> wordToPrint = WordFor2
        1, 21, 31, 41, 51, 61, 71, 81, 91 -> wordToPrint = WordFor1
    }
    return wordToPrint
}

fun droppingDigitsAboveSecond(anyInt: Int): Int {
    return if (anyInt < 100) anyInt
    else anyInt - droppingDigitsBelowThird(anyInt)
}

fun  droppingDigitsBelowThird(anyInt: Int): Int {
    val hundredthPart: Int = anyInt / 100
    return if (anyInt < 100) anyInt
    else hundredthPart * 100
}

