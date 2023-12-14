package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Item;
import test.mockedObjects.MockHelperItem;

public class ItemTest {
	
	@Test
	@DisplayName("Testa constructorn")
	public void testConstructor() {
		MockHelperItem item = new MockHelperItem("Const");
		assertEquals(item.toString(),item.getId());
	}
	
	@Test
    @DisplayName("Testa toString med tom string")
    public void testToStringWithEmptyString() {
    	MockHelperItem item = new MockHelperItem("");
        assertEquals("", item.toString());
    }

    @Test
    @DisplayName("Testa toString med bokstäver")
    public void testToStringWithLetters() {
    	MockHelperItem item = new MockHelperItem("TestItem");
        assertEquals("testitem", item.toString());
    }

    @Test
    @DisplayName("Testa toString med nummer")
    public void testToStringWithNumbers() {
    	MockHelperItem item = new MockHelperItem("123");
        assertEquals("123", item.toString());
    }

    @Test
    @DisplayName("Testa setId")
    public void testSetId() {
    	MockHelperItem item = new MockHelperItem("");
        item.setId("NewId");
        assertEquals("newid", item.toString());
    }
	
	@Test
	@DisplayName("Testa så det inte blir null")
	public void testNull() {
       assertThrows(NullPointerException.class,() -> new Item(null));
	}


    @Test
    @DisplayName("Testa toString med lång string input")
    public void testToStringWithLongString() {
        String longString = new String(new char[1000]).replace('\0', 'a');
        MockHelperItem item = new MockHelperItem(longString);
        assertEquals(longString.toLowerCase(), item.toString());
    }

    @Test
    @DisplayName("Testa setId med lång string input")
    public void testSetIdWithLongString() {
        MockHelperItem item = new MockHelperItem("");
        String longString = new String(new char[1000]).replace('\0', 'b');
        item.setId(longString);
        assertEquals(longString.toLowerCase(), item.toString());
    }

    @Test
    @DisplayName("Testa toString med annan data type")
    public void testToStringWithDifferentDataTypes() {
        MockHelperItem item = new MockHelperItem("12345");
        assertEquals("12345", item.toString());
    }

    @Test
    @DisplayName("Testa setId följd av toString")
    public void testSetIdFollowedByToString() {
        MockHelperItem item = new MockHelperItem("");
        item.setId("Test");
        assertEquals("test", item.toString());
    }

}
