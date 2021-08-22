package com.eventreadersystem.eventreader.respository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eventreadersystem.eventreader.Model.Events;
import com.eventreadersystem.eventreader.Model.Products;


@Repository
public interface EventRespository extends JpaRepository<Events, String>
{
	Optional<Events> findById(String id);

	Optional<Events> getOptionalByinsuredId(Long insuredId);

	List<Products> getOptionalProductsByinsuredId(Long insuredId);
}
