package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.Nomina;

/**
 * The Class NominaDAO.
 */
public class NominaDAO {

	/** The conexion. */
	private static Connection conexion;

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	public static Connection conectar() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/laboral", "root", "");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conexion;

	}

	/**
	 * Mostrar salario.
	 *
	 * @param dniEmpleado the dni empleado
	 * @return the nomina
	 */
	public Nomina mostrarSalario(String dniEmpleado) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Nomina nomina = null;

		try {
			connection = conectar();

			preparedStatement = connection.prepareStatement("select sueldo from nominas where dni =?");

			preparedStatement.setString(1, dniEmpleado);

			rs = preparedStatement.executeQuery();

			rs.absolute(1);
			int sueldo = rs.getInt("sueldo");

			nomina = new Nomina(sueldo, dniEmpleado);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nomina;
	}

	/**
	 * Actualizar nomina.
	 *
	 * @param nomina the nomina
	 * @throws SQLException the SQL exception
	 */
	public void actualizarNomina(Nomina nomina) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = conectar();
			preparedStatement = connection.prepareStatement("update nominas set sueldo = ? where dni = ?;");
			preparedStatement.setInt(1, nomina.getSueldo());
			preparedStatement.setString(2, nomina.getDniEmp());

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		{

		}
	}

	/**
	 * Insertar nomina.
	 *
	 * @param nomina the nomina
	 * @throws SQLException the SQL exception
	 */
	public static void insertarNomina(Nomina nomina) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = conectar();
			preparedStatement = connection.prepareStatement("INSERT INTO nominas (sueldo, dni) VALUES (?, ?);");
			preparedStatement.setInt(1, nomina.getSueldo());
			preparedStatement.setString(2, nomina.getDniEmp());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar la nomina");
		}
	}

	/**
	 * Eliminar nomina.
	 *
	 * @param dni the dni
	 * @throws SQLException the SQL exception
	 */
	public void eliminarNomina(String dni) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = conectar();
			preparedStatement = connection.prepareStatement("delete from nominas where dni = ?;");

			preparedStatement.setString(1, dni);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al eliminar nomina");
		}
	}

}
