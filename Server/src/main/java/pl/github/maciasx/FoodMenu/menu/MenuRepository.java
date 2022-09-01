package pl.github.maciasx.FoodMenu.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    void deleteMenuById(Long id);

    @Query(value = "SELECT m FROM Menu  m WHERE TRUNC(m.dateMenu) = ?1 and m.user.id = ?2 ")
    List<Menu> findAllMenu(Date dateMenu,Long id);
}
