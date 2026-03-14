package g145.g145firstproject.exception;

import g145.g145firstproject.dto.HttpExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<HttpExceptionDto> handleNotFoundException(NotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(404)
                .body(HttpExceptionDto.builder()
                        .statusCode(404)
                        .message(e.getMessage())
                        .time(Instant.now())
                        .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<HttpExceptionDto> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.status(400)
                .body(HttpExceptionDto.builder()
                        .statusCode(400)
                        .message(e.getMessage())
                        .time(Instant.now())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpExceptionDto> handleException(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.status(500)
                .body(HttpExceptionDto.builder()
                        .statusCode(500)
                        .message("Unhandled error")
                        .time(Instant.now())
                        .build());
    }

}
