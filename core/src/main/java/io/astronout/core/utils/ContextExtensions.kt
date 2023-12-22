package io.astronout.core.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
fun Context.hasNotificationPermission(): Boolean {
    return ContextCompat.checkSelfPermission(this,
        android.Manifest.permission.POST_NOTIFICATIONS
    ) == PackageManager.PERMISSION_GRANTED
}

fun Context.shareLink(url: String) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, url)
    }
    startActivity(Intent.createChooser(shareIntent, null))
}