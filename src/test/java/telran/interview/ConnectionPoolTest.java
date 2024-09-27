package telran.interview;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConnectionPoolTest {
    private ConnectionPool connectionPool;
    private Connection connection1;
    private Connection connection2;
    private Connection connection3;

    @BeforeEach
    public void setUp() {
        connectionPool = new ConnectionPool(2);
        connection1 = new Connection("conn1");
        connection2 = new Connection("conn2");
        connection3 = new Connection("conn3");
    }

    @Test
    public void testAddConnection() {
        connectionPool.addConnection(connection1);
        assertEquals(1, connectionPool.getSize());
        connectionPool.addConnection(connection2);
        assertEquals(2, connectionPool.getSize());
    }

    @Test
    public void testAddConnectionOverLimit() {
        connectionPool.addConnection(connection1);
        connectionPool.addConnection(connection2);
        connectionPool.addConnection(connection3);

        assertEquals(2, connectionPool.getSize());
        assertFalse(connectionPool.containsConnection("conn1"));
        assertTrue(connectionPool.containsConnection("conn2"));
        assertTrue(connectionPool.containsConnection("conn3"));
    }

    @Test
    public void testAddExistingConnectionThrowsException() {
        connectionPool.addConnection(connection1);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            connectionPool.addConnection(connection1);
        });
        assertEquals("Connection already exists", exception.getMessage());
    }

    @Test
    public void testGetConnection() {
        connectionPool.addConnection(connection1);
        connectionPool.addConnection(connection2);
        assertEquals(connection1, connectionPool.getConnection("conn1"));
        assertEquals(connection2, connectionPool.getConnection("conn2"));
    }

    @Test
    public void testGetNonExistentConnectionThrowsException() {
        connectionPool.addConnection(connection1);
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            connectionPool.getConnection("non_existent");
        });
        assertEquals("Connection not found", exception.getMessage());
    }

    @Test
    public void testConnectionUsageUpdatesOrder() {
        connectionPool.addConnection(connection1);
        connectionPool.addConnection(connection2);
        
        connectionPool.getConnection("conn1");
        connectionPool.addConnection(connection3);
        
        assertTrue(connectionPool.containsConnection("conn1"));
        assertFalse(connectionPool.containsConnection("conn2"));
        assertTrue(connectionPool.containsConnection("conn3"));
    }
}
