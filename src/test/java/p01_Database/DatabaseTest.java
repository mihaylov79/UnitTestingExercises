package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import javax.naming.OperationNotSupportedException;
import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUP() throws OperationNotSupportedException {
        database = new Database(1,2,3,4,5);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void add_Should_Throw_When_null() throws OperationNotSupportedException {
       // Database database = new Database(1,2,3,4,5);
        database.add(null);
    }

    @Test
    public void test_add_Should_Add_Element() throws OperationNotSupportedException {
        //Database database = new Database(1,2,3,4,5);
        Database expected = new Database(1,2,3,4,5,6);
        database.add(6);
        assertArrayEquals(expected.getElements(), database.getElements() );

    }
    @Test(expected = OperationNotSupportedException.class)
    public void test_remove_Should_Throw_When_DB_isEmpty() throws OperationNotSupportedException {
        database = new Database();

        database.remove();
    }
    @Test
    public void test_remove_Should_Remove_Correct_elements() throws OperationNotSupportedException {
        int expected = (database.getElements().length - 1);
        database.remove();
        int real = database.getElements().length;
        Assert.assertEquals(expected, real);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_Should_Throw_When_Elements_Are_Over_16() throws OperationNotSupportedException {

        Integer[] elementsToImport = new Integer[17];
        database = new Database(elementsToImport);
    }

    @Test
    public void test_Constructor_Should_return_correct_values(){

        Integer[] expected = {1,2,3,4,5};
        Integer[] elements = database.getElements();

        assertArrayEquals(expected,elements);
    }



}
