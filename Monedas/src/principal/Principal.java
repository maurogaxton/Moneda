
package principal;


import coin.dominio.moneda.MonedaService;
import coin.dominio.pais.Pais;
import coin.dominio.pais.PaisService;

public class Principal {

    public static void main(String[] args) {

        PaisService paisService = new PaisService();
        MonedaService monedaService = new MonedaService();

        
        try {
            //Creamos  paises
            paisService.crearPais("Argentina");
            paisService.crearPais("Uruguay");
            paisService.imprimirPaises();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        
        
        try {
            //Modificamos un pais
            paisService.modificarNombrePais("Argentina", "Noruega");
            paisService.imprimirPaises();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        
        
        try {
            //Eliminamos un pais
            paisService.eliminarPais("Noruega");
            paisService.imprimirPaises();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        
        
        try {
            //Buscamos el pais por nombre
            Pais pais = paisService.buscarPaisPorNombre("Uruguay");
            
            //Creamos moneda con el pais anterior
            
            monedaService.crearMoneda("Euro", 50.00, pais);

            //Mostramos Moneda con su pais
            monedaService.imprimirMonedas();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        
        
    }
}
