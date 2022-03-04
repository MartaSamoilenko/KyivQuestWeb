package kyivQuestWeb.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "datetime", nullable = false)
    private Date datetime;

    @Column(name = "namegenerated", nullable = false)
    private String namegenerated;

    @Column(name = "userid", nullable = false)
    private Long userid;

    @Column(name = "routeid", nullable = false)
    private Long routeid;

    @OneToOne
    @JoinColumn(name = "routeid", referencedColumnName = "id", insertable = false, updatable = false)
    private Route route;

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
}
