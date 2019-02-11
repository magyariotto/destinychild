package destinychild.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class SolarSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long lineId;
    private Long userId;
    private String coordinateFull;
    private Integer coordinateUniverse;
    private Integer coordinateSystem;
    private Integer coordinatePlanetnumber;
}
