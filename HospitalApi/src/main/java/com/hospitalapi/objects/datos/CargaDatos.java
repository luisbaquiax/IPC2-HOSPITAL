/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.objects.datos;

import com.hospitalapi.data.modelDB.AdminDB;
import com.hospitalapi.data.modelDB.ConsultaDB;
import com.hospitalapi.data.modelDB.EspecialidadDB;
import com.hospitalapi.data.modelDB.ExamenConsultaDB;
import com.hospitalapi.data.modelDB.ExamenesSolicitudDB;
import com.hospitalapi.data.modelDB.HistorialPorcentajDB;
import com.hospitalapi.data.modelDB.HorarioDB;
import com.hospitalapi.data.modelDB.LaboratorioDB;
import com.hospitalapi.data.modelDB.MedicoDB;
import com.hospitalapi.data.modelDB.MedicoEspecialidadDB;
import com.hospitalapi.data.modelDB.PacienteDB;
import com.hospitalapi.data.modelDB.PrecioExamenDB;
import com.hospitalapi.data.modelDB.SolicitudExamenDB;
import com.hospitalapi.data.modelDB.TipoExamenDB;
import com.hospitalapi.data.modelDB.UserDB;
import com.hospitalapi.model.Consulta;
import com.hospitalapi.model.Especialidad;
import com.hospitalapi.model.ExamenConsulta;
import com.hospitalapi.model.ExamenSolicitado;
import com.hospitalapi.model.Horario;
import com.hospitalapi.model.MedicoEspecialidad;
import com.hospitalapi.model.PrecioExamen;
import com.hospitalapi.model.SolicitudExamen;
import com.hospitalapi.model.TipoExamen;
import com.hospitalapi.model.Usuario;
import com.hospitalapi.objects.Encriptador;
import com.hospitalapi.objects.ListaTiposUsuario;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author luis
 */
@Getter
@ToString
public class CargaDatos {

    private ProcesadorEnradaJSON procesadorJSON;

    //DB
    private EspecialidadDB especialidadDB;
    private MedicoEspecialidadDB medicoEspecialidadDB;
    private UserDB userDB;
    private MedicoDB medicoDB;
    private PacienteDB pacienteDB;
    private LaboratorioDB laboratorioDB;
    private AdminDB adminDB;
    private ConsultaDB consultaDB;
    private ExamenConsultaDB examenConsultaDB;
    private SolicitudExamenDB solicitudExamenDB;
    private ExamenesSolicitudDB examenesSolicitudDB;
    private TipoExamenDB tipoExamenDB;
    private PrecioExamenDB precioExamenDB;
    private HorarioDB horarioDB;

    private Encriptador encriptador;

    public CargaDatos(ProcesadorEnradaJSON procesadorJSON) {
        this.procesadorJSON = procesadorJSON;
        //DB
        this.especialidadDB = new EspecialidadDB();
        this.medicoEspecialidadDB = new MedicoEspecialidadDB();
        this.userDB = new UserDB();
        this.medicoDB = new MedicoDB();
        this.pacienteDB = new PacienteDB();
        this.laboratorioDB = new LaboratorioDB();
        this.adminDB = new AdminDB();
        this.consultaDB = new ConsultaDB();
        this.examenConsultaDB = new ExamenConsultaDB();
        this.solicitudExamenDB = new SolicitudExamenDB();
        this.examenesSolicitudDB = new ExamenesSolicitudDB();
        this.tipoExamenDB = new TipoExamenDB();
        this.precioExamenDB = new PrecioExamenDB();
        this.horarioDB = new HorarioDB();

        this.encriptador = new Encriptador();
    }

