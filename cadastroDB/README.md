# catastroBD
Descripción general Esta aplicación Java está diseñada para lidar con la gerencia de usuarios en un banco de datos MySQL. Los principios del patrón de diseño DAO (objeto de acceso a datos) para las implementaciones para separar la lógica de acceso a los datos de la lógica de negocios, promoviendo un código más limpio, modular y de fácil manipulación.

Componentes del aplicativo Clase de usuario:

Descripción: Representa un usuario no sistema. Atributos: código: identificador exclusivo del usuario. nombre: Nombre del usuario. teléfono: número de teléfono del usuario. correo electrónico: endereço de e-mail do usuário. Métodos: Incluye captadores y definidores para cada atributo.

entidad de paquete;

public class Usuario { privado int codigo; nombre de cadena privado; teléfono privado String; correo electrónico de cadena privada;

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

# Clase UsuarioDAO:
Descripción: Gestión de operaciones de acceso a datos para una entidad usuaria. Métodos: insertUser: Inserte un usuario en el banco de datos. Tratamiento de excesos: captura y trata SQLException para garantizar que los errores no se tratan correctamente en el banco de datos.

paquete DAO;

importar java.sql.Conexión; importar java.sql.PreparedStatement; importar java.sql.SQLException; entidad importadora.Usuario;

clase pública UsuarioDAO { conexión de conexión privada;

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

# Clase de aplicación:
Descripción: Contiene el método principal y sirve como punto de entrada de la aplicación. Características: Establece una conexión con el banco de datos MySQL. Llame a instancias de User y DAOUser. Insira um usuário no banco de datos usando DAOUser. Lida com quaisquer exceções SQL que possam ocorrer.

importar java.sql.Conexión; importar java.sql.DriverManager; importar java.sql.SQLException; importar DAO.UsuarioDAO; entidad importadora.Usuario;

Aplicación de clase pública { public static void main(String[] args) { String url = "jdbc:mysql://localhost:3306/bancoDadosLoja"; Usuario de cadena = "raíz"; Contraseña de cadena = "134265Rj*";

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

# conclusión
Esta aplicación demuestra el uso del padrón DAO para gestionar la persistencia de datos de forma eficiente y organizada. Al encapsular la lógica de acceso a los datos de la clase DAOUser, se logra una separación clara de responsabilidades, tornando el código más fácil de mantener y escalar.

Tecnologias Utilizadas
Java : lenguaje de programación principal utilizado para desarrollar una aplicación.
Versión: Java 17 (Zulu OpenJDK 17.0.11)
JDBC (Java Database Connectivity) : middleware utilizado para conectar y ejecutar consultas en el banco de datos.
Controlador: Controlador MySQL JDBC
MySQL : Sistema de gestión de banco de datos relacional usado para armazenar datos del usuario.
Versión: MySQL 8.0
IDE/ambientes de desarrollo :
Visual Studio Code : editor de código usado para grabar y desarrollar el proyecto.
NetBeans : Ambiente de desarrollo integrado (IDE) que también puede usarse para abrir y gerenciar el proyecto.
Maven : herramienta de automatización de compilación y gestión de dependencias utilizadas para gestionar bibliotecas y ciclo de vida del proyecto.
Archivo de configuración:pom.xml
Git : Sistema de control de versión usado para gestionar el código fuente y su histórico.
Plataforma de hospedaje de repositorio: GitHub (opcional)
Markdown : Lenguaje de marcación leve usado para guardar el archivo README.mdcon la documentación del proyecto.
Resumen de Tecnologías
Estas tecnologías están integradas para desarrollar una aplicación robusta y escalable, desde la gerencia de Java y JDBC a la lógica de negocios y el acceso a los datos, respectivamente, y MySQL como backend para armamento de datos. Ambientes y herramientas de desarrollo adicional, como Maven y Git, facilitan el desarrollo, la gestión de dependencias y el control de versiones, garantizando un flujo de trabajo eficiente y organizado.

