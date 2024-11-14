import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

	ManagementCompany company1, company2, company3, company4;
	Property property1, property2, property3;

	@BeforeEach
	void setUp() {
		// Create properties
		property1 = new Property("property1", "City1", 1500.0, "Owner1", 1, 1, 5, 5);
		property2 = new Property("property2", "City2", 2000.0, "Owner2", 6, 6, 5, 5);
		property3 = new Property("property3", "City3", 2500.0, "Owner3", 10, 10, 5, 5);

		company1 = new ManagementCompany();  
		company2 = new ManagementCompany("Company A", "123456789", 10);  
		company3 = new ManagementCompany("Company B", "987654321", 15, 0, 0, 10, 10);  
		company4 = new ManagementCompany(company3);  
	}

	@AfterEach
	void tearDown() {
		company1 = company2 = company3 = company4 = null;
		property1 = property2 = property3 = null;
	}

	@Test
	void testManagementCompany() {
		assertEquals("", company1.getName());
		assertEquals("", company1.getTaxID());
		assertEquals(0, company1.getManagementFee());
		assertEquals(0, company1.getNumberOfProperties());
		assertNotNull(company1.getPlot()); 
		
		assertEquals("Company A", company2.getName());
		assertEquals("123456789", company2.getTaxID());
		assertEquals(10, company2.getManagementFee());
		assertEquals(0, company2.getNumberOfProperties());
		assertNotNull(company2.getPlot());
		
		assertEquals("Company B", company3.getName());
		assertEquals("987654321", company3.getTaxID());
		assertEquals(15, company3.getManagementFee());
		
		assertEquals(company3.getName(), company4.getName());
		assertEquals(company3.getTaxID(), company4.getTaxID());
		assertEquals(company3.getManagementFee(), company4.getManagementFee());
	}

	@Test
	void testAddProperty() {
		assertEquals(0, company2.addProperty(property1));  
		assertEquals(1, company2.addProperty(property2));  
		assertEquals(-1, company2.addProperty(property3)); 
		assertEquals(2, company2.getNumberOfProperties()); 
		
	}

	
	@Test
	void testGetTotalRent() {
		company2.addProperty(property1);
		company2.addProperty(property2);
		assertEquals(3500.0, company2.getTotalRent());  
	}

	// Test Highest Rent Property
	@Test
	void testGetHighestRentProperty() {
		company2.addProperty(property1);
		company2.addProperty(property2);
		Property highestRent = company2.getHighestRentProperty();
		assertEquals(property2, highestRent);  
	}

	// Test Remove Last Property
	@Test
	void testRemoveLastProperty() {
		company2.addProperty(property1);
		company2.addProperty(property2);
		assertEquals(2, company2.getNumberOfProperties());  
		company2.romoveLastProperty();
		assertEquals(1, company2.getNumberOfProperties());  
	}

	// Test if Properties are Full
	@Test
	void testIsPropertiesFull() {
		assertFalse(company2.isPropertiesFull());  
		company2.addProperty(property1);
		company2.addProperty(property2);
		assertTrue(company2.isPropertiesFull()); 
	}

	// Test Management Fee Validity
	@Test
	void testIsManagementFeeValid() {
		assertTrue(company2.isManagementFeeValid());  
		company2.setManagementFee(105);  
		assertFalse(company2.isManagementFeeValid());  
	}

	// Test toString Method
	@Test
	void testToString() {
		company2.addProperty(property1);
		company2.addProperty(property2);
		String expectedString = "This list of the properties for Company A, taxID: 123456789\n" +
				"______________________________________________________\n" +
				property1.toString() + "\n" +
				property2.toString() + "\n" +
				"______________________________________________________\n" +
				"Total management Fee: " + String.format("%.2f", (company2.getTotalRent() * company2.getManagementFee() * 0.01));
		assertEquals(expectedString, company2.toString());
	}
}






}
