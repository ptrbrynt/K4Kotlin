package com.livinglifetechway.k4kotlin

import android.widget.Toast
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment.application
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class ToastTest {

    private val shownToasts: List<Toast>
        get() = shadowOf(application).shownToasts

    @Test
    fun normalToast() {
        val toast = application.toast("Ping!")
        assertTrue(shownToasts.contains(toast))
    }

    @Test
    fun shortToast() {
        val toast = application.shortToast("Pop!")
        assertTrue(shownToasts.contains(toast))
    }

    @Test
    fun longToast() {
        val toast = application.longToast("Paaaaaarp!")
        assertTrue(shownToasts.contains(toast))
    }

    @Test
    fun normalToastNow() {
        application.toast("Hello!")
        val toast = application.toastNow("Surprise!")
        assertTrue(shownToasts.contains(toast))
    }

    @Test
    fun shortToastNow() {
        application.toast("Hello!")
        val toast = application.shortToastNow("Boo!")
        assertTrue(shownToasts.contains(toast))
    }

    @Test
    fun longToastNow() {
        application.toast("Hello!")
        val toast = application.longToastNow("This is an unexpected message!")
        assertTrue(shownToasts.contains(toast))
    }




}