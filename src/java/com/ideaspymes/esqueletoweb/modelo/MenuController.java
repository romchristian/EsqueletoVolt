/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.esqueletoweb.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cromero
 */
@Named
@SessionScoped
public class MenuController implements Serializable {

    private List<Modulo> modulos;
    private Modulo moduloActual;

    @PostConstruct
    public void init() {
        cargaModulos();
    }

    public Modulo getModuloActual() {
        return moduloActual;
    }

    public void setModuloActual(Modulo moduloActual) {
        this.moduloActual = moduloActual;
    }

    public List<Modulo> getModulos() {
        if (modulos == null) {
            cargaModulos();
        }
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    private void cargaModulos() {
        modulos = new ArrayList<>();
        Modulo modulo1 = new Modulo("Punto de Venta", "icon-printer2 Opac80", "/EsqueletoVolt/main/puntoventa/home.xhtml", "Tickets, Facturas..");
        Submenu menuSesiones = new Submenu(modulo1, "Sesiones", "icon-select");
        MenuItem mItemMiSesion = new MenuItem(menuSesiones, "#", "Mi Sesión", "icon-uniE675");
        List<MenuItem> listaItems1 = new ArrayList<>();
        listaItems1.add(mItemMiSesion);
        menuSesiones.setItems(listaItems1);
        Submenu menuProductos = new Submenu(modulo1, "Productos", "icon-select");
        MenuItem mItemProductos = new MenuItem(menuProductos, "#", "Productos", "icon-uniE675");
        List<MenuItem> listaItems2 = new ArrayList<>();
        listaItems1.add(mItemProductos);
        menuProductos.setItems(listaItems2);
        
        List<Submenu> submenus1 = new ArrayList<>();
        submenus1.add(menuSesiones);
        submenus1.add(menuProductos);
        
        modulo1.setMenus(submenus1);
        
        
        
        
        moduloActual = modulo1;
        modulos.add(new Modulo("Contabilidad", "icon-printer2 Opac80", "/EsqueletoVolt/main/contabilidad/home.xhtml", "Cuentas, Asientos.."));
        modulos.add(new Modulo("Compras", "icon-printer2 Opac80", "/EsqueletoVolt/main/compras/home.xhtml", "Órdenes de compras, etc."));
        modulos.add(new Modulo("Ventas", "icon-printer2 Opac80", "/EsqueletoVolt/main/ventas/home.xhtml", "Presupuestos, Pedidos.."));
        modulos.add(new Modulo("Stock", "icon-printer2 Opac80", "/EsqueletoVolt/main/stock/home.xhtml", "Stock, Movimientos.."));
        modulos.add(modulo1);
    }

}
