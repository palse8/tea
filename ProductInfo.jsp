<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品画面</title>
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
        
    </div>
    
    
	<div id="main1">
    <div id="setting5">
    	<div id="picture">
        	<img src="2.png" alt="ロゴ" width="300" height="300">
        </div>
        <div id="productinfo">
        	<ul style='list-style-type:none;'>
       			<li>商品名：スニーカー</li>
       			<li>色：赤</li>
        		<li>値段：¥15,000</li>
        		<li>在庫 SS:◯ S:◯ M:◯ L:◯ LL:◯</li>
        		<li>商品説明：赤いスニーカーでとても人気です。</li>
       		</ul>
        	
            <br><br><br><br><br><br><br><br>
            <div id="setting6">
        	サイズ：<select name="size">
						<option value="SS">SS</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="LL">LL</option>
					</select>
    	
            注文個数：<input type="text" size="1" maxlength="1" name="kosuu" value="1">個
        
        	<button type="button" name="cart" value="cart">
				<font size="4">購入</font>
			</button>
            </div>
        </div>
        </div>
    </div>
    <div id="under3">
		<a href="top.html">
        	<p>Topに戻る</p>
        </a>
	</div>
</body>
</html>
