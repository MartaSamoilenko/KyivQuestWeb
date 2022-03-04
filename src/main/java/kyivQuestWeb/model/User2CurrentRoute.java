package kyivQuestWeb.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "user2currentroute")
public class User2CurrentRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "currentuserid", nullable = false)
    private Long currentuserid;

    @Column(name = "currentrouteid", nullable = false)
    private Long currentrouteid;

    @Column(name = "currentcheckpointid", nullable = false)
    private Long currentcheckpointid;

    @Column(name = "date", nullable = false)
    private LocalDateTime localDateTime;

    @OneToOne
    @JoinColumn(name = "currentuserid", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "currentrouteid", referencedColumnName = "id", insertable = false, updatable = false)
    private Route route;

    @OneToOne
    @JoinColumn(name = "currentcheckpointid", referencedColumnName = "id", insertable = false, updatable = false)
    private Checkpoint checkpoint;
}
