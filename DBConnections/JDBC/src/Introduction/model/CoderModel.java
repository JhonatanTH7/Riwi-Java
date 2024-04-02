package Introduction.model;

import Introduction.database.CRUD;
import Introduction.database.ConfigDB;
import Introduction.entity.Coder;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {
    @Override
    public Object insert(Object object) {
        // 1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();

        // 2. Castear el objeto
        Coder objCoder = (Coder) object;

        try {
            // 3. Crear el SQL
            String sql = "INSERT INTO coder(name,age,clan)VALUES(?,?,?);";

            // 4. Preparamos el statement
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            // 5. Asignar los ?
            objPrepare.setString(1, objCoder.getName());
            objPrepare.setInt(2, objCoder.getAge());
            objPrepare.setString(3, objCoder.getClan());

            // 6. Ejecutamos el Query
            objPrepare.execute();

            // 7. Obtener el resultado
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objCoder.setId(objResult.getInt(1));
            }

            // 8. Cerramos el prepareStatement
            objPrepare.close();
            JOptionPane.showMessageDialog(null, "Coder added successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error >> Couldn't add the Coder >> " + e.getMessage());
        }
        // 9. Cerrar la conexión
        ConfigDB.closeConnection();
        return objCoder;
    }

    @Override
    public boolean update(Object object) {
        // 1. Abrir conexión
        Connection objConnection = ConfigDB.openConnection();

        // 2. Convertir el objeto
        Coder objCoder = (Coder) object;

        // 3. Creamos la sentencia
        String sql = "UPDATE coder SET name=?,age=?,clan=? WHERE id=?";

        // Variable bandera para saber si se actualizó
        boolean idIsUpdated = false;
        try {
            // 4. Preparamos el statement
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            // 5. Dar valor a los ?
            objPreparedStatement.setString(1, objCoder.getName());
            objPreparedStatement.setInt(2, objCoder.getAge());
            objPreparedStatement.setString(3, objCoder.getClan());
            objPreparedStatement.setInt(4, objCoder.getId());

            // 6. Ejecutar el Query
            idIsUpdated = objPreparedStatement.execute();
            if (idIsUpdated) {
                JOptionPane.showMessageDialog(null, "Updated successfully");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        // 7. Cerrar la conexión
        ConfigDB.closeConnection();
        return idIsUpdated;
    }

    @Override
    public boolean delete(Object object) {
        // 1. Convertir el objeto a la entidad
        Coder objCoder = (Coder) object;

        // 2. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();

        // Variable bandera para saber si se actualizó
        boolean idIsDeleted = false;

        try {
            // 3. Escribir la sentencia SQL
            String sql = "DELETE FROM coder WHERE  id = ?;";

            // 4. Preparamos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // 5. Asignamos el valor al ?
            objPrepare.setInt(1, objCoder.getId());

            // 6. ExecuteUpdate devuelve la cantidad filas afectadas por la sentencia SQL
            // ejecutada.
            idIsDeleted = objPrepare.execute();

            if (idIsDeleted) {
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // 7. Cerrar la conexión
        ConfigDB.closeConnection();
        return idIsDeleted;
    }

    @Override
    public List<Object> findAll() {
        // 1. Abrir conexión
        Connection objConnection = ConfigDB.openConnection();

        // 2. Inicializar la lista donde se guardan los registros que
        // devuelve la BD
        List<Object> codersList = new ArrayList<>();

        try {
            // 3. Escribir la secuencia SQL
            String sql = "SELECT * FROM coder ORDER BY coder.id ASC;";

            // 4. Utilizar PrepareStatement para preparalo
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql);

            // 5. Ejecutar el Query o Prepare (Devuelve un tipo ResultSet)
            ResultSet objResult = (ResultSet) objPreparedStatement.executeQuery();

            // 6. Obtener los resultados
            while (objResult.next()) {
                // Instancia del objeto que vamos a usar
                Coder objCoder = new Coder();

                // Asignamos valores al objeto
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));

                // Finalmente, agregamos el objeto a la lista de elementos
                codersList.add(objCoder);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data acquisition error " + e.getMessage());
        }

        // 7. Cerramos la conexión
        ConfigDB.closeConnection();

        // 8. Retornamos lista de elementos
        return codersList;
    }

    @Override
    public Object findById(int id) {
        // 1. Abrir conexión
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = null;
        try {
            // 2. Sentencia SQL
            String sql = "SELECT * FROM coder WHERE id = ?;";

            // 3. Preparar el statement
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(sql);

            // 4. Damos valor al ?
            objPreparedStatement.setInt(1, id);

            // 5. Ejecutamos el Query
            ResultSet objResult = objPreparedStatement.executeQuery();

            // 6. Mientras haya un registro siguiente
            while (objResult.next()) {
                objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setAge(objResult.getInt("age"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        // 7. Cerrar la conexión
        ConfigDB.closeConnection();
        return objCoder;
    }

    public ArrayList<Coder> findByName(String name) {
        // 1. Abrir conexión
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = null;

        // 2. Crear sentencia SQL
        String sql = "SELECT * FROM coder WHERE coder.name LIKE ?;";
        ArrayList<Coder> codersList = new ArrayList<>();
        try {
            // 3. Preparar el statement
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(sql);

            // 4. Damos valor a ?
            objPreparedStatement.setString(1, "%" + name + "%");

            // 5. Ejecutamos el Query
            ResultSet objResult = objPreparedStatement.executeQuery();

            // 6. Damos valores
            while (objResult.next()) {
                objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));
                codersList.add(objCoder);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        // 7. Cerrar conexión
        ConfigDB.closeConnection();
        return codersList;
    }
}
