package me.ryan.black.hoody.api.config

import me.ryan.black.hoody.api.common.ErrorSource
import me.ryan.black.hoody.utils.Jackson
import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.ServletWebRequest
import javax.servlet.http.HttpServletRequest

@ControllerAdvice(annotations = [RestController::class])
class ExceptionConfiguration(
    private val env: Environment
) {
    @ExceptionHandler(value = [HumanException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleHumanException(
        e: HumanException,
        request: HttpServletRequest
    ): GlobalErrorFormat {
        return errorForm(request, e, e.error)
    }

    private fun errorForm(request: HttpServletRequest, e: Exception, error: ErrorSource): GlobalErrorFormat {

        val errorAttributeOptions = if (env.activeProfiles.contains("prod").not())
            ErrorAttributeOptions.of(ErrorAttributeOptions.Include.STACK_TRACE)
        else ErrorAttributeOptions.defaults()

        val errorAttributes =
            DefaultErrorAttributes().getErrorAttributes(ServletWebRequest(request), errorAttributeOptions)

        errorAttributes.apply {
            this["message"] = error.message
            this["code"] = error.code
            this["causeBy"] = error.causeBy
            this["type"] = e.javaClass.simpleName
        }

        return Jackson.getMapper().convertValue(errorAttributes, GlobalErrorFormat::class.java)
    }
}