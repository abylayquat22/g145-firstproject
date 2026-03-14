package g145.g145firstproject.exception;

import g145.g145firstproject.dbo.HttpExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<HttpExceptionDto> handleNotFoundException(NotFoundException e){
        return ResponseEntity.status(404)
                .body(HttpExceptionDto.builder()
                        .message(e.getMessage())
                        .code(404)
                        .data(Instant.now())
                        .build());
    }
}
