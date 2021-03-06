<%@page import="Controller.API_PAYMENT.Config"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : vnpay_return
    Created on : Sep 29, 2015, 7:23:56 PM
    Author     : xonv
    Description: Su dung de thong bao ket qua thanh toan toi khach hang. 
                 Khong thuc hien cap nhat vao db tai file nay
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>	
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<!DOCTYPE html>
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>VNPAY</title>
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
     <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
     <link rel="stylesheet" href="style.css">
 </head>
 <style type="text/css">
 	*{
     margin:0;
     padding: 0;
     font-family: 'Roboto', sans-serif;
     box-sizing: border-box;
 }
section{
     position: relative;
     display: flex;
     justify-content: center;
     align-items: center;
     min-height: 100vh;
     background: #112d42;
 }
section::before{
     content: "";
     position: absolute;
     top: 0;
     left: 0;
     width:50%;
     height: 100%;
     background: #03a9f4;
 }
section .container{
     position: relative;
     min-width: 1100px;
     min-height: 550px;
     display:flex;
     z-index: 100;
 }
 section .container .containerinfo{
     position: absolute;
     top: 40px;
     width: 350px;
     height: calc(100% - 80px);
     background: #0f3959;
     z-index: 1;
     padding: 40px;
     display: flex;
     flex-direction: column;
     justify-content: space-between;
     box-shadow: 0 20px 20px rgba(0,0,0,0.2);
 }
section .container .containerinfo h2{
     color: #fff;
     font-size: 24px;
     margin: 20px 0;
 }
 section .container .containerinfo li{
     position: relative;
     list-style: none;
     display: flex;
     margin: 20px 0;
     cursor: pointer;
     align-items: flex-start;
 }
section .container .containerinfo li span{
     color: #fff;
     margin-left: 10px;
     font-weight: 300;
     opacity: 0.5;
     font-size: 20px;
 }
 /*Hi???u ???ng Hover Cho Th??? Li*/
 section .container .containerinfo li:hover span{
     opacity: 1;
 }
 section .container .containerinfo .sci{
     position: relative;
     display:flex;
 }
section .container .containerinfo .sci li{
     list-style: none;
     margin-right: 15px;
 }
section .container .containerinfo .sci li a{
     text-decoration: none;
     opacity: 0.5;
     color: #fff;
     font-size: 32px;
 }
 /*Hi???u ???ng Hover Icon*/
 section .container .containerinfo .sci li:hover a{
     opacity: 1;
 }
 section .container .containerForm{
     position: absolute;
     padding: 70px 50px;
     background: #fff;
     margin-left: 150px;
     padding-left: 250px;
     width: calc(100% - 150px);
     height: 100%;
     box-shadow: 0 50px 50px rgba(0,0,0,0.5);
 }
section .container .containerForm h2{
     color: #0f3959;
     font-size: 24px;
     font-weight: 500;
 }
section .container .containerForm .formBox{
     position: relative;
     display: flex;
     justify-content: space-between;
     flex-wrap: wrap;
     padding-top: 30px;
 }
section .container .containerForm .formBox .inputBox{
     position: relative;
     margin: 0 0 35px 0;
 }
section .container .containerForm .formBox .inputBox.w50{
     width: 47%;
 }
section .container .containerForm .formBox .inputBox.w100{
     width: 100%;
 }
  section .container .containerForm .formBox .inputBox textarea{
     width: 100%;
     padding: 5px 0;
     resize: none;
     font-size: 18px;
     font-weight: 400;
     color: #333;
     border: none;
     border-bottom: 1px solid #777;
     outline: none;
 }
section .container .containerForm .formBox .inputBox textarea{
     min-height: 120px;
 }
section .container .containerForm .formBox .inputBox input[type="submit"]{
     position: relative;
     cursor: pointer;
     background: #0f3959;
     color: #fff;
     border: none;
     max-width: 150px;
     padding: 12px;
 }
section .container .containerForm .formBox .inputBox input[type="submit"]:hover{
     background:  #ff568c;
 }

 </style>
 <body>
        <%
            //Begin process return from VNPAY
            Map<String,String> fields = new HashMap();
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

        %>
        <!--Begin display -->
        <section>
   <div class="container">
       <div class="containerinfo" style="color:white">
       	VNPAY RESPONSE
       	<img src="https://downloadlogomienphi.com/sites/default/files/logos/download-logo-vector-vnpayqr-noqr-mien-phi.jpg">
       </div>
       <!-- B???t ?????u ??o???n m?? m???i-->
       <div class="containerForm">
           <h2></h2>
           <div class="formBox">
               <div class="inputBox w50">
                   <label >M?? ????n h??ng:</label>
                    <label><%=request.getParameter("vnp_TxnRef")%></label>
               </div>

               <div class="inputBox w50">
                  <label >S??? ti???n:</label>
                    <label><%=Integer.parseInt(request.getParameter("vnp_Amount"))/100%>??</label>
               </div>
               <div class="inputBox w50">
                    <label >N???i dung thanh to??n:</label>
                    <label><%=request.getParameter("vnp_OrderInfo") %></label>
               </div>
               <div class="inputBox w50">
                   <label >M?? ph???n h???i (vnp_ResponseCode):</label>
                    <label><%=request.getParameter("vnp_ResponseCode")%></label>
               </div>
               <div class="inputBox w50">
                  <label >M?? GD T???i VNPAY:</label>
                    <label><%=request.getParameter("vnp_TransactionNo")%></label>
               </div>
               <div class="inputBox w50">
                  <label >M?? Ng??n h??ng:</label>
                    <label><%=request.getParameter("vnp_BankCode")%></label>
               </div>
               <div class="inputBox w50">
                 <label >Th???i gian thanh to??n:</label>
                    <label><%=request.getParameter("vnp_PayDate")%></label>
               </div>
                <div class="inputBox w100">
                   <label >K???t qu???:</label>
                    <label>
                        <%
                            if (signValue.equals(vnp_SecureHash)) {
                                if ("00".equals(request.getParameter("vnp_ResponseCode"))) {
                                    out.print("GD Thanh cong");
                                } else {
                                    out.print("GD Khong thanh cong");
                                }

                            } else {
                                out.print("Chu ky khong hop le");
                            }
                        %></label>
               </div>
            <a href="http://localhost:8080/Client_Project/index"> <button >Tr??? v??? trang ch??? </button> </a>
           </div>
       </div>
      <!-- K???t th??c ??o???n m?? m???i-->
   </div>
 </section>
    </body>
</html>
