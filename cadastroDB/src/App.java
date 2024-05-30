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
