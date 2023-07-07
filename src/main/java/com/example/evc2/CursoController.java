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
        Curso s = new Curso();
        s.setNombre(name);
        s.setCreditos(creditos);
        cursoRepository.save(s);
        return "Saved";
    }

    @DeleteMapping(path = "/eliminar")
    public @ResponseBody String delCurso(@RequestParam Integer id) {
        Curso s = new Curso();
        s.setId(id);
        cursoRepository.delete(s);
        return "Deleted";
    }

}
