package br.com.manager.domain.model;


import br.com.manager.dto.CreateUserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Embedded;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String cpf;

    private String phone;

    @Embedded
    private Address address;

    public Users(CreateUserDTO createUserDTO) {
        this.name = createUserDTO.getName();
        this.email = createUserDTO.getEmail();
        this.cpf = createUserDTO.getCpf();
        this.phone = createUserDTO.getPhone();
        this.address = new Address(createUserDTO.getAddress());
    }
}
