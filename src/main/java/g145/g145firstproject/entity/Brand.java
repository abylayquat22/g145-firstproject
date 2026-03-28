package g145.g145firstproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Not;

import java.util.List;

@Entity
@Table(name = "BRANDS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CODE", nullable = false, unique = true, length = 50)
    private String code;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

//    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Notebook> notebooks;
}
