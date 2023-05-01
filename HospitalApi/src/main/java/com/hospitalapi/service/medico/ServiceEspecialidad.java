/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.service.medico;

import com.hospitalapi.data.modelDB.EspecialidadDB;
import com.hospitalapi.data.modelDB.MedicoEspecialidadDB;
import com.hospitalapi.model.Especialidad;
import com.hospitalapi.model.MedicoEspecialidad;
import com.hospitalapi.model.reports.EspecialidadesMedico;
import java.util.List;

/**
 *
 * @author luis
 */
public class ServiceEspecialidad {

    private EspecialidadDB especialidadDB;

    private MedicoEspecialidadDB medicoEspecialidadDB;

    public ServiceEspecialidad() {
        this.especialidadDB = new EspecialidadDB();
        this.medicoEspecialidadDB = new MedicoEspecialidadDB();
    }

    public List<Especialidad> getEspecialidades() {
        return this.especialidadDB.getEspecialidades();
    }

    public void ingresarEspecialidades(List<EspecialidadesMedico> especialidades, int medico) {
        for (EspecialidadesMedico especialidad : especialidades) {
            for (Especialidad es : this.especialidadDB.getEspecialidades()) {
                if (especialidad.getEspecialidad().equals(es.getName())) {
                    this.medicoEspecialidadDB.insert(new MedicoEspecialidad(
                            es.getId(),
                            medico,
                            especialidad.getPrecio()));
                    break;
                }
            }
        }
    }
}
