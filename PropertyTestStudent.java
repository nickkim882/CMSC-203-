import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	Property property1, property2, property3, property4, property5;
	
	@BeforeEach
	void setUp() throws Exception {
		property1 = new Property();  // Default constructor
        property2 = new Property("property1", "New York", 2500.0, "John Doe");  // Constructor with name, city, rent, and owner
        property3 = new Property("property2", "Miami", 3500.0, "Sean Kim", 5, 6, 10, 12);  // Full constructor with plot
        property4 = new Property(property3);  // Copy constructor
        property5 = new Property("property3", "LA", 5000.0, "Nick Kim", 8, 10, 15, 20);  // Another property to test additional logic
    }
	

	@AfterEach
	void tearDown() throws Exception {
		property1 = property2 = property3 = property4 = property5 = null;
	}

	@Test
	void testProperty() {
		
		assertEquals("", property1.getPropertyName());
        assertEquals("", property1.getCity());
        assertEquals(0.0, property1.getRentAmount());
        assertEquals("", property1.getOwner());
        
        assertEquals("property1", property2.getPropertyName());
        assertEquals("New York", property2.getCity());
        assertEquals(2500.0, property2.getRentAmount());
        assertEquals("John Doe", property2.getOwner()); 
        
        assertEquals("property2", property3.getPropertyName());
        assertEquals("Miami", property3.getCity());
        assertEquals(3500.0, property3.getRentAmount());
        assertEquals("Sean Kim", property3.getOwner());
        
        assertEquals(5, property3.getPlot().getX());
        assertEquals(6, property3.getPlot().getY());
        assertEquals(10, property3.getPlot().getDepth());
        assertEquals(12, property3.getPlot().getWidth());
		
        assertEquals(property3.getPropertyName(), property4.getPropertyName());
        assertEquals(property3.getCity(), property4.getCity());
        assertEquals(property3.getRentAmount(), property4.getRentAmount());
        assertEquals(property3.getOwner(), property4.getOwner());
        
	}

	@Test
	void testGetPropertyName() {
		assertEquals("property1", property2.getPropertyName());
	}

	@Test
	void testGetCity() {
		assertEquals("Miami", property3.getCity());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(2500.0, property2.getRentAmount());
	}

	@Test
	void testGetOwner() {
		assertEquals("John Doe", property2.getOwner());
	}

	@Test
	void testGetPlot() {
		assertEquals(5, property3.getPlot().getX());
	}

	@Test
	void testSetPropertyName() {
		property1.setPropertyName("property4");
        assertEquals("property4", property1.getPropertyName());
	}

	@Test
	void testSetCity() {
		property1.setCity("San Francisco");
        assertEquals("San Francisco", property1.getCity());
	}

	@Test
	void testSetRentAmount() {
		property1.setRentAmount(4500.0);
        assertEquals(4500.0, property1.getRentAmount());
	}

	@Test
	void testSetOwner() {
		 property1.setOwner("Alex Kim");
	     assertEquals("Alex Kim", property1.getOwner());
	}

	@Test
	void testSetPlot() {
		Plot newPlot = new Plot(10, 10, 15, 15);
        property1.setPlot(newPlot);
        assertEquals(10, property1.getPlot().getX());
        assertEquals(10, property1.getPlot().getY());
        assertEquals(15, property1.getPlot().getDepth());
        assertEquals(15, property1.getPlot().getWidth());
	}

	@Test
	void testToString() {
		assertEquals("property3,LA,Nick Kim,5000.0", property5.toString());
	}

}
