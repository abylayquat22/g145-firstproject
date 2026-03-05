package g145.g145firstproject.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Phone {

    String name;
    String brand;
    Double price;
    @Builder.Default
    String description = "Хороший телефон";
}
