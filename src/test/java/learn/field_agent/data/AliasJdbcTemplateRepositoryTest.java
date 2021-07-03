package learn.field_agent.data;

import learn.field_agent.models.Alias;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AliasJdbcTemplateRepositoryTest {

    @Autowired
    AliasJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldCreate(){
        Alias alias = new Alias();
        alias.setName("george");
        alias.setPersona("cook");
        alias.setAgentId(1);

        Alias actual = repository.add(alias);

        assertNotNull(actual);
        assertEquals(5, actual.getAliasId());
    }

    @Test
    void shouldUpdateExisting(){
        Alias alias = new Alias();
        alias.setAliasId(2);
        alias.setName("george");
        alias.setPersona("cook");
        alias.setAgentId(1);

        assertTrue(repository.update(alias));
    }

    @Test
    void shouldNotUpdateMissing(){
        Alias alias = new Alias();
        alias.setName("george");
        alias.setPersona("cook");
        alias.setAgentId(1);

        assertFalse(repository.update(alias));
    }

    @Test
    void shouldDelete() {
        assertTrue(repository.deleteById(4));
        assertFalse(repository.deleteById(4));
    }


}