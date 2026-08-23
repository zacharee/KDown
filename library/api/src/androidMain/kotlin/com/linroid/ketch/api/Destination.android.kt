@file:Suppress("UseKtx")

package com.linroid.ketch.api

import android.net.Uri
import android.provider.DocumentsContract
import com.linroid.ketch.api.log.KetchLogger

actual fun Destination.isFile(): Boolean =
  !isName().also { KetchLogger("Dest").e { "isName $this ${it}" } } && !isDirectory().also { KetchLogger("Dest").e { "isDir $this $it" } }

actual fun Destination.isDirectory(): Boolean {
  val uri = Uri.parse(value)
  if (uri.scheme == "content") {
    return DocumentsContract.isTreeUri(uri)
  }
  return value.endsWith('/') || value.endsWith('\\')
}

actual fun Destination.isName(): Boolean {
  val uri = Uri.parse(value)
  if (uri.scheme != null) return false
  return !value.contains('/') && !value.contains('\\')
}
