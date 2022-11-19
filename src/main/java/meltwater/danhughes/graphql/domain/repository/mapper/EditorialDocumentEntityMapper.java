package meltwater.danhughes.graphql.domain.repository.mapper;

import meltwater.danhughes.graphql.domain.model.EditorialDocumentModel;
import meltwater.danhughes.graphql.domain.repository.model.EditorialDocumentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EditorialDocumentEntityMapper {
  public static final EditorialDocumentEntityMapper MAPPER = Mappers.getMapper(EditorialDocumentEntityMapper.class);

  public abstract EditorialDocumentEntity map(EditorialDocumentModel.EditorialDocument editorialDocument);

  public abstract EditorialDocumentModel.EditorialDocument map(EditorialDocumentEntity editorialDocumentEntity);

  public abstract EditorialDocumentEntity map(EditorialDocumentModel.EditorialDocumentInput editorialDocumentInput);

  public abstract EditorialDocumentEntity map(Integer id, EditorialDocumentModel.EditorialDocumentInput editorialDocumentInput);
}
