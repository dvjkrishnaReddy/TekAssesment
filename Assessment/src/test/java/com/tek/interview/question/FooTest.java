/**
 * 
 */
package com.tek.interview.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Krish
 *
 */
public class FooTest {
	
	Item item1;
	Item item2;
	OrderLine orderLine1;
	OrderLine orderLine2;
	Order order;
	Map<String, Order> orderMap;
		
	@Before
	public void init() throws Exception{
		
		item1 = new Item("music CD",14.99f);
		item2 = new Item("chocolate bar",0.85f);
		orderLine1 = new OrderLine(item1,1);
		orderLine2 = new OrderLine(item2,1);
		List<OrderLine> orderLines = new ArrayList<OrderLine>();
		orderLines.add(orderLine1); 
		orderLines.add(orderLine2);
		order = new Order();
		orderMap = new HashMap<String, Order>();

		order.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		order.add(new OrderLine(new Item("imported box of perfume", 47.55f), 1));
		
		orderMap.put("Order 1", order);
		

    }
	
	// Testing methods getDescription() and getPrice() and exception from Item Class 
	
	@Test
	public void getDescriptionTest(){
		Assert.assertEquals("music CD",item1.getDescription());
	}
	
	@Test
	public void getPriceTest(){
		Assert.assertEquals(14.99f, item1.getPrice(), 0.0);;
	}
	
	@Test(expected=Exception.class)
	public void exceptionTest() throws Exception{
		orderLine1 = new OrderLine(null,1);
		orderLine1.getItem();
	}
	
	//Testing getQuantity() and exceptions from OrderLine Class
	@Test
	public void getQuantityTest(){
		Assert.assertEquals(1, orderLine1.getQuantity());
	}
	
	@Test
	public void notIllegalArgumentExceptionTest() throws Exception{
		order.add(orderLine1);
		order.add(orderLine2);
	}
	@Test(expected=IllegalArgumentException.class)
	public void illegalArgumentExceptionTest() throws Exception{
		orderLine1=null;
		order.add(orderLine1);
	}
	
	// Testing Order size and clear Test method from Order Class
	@Test
	public void orderSizeTest() throws Exception{
		order.add(orderLine1);
		order.add(orderLine2);
		Assert.assertEquals(4,order.size(),0);
	}
	
	@Test
	public void clearTest() {
		    order = order.clear();
			Assert.assertEquals(0,order.size(),0);
	}
	
	//Testing rounding method from calculator class
	@Test
	public void roundingTest(){
		Assert.assertEquals(4.63, calculator.rounding(4.6346),0);
	}
	@Test
	public void roundingNotEqualTest(){
		Assert.assertNotEquals(4.67, calculator.rounding(4.6345),0);
	}
	
	
}
