package me.ryan.black.hoody.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.io.IOException
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

object Jackson {
    private val mapper = Jackson2ObjectMapperBuilder.json()
        .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .modules(JavaTimeModule())
        .serializerByType(
            LocalDateTime::class.java,
            LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
        )
        .serializers(CustomSerializer())
        .build<ObjectMapper>()
        .registerKotlinModule()

    fun getMapper(): ObjectMapper = mapper

}

private class CustomSerializer : StdSerializer<Date>(Date::class.java) {
    override fun serialize(value: Date?, gen: JsonGenerator?, provider: SerializerProvider?) {
        if (value != null && gen != null) {
            gen.writeString(
                LocalDateTime.ofInstant(
                    value.toInstant(),
                    ZoneId.systemDefault()
                ).format(DateTimeFormatter.ISO_DATE_TIME)
            )
        }
    }
}

class KeepAsJsonDeserializer : JsonDeserializer<String>() {

    @Throws(IOException::class, JsonProcessingException::class)
    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext?): String {
        return jp.codec.readTree<TreeNode?>(jp).toString()
    }
}

internal fun <T> T.toJson(): String = Jackson.getMapper().writeValueAsString(this)

internal inline fun <reified T> String.fromJson(): T = Jackson.getMapper().readValue(this)