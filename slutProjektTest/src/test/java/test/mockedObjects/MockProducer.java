package test.mockedObjects;

import main.Buffer;
import main.Item;
import main.Producer;

public class MockProducer implements Producer{

	
	Buffer mockBuffer;
	
	public MockProducer(Buffer mockBuffer) {
		this.mockBuffer = mockBuffer;
	}
	
	public boolean addItem(Item item) {
		return mockBuffer.add(item);
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopRunning() {
		// TODO Auto-generated method stub
		
	}

}
