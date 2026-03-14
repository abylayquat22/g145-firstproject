package g145.g145firstproject.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class HttpExceptionDto {

    private Integer statusCode;
    private String message;
    private Instant time;
}
