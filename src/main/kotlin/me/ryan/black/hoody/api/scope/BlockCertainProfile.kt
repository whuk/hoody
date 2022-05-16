package me.ryan.black.hoody.api.scope

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class BlockCertainProfile(
    val profiles: Array<String> = ["prod"]
)
