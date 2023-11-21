
package coin.persistencia;

import coin.dominio.pais.Pais;
import java.util.ArrayList;
import java.util.Collection;

public final class PaisDAO extends DAO {

    public void guardarPais(Pais pais) throws Exception {
        try {
            if (pais == null) {
                throw new Exception("Debe indicar el pais");
            }

            String sql = "INSERT INTO Pais (nombre)"
                    + "VALUES ( '" + pais.getNombre() + "' );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarPais(Pais pais) throws Exception {
        try {
            if (pais == null) {
                throw new Exception("Debe indicar el pais que desea modificar");
            }

            String sql = "UPDATE Pais SET "
                    + "nombre = '" + pais.getNombre() + "' WHERE nombre = '" + pais.getNombre() + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarPais(String nombre) throws Exception {
        try {

            String sql = "DELETE FROM Pais WHERE nombre = '" + nombre + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Pais buscarPaisPorNombre(String nombre) throws Exception {
        try {

            String sql = "SELECT * FROM Pais "
                    + " WHERE nombre = '" + nombre + "'";

            consultarBase(sql);

            Pais pais = null;
            while (resultado.next()) {
                pais = new Pais();
                pais.setId(resultado.getInt(1));
                pais.setNombre(resultado.getString(2));
                
            }
            desconectarBase();
            return pais;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Pais buscarPaisPorId(Integer id) throws Exception {
        try {

            String sql = "SELECT * FROM Pais "
                    + " WHERE id = '" + id + "'";

            consultarBase(sql);

            Pais pais = null;
            while (resultado.next()) {
                pais = new Pais();
                pais.setId(resultado.getInt(1));
                pais.setNombre(resultado.getString(2));
                
            }
            desconectarBase();
            return pais;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Pais> listarPaises() throws Exception {
        try {
            String sql = "SELECT nombre FROM Pais ";

            consultarBase(sql);

            Pais pais = null;
            Collection<Pais> paises = new ArrayList();
            while (resultado.next()) {
                pais = new Pais();
                pais.setNombre(resultado.getString(1));
                
                paises.add(pais);
            }
            desconectarBase();
            return paises;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
