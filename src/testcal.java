

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testcal {
	private calculator calc;
	@Before
	 public void setUp() throws Exception {
	  calc = new calculator();
	 }
	
	 @After
	 public void tearDown() throws Exception {
	  calc = null;
	 }
	
	 @Test
	 public void testAdd() {
	  double result = calc.add1(10.5, 20.32);
	  assertEquals(30.82, result, 0);
	 }
	 @Test
	 public void testSubtract() {
	  double result = calc.sub1(100.5, 100);
	  assertEquals(0.5, result, 0);
	 }
	 
	 @Test
	 public void testMultiply() {
	  double result = calc.mul1(2.5, 100);
	  assertEquals(250, result, 0);
	 }
	 
	 @Test
	 public void testDivide() {
	  double result = calc.div1(100, 10);
	  assertEquals(10, result, 0.001);
	   
	 }
	  
	 @Test(expected = ArithmeticException.class)
	 public void testDivideByZero() {
	  calc.div1(100.5, 0);
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
