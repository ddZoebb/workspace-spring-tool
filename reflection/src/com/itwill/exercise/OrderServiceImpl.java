package com.itwill.exercise;

@Service(value = "orderService")
public class OrderServiceImpl {
	@AutoWire
	@Qualifier("orderDao")
	private OrderDaoImpl orderDaoImpl;
	
	public OrderServiceImpl() {
	}
	@AutoWire
	public OrderServiceImpl(@Qualifier(value="orderDao") OrderDaoImpl orderDaoImpl) {
		super();
		this.orderDaoImpl = orderDaoImpl;
	}

	public OrderDaoImpl getOrderDaoImpl() {
		return orderDaoImpl;
	}

	public void setOrderDaoImpl(OrderDaoImpl orderDaoImpl) {
		this.orderDaoImpl = orderDaoImpl;
	}
		

}
