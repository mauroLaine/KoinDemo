package com.laine.mauro.koindemo

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.laine.mauro.koindemo.data.DataRepository
import com.laine.mauro.koindemo.model.MyCurrency
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest : KoinTest {

    private val mockDataRepository = mock<DataRepository>()

    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Test
    fun activityLaunches() {
        activity.launchActivity(null)
        onView(withId(R.id.currencies_rv)).check(matches(isDisplayed()))
    }

    @Test
    fun checkCurrenciesDisplay() {
        val currencies = CurrencyFactory.makeCurrencyList(5)
        stubDataRepositoryCurrencies(currencies)
        activity.launchActivity(null)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.laine.mauro.koindemo", appContext.packageName)
    }

    private fun stubDataRepositoryCurrencies(currencies: List<MyCurrency>) {
        whenever(mockDataRepository.getCurrencies(any())).thenReturn(currencies)
    }
}
