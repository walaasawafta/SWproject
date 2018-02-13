

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test1 {
	private calculator calc;
	@Before
	 public void setUp() 
			 throws Exception {
	  calc = new calculator();
	 }
	
	 @After
	 public void tearDown() throws Exception {
	  calc = null;
	 }
	
	 @Test
	  public void testAdd_positiveNumbers_shouldReturnResult() {
		calc.add(3, 4);
	    
	  }

	  @Test(expected = IllegalArgumentException.class)
	  public void testAdd_negativeNumbers_shouldThrowException() {
		 calc.add1(-3, -4);
	}
	 @Test
	 public void testAdd() {
	   
		 calc.add(10.5, 20.32);
	 
	 }
	 @Test
	 public void testSubtract() {
	  calc.sub(100.5, 100);
	 
	 }
	 
	 @Test
	 public void testMultiply() {
	   calc.mul(2.5, 100);
	  
	 }
	 
	 @Test
	 public void testDivide() {
	  calc.div(100, 10);
	  
	   
	 }
	
	 
	 @Test(expected = ArithmeticException.class)
	 public void testDivideByZero(){
	  //calc.div(100.5, 0);
	 
	      calc.div(100.5, 0);
	     throw new ArithmeticException ("Should have thrown an exception!");
	    
	  
	  }
	 
	

	
	
	
	
	
	

}
