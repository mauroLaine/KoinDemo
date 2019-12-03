package com.laine.mauro.koindemo

import com.laine.mauro.koindemo.model.MyCurrency

object CurrencyFactory {

    fun makeCurrency(): MyCurrency {
        return MyCurrency(
            DataFactory.randomInt(),
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            DataFactory.randomUuid()
        )
    }

    fun makeCurrencyList(count: Int): List<MyCurrency> {
        return (0..count).map { makeCurrency() }
    }
}