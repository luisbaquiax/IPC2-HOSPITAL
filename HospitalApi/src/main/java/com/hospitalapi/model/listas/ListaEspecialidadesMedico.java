/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.model.listas;

import com.hospitalapi.model.reports.EspecialidadesMedico;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author luis
 */
@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class ListaEspecialidadesMedico {
    private List<EspecialidadesMedico> especialidades;
}
