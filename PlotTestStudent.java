import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

	Plot plot, plot1, plot2, plot3, plot4, plot5;
	@BeforeEach
	void setUp() throws Exception {
		plot = new Plot();
		plot1 = new Plot();
		plot2 = new Plot(3,4,4,3);
		plot3 = new Plot(4,5,2,3);
		plot4 = new Plot(plot3);
		plot5 = new Plot(10,10,1,1);
		

	}

	@AfterEach
	void tearDown() throws Exception {
		plot1 = plot2 = plot3 = plot4 = null;
	}

	@Test
	void testPlot() {
		//test default constructor
		assertEquals(0, plot1.getX());
        assertEquals(0, plot1.getY());
        assertEquals(0, plot1.getDepth());
        assertEquals(0, plot1.getWidth());
        
        //test constructor
        assertEquals(3, plot2.getX());
        assertEquals(4, plot2.getY());
        assertEquals(4, plot2.getDepth());
        assertEquals(3, plot2.getWidth());
        
        //test copy constructor 
        assertEquals(plot3.getX(), plot4.getX());
        assertEquals(plot3.getY(), plot4.getY());
        assertEquals(plot3.getDepth(), plot4.getDepth());
        assertEquals(plot3.getWidth(), plot4.getWidth());
	}

	@Test
	void testGetX() {
		assertEquals(3, plot2.getX());
	}

	@Test
	void testGetY() {
		assertEquals(5, plot3.getY());
	}

	@Test
	void testGetDepth() {
		assertEquals(4, plot2.getDepth());
	}

	@Test
	void testGetWidth() {
		assertEquals(3, plot2.getWidth());
	}

	@Test
	void testSetX() {
		plot1.setX(2);
		assertEquals(2, plot1.getX());
	}

	@Test
	void testSetY() {
		plot1.setY(2);
		assertEquals(2, plot1.getY());
	}

	@Test
	void testSetDepth() {
		plot1.setDepth(6);
		assertEquals(6, plot1.getDepth());
	}

	@Test
	void testSetWidth() {
		plot1.setWidth(6);
		assertEquals(6, plot1.getWidth());
	}

	@Test
	void testOverlap() {
		assertTrue(plot2.overlaps(plot3));
		assertFalse(plot.overlaps(plot5));
	}

	@Test
	void testEncompasses() {
		assertFalse(plot.encompasses(plot5));
	}

	@Test
	void testToString() {
		assertEquals("10,10,1,1", plot5.toString());
	}

}
