package destinychild.controller.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolarView {
    private Long id;
    private Long userId;
    private String coordinateFull;
    private Long coordinateUniverse;
    private Long coordinateSystem;
    private Long coordinatePlanetnumber;
}
