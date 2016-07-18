<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" import = "beans.Product" import = "beans.Category"%>
<% 
String command = (String)session.getAttribute("command");
ArrayList<Product> productList = null;
ArrayList<Category> categoryList = null;
System.out.println("top.jsp : " + (command == null));
System.out.println("Error : " + (String)request.getAttribute("Error"));
if(command == null || !command.equals("searchAll")){
	session.setAttribute("command", "searchAll");
	response.sendRedirect("FrontController");
}else{
	session.removeAttribute("command");
	productList = (ArrayList<Product>)session.getAttribute("productList");
	System.out.println(productList.size());
	categoryList = (ArrayList<Category>)session.getAttribute("categoryList");
}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>トップ</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="hedder">
		<a href="top.html">
        	<img src="2.png" alt="ロゴ" width="105" height="80">
        <img src="01.png" alt="マーク" width="300" height="80">
		</a>
</div>

	<div id="side">
    	<table width="90%">
        	<tr>
				<td>ID</td>
				<td><input type="text" size="10" maxlength="4" name="id"></td>
			</tr>

			<tr>
				<td>パスワード</td>
				<td><input type="text" size="10" maxlength="4" name="remit" value=""></td>
			</tr>
        </table>
        
        <br>
        	<div id="setting3">
       			 <button type="button" name="login" value="login">
					<font size="4">ログイン</font>
				</button>
            </div>
        <br><br><br>
        <hr>
        <div id="setting4">
       		<a href="cart.html"><p>注文商品を確認する</p></a>
        </div>
         <hr>
        
        <div id="setting4">
        	<a href=".html"><p>会社概要</p></a>
        </div>
         <hr>
        
        <div id="setting4">
        	<a href=".html"><p>特定商取引法</p></a>
        </div>
    </div>
    
<div id="side2">
    	<select name="category">
			<option value="SS">SS</option>
			<option value="S">S</option>
			<option value="M">M</option>
			<option value="L">L</option>
			<option value="LL">LL</option>
		</select>
        <input type="text" size="10" maxlength="10" name="word" value="word">
        <button type="button" name="change" value="change">
				<font size="3">検索</font>
		</button>         
   <br>
   <hr>
   
   		カテゴリ
  <li>スタンダードスニーカー</li>
   			<li>レザースニーカー</li>
   			<li>◯◯スニーカー</li>
   			<li>◯◯スニーカー</li>
   		
   		色
   		<li>赤</li>
   		<li>青</li>
  		<li>白</li>
   		<li>黒</li>
    </div>
    
    
    <div id="main2">
    <%
    if(productList != null){
    for(Product p : productList){ 
    %>
   	  <div id="content">
   	  	<a href="ProductInfo.jsp"> <img src="2.png" alt="ロゴ" width="105" height="80"><br><%= p.getProductName() %><br>¥<%= p.getUnitPrice() %><br>在庫：◯</a>
      </div>
    <% }} %>

      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
      <div id="content">
        <img src="2.png" alt="ロゴ" width="105" height="80"><br>スニーカー<br>¥15,000<br>在庫：◯
      </div>
      
    </div>
    
    
</body>
</html>
