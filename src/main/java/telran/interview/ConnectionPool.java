package telran.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

public class ConnectionPool {

    private final int sizeLimit;
    private final Map<String, Connection> connections;
    private final LinkedList<String> orderQueue;

    public ConnectionPool(int size) {
        this.sizeLimit = size;
        this.connections = new HashMap<>();
        this.orderQueue = new LinkedList<>();
    }

    public void addConnection(Connection connection) {
        String connectionId = connection.connectionId();

        if (connections.containsKey(connectionId)) {
            throw new IllegalStateException("Connection already exists");
        }
        if (connections.size() >= sizeLimit) {
            String oldestConnectionId = orderQueue.removeFirst();
            connections.remove(oldestConnectionId);
        }

        connections.put(connectionId, connection);
        orderQueue.addLast(connectionId);
    }

    public Connection getConnection(String connectionId) {
        if (!connections.containsKey(connectionId)) {
            throw new NoSuchElementException("Connection not found");
        }
        orderQueue.remove(connectionId);
        orderQueue.addLast(connectionId);

        return connections.get(connectionId);
    }

    public int getSize() {
        return connections.size();
    }

    public boolean containsConnection(String connectionId) {
        return connections.containsKey(connectionId);
    }
}
