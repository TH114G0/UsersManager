package br.com.manager.domain.model;

import br.com.manager.dto.AddressDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

    private String city;

    private String street;

    private String state;

    private String neighborhood;

    private String state_code;

    private String zip_code;

    private String complement;

    private String number;

    public Address(AddressDTO address) {
        this.city = address.getCity();
        this.street = address.getStreet();
        this.state = address.getState();
        this.state_code = address.getState_code();
        this.neighborhood = address.getNeighborhood();
        this.zip_code = address.getZip_code();
        this.complement = address.getComplement();
        this.number = address.getNumber();
    }

    public void update(AddressDTO addressDTO) {
        if (addressDTO.getCity() != null && !addressDTO.getCity().isBlank()) {
            this.city = addressDTO.getCity();
        }
        if (addressDTO.getStreet() != null && !addressDTO.getStreet().isBlank()) {
            this.street = addressDTO.getStreet();
        }
        if (addressDTO.getState() != null && !addressDTO.getState().isBlank()) {
            this.state = addressDTO.getState();
        }
        if (addressDTO.getState_code() != null && !addressDTO.getState_code().isBlank()) {
            this.state_code = addressDTO.getState_code();
        }
        if (addressDTO.getNeighborhood() != null && !addressDTO.getNeighborhood().isBlank()) {
            this.neighborhood = addressDTO.getNeighborhood();
        }
        if (addressDTO.getZip_code() != null && !addressDTO.getZip_code().isBlank()) {
            this.zip_code = addressDTO.getZip_code();
        }
        if (addressDTO.getComplement() != null && !addressDTO.getComplement().isBlank()) {
            this.complement = addressDTO.getComplement();
        }
        if (addressDTO.getNumber() != null && !addressDTO.getNumber().isBlank()) {
            this.number = addressDTO.getNumber();
        }
    }
}
