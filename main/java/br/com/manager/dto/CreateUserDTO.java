package br.com.manager.dto;

import br.com.manager.util.MaskFormatter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateUserDTO {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String cpf;

    @NotBlank
    private String phone;

    @NotNull
    @Valid
    private AddressDTO address;

    public String getCpf() {
        return MaskFormatter.maskCpf(this.cpf);
    }

    public String getPhone() {
        return MaskFormatter.maskPhone(this.phone);
    }
}
