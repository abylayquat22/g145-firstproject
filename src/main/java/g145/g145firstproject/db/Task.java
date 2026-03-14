package g145.g145firstproject.db;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Task {
    private Long id;
    private String name;
    private String deadlineDate;
    private boolean isCompleted;
}
