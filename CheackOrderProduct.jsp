<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カート</title>
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
    </div>
    
    
	<div id="main1">
    	<p>　以下の商品がカート内に入ってます。</p>
       
        <table>
        	<tr>
            	<td><input type="checkbox" name="todoke" value="same"></td>
				<td><img src="2.png" alt="ロゴ" width="105" height="80"></td>
				<td>スニーカー</td>
                <td>¥15,000</td>
                <td><input type="text" size="1" maxlength="1" name="kosuu" value="1">個</td>
                <td>サイズ
                	<select name="size">
						<option value="SS">SS</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="LL">LL</option>
					</select>
               </td>
			</tr>
            
            <tr>
            	<td><input type="checkbox" name="todoke" value="same"></td>
				<td><img src="2.png" alt="ロゴ" width="105" height="80"></td>
				<td>スニーカー</td>
                <td>¥15,000</td>
                <td><input type="text" size="1" maxlength="1" name="kosuu" value="1">個</td>
                <td>サイズ
                	<select name="size">
						<option value="SS">SS</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="LL">LL</option>
					</select>
               </td>
			</tr>
            
            <tr>
            	<td><input type="checkbox" name="todoke" value="same"></td>
				<td><img src="2.png" alt="ロゴ" width="105" height="80"></td>
				<td>スニーカー</td>
                <td>¥15,000</td>
                <td><input type="text" size="1" maxlength="1" name="kosuu" value="1">個</td>
                <td>サイズ
                	<select name="size">
						<option value="SS">SS</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="LL">LL</option>
					</select>
               </td>
			</tr>
            
            <tr>
            	<td><input type="checkbox" name="todoke" value="same"></td>
				<td><img src="2.png" alt="ロゴ" width="105" height="80"></td>
				<td>スニーカー</td>
                <td>¥15,000</td>
                <td><input type="text" size="1" maxlength="1" name="kosuu" value="1">個</td>
                <td>サイズ
                	<select name="size">
						<option value="SS">SS</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="LL">LL</option>
					</select>
               </td>
			</tr>
            
            <tr>
            	<td><input type="checkbox" name="todoke" value="same"></td>
				<td><img src="2.png" alt="ロゴ" width="105" height="80"></td>
				<td>スニーカー</td>
                <td>¥15,000</td>
                <td><input type="text" size="1" maxlength="1" name="kosuu" value="1">個</td>
                <td>サイズ
                	<select name="size">
						<option value="SS">SS</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="LL">LL</option>
					</select>
               </td>
			</tr>
            
            <tr>
            	<td><input type="checkbox" name="todoke" value="same"></td>
				<td><img src="2.png" alt="ロゴ" width="105" height="80"></td>
				<td>スニーカー</td>
                <td>¥15,000</td>
                <td><input type="text" size="1" maxlength="1" name="kosuu" value="1">個</td>
                <td>サイズ
                	<select name="size">
						<option value="SS">SS</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="LL">LL</option>
					</select>
               </td>
			</tr>
        </table>
        
        <p>　　　　合計商品数：6　　　　小計(税抜)：¥90,000</p>
        
        <div id="button3">
        	<button type="button" name="change" value="change">
				<font size="4">変更</font>
			</button>
		
        	<button type="button" name="delete" value="delete">
				<font size="4">削除</font>
			</button>
 	   
        	<button type="button" name="order" value="order">
				<font size="4">注文</font>
			</button>
        </div>
     </div>
     
     <div id="under3">
		<a href="top.html">
        	<p>Topに戻る</p>
        </a>
	</div>
    
</body>
</html>
