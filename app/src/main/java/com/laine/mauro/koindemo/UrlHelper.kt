package com.laine.mauro.koindemo

import android.content.Context
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat

class UrlHelper {

    fun lanchUrl(context: Context, uri: Uri) {
        val customTab = CustomTabsIntent.Builder()
            .addDefaultShareMenuItem()
            .setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
            .setShowTitle(true)
            .build()
        customTab.launchUrl(context, uri)
    }
}