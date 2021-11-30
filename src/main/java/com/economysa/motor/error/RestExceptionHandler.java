package com.economysa.motor.error;

import com.economysa.motor.error.exception.BadRequestException;
import com.economysa.motor.error.exception.UserAlreadyExistsException;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author QuickDev
 * @version 1.0
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe,
                                                           HttpServletRequest request) {
    ErrorDetail errorDetail = new ErrorDetail();
    errorDetail.setTimeStamp(new Date().getTime());
    errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
    errorDetail.setTitle(ConstantMessage.ERROR_NOT_FOUND);
    errorDetail.setDetail(rnfe.getMessage());
    errorDetail.setDeveloperMessage(rnfe.getClass().getName());

    return new ResponseEntity(errorDetail, null, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException uaee,
                                                            HttpServletRequest request) {
    ErrorDetail errorDetail = new ErrorDetail();
    errorDetail.setTimeStamp(new Date().getTime());
    errorDetail.setStatus(HttpStatus.CONFLICT.value());
    errorDetail.setTitle(ConstantMessage.ERROR_CONFLICT);
    errorDetail.setDetail(uaee.getMessage());
    errorDetail.setDeveloperMessage(uaee.getClass().getName());

    return new ResponseEntity(errorDetail, null, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<?> handleBadRequestException(BadRequestException bre,
                                                     HttpServletRequest request) {
    ErrorDetail errorDetail = new ErrorDetail();
    errorDetail.setTimeStamp(new Date().getTime());
    errorDetail.setStatus(HttpStatus.BAD_REQUEST.value());
    errorDetail.setTitle(ConstantMessage.ERROR_BAD_REQUEST);
    errorDetail.setDetail(bre.getMessage());
    errorDetail.setDeveloperMessage(bre.getClass().getName());

    return new ResponseEntity(errorDetail, null, HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                HttpHeaders headers, HttpStatus status,
                                                                WebRequest request) {
    ErrorDetail errorDetail = new ErrorDetail();
    errorDetail.setTimeStamp(new Date().getTime());
    errorDetail.setStatus(status.value());
    errorDetail.setTitle(ConstantMessage.ERROR_MESSAGE_NOT_READABLE);
    errorDetail.setDetail(ex.getMessage());
    errorDetail.setDeveloperMessage(ex.getClass().getName());

    return handleExceptionInternal(ex, errorDetail, headers, status, request);
  }

  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manve,
                                                             HttpHeaders headers, HttpStatus status,
                                                             WebRequest request) {
    ErrorDetail errorDetail = new ErrorDetail();
    errorDetail.setTimeStamp(new Date().getTime());
    errorDetail.setStatus(HttpStatus.BAD_REQUEST.value());
    errorDetail.setTitle(ConstantMessage.ERROR_VALIDATION_FAILED);
    errorDetail.setDetail(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED);
    errorDetail.setDeveloperMessage(manve.getClass().getName());

    List<FieldError> fieldErrors = manve.getBindingResult().getFieldErrors();
    for (FieldError fe : fieldErrors) {
      List<ValidationError> validationErrorList = errorDetail.getErrors().get(fe.getField());
      if (validationErrorList == null) {
        validationErrorList = new ArrayList<>();
        errorDetail.getErrors().put(fe.getField(), validationErrorList);
      }
      ValidationError validationError = new ValidationError();
      validationError.setCode(fe.getCode());
      validationError.setMessage(fe.getDefaultMessage());
      validationErrorList.add(validationError);
    }

    return handleExceptionInternal(manve, errorDetail, headers, status, request);
  }
}
