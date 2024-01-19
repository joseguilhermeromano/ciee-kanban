package br.com.ciee.kanban.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;

@Entity
public class Kanban implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String descricao;
    @Column(name = "data_para_finalizar", columnDefinition = "DATE")
    private LocalDate dataParaFinalizar;
    private String targetColumn;
    private Integer positionColumn;
    private Boolean finalizado = false;

    public Kanban() {
        super();
    }

    public Kanban(Integer id, String nome, String email, String descricao, LocalDate dataParaFinalizar,String targetColumn, Integer positionColumn, Boolean finalizado) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataParaFinalizar = dataParaFinalizar;
        this.targetColumn = targetColumn;
        this.positionColumn = positionColumn;
        this.finalizado = finalizado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataParaFinalizar() {
        return dataParaFinalizar;
    }

    public void setDataParaFinalizar(LocalDate dataParaFinalizar) {
        this.dataParaFinalizar = dataParaFinalizar;
    }

    public String getTargetColumn() {
        return targetColumn;
    }

    public void setTargetColumn(String targetColumn) {
        this.targetColumn = targetColumn;
    }

    public Integer getPositionColumn() {
        return positionColumn;
    }

    public void setPositionColumn(Integer positionColumn) {
        this.positionColumn = positionColumn;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Kanban other = (Kanban) obj;
        if (id == null){
            if (other.id != null)
                return false;
        }else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataParaFinalizar.format(formatter);
    }
}
