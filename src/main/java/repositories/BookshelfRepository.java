package repositories;

import models.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookshelfRepository extends JpaRepository <Bookshelf, Long>{
}
