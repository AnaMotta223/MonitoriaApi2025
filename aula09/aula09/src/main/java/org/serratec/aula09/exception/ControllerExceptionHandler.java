package org.serratec.aula09.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<String> erros = new ArrayList<>();
		
		for(FieldError fe : ex.getBindingResult().getFieldErrors()) {
			erros.add(fe.getField() + " : " + fe.getDefaultMessage());
		}
		
		ErroResposta erroResposta = new ErroResposta(status.value(), "Existem campos inválidos", LocalDateTime.now(), erros);
		
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}
	
	@ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<String> handleEmailJaCadastrado(EmailJaCadastradoException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Email já cadastrado.");
    }

    @ExceptionHandler(InscricaoDuplicadaException.class)
    public ResponseEntity<String> handleInscricaoDuplicada(InscricaoDuplicadaException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body("Inscrição já realizada.");
    }
    
    @ExceptionHandler(SenhaInvalidaException.class)
    public ResponseEntity<String> handleSenhaInvalida(SenhaInvalidaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Senha e confirma senha devem ser iguais.");
    }

}
