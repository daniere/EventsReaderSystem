package com.eventreadersystem.eventreader.respository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eventreadersystem.eventreader.Model.RequestDetails;


@Repository
public interface RequestDetailsRepository extends JpaRepository<RequestDetails, String>
{
	Optional<RequestDetails> findById(String sourceCompany);
}
