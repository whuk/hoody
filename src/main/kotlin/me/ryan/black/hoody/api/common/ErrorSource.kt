package me.ryan.black.hoody.api.common

interface ErrorSource {
    val code: String
    val message: String
    val causeBy: Map<String, Any>?
    val refCode: String?
}
