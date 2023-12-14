package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
import main.Item;
import test.mockedObjects.MockConsumer;
import test.mockedObjects.MockHelperBuffer;
import test.mockedObjects.MockProducer;

import java.util.Queue;


class BufferTest {

	 @Test
	    @DisplayName("Test att lägga till via add")
	    void testBufferAdd() {
	        MockHelperBuffer buffer = new MockHelperBuffer();
	        MockProducer producer = new MockProducer(buffer);
	        Item item = new Item("Mössa");

	        assertTrue(producer.addItem(item));
	        assertNotNull(buffer); 
	    }

	    @Test
	    @DisplayName("Test för att ta bort item")
	    void testBufferRemove() {
	    	MockHelperBuffer buffer = new MockHelperBuffer();
	        MockConsumer consumer = new MockConsumer(buffer);
	        Item item = new Item("Mössa");
	        buffer.add(item); 

	        Item removed = consumer.removeItem();
	        
	        assertNotNull(removed);
	    }
    
    @Test
    @DisplayName("Test för att hämta buffer")
    void testGetBuffer() {
        MockHelperBuffer buffer = new MockHelperBuffer();
        Item item1 = new Item("Hatt");
        Item item2 = new Item("Jacka");
        buffer.add(item1);
        buffer.add(item2);

        Queue<Item> retrievedBuffer = buffer.getBuffer();

        assertNotNull(retrievedBuffer);

        assertEquals(2, retrievedBuffer.size());
        assertEquals(item1, retrievedBuffer.poll());
        assertEquals(item2, retrievedBuffer.poll());
    }
    
    @DisplayName("Testar wait i min remove")
    @Test
    public void testWait() throws InterruptedException {
        MockHelperBuffer buffer = new MockHelperBuffer();
		
        Thread testThread = new Thread(() -> {
            Item item = buffer.remove();
            assertNotNull(item); 
        });

        testThread.start(); 
        
        Thread.sleep(100);

        assertEquals(Thread.State.WAITING, testThread.getState());

        buffer.add(new Item("Mössa"));
        synchronized (buffer) {
            buffer.notifyAll();
        }

        testThread.join();

        assertEquals(Thread.State.TERMINATED, testThread.getState());
    }

}


