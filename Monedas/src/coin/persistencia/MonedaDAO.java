
package coin.persistencia;

import coin.dominio.moneda.Moneda;
import coin.dominio.pais.Pais;
import coin.dominio.pais.PaisService;
import java.util.ArrayList;
import java.util.Collection;

public final class MonedaDAO extends DAO {

    private final PaisService paisService;

    public MonedaDAO() {
        this.paisService = new PaisService();
    }

    public void guardarMoneda(Moneda moneda) throws Exception {
        try {
            if (moneda == null) {
                throw new Exception("Debe indicar la moneda");
            }
            String sql = "INSERT INTO Moneda (denomina, numero, idPais) "
                    + "VALUES ( '" + moneda.getDenomina() + "' , '" + moneda.getNumero() + "' ," + moneda.getPais().getId() + " );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarMoneda(Moneda moneda) throws Exception {
        try {
            if (moneda == null) {
                throw new Exception("Debe indicar la moneda que desea modificar");
            }
            String sql = "UPDATE Moneda SET "
                    + " denomina = '" + moneda.getDenomina() + "' , numero = '" + moneda.getNumero() + "' , idPais = " + moneda.getPais().getId()
                    + " WHERE id = '" + moneda.getId() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarMoneda(int id) throws Exception {
        try {
            String sql = "DELETE FROM Moneda WHERE id = " + id + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Moneda buscarMonedaPorId(int id) throws Exception {
        try {
            String sql = "SELECT * FROM Moneda WHERE id = " + id + "";
            consultarBase(sql);
            Moneda moneda = null;
            while (resultado.next()) {
                moneda = new Moneda();
                moneda.setId(resultado.getInt(1));
                moneda.setDenomina(resultado.getString(2));
                moneda.setNumero(resultado.getDouble(3));
                Integer idPais = resultado.getInt(4);
                Pais pais = paisService.buscarPaisPorId(idPais);
                moneda.setPais(pais);
            }
            desconectarBase();
            return moneda;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Moneda> listarMonedas() throws Exception {
        try {
            String sql = "SELECT * FROM Moneda ";
            consultarBase(sql);
            Moneda moneda = null;
            Collection<Moneda> monedas = new ArrayList();
            while (resultado.next()) {
                moneda = new Moneda();
                moneda.setId(resultado.getInt(1));
                moneda.setDenomina(resultado.getString(2));
                moneda.setNumero(resultado.getDouble(3));
                Integer idPais = resultado.getInt(4);
                Pais pais = paisService.buscarPaisPorId(idPais);
                moneda.setPais(pais);
                monedas.add(moneda);
            }
            desconectarBase();
            return monedas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
