package g145.g145firstproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "NOTEBOOKS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE", nullable = false, length = 50, unique = true)
    private String code;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "MEMORY")
    private String memory;

    @Column(name = "RAM")
    private String ram;

    @Column(name = "GRAPHICS_CARD")
    private String graphicsCard;

}
