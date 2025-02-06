package br.com.manager.dto;

import br.com.manager.util.MaskFormatter;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDTO {

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @NotBlank
    private String state;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String zip_code;

    @NotBlank
    private String state_code;

    private String complement;

    private String number;

    public String getZip_code() {
        return MaskFormatter.maskZip_code(this.zip_code);
    }
}
