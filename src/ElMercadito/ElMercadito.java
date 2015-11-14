/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ElMercadito;
import Persistencia.ControladoraPersistencia;
import model.Sucursal;
import view.*;

/**
 *
 * @author Antonio
 * autor autor autor
 */
public class ElMercadito {
    private static final Sucursal unaSucursal = new Sucursal(1,"cuil","telefono","razon social");
    private ControladoraPersistencia unaControlPersistencia;
    private ControladoraVisual unaControladoraVisual = new ControladoraVisual();

    public static void main(String[] args) throws Exception{
        ElMercadito unMercadito = new ElMercadito();
        unMercadito.getUnaControladoraVisual().crearMenu(unMercadito);
    }
   
    public Sucursal getUnaSucursal() {
        return unaSucursal;
    }
    public ControladoraVisual getUnaControladoraVisual() {
        return unaControladoraVisual;
    }

    public void setUnaControladoraVisual(ControladoraVisual unaControladoraVisual) {
        this.unaControladoraVisual = unaControladoraVisual;
    }

    public ControladoraPersistencia getUnaControlPersistencia() {
        return unaControlPersistencia;
    }


    public void setUnaControlPersistencia(ControladoraPersistencia unaControlPersistencia) {
        this.unaControlPersistencia = unaControlPersistencia;
    }

}
    

    