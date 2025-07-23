package edu.workshop.todo.todo_console.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.workshop.todo.todo_console.dto.GrupoDeListaDTO;
import edu.workshop.todo.todo_console.dto.GrupoDeListaResponseDTO;
import edu.workshop.todo.todo_console.exception.DuplicateResourceException;
import edu.workshop.todo.todo_console.mapper.ListaDeTareaMapper;
import edu.workshop.todo.todo_console.model.GrupoDeLista;
import edu.workshop.todo.todo_console.model.ListaDeTarea;
import edu.workshop.todo.todo_console.model.Usuarios;
import edu.workshop.todo.todo_console.repository.GrupoDeListaRepository;
import edu.workshop.todo.todo_console.service.GrupoDeListaService;
import edu.workshop.todo.todo_console.mapper.ListaDeTareaMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class GrupoDeListaServiceImpl implements GrupoDeListaService {
    private final GrupoDeListaRepository grupoDeListaRepository;

    @Override
    @Transactional
    public GrupoDeListaResponseDTO crearGrupoDeLista(GrupoDeListaDTO dto) {
        log.info("Creating a new Grupo de lista to user: {}", dto.getId());

        if (grupoDeListaRepository.findById(dto.getId()).isPresent()) {
            throw DuplicateResourceException.create("GrupoDeLista", "id", dto.getNombre());
        }

        List<ListaDeTarea> listaDeTareas = ListaDeTareaMapper.toEntityList(dto.getListaDeTareas());

        GrupoDeLista grupoDeLista = GrupoDeLista.builder()
                .nombre(dto.getNombre())
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .listasDeTareas(listaDeTareas)
                .build();
        Usuarios usuario = new Usuarios();
        usuario.setId(dto.getUsuario_id());
        grupoDeLista.setUsuario(usuario);

        for (ListaDeTarea listaDeTarea : listaDeTareas) {
            listaDeTarea.setGrupoDeLista(grupoDeLista);
        }

        GrupoDeLista savedGrupoDeLista = grupoDeListaRepository.save(grupoDeLista);
        return mapToDto(savedGrupoDeLista);

    }

    @Override
    @Transactional
    public void eliminarGrupoDeLista(Long id) {
        log.info("Deleting Grupo de Lista with ID: ", id);
        grupoDeListaRepository.deleteById(id);
        log.info("Grupo deleted successfully: {}", id);
    }

    public GrupoDeListaResponseDTO mapToDto(GrupoDeLista grupoDeLista) {
        return GrupoDeListaResponseDTO.builder()
                .id(grupoDeLista.getId())
                .nombre(grupoDeLista.getNombre())
                .fechaDeCreacion(grupoDeLista.getFechaDeCreacion())
                .listaDeTareas(ListaDeTareaMapper.toDTOList(grupoDeLista.getListasDeTareas()))
                .usuario_id(grupoDeLista.getUsuario().getId())
                .build();
    }

}
