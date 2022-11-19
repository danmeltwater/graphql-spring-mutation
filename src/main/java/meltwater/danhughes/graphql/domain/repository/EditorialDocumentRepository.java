package meltwater.danhughes.graphql.domain.repository;

import meltwater.danhughes.graphql.domain.repository.model.EditorialDocumentEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface EditorialDocumentRepository extends JpaRepository<EditorialDocumentEntity, Integer> {

    List<EditorialDocumentEntity> findEditorialDocumentEntitiesByUrl(String url);

}
