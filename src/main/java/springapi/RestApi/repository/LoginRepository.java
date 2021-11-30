package springapi.RestApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springapi.RestApi.model.Login;

@Repository
public interface LoginRepository  extends JpaRepository<Login, Long> {

		Optional<Login> findByEmail(String email);

}
