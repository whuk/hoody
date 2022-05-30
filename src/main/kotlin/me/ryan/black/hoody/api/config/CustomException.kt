package me.ryan.black.hoody.api.config

import me.ryan.black.hoody.api.common.Error
import me.ryan.black.hoody.api.common.ErrorCode
import me.ryan.black.hoody.api.common.ErrorSource

open class CustomException(error: ErrorSource) : RuntimeException(error.message)

/**
 * Human Exception
 */
open class HumanException(error: ErrorSource) : CustomException(error)

class UsernameInvalidException : HumanException(Error(ErrorCode.HI00, "Username Invalid"))

/**
 * UnAuthorized Exception
 */
open class UnAuthorizedException(error: Error) : CustomException(error)

class AccessDeniedException : UnAuthorizedException(Error(ErrorCode.HA00, "Unauthorized"))
