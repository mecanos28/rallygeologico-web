package cr.ac.ucr.cicg.clavicusoft.rallygeologico.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CompetitionStatistics")
public class CompetitionStatistics extends BasicEntity {

    @Id
    @Column(name="FacebookId")
    private String facebookId;

    @Id
    @Column(name="CompetitionId")
    private boolean competitionId;

    @Column(name="StartingDate")
    private Date startingDate;

    @Column(name="FinishingDate")
    private Date finishingDate;

    @Column(name = "Points")
    private int points;

    @Override
    public boolean onEquals(Object o) {
        return false;
    }

    @Override
    public int onHashCode(int result) {
        return 0;
    }
}
