package fr.mns.loctraining.service.user;

import fr.mns.loctraining.domain.model.user.Status;
import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.domain.model.user.UserAffiliation;
import fr.mns.loctraining.domain.model.user.UserGender;
import fr.mns.loctraining.domain.repository.user.StatusRepository;
import fr.mns.loctraining.domain.repository.user.UserRepository;
import fr.mns.loctraining.tools.exception.NotFoundException;
import fr.mns.loctraining.tools.utils.MappingUtils;
import fr.mns.loctraining.vo.user.status.StatusDetails;
import fr.mns.loctraining.vo.user.user.UserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private StatusRepository statusRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    void getDetailsNotFound() {
        Integer id = 1;
        when(userRepository.findByIdNullSafe(id)).thenReturn(null);
        try {
            userService.getDetails(id);
            fail();
        } catch (NotFoundException e) {
            assertNotNull(e);
        }
    }

    @Test
    void getDetails() {
        Integer id = 1;
        User expectedUser = getExpectedUser(id);
        when(userRepository.findByIdNullSafe(id)).thenReturn(expectedUser);
        UserDetails details = userService.getDetails(id);
        assertNotNull(details);
        checkDetails(MappingUtils.getUserDetails(expectedUser), details);
    }

    private void checkDetails(UserDetails expected, UserDetails details) {
        assertEquals(expected.getId(), details.getId());
        assertEquals(expected.getLastname(), details.getLastname());
        assertEquals(expected.getFirstname(), details.getFirstname());
        assertEquals(expected.getEmail(), details.getEmail());
        assertEquals(expected.getLogin(), details.getLogin());
        assertEquals(expected.getGender(), details.getGender());
        assertEquals(expected.getPhone(), details.getPhone());
        assertEquals(expected.getAffiliation(), details.getAffiliation());
        checkStatus(expected.getStatus(), details.getStatus());
    }

    private void checkStatus(StatusDetails expected, StatusDetails details) {
        assertEquals(expected.getId(), details.getId());
        assertEquals(expected.getName(), details.getName());
    }

    private User getExpectedUser(Integer id) {
        User user = new User();
        user.setId(id);
        user.setLastname("Last name");
        user.setFirstname("First name");
        user.setEmail("email@email.email");
        user.setLogin("login");
        user.setGender(UserGender.MALE);
        user.setPhone("0123456789");
        user.setAffiliation(UserAffiliation.MNS);
        user.setStatus(getExpectedStatus(id));
        return user;

    }

    private Status getExpectedStatus(Integer id) {
        Status status = new Status();
        status.setId(id);
        status.setName("name");
        return status;
    }
}
