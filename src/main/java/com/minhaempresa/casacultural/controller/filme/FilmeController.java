package com.minhaempresa.casacultural.controller.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.minhaempresa.casacultural.model.Filme;
import com.minhaempresa.casacultural.repository.FilmeRepository;

@RestController
@RequestMapping("/api")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    // Listar todos os filmes
    @GetMapping("/{id}")
    public ResponseEntity<List<Filme>> listarFilmes() {
        List<Filme> filmes = filmeRepository.findAll();
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }

    // Adicionar um novo filme
    @PostMapping("/filmes")
    public ResponseEntity<Filme> adicionarFilme(@RequestBody Filme filme) {
        Filme novoFilme = filmeRepository.save(filme);
        return new ResponseEntity<>(novoFilme, HttpStatus.CREATED);
    }

    // Atualizar um filme pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody Filme filme) {
        Optional<Filme> filmeOptional = filmeRepository.findById(id);
        if (filmeOptional.isPresent()) {
            Filme filmeExistente = filmeOptional.get();
            // Atualize os campos do filme com base nos dados fornecidos
            filmeExistente.setTitulo(filme.getTitulo());
            filmeExistente.setSinopse(filme.getSinopse());
            filmeExistente.setGenero(filme.getGenero());
            filmeExistente.setAnoLancamento(filme.getAnoLancamento());
            Filme filmeAtualizado = filmeRepository.save(filmeExistente);
            return new ResponseEntity<>(filmeAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deletar um filme pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {
        Optional<Filme> filmeOptional = filmeRepository.findById(id);
        if (filmeOptional.isPresent()) {
            filmeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