    public void subirDatos(ProcesadorEnradaJSON procesadorJSON) {
        subirTipoExamen(procesadorJSON.getTiposExamens());
        subirEspecialidades(procesadorJSON.getEspecialidades());
        subirUsuarios(procesadorJSON.getUsuarios());
        subirPrecioExamenLaboratorio(procesadorJSON.getPreciosExamens());
        subirMedicoEspecialidad(procesadorJSON.getEspecialidadesMedicos());
        subirConsultas(procesadorJSON.getConsultas());
        subirExamenesConsulta(procesadorJSON.getExamenConsultas());
        subirSolicitudExamenLab(procesadorJSON.getSolicitudExamens());
        subirExamenesSolicitudLab(procesadorJSON.getExamenesSolicitados());
        subirHorarios(procesadorJSON.getHorariosMedicos());
    }

    private void subirTipoExamen(List<TipoExamen> tipoExamenes) {
        for (TipoExamen tipoExamen : tipoExamenes) {
            tipoExamenDB.insertTipoExamen(tipoExamen);
        }
    }

    private void subirEspecialidades(List<Especialidad> especialidads) {
        for (Especialidad especialidad : especialidads) {
            especialidadDB.insert(especialidad);
        }
    }

    private void subirUsuarios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            usuario.setPassword(encriptador.encriptar(usuario.getPassword()));
            if (userDB.insertFromFile(usuario)) {
                switch (usuario.getTipo()) {
                    case ListaTiposUsuario.ADMIN:
                        adminDB.insert(usuario.getId());
                        break;
                    case ListaTiposUsuario.MEDICO:
                        medicoDB.insert(usuario.getId());
                        break;
                    case ListaTiposUsuario.PACIENTE:
                        pacienteDB.insert(usuario.getId());
                        break;
                    case ListaTiposUsuario.LABORATORIO:
                        laboratorioDB.insert(usuario.getId());
                        break;
                }
            }

        }
    }

    private void subirPrecioExamenLaboratorio(List<List<PrecioExamen>> preciosExamenes) {
        System.out.println(Arrays.toString(preciosExamenes.toArray()));
        for (List<PrecioExamen> preciosExamene : preciosExamenes) {
            for (PrecioExamen precioExamen : preciosExamene) {
                precioExamenDB.insert(precioExamen);
            }
        }
    }

    private void subirConsultas(List<Consulta> consultas) {
        for (Consulta consulta : consultas) {
            if (consultaDB.insertFromFile(consulta)) {
            }
        }
    }

    private void subirExamenesConsulta(List<List<ExamenConsulta>> examenesConsulta) {
        System.out.println(Arrays.toString(examenesConsulta.toArray()));
        for (List<ExamenConsulta> list : examenesConsulta) {
            for (ExamenConsulta examenConsulta : list) {
                examenConsultaDB.insert(examenConsulta);
            }
        }
    }

    private void subirSolicitudExamenLab(List<SolicitudExamen> solicitudes) {
        System.out.println(Arrays.toString(solicitudes.toArray()));
        for (SolicitudExamen solicitud : solicitudes) {
            solicitudExamenDB.insertFromFile(solicitud);
        }
    }

    private void subirExamenesSolicitudLab(List<List<ExamenSolicitado>> examaenes) {
        System.out.println(Arrays.toString(examaenes.toArray()));
        for (List<ExamenSolicitado> examaene : examaenes) {
            for (ExamenSolicitado examenSolicitado : examaene) {
                examenesSolicitudDB.insert(examenSolicitado);
            }
        }
    }

    private void subirHorarios(List<List<Horario>> horarios) {
        for (List<Horario> horario : horarios) {
            for (Horario horario1 : horario) {
                horarioDB.insert(horario1);
            }
        }
    }

    private void subirMedicoEspecialidad(List<List<MedicoEspecialidad>> especialidads) {
        System.out.println("Especialidades-meido:" + Arrays.toString(especialidads.toArray()));
        for (List<MedicoEspecialidad> especialidad : especialidads) {
            for (MedicoEspecialidad medicoEspecialidad : especialidad) {
                medicoEspecialidadDB.insert(medicoEspecialidad);
            }
        }
    }

}
