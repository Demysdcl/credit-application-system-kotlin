package com.dclfactor.credit.application.system.modules.exception

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidException(ex: MethodArgumentNotValidException) = ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(
            ExceptionDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDateTime.now(),
                exception = ex.javaClass.toString(),
                status = HttpStatus.BAD_REQUEST.value(),
                details = ex.bindingResult
                    .allErrors
                    .associate { (it as FieldError).field to it.defaultMessage }
                    .toMutableMap()
            )
        )

    @ExceptionHandler(DataAccessException::class)
    fun handleDataAccessException(ex: DataAccessException) = ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(
            ExceptionDetails(
                title = "Conflict! Consult the documentation",
                timestamp = LocalDateTime.now(),
                exception = ex.javaClass.toString(),
                status = HttpStatus.CONFLICT.value(),
                details = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )


    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException) = ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(
            ExceptionDetails(
                title = "Not Found! Consult the documentation",
                timestamp = LocalDateTime.now(),
                exception = ex.javaClass.toString(),
                status = HttpStatus.NOT_FOUND.value(),
                details = mutableMapOf("message" to ex.message)
            )
        )
}