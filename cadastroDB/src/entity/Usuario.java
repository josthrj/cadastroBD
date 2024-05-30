package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario {

    private int codigo;
    private String nome;
    private String telefone;
    private String email;

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método para insertar un usuario en la base de datos
    public void inserirUsuario(Connection conn) throws SQLException {
        String sql = "INSERT INTO usuarios (codigo, nome, telefone, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getCodigo());
            stmt.setString(2, getNome());
            stmt.setString(3, getTelefone());
            stmt.setString(4, getEmail());
            stmt.executeUpdate();
        }
    }
}
