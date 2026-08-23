package com.linroid.ketch.endpoints.model

import kotlinx.serialization.Serializable

@Serializable
data class UpdateHeadersRequest(
  val newHeaders: Map<String, String>,
)
