package cr.ac.ucr.cicg.clavicusoft.rallygeologico.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Province")
public class Province extends BasicEntity{

    @Id
    @Column(name="Name")
    private String name;

    @OneToMany(mappedBy = "HasCanton")
    private Set<Canton> cantons;

    @OneToMany(mappedBy = "Sites")
    private Set<Site> sites;

}
