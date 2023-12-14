package test.mockedObjects;

import main.Buffer;
import main.Consumer;
import main.Item;

public class MockConsumer implements Consumer{
	
	Buffer mockBuffer;

	public MockConsumer(Buffer mockBuffer) {
		this.mockBuffer = mockBuffer; 
	}
	
	public Item removeItem() {
		return mockBuffer.remove();
	}
	@Override
	public void run() {
		
		
	}

	@Override
	public void stopRunning() {
		
		
	}

}
