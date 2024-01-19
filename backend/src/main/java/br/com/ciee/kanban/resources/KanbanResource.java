package br.com.ciee.kanban.resources;

import br.com.ciee.kanban.domain.Kanban;
import br.com.ciee.kanban.services.KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/professionals")
public class KanbanResource {

    @Autowired
    private KanbanService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<Kanban> findById(@PathVariable Integer id){
        Kanban obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/target-column/{targetColumn}")
    public ResponseEntity<List<Kanban>> listByTargetColumn(@PathVariable String targetColumn) {
        List <Kanban> list = service.findByTargetColumn(targetColumn);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<List<Kanban>> listAll() {
        List<Kanban> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Kanban> create(@RequestBody Kanban obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Kanban> update(@PathVariable Integer id, @RequestBody Kanban obj) {
        Kanban newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
}
