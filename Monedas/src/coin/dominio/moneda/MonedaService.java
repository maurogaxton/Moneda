
package coin.dominio.moneda;
import coin.dominio.moneda.Moneda;
import coin.dominio.pais.Pais;
import coin.persistencia.MonedaDAO;
import java.util.Collection;

public class MonedaService {

    private MonedaDAO dao;

    public MonedaService() {
        this.dao = new MonedaDAO();
    }

    public void crearMoneda(String denomina, Double numero, Pais pais) throws Exception {

        try {
            //Validamos
            if (denomina == null || denomina.trim().isEmpty()) {
                throw new Exception("Debe indicar la denominación");
            }

            if (numero == null || numero == 0) {
                throw new Exception("Debe indicar el valor");
            }

            if (pais == null) {
                throw new Exception("Debe indicar el País");
            }

            //Creamos la moneda
            Moneda moneda = new Moneda();
            moneda.setDenomina(denomina);
            moneda.setNumero(numero);
            moneda.setPais(pais);

            dao.guardarMoneda(moneda);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarClaveMoneda(int id, String denomina, Double numero, int idPais) throws Exception {

        try {

            //Validamos
            if (id > 0) {
                throw new Exception("Debe indicar el id");
            }

            if (denomina == null || denomina.trim().isEmpty()) {
                throw new Exception("Debe indicar la denominación");
            }

            if (numero == null || numero == 0) {
                throw new Exception("Debe indicar el valor");
            }

            if (idPais < 0) {
                throw new Exception("Debe indicar el País");
            }

            //Buscamos
            Moneda moneda = buscarMonedaPorId(id);

            dao.modificarMoneda(moneda);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarMoneda(int id) throws Exception {

        try {

            //Validamos 
            if (id < 0) {
                throw new Exception("Debe indicar el Id");
            }
            dao.eliminarMoneda(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public Moneda buscarMonedaPorId(int id) throws Exception {

        try {

            //Validamos
            if (id < 0) {
                throw new Exception("Debe indicar el id");
            }
            Moneda moneda = dao.buscarMonedaPorId(id);
            //Verificamos
            if (moneda == null) {
                throw new Exception("No se econtró la moneda para el païs");
            }

            return moneda;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Moneda> listarMoneda() throws Exception {

        try {

            Collection<Moneda> monedas = dao.listarMonedas();

            return monedas;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirMonedas() throws Exception {

        try {

            //Listamos las monedas
            Collection<Moneda> monedas = listarMoneda();

            //Imprimimos las monedas
            if (monedas.isEmpty()) {
                throw new Exception("No existen monedas para imprimir");
            } else {
                for (Moneda u : monedas) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}

