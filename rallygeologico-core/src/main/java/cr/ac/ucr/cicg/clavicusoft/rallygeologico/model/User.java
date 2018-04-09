package cr.ac.ucr.cicg.clavicusoft.rallygeologico.model;

import javax.persistence.*;

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

    @Override
    public boolean onEquals(Object o) {
        return false;
    }

    @Override
    public int onHashCode(int result) {
        return 0;
    }
}
