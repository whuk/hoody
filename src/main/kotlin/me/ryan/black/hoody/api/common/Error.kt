package me.ryan.black.hoody.api.common

class Error(
    errorCode: ErrorCode,
    override val message: String,
    override val causeBy: Map<String, Any>? = null
) : ErrorSource {
    override val code = errorCode.name
    override val refCode: String? = null
}
