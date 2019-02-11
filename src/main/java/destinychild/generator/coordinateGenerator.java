package destinychild.generator;

import lombok.Data;

@Data
public class coordinateGenerator {
    private int primarysystemnumberrandom = (int)( Math.random()*(500-1+1))+1;
    private Integer primaryplantnumberrandom = (int)( Math.random()*(15-1+1))+1 ;
    private String coordfull = "1:"+primarysystemnumberrandom+":"+primaryplantnumberrandom;
    private Integer coordsyst = primarysystemnumberrandom;
    private Integer coordplan = primaryplantnumberrandom;
}
