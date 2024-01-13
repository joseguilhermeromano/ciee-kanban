package br.com.ciee.kanban.repositories;

import br.com.ciee.kanban.domain.Kanban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KanbanRepository extends JpaRepository<Kanban, Integer> {

    @Query("SELECT obj FROM Kanban obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
    List <Kanban> findAllOpen();

    @Query("SELECT obj FROM Kanban obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar")
    List <Kanban> findAllClose();

}
