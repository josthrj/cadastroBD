## AS DOCUMENTAÇOES DESTE PROJETO ENCONTRA-SE NO SUIGUINTE LINK: https://drive.google.com/file/d/1Q6nfk2uVywmnZ0iahnwAWwtpbr5M4vnC/view?usp=drive_link
# cadastroBD
 Descrição geral
Esta aplicação Java foi desenvolvida para lidar com o gerenciamento de usuários em um banco de dados MySQL. Os princípios do padrão de design DAO (Data Access Object) foram implementados para separar a lógica de acesso a dados da lógica de negócios, promovendo assim um código mais limpo, modular e de fácil manutenção.

Componentes do aplicativo
Classe de usuário:

Descrição: Representa um usuário no sistema.
Atributos:
código: identificador exclusivo do usuário.
nome: Nome do usuário.
telefone: número de telefone do usuário.
e-mail: endereço de e-mail do usuário.
Métodos: Inclui getters e setters para cada atributo.

package entity;

public class Usuario {
    private int codigo;
    private String nome;
    private String telefone;
    private String email;

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
}


# Classe UsuarioDAO:

Descrição: Gerencia operações de acesso a dados para a entidade Usuário.
Métodos:
insertUser: Insere um usuário no banco de dados.
Tratamento de exceções: captura e trata SQLException para garantir que os erros no banco de dados sejam tratados corretamente.


package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entity.Usuario;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (codigo, nome, telefone, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getCodigo());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


# Classe de APP:

Descrição: Contém o método principal e serve como ponto de entrada da aplicação.
Características:
Estabelece uma conexão com o banco de dados MySQL.
Crie instâncias de User e DAOUser.
Insira um usuário no banco de dados usando DAOUser.
Lida com quaisquer exceções SQL que possam ocorrer.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import DAO.UsuarioDAO;
import entity.Usuario;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bancoDadosLoja";
        String user = "root";
        String password = "134265Rj*";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(conn);

            Usuario usuario = new Usuario();
            usuario.setCodigo(1);
            usuario.setNome("Joao");
            usuario.setTelefone("123456789");
            usuario.setEmail("joao@example.com");

            usuarioDAO.inserirUsuario(usuario);
            System.out.println("Usuário inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
# Conclusão
A aplicação demonstra o uso do padrão DAO para gerenciar a persistência de dados de forma eficiente e organizada. Ao encapsular a lógica de acesso a dados na classe DAOUser, é alcançada uma separação clara de responsabilidades, tornando o código mais fácil de manter e escalonável.

### Tecnologias Utilizadas

1. **Java**: Principal linguagem de programação utilizada para desenvolver a aplicação.
 - Versão: Java 17 (Zulu OpenJDK 17.0.11)

2. **JDBC (Java Database Connectivity)**: Middleware utilizado para conectar e executar consultas no banco de dados.
 - Driver: Driver MySQL JDBC

3. **MySQL**: Sistema de gerenciamento de banco de dados relacional usado para armazenar dados do usuário.
 - Versão: MySQL 8.0

4. **IDE/ambientes de desenvolvimento**:
 - **Visual Studio Code**: Editor de código usado para escrever e desenvolver o projeto.
 - **NetBeans**: Ambiente de desenvolvimento integrado (IDE) que também pode ser usado para abrir e gerenciar o projeto.

5. **Maven**: ferramenta de automação de compilação e gerenciamento de dependências usada para gerenciar bibliotecas e ciclo de vida do projeto.
 - Arquivo de configuração: `pom.xml`

6. **Git**: Sistema de controle de versão usado para gerenciar o código-fonte e seu histórico.
 - Plataforma de hospedagem de repositório: GitHub (opcional)

7. **Markdown**: Linguagem de marcação leve usada para criar o arquivo `README.md` com a documentação do projeto.

### Resumo de Tecnologias

Essas tecnologias foram integradas para desenvolver uma aplicação robusta e escalável, onde Java e JDBC gerenciam a lógica de negócios e o acesso aos dados, respectivamente, e o MySQL atua como backend para armazenamento de dados. Ambientes e ferramentas de desenvolvimento adicionais, como Maven e Git, facilitam o desenvolvimento, o gerenciamento de dependências e o controle de versões, garantindo um fluxo de trabalho eficiente e organizado.
