package g145.g145firstproject.dbo;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaskDTO {
    private Long id;
    private String name;
    private LocalDate deadlineDate;
    private boolean isCompleted;
}
