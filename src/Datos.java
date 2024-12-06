import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class Datos {
    // Parámetros de conexión - REEMPLAZA estos con tus datos de Clever Cloud
    // Al inicio de tu método de conexión
    

// Modifica tu URL de conexión para usar el formato correcto
    private static final String URL = "jdbc:mysql://bfazsrsylgrnbv9oyjti-mysql.services.clever-cloud.com:3306/bfazsrsylgrnbv9oyjti";
    private static final String USER = "uyvfun0cm0izhv2s";
    private static final String PASSWORD = "5AV6ltD2rAZ9vqnZALg3";

    //codigo Materia
    private int codigo;
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    //nombre materia
    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //creditos materia
    private int creditos;
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    //semeste materia
    private int semestre;
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    //intensidad materia
    private int intensidad_horaria_semanal;
    public int getIntensidad_horaria_semanal() {
        return intensidad_horaria_semanal;
    }
    public void setIntensidad_horaria_semanal(int intensidad_horaria_semanal) {
        this.intensidad_horaria_semanal = intensidad_horaria_semanal;
    }

    //metodo de estudio
    private String metodo_estudio;
    public String getMetodo_estudio() {
        return metodo_estudio;
    }
    public void setMetodo_estudio(String metodo_estudio) {
        this.metodo_estudio = metodo_estudio;
    }

    //alternativa
    private String metodo_estudio_alternativo;
    public String getMetodo_estudio_alternativo() {
        return metodo_estudio_alternativo;
    }
    public void setMetodo_estudio_alternativo(String metodo_estudio_alternativo) {
        this.metodo_estudio_alternativo = metodo_estudio_alternativo;
    }

    //herramienta de estudio
    private String herramienta_de_estudio;
    public String getHerramienta_de_estudio() {
        return herramienta_de_estudio;
    }
    public void setHerramienta_de_estudio(String herramienta_de_estudio) {
        this.herramienta_de_estudio = herramienta_de_estudio;
    }

    private int diaExamen;

    public int getDiaExamen() {
        return diaExamen;
    }
    public void setDiaExamen(int diaExamen) {
        this.diaExamen = diaExamen;
    }

    private double porsentaje;

   
    public double getPorsentaje() {
        return porsentaje;
    }
    public void setPorsentaje(double porsentaje) {
        this.porsentaje = porsentaje;
    }

    private double horasSemanales;
    
    public double getHorasSemanales() {
        return horasSemanales;
    }
    public void setHorasSemanales(double horasSemanales) {
        this.horasSemanales = horasSemanales;
    }
    public static List<Datos> consultaPorSemestre(int semestre){
        List<Datos> resultados = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM Materias WHERE semestre = ?")) {
        
        statement.setInt(1, semestre);
        
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Datos dato = new Datos();
                dato.setNombre(resultSet.getString("nombre"));
                dato.setCodigo(resultSet.getInt("codigo"));
                dato.setCreditos(resultSet.getInt("creditos"));
                dato.setSemestre(resultSet.getInt("semestre"));
                dato.setIntensidad_horaria_semanal(resultSet.getInt("intensidad_horaria_semanal"));
                dato.setMetodo_estudio(resultSet.getString("metodo_estudio"));
                dato.setMetodo_estudio_alternativo(resultSet.getString("metodo_estudio_alternativo"));
                dato.setHerramienta_de_estudio(resultSet.getString("herramientas_estudio"));
                resultados.add(dato);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al consultar los datos: " + e.getMessage());
    }
    
    return resultados;   
    }
    
}
