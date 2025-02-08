package br.com.manager.util;

public class MaskFormatter {

    public static String maskCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve conter 11 dígitos.");
        }
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }

    public static String maskPhone(String phone) {
        phone = phone.replaceAll("[^0-9]", "");

        if(phone.length() != 11) {
            throw new IllegalArgumentException("Número do celular deve conter 11 dígitos.");
        }
        return "(" + phone.substring(0,2) + ") " +
                phone.substring(2,7) + "-" +
                phone.substring(7,11);
    }

    public static String maskZip_code(String zip_code) {
        zip_code = zip_code.replaceAll("[^0-9]", "");
        if (zip_code.length() != 8) {
            throw new IllegalArgumentException("CEP deve conter 8 dígitos.");
        }

        if (!zip_code.matches("[0-9]+")) {
            throw new IllegalArgumentException("CEP deve conter apenas dígitos.");
        }

        return zip_code.substring(0,5) + "-" +
                zip_code.substring(5, 8);
    }
}
