/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.service.laboratorio;

import com.hospitalapi.data.modelDB.ExamanesLaboratorioDB;
import com.hospitalapi.data.modelDB.PrecioExamenDB;
import com.hospitalapi.model.Laboratorio;
import com.hospitalapi.model.PrecioExamen;
import com.hospitalapi.model.Usuario;
import com.hospitalapi.model.reports.ExamenesLaboratorio;
import java.util.List;

/**
 *
 * @author luis
 */
public class ServiceExamenesLaboratorio {

    private ExamanesLaboratorioDB examanesLaboratorioDB;
    private PrecioExamenDB precioExamenDB;

    public ServiceExamenesLaboratorio() {
        this.examanesLaboratorioDB = new ExamanesLaboratorioDB();
        this.precioExamenDB = new PrecioExamenDB();
    }

    public List<ExamenesLaboratorio> getByLaboratorio(Usuario userLab) {
        return this.examanesLaboratorioDB.getList(userLab);
    }

}
