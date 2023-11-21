package equipo7.challenge2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name = "roles")
public class Role {
    @Id
    @GeneratedValue
    private long id_role;
    @Enumerated(EnumType.STRING)
    private Erole role;
}
