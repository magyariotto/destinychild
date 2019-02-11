package destinychild.controller.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserView {
    private Long id;
    private String userName;
    private String email;
    private String coordinateFull;
    private String tp;
    private String planetNumber;
}
