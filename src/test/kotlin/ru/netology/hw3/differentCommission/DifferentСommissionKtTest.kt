package ru.netology.hw3.differentCommission

import org.junit.Test

import org.junit.Assert.*

class DifferentCommissionKtTest {

    @Test
    fun test_by_default_commissionCalculation() {
        val cardType = "vkpay"
        val amountOfPreviousTransfers = 0
        val testTransferAmount = 76_00

        val result = commissionCalculation(
            cardAccountType = cardType,
            amountOfPreviousTransfersThisMonth = amountOfPreviousTransfers,
            transferAmount = testTransferAmount
        )

        assertEquals(0, result)
    }

    @Test
    fun test_mastercard_maestro_noOutOfLimit_CommissionCalculation() {
        val cardType = "maestro"
        val amountOfPreviousTransfers = 0
        val testTransferAmount = 760_00

        val result = commissionCalculation(
            cardAccountType = cardType,
            amountOfPreviousTransfersThisMonth = amountOfPreviousTransfers,
            transferAmount = testTransferAmount
        )

        assertEquals(0, result)
    }

    @Test
    fun test_mastercard_maestro_OutOfLimit_CommissionCalculation() {
        val cardType = "maestro"
        val amountOfPreviousTransfers = 75_000_00
        val testTransferAmount = 760_00

        val result = commissionCalculation(
            cardAccountType = cardType,
            amountOfPreviousTransfersThisMonth = amountOfPreviousTransfers,
            transferAmount = testTransferAmount
        )

        assertEquals(2456, result)
    }

    @Test
    fun test_visa_mir_noOutOfLimit_CommissionCalculation() {
        val cardType = "visa"
        val amountOfPreviousTransfers = 0
        val testTransferAmount = 760_00

        val result = commissionCalculation(
            cardAccountType = cardType,
            amountOfPreviousTransfersThisMonth = amountOfPreviousTransfers,
            transferAmount = testTransferAmount
        )

        assertEquals(3500, result)
    }

    @Test
    fun test_visa_mir_OutOfLimit_CommissionCalculation() {
        val cardType = "visa"
        val amountOfPreviousTransfers = 0
        val testTransferAmount = 760_000_00

        val result = commissionCalculation(
            cardAccountType = cardType,
            amountOfPreviousTransfersThisMonth = amountOfPreviousTransfers,
            transferAmount = testTransferAmount
        )

        assertEquals(570000, result)
    }

    @Test
    fun testOfTest_by_default_commissionCalculation() {
        val cardType = "vkpay"
        val amountOfPreviousTransfers = 0
        val testTransferAmount = 76_00

        val result = commissionCalculation(
            cardAccountType = cardType,
            amountOfPreviousTransfersThisMonth = amountOfPreviousTransfers,
            transferAmount = testTransferAmount
        )

        assertEquals(3500, result)
    }
}