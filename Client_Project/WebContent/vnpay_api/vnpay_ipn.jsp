<%@page import="Controller.API_PAYMENT.*"%>
<%@page import="Model.*"%>
<%@page import="Service.*"%>
<%@page contentType="application/json; charset=UTF-8"%>
<%-- 
    Document   : vnpay_ipn
    Created on : Sep 29, 2015, 7:23:56 PM
    Author     : xonv
    Description: IPN URL su dung de nhan ket qua thanh toan tu server của VNPAY
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Random"%>

<%
    //Begin process return from VNPAY
    Map fields = new HashMap();
    for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
        String fieldName = (String) params.nextElement();
        String fieldValue = request.getParameter(fieldName);
        if ((fieldValue != null) && (fieldValue.length() > 0)) {
            fields.put(fieldName, fieldValue);
        }
    }

    String vnp_SecureHash = request.getParameter("vnp_SecureHash");
    if (fields.containsKey("vnp_SecureHashType")) {
        fields.remove("vnp_SecureHashType");
    }
    if (fields.containsKey("vnp_SecureHash")) {
        fields.remove("vnp_SecureHash");
    }
    String signValue = Config.hashAllFields(fields);
    if (signValue.equals(vnp_SecureHash)) {
        //Kiem tra chu ky OK
        /* Kiem tra trang thai don hang trong DB: checkOrderStatus, 
        - Neu trang thai don hang OK, tien hanh cap nhat vao DB, tra lai cho VNPAY RspCode=00
        - Neu trang thai don hang (da cap nhat roi) => khong cap nhat vao DB, tra lai cho VNPAY RspCode=02
         */
        boolean checkOrderStatus = true;

        if (checkOrderStatus) {
            if ("00".equals(request.getParameter("vnp_ResponseCode"))) {
                //Xu ly thanh toan thanh cong
                // out.print("GD Thanh cong");
                String fullname = (String)session.getAttribute("fullname");
                String phone = (String)session.getAttribute("phone");
                String email = (String)session.getAttribute("email");
                String address = (String)session.getAttribute("address");
                String CHAR_LIST ="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        		int RANDOM_STRING_LENGTH = 10;
        		Random rnd = new Random();
                StringBuilder sb = new StringBuilder(RANDOM_STRING_LENGTH);
                for (int i = 0; i <RANDOM_STRING_LENGTH; i++) {
                    sb.append(CHAR_LIST.charAt(rnd.nextInt(CHAR_LIST.length())));
                }
        		User user = (User) session.getAttribute("user");
        		Order order = (Order) session.getAttribute("order");
        		Order_service order_sv = new Order_service();
        		Order_detail_service ordService = new Order_detail_service();
        		List<Item> listitem =order.getItems();
        		List<Order> listOrder =order_sv.getListOrder();
        		String MADH ="";
        		for(Order or: listOrder) {
        				MADH ="DH-"+ sb;
        				if(MADH.equals(or.getId())) {
        					continue;
        				}else{
        					break;
        				}
        		}
        		if(order != null) {
    				if(user == null) {
    					order_sv.insertOrder(fullname, phone, email, address,1, order.getTotal(),MADH);
    					
    				}else {
    					order_sv.insertOrder(fullname, phone, email, address, user.getId(), order.getTotal(),MADH);
    					
    				}
    				for(Item item : listitem) {
    					System.out.println(item.getQuantity()+MADH+item.getProduct().getId()+item.getSize().getId());
    					ordService.insertOrderDetail(item.getQuantity(),MADH,item.getProduct().getId(),item.getSize().getId());
    				}
    			}
    			session.removeAttribute("order");
    			request.getRequestDispatcher("vnpay_return.jsp").forward(request, response);
                
                
            } else {
                //Xu ly thanh toan khong thanh cong
                //  out.print("GD Khong thanh cong");
            	request.getRequestDispatcher("vnpay_return.jsp").forward(request, response);
            }
            out.print ("{\"RspCode\":\"00\",\"Message\":\"Confirm Success\"}");
        } else {
            //Don hang nay da duoc cap nhat roi, Merchant khong cap nhat nua (Duplicate callback)
            out.print("{\"RspCode\":\"02\",\"Message\":\"Order already confirmed\"}");
        }

    } else {
        out.print("{\"RspCode\":\"97\",\"Message\":\"Invalid Checksum\"}");
    }
%>
