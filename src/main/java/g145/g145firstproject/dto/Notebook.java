package g145.g145firstproject.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notebook {
    Long id;
    String name;
    String brand;
    Double price;
    String memory;
    String ram;
    String description;
    String processor;
    String graphicsCard;
}
