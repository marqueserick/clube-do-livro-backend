package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {

    @Id
    @Column(name = "cod_cliente")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;


}
