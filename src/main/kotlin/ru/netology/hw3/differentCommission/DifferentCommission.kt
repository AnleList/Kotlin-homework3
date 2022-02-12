package ru.netology.hw3.differentCommission

fun main() {
    val transferAmount = 760_000_00 //в копейках
    val cardAccountType = "visa"
    val amountOfPreviousTransfersThisMonth = 0


    val commission = commissionCalculation(
        cardAccountType,
        amountOfPreviousTransfersThisMonth,
        transferAmount
    )

    println(println("коммисия составит: $commission копеек"))
}

fun commissionCalculation(
    cardAccountType: String,
    amountOfPreviousTransfersThisMonth: Int,
    transferAmount: Int
): Int {
    return when (cardAccountType.trim().lowercase()) {
        "vkpay" -> 0
        "mastercard", "maestro" ->
            if (transferAmount + amountOfPreviousTransfersThisMonth <= 75_000_00) 0
            else ("%.0f".format((transferAmount * 0.006) + 20_00)).toInt()
        else -> //visa, mir, мир
            if (transferAmount * 0.0075 <= 35_00) 35_00
            else ("%.0f".format(transferAmount * 0.0075).toInt())
    }
}