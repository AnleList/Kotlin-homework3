package ru.netology.hw3

fun main() {
    val transferAmount = 76_00 //в копейках
    val cardAccountType = "Мир"
    val amountOfPreviousTransfersThisMonth = 0


    val commission = commissionCalculation(
        cardAccountType,
        amountOfPreviousTransfersThisMonth,
        transferAmount
    )

    println(println("коммисия составит: $commission копеек"))
}

fun commissionCalculation(
    CardAccountType: String,
    amountOfPreviousTransfersThisMonth: Int,
    transferAmount: Int
): Int {
    return when (CardAccountType.trim().lowercase()) {
        "vkpay" -> 0
        "mastercard", "maestro" ->
            if (transferAmount + amountOfPreviousTransfersThisMonth <= 75_000_00) 0
            else ("%.0f".format((transferAmount * 0.006) + 20_00)).toInt()
        else -> //visa, mir, мир
            if (transferAmount * 0.0075 <= 35_00) 35_00
            else ("%.0f".format(transferAmount * 0.0075).toInt())
    }
}