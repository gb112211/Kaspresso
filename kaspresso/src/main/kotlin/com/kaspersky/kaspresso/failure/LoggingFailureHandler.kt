package com.kaspersky.kaspresso.failure

import android.view.View
import androidx.test.espresso.FailureHandler
import com.kaspersky.kaspresso.logger.UiTestLogger
import org.hamcrest.Matcher

/**
 * An implementation of [FailureHandler] that logs rich description of failure.
 */
class LoggingFailureHandler(
    val logger: UiTestLogger
) : FailureHandler,
    FailureLoggingProvider by FailureLoggingProviderImpl(logger) {

    @Throws(Throwable::class)
    override fun handle(error: Throwable?, viewMatcher: Matcher<View>?) {
        logDescriptionAndThrow(error, viewMatcher)
    }
}