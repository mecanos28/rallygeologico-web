package cr.ac.ucr.cicg.clavicusoft.rallygeologico.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Canton")
public class Canton extends BasicEntity {

    @Id
    @Column(name="Name")
    private String name;

    @OneToMany(mappedBy = "HasDistrict")
    private Set<District> districts;

    @ManyToOne
    private Province province;
}
