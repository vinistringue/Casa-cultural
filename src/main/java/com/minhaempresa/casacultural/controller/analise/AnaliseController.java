package com.minhaempresa.casacultural.controller.analise;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.minhaempresa.casacultural.model.Analise;
import com.minhaempresa.casacultural.repository.AnaliseRepository;

@RestController
@RequestMapping("/api/analises")
public class AnaliseController {

    @Autowired
    private AnaliseRepository analiseRepository;

    // Endpoint para listar análises
    @GetMapping
    public ResponseEntity<List<Analise>> listarAnalises() {
        List<Analise> analises = analiseRepository.findAll();
        return new ResponseEntity<>(analises, HttpStatus.OK);
    }

    // Endpoint para adicionar uma nova análise
    @PostMapping
    public ResponseEntity<Analise> adicionarAnalise(@RequestBody Analise analise) {
        Analise novaAnalise = analiseRepository.save(analise);
        return new ResponseEntity<>(novaAnalise, HttpStatus.CREATED);
    }

    // Endpoint para atualizar uma análise existente
    @PutMapping("/{id}")
    public ResponseEntity<Analise> atualizarAnalise(@PathVariable Long id, @RequestBody Analise analise) {
        Optional<Analise> analiseOptional = analiseRepository.findById(id);
        if (analiseOptional.isPresent()) {
            Analise analiseExistente = analiseOptional.get();
            // Atualize os campos da análise com base nos dados fornecidos
            analiseExistente.setComentario(analise.getComentario());
            analiseExistente.setNota(analise.getNota());
            // Suponha que haja um campo "filme" na entidade Analise para relacioná-la a um Filme
            analiseExistente.setFilme(analise.getFilme());
            Analise analiseAtualizada = analiseRepository.save(analiseExistente);
            return new ResponseEntity<>(analiseAtualizada, HttpStatus.OK);
        } else {
            // Caso a análise com o ID especificado não seja encontrada, retorne NOT_FOUND (404)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para excluir uma análise pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnalise(@PathVariable Long id) {
        Optional<Analise> analiseOptional = analiseRepository.findById(id);
        if (analiseOptional.isPresent()) {
            analiseRepository.deleteById(id);
            // Retorna NO_CONTENT (204) após a exclusão bem-sucedida
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // Caso a análise com o ID especificado não seja encontrada, retorne NOT_FOUND (404)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
