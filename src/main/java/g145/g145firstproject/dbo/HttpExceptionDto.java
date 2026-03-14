package g145.g145firstproject.dbo;

import lombok.*;

import java.time.Instant;
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HttpExceptionDto {
    private String message;
    private Integer code;
    private Instant data;
}
