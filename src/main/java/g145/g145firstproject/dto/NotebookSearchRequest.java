package g145.g145firstproject.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotebookSearchRequest {

    String code;
    String name;
    String description;
    Double price;
    String memory;
    String ram;
    String graphicsCard;
    Long brandId;
}
