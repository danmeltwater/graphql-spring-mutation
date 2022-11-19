package meltwater.danhughes.graphql.domain.model;

public class EditorialDocumentModel {

  public static record EditorialDocument(
      Integer id, String text, String url, String publishedDate) {}

  public static record EditorialDocumentInput(String text, String url,  String publishedDate) {}

  public static record EditorialDocumentInfo(
          Integer id, String text, String url,  String publishedDate) {}
}
