package validation;

import domain.Tema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemaValidatorTest {
    TemaValidator validator = new TemaValidator();

    @Test
    public void validateTemaWithEverythingNullExceptionThrownForId(){
        Tema tema = new Tema(null,null,0,0);
        Exception e = assertThrows(ValidationException.class, ()->validator.validate(tema));
        assertEquals("ID invalid! \n", e.getMessage());
    }

    @Test
    public void validateTemaWithEverythingNullIdEmptyExceptionThrownForId(){
        Tema tema = new Tema("",null,0,0);
        Exception e = assertThrows(ValidationException.class, ()->validator.validate(tema));
        assertEquals("ID invalid! \n", e.getMessage());
    }

}