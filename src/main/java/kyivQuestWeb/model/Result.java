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
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userid", nullable = false)
    private Long userid;

    @Column(name = "questionid", nullable = false)
    private Long questionid;

    @Column(name = "routeid", nullable = false)
    private Long routeid;

    @Column(name = "useranswer")
    private Long useranswer;

    @Column(name = "result")
    private Boolean result;

    @Column(name = "points", nullable = false)
    private Long points;

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "questionid", referencedColumnName = "id", insertable = false, updatable = false)
    private Question question;

    @OneToOne
    @JoinColumn(name = "routeid", referencedColumnName = "id", insertable = false, updatable = false)
    private Route route;
}
