package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hotel_alura.coneccion.ConeccionBD;
import com.hotel_alura.modelo.Huespedes;
import com.hotel_alura.views.HuespedesFrame;

public class HuespedesDAO {

	final private Connection con;

	public HuespedesDAO(Connection con) {
		this.con = con;
	}

	public void Agregar(Huespedes huesped) {

		try{			

			final PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO huespedes "
							+ "(Nombre, Apellido, FechaNacimiento,Nacionalidad,Telefono)"
							+ " VALUES (?, ?, ?,?,?)",
							Statement.RETURN_GENERATED_KEYS);

			try(statement) {
				//TODO Math
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setDate(3, huesped.getFechaNacimiento());
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				//statement.setInt(6,huesped.getIdReserva());

				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();

				try(resultSet) {
					while (resultSet.next()) {
						huesped.setId(resultSet.getInt(1));
						System.out.println(String.format("Fue insertado el producto %s", huesped));
					}
				}			

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}	
	
	

	public List<Huespedes> listar() {
		List<Huespedes> resultado= new ArrayList<>();      


		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT Id, Nombre, Apellido, FechaNacimiento,Nacionalidad,Telefono FROM huespedes");

			try(statement) {
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try(resultSet) {
					while (resultSet.next()) {
						resultado.add(new Huespedes(
								resultSet.getInt("Id"),
								resultSet.getString("Nombre"),
								resultSet.getString("Apellido"),
								resultSet.getDate("FechaNacimiento"),
								resultSet.getString("Nacionalidad"),
								resultSet.getString("Telefono")));                    

					}
				}
			}

			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;

	}

	public int modificar(String nombre, String apellido, Date fechaNac, String nacionalidad, String telefono,Integer id) {
		
                
        try {
            final PreparedStatement statement = con
                .prepareStatement("UPDATE huespedes SET "
                        + " Nombre = ?, "
                        + " Apellido = ?,"
                        + " FechaNacimiento = ?,"
                        + " Nacionalidad = ?,"
                        + " Telefono = ?"
                        + " WHERE Id = ?");
            
            try(statement) {
            	statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setDate(3, fechaNac);
                statement.setString(4, nacionalidad);
                statement.setString(5, telefono);
                statement.setInt(6, id);
                statement.execute();
        
                int updateCount = statement.getUpdateCount();
        
                return updateCount;
            }
                
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
	
	public int eliminar(Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	

	
}
