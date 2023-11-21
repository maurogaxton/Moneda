
package coin.dominio.moneda;

import coin.dominio.pais.Pais;

public class Moneda {
    private int id;
    private String denomina;
    private Double numero;
    private Pais pais;

    public Moneda() {
    }

    public Moneda(int id, String denomina, Double numero, Pais pais) {
        this.id = id;
        this.denomina = denomina;
        this.numero = numero;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenomina() {
        return denomina;
    }

    public void setDenomina(String denomina) {
        this.denomina = denomina;
    }

    public Double getNumero() {
        return numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Moneda{" + "id=" + id + ", denomina=" + denomina + ", numero=" + numero + ", pais=" + pais + '}';
    }
    
}
