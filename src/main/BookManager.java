import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookManager {

  private List<Book> bookList = new ArrayList<>();

  public Book searchBook(int id) {
    for (Book book : bookList) {
      if (Objects.equals(book.getId(), id)) {
        System.out.printf("검색결과:\n{id: '%d', 제목: '%s', 저자: '%s', 출판년도: '%s'}.\n",
            book.getId(), book.getTitle(), book.getAuthor(), book.getYear());
        return book;
      }
    }
    System.out.println("검색된 도서가 없습니다.");
    throw new IllegalArgumentException("검색된 도서가 없습니다.");
  }

  public void addBook(Book newBook) {
    for (Book book : bookList) {
      if (Objects.equals(book.getId(), newBook.getId())) {
        System.out.println("해당 ID(" + book.getId() + ")가 존재합니다.");
        searchBook(newBook.getId());
        throw new IllegalArgumentException("해당 ID(" + book.getId() + ") 는 이미 존재합니다.");
      }
    }
    bookList.add(newBook);
    System.out.printf("{id: '%d', 제목: '%s', 저자: '%s', 출판년도: '%s'}도서가 추가되었습니다.\n",
        newBook.getId(), newBook.getTitle(), newBook.getAuthor(), newBook.getYear());
  }

  public void deleteBook(int id) {
    Book bookToDelete = null;
    for (Book book : bookList) {
      if (book.getId() == id) {
        bookToDelete = book;
        break;
      }
    }
    if (bookToDelete != null) {
      bookList.remove(bookToDelete);
      System.out.printf("{id: '%d', 제목: '%s', 저자: '%s', 출판년도: '%s'}도서를 삭제했습니다.\n",
          bookToDelete.getId(),bookToDelete.getTitle(),bookToDelete.getAuthor(),bookToDelete.getYear());
    } else {
      System.out.println(("해당 ID(" + id + ")의 도서를 찾을 수 없습니다."));
      throw new IllegalArgumentException("해당 ID(" + id + ")의 도서를 찾을 수 없습니다.");
    }
  }
}