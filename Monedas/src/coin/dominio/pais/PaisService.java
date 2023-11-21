
package coin.dominio.pais;
import coin.persistencia.PaisDAO;
import java.util.Collection;

public class PaisService {

    private PaisDAO dao;

    public PaisService() {
        this.dao = new PaisDAO();
    }

    public void crearPais(String nombre) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }
            
            
            
            if (buscarPaisPorNombre(nombre) != null) {
                throw new Exception("Ya existe un pais con el nombre indicado " + nombre);
            }

            //Creamos el usuario
            Pais pais = new Pais();
            pais.setNombre(nombre);
            
            dao.guardarPais(pais);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarNombrePais(String nombre, String nuevoNombre) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el pais");
            }

            if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nuevo nombre");
            }

            //Buscamos
            Pais pais = buscarPaisPorNombre(nombre);

            //Validamos
            if (!pais.getNombre().equals(nombre)) {
                throw new Exception("El nombre actual no es el registrado en el sistema");
            }

            //Modificamos
            pais.setNombre(nuevoNombre);

            dao.modificarPais(pais);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarPais(String nombre) throws Exception {

        try {

            //Validamos 
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            dao.eliminarPais(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    public Pais buscarPaisPorNombre(String nombre) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            Pais pais = dao.buscarPaisPorNombre(nombre);

            return pais;
        } catch (Exception e) {
            throw e;
        }
    }

    public Pais buscarPaisPorId(Integer id) throws Exception {

        try {

            //Validamos
            if (id == null) {
                throw new Exception("Debe indicar el id");
            }

            Pais pais = dao.buscarPaisPorId(id);

            return pais;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Pais> listarPais() throws Exception {

        try {

            Collection<Pais> paises = dao.listarPaises();

            return paises;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirPaises() throws Exception {

        try {

            //Listamos los paises
            Collection<Pais> paises = listarPais();

            //Imprimimos los paises
            if (paises.isEmpty()) {
                throw new Exception("No existen paises para imprimir");
            } else {
                for (Pais u : paises) {
                    System.out.println(u);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
