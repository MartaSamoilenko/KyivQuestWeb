package kyivQuestWeb.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "route2checkpoint")
public class Route2Checkpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "routeid")
    private long routeid;

    @Column(name = "checkpointid")
    private long checkpointid;

    @OneToOne
    @JoinColumn(name = "routeid", referencedColumnName = "id", insertable = false, updatable = false)
    private Route route;

    @OneToOne
    @JoinColumn(name = "checkpointid", referencedColumnName = "id", insertable = false, updatable = false)
    private Checkpoint checkpoint;


}
