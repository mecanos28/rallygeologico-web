package cr.ac.ucr.cicg.clavicusoft.rallygeologico.model;

import javax.persistence.*;

@Entity
@Table(name = "District")
public class District extends BasicEntity {

    @Id
    @Column(name="Name")
    private String name;

    @ManyToOne
    private Canton canton;
}
