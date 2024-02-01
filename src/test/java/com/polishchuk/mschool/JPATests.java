package com.polishchuk.mschool;

import com.polishchuk.mschool.model.entity.task.TaskEntity;
import com.polishchuk.mschool.model.entity.user.UserEntity;
import com.polishchuk.mschool.model.object.User;
import com.polishchuk.mschool.model.repository.UserRepository;
import jakarta.validation.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.comparator.Comparators;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
@DataJpaTest
@Sql("/test-data.sql")
public class JPATests {

	@Autowired
	private UserRepository userRepository;

	@Container
	@ServiceConnection
	public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15-alpine")
			.withUsername("spring.datasource.username")
			.withPassword("spring.datasource.password")
			.withDatabaseName("testdb");

	@DynamicPropertySource
	static void postgresqlProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
		registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
		registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
	}

	private Long user_id = 1L;

	@Test
	public void testOrderBy() {
		Optional<UserEntity> optionalUser = userRepository.findById(user_id);

		if (optionalUser.isPresent()) {
			List<TaskEntity> tasks = optionalUser.get().getTasks();
			assert (SortCheck.isDescSorted(tasks, TaskEntity.DATE_COMPARATOR));
		}
	}

	@Test
	public void whenUserInvalid_thenValidationFails() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		User user = User.builder()
				.userName("wer")
				.name(null)
				.password("dfjjkg")
				.build();

		Set<ConstraintViolation<User>> violations = validator.validate(user);
		assertFalse(violations.isEmpty());

		user = User.builder()
				.userName("wer34")
				.name("null")
				.surname("fgjhdfh")
				.password("dfjjkgfdgdfg")
				.build();

		violations = validator.validate(user);
		assertTrue(violations.isEmpty());
	}

}
