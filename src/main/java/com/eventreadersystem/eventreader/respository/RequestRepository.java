package com.eventreadersystem.eventreader.respository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eventreadersystem.eventreader.Model.Request;


@Repository
public interface RequestRepository extends JpaRepository<Request, String>
{
	Optional<Request> findById(String sourceCompany);
}
