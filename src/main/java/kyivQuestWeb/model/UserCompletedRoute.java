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
@Table(name = "usercompletedroute")
public class UserCompletedRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userid", nullable = false)
    private Long userid;

    @Column(name = "routeid", nullable = false)
    private Long routeid;

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "routeid", referencedColumnName = "id", insertable = false, updatable = false)
    private Route route;
}
