import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void test1_EveryStatement(){
        RuntimeException exception;

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, ""));
        assertTrue(exception.getMessage().contains("allItems list can't be null!"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("", 10, 200, 0.0)), ""));
        assertTrue(exception.getMessage().contains("Invalid item!"));

        assertEquals(4970.0, SILab2.checkCart(List.of(new Item("Book", 10, 500, 0.0)), "0122333444455555"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Book", 10, 500, 0.2)), "123456789"));
        assertTrue(exception.getMessage().contains("Invalid card number!"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Book", 10, 500, 0.2)), "4cardNumberOfAna"));
        assertTrue(exception.getMessage().contains("Invalid character in card number!"));
    }

    @Test
    public void test2_MultipleCondition(){

        assertEquals(4970.0, SILab2.checkCart(List.of(new Item("Book", 10, 500, 0.0)), "0122333444455555"));

        assertEquals(1370.0, SILab2.checkCart(List.of(new Item("Book", 10, 200, 0.3)), "0122333444455555"));

        assertEquals(2970.0, SILab2.checkCart(List.of(new Item("Book", 15, 200, 0.0)), "0122333444455555"));

        assertEquals(1000.0, SILab2.checkCart(List.of(new Item("Book", 5, 200, 0.0)), "0122333444455555"));
    }
}
