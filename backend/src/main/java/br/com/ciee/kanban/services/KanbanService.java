package br.com.ciee.kanban.services;

import br.com.ciee.kanban.domain.Kanban;
import br.com.ciee.kanban.repositories.KanbanRepository;
import br.com.ciee.kanban.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KanbanService {
    @Autowired
    private KanbanRepository repository;

    public Kanban findById(Integer id) {
        Optional<Kanban> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id: " + id + " " + Kanban.class.getName()));
    }

    public List<Kanban> findAllOpen() {
        List<Kanban> list = repository.findAllOpen();
        return list;
    }

    public List<Kanban> findAllClose() {
        List<Kanban> list = repository.findAllClose();
        return list;
    }

    public List<Kanban> findAll() {
        List<Kanban> list = repository.findAll();
        return list;
    }

    public Kanban create(Kanban obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Kanban update(Integer id, Kanban obj) {
        Kanban newObj = findById(id);
        newObj.setTitulo(obj.getTitulo());
        newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
        newObj.setDescricao(obj.getDescricao());
        newObj.setFinalizado(obj.getFinalizado());
        return repository.save(newObj);
    }
}
