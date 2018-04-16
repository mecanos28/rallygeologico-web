package cr.ac.ucr.cicg.clavicusoft.rallygeologico.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "User")
public class User extends BasicEntity{

    @Id
    @Column(name="FacebookId")
    private String facebookId;

    @Column(name="Username")
    private String username;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="Email")
    private String email;

    @Column(name="PhotoUrl")
    private String photoUrl;

    @OneToMany(mappedBy="Host")
    private Set<Invitation> sentInvitations;

    @OneToMany(mappedBy="Guest")
    private Set<Invitation> receivedInvitations;

    @OneToOne
    private Competition competition;

    @OneToMany(mappedBy="competitionStatistics")
    private Set<CompetitionStatistics> competitionStatistics;

    @Override
    public boolean onEquals(Object o) {
        return false;
    }

    @Override
    public int onHashCode(int result) {
        return 0;
    }
}
