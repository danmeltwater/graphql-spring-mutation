package meltwater.danhughes.graphql.application.service;

import meltwater.danhughes.graphql.domain.model.EditorialDocumentModel;
import meltwater.danhughes.graphql.domain.repository.EditorialDocumentRepository;
import meltwater.danhughes.graphql.domain.repository.mapper.EditorialDocumentEntityMapper;
import meltwater.danhughes.graphql.domain.repository.model.EditorialDocumentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorialDocumentService {

    private final EditorialDocumentRepository editorialDocumentRepository;

    public EditorialDocumentModel.EditorialDocumentInfo saveEditorialDocument(EditorialDocumentModel.EditorialDocumentInput editorialDocumentInput) {
        var editorialDocumentEntityMapper = EditorialDocumentEntityMapper.MAPPER;
        var entity = editorialDocumentEntityMapper.map(editorialDocumentInput);
        var persistedEditorialDocument = editorialDocumentRepository.save(entity);

        return new EditorialDocumentModel.EditorialDocumentInfo(
                persistedEditorialDocument.getId(),
                persistedEditorialDocument.getText(),
                persistedEditorialDocument.getUrl(),
                persistedEditorialDocument.getPublishedDate());
    }

    public Collection<EditorialDocumentModel.EditorialDocument> getDocuments() {
        var editorialDocumentEntityMapper = EditorialDocumentEntityMapper.MAPPER;
        List<EditorialDocumentEntity>  documents = editorialDocumentRepository.findAll();
        return documents.stream().map(editorialDocumentEntityMapper::map).toList();
    }

    public Collection<EditorialDocumentModel.EditorialDocument> documentByUrl(String url) {
        var editorialDocumentEntityMapper = EditorialDocumentEntityMapper.MAPPER;
        List<EditorialDocumentEntity>  documents = editorialDocumentRepository.findEditorialDocumentEntitiesByUrl(url);
        return documents.stream().map(editorialDocumentEntityMapper::map).toList();
    }
}
