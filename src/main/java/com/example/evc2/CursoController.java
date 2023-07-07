package com.example.evc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping(path = "/listar")
    public @ResponseBody Iterable<Curso> getAllCurso() {
        return cursoRepository.findAll();
    }

    @PostMapping(path = "/nuevo")
    public @ResponseBody String addCurso(@RequestParam String name, @RequestParam int creditos) {
        Curso c = new Curso();
        c.setNombre(name);
        c.setCreditos(creditos);
        cursoRepository.save(c);
        return "Saved";
    }

    @DeleteMapping(path = "/eliminar")
    public @ResponseBody String delCurso(@RequestParam Integer id) {
        Curso c = new Curso();
        c.setId(id);
        cursoRepository.delete(c);
        return "Deleted";
    }

}
