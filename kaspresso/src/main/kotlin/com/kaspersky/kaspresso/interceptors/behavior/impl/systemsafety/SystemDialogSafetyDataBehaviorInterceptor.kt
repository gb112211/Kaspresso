package com.kaspersky.kaspresso.interceptors.behavior.impl.systemsafety

import androidx.test.espresso.DataInteraction
import com.kaspersky.kaspresso.interceptors.behavior.DataBehaviorInterceptor
import com.kaspersky.kaspresso.logger.UiTestLogger
import com.kaspersky.kaspresso.systemsafety.SystemDialogSafetyParams
import com.kaspersky.kaspresso.systemsafety.SystemDialogSafetyProvider
import com.kaspersky.kaspresso.systemsafety.SystemDialogSafetyProviderImpl

class SystemDialogSafetyDataBehaviorInterceptor(
    private val params: SystemDialogSafetyParams,
    private val logger: UiTestLogger
) : DataBehaviorInterceptor,
    SystemDialogSafetyProvider by SystemDialogSafetyProviderImpl(params, logger) {

    override fun <R> intercept(interaction: DataInteraction, action: () -> R): R = passSystemDialogs(action = action)
}