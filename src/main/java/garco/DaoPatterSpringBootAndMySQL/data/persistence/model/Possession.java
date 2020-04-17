package garco.DaoPatterSpringBootAndMySQL.data.persistence.model;

import javax.persistence.*;

@Entity
@Table
public class Possession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Possession() {super();
    }
    public Possession(final String name) {
        super();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
