package Firedev.DesafioKitsu.Handler;

import Firedev.DesafioKitsu.Util.Exceptions.ExceptionDetails;
import Firedev.DesafioKitsu.Util.Exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails> handlerBadRequestException(BadRequestException badRequest){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request, Invalid Values")
                        .details(badRequest.getMessage())
                        .developerMessage("Valores invalidos foram passados pela url, revise-os")
                        .build(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ExceptionDetails> handlerNumberFormatException(NumberFormatException numberFormat){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request, Invalid Values")
                        .details(numberFormat.getMessage())
                        .developerMessage("Tipos de valores invalidos foram passados pela url, revise-os")
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ExceptionDetails> handlerHttpClientErrorException(HttpClientErrorException clientError){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("No results")
                        .details(clientError.getMessage())
                        .developerMessage("Que pena, parece que o conteúdo que voce procurou não está disponivel")
                        .build(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionDetails> handlerNullPointerException(NullPointerException nullPointer){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Valores nulos")
                        .details(nullPointer.getMessage())
                        .developerMessage("Confira a url, você pode ter esquecido algum atributo ou passado um errado.")
                        .build(), HttpStatus.BAD_REQUEST);
    }
}
