/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.service.admin;

import com.hospitalapi.data.modelDB.HistorialPorcentajDB;
import com.hospitalapi.model.HistorialPorcentaje;
import com.hospitalapi.objects.Entidad;
import java.util.List;

/**
 *
 * @author luis
 */
public class HistorialPorcentajeService implements Entidad {

    private HistorialPorcentajDB historialPorcentajDB;

    public HistorialPorcentajeService() {
        this.historialPorcentajDB = new HistorialPorcentajDB();
    }

    @Override
    public boolean insert(Object object) {
        return this.historialPorcentajDB.insert((HistorialPorcentaje) object);
    }

    @Override
    public boolean update(Object object) {
        return this.historialPorcentajDB.update((HistorialPorcentaje) object);
    }

    public List<HistorialPorcentaje> getAll() {
        return this.historialPorcentajDB.getListaHistorialPorcentaje();
    }

}
