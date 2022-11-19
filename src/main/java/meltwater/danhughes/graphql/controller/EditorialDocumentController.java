package meltwater.danhughes.graphql.controller;

import meltwater.danhughes.graphql.application.service.EditorialDocumentService;
import meltwater.danhughes.graphql.domain.model.EditorialDocumentModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Slf4j
@Controller
@RequiredArgsConstructor
public class EditorialDocumentController {

  private final EditorialDocumentService editorialDocumentService;

  @MutationMapping
  public EditorialDocumentModel.EditorialDocumentInfo addEditorialDocument(@Argument EditorialDocumentModel.EditorialDocumentInput editorialDocument) {
    log.info("Saving editorial document, name {}", editorialDocument.url());
    return editorialDocumentService.saveEditorialDocument(editorialDocument);
  }

  @MutationMapping
  public EditorialDocumentModel.EditorialDocumentInfo addEditorialDocumentWithScalars(@Argument String text,@Argument String url,@Argument String publishedDate ) {
    var editorialDocument = new EditorialDocumentModel.EditorialDocumentInput(text,url,publishedDate);
    log.info("Saving editorial document, name {}", editorialDocument.url());
    return editorialDocumentService.saveEditorialDocument(editorialDocument);
  }

  @QueryMapping()
  public Collection<EditorialDocumentModel.EditorialDocument> documents() {
    log.info("Fetching all documents..");
    return editorialDocumentService.getDocuments();
  }

  @QueryMapping
  public Collection<EditorialDocumentModel.EditorialDocument> editorialDocumentByUrl(@Argument String url) {
    log.info("Getting document by url, {}",url );
    return editorialDocumentService.documentByUrl(url);
  }
}
