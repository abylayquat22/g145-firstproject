package g145.g145.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Item  {
    private Long id;
    private String name;
    private String description;
    private double price;

}
