package cr.ac.ucr.cicg.clavicusoft.rallygeologico.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Invitation")
public class Invitation extends BasicEntity{

    @Id
    @Column(name="InvitationId")
    private String invitationId;

    @Column(name="Accepted")
    private boolean accepted;

    @OneToOne(mappedBy="relatedCompetitions")
    private Set<Competition> competitions;

    @OneToOne(mappedBy="HostId")
    private User hostId;

    @OneToOne(mappedBy="GuestId")
    private User guestId;

    @Override
    public boolean onEquals(Object o) {
        return false;
    }

    @Override
    public int onHashCode(int result) {
        return 0;
    }
}
