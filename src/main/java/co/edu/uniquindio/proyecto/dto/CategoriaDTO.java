package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotNull;

public class CategoriaDTO {

    @NotNull
    private String categoria;

    public CategoriaDTO() {}

    public CategoriaDTO(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
