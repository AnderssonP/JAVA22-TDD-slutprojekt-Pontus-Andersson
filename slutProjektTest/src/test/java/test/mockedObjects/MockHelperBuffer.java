package test.mockedObjects;

import java.util.Queue;

import main.Buffer;
import main.Item;

public class MockHelperBuffer extends Buffer{

   
    public MockHelperBuffer() {
    	super();
    }
    
    public Queue<Item> getBuffer(){
		return super.buffer;
    }
    
}
