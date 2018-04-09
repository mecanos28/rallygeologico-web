package cr.ac.ucr.cicg.clavicusoft.rallygeologico.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Competition")
public class Competition extends BasicEntity {

    @Id
    @Column(name="CpId")
    private String competitionId;

    @Column(name="IsActive")
    private boolean isActive;

    @Column(name="IsPublic")
    private boolean isPublic;

    @Column(name="StartingDate")
    private Date startingDate;

    @Column(name="FinishingDate")
    private Date finishingDate;

    @Column(name="Name")
    private String name;

    @OneToOne(mappedBy="Admin")
    private User admin;

    @ManyToOne()
    private Rally rally;

    @Override
    public boolean onEquals(Object o) {
        return false;
    }

    @Override
    public int onHashCode(int result) {
        return 0;
    }
}
