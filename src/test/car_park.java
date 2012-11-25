package test;

import com.park.carPark;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class car_park {
	private carPark park = null;
	private String IDCard = "123456789";
	private String carNumber = "¾©A12345"; 
	
	@Before
	public void init(){
		park = new carPark(10);	
	}
	
	@Test
	public void have_empty_space_push_a_car_success_test() {
		boolean result = park.pushACar(IDCard, carNumber);
		int count = park.getEmptySpaces();
		assertTrue("success", result);
	    assertEquals(count, 9);
	}

	@Test
	public void have_no_empty_space_push_a_car_return_false_test(){
		carPark nospace = new carPark(0);
		boolean result = nospace.pushACar(IDCard, carNumber);
		assertFalse("Fail", result);
	}
	
	@Test
	public void get_the_car_success_test(){
		carPark getCar = new carPark(10);
		getCar.pushACar(IDCard, carNumber);
		Object result = getCar.popACar(IDCard);
		assertNotNull("Success", result);
		int count = park.getEmptySpaces();
		assertEquals(count, 10);
	}
	
	@Test
	public void get_the_car_from_empty_park_false_test(){
		carPark getCar = new carPark(10);
		Object result = getCar.popACar(IDCard);
		assertNull("fail", result);
	}
	
	@Test
	public void get_the_pushed_in_car_from_park_success_test(){
		carPark getCar = new carPark(10);
		getCar.pushACar(IDCard, carNumber);
		String result = getCar.popACar(IDCard).toString();
		assertEquals(result, carNumber);
	}
	
	@Test
	public void get_the_pushed_in_car_by_invalid_idcard_fail_test(){
		carPark getCar = new carPark(10);
		getCar.pushACar(IDCard, carNumber);
		Object result = getCar.popACar("122334");
		assertNull(result);
	}
	
	@Test
	public void get_twice_the_pushed_in_car_success_test(){
		carPark getCar = new carPark(10);
		getCar.pushACar(IDCard, carNumber);
		String result1 = getCar.popACar(IDCard).toString();
		Object result2 = getCar.popACar(IDCard);
		assertEquals(result1, carNumber);
		assertNull(result2);
		
		
	}
}
