<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>確認画面</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="hedder">
  <a href="top.html">
    	<img src="2.png" alt="ロゴ" width="105" height="80">
        <img src="01.png" alt="マーク" width="300" height="80">
  </a>
</div>

<div id="main">
	<div id="message3">
		<p>下記にご請求先情報と納品先情報を記載しています。</p>
	</div>

	・個人情報
	<table>
    	<tr><td>氏名(フリガナ)</td><td>前田　博樹(マエダ　ヒロキ)</td></tr>
		<tr><td>郵便番号</td><td>3000005</td></tr>
		<tr><td>住所(フリガナ)</td><td>東京都千代田区丸の内1-6-X(トウキョウトチヨダクマルノウチ1-6-X)</td></tr>
		<tr><td>電話番号</td><td>0352321234</td></tr>
	</table>
	
    ・納品先情報
	<table>
  		<tr><td>氏名(フリガナ)</td><td>前田　博樹(マエダ　ヒロキ)</td></tr>
        <tr><td>郵便番号</td><td>3000005</td></tr>
        <tr><td>住所(フリガナ)</td><td>東京都千代田区丸の内1-6-X(トウキョウトチヨダクマルノウチ1-6-X)</td></tr>
        <tr><td>電話番号</td><td>0352321234</td></tr>
	</table>

	カード情報
	<table>
		<tr><td>カードブランド名</td><td>VISA</td></tr>
        <tr><td>カード番号</td><td>1234567890123456</td></tr>
        <tr><td>セキュリティコード</td><td>123</td></tr>
        <tr><td>有効期限(月/年)</td><td>10/20</td></tr>
	</table>
	
    <br>

	<div id="money">
		<u>
			小計(税抜):¥45,000<br>
			消費税:¥3,600<br>
			送料(税抜):¥0<br>
			合計金額(税込):¥48,600
		</u>
	</div>

	・注文商品
	<table>
		<tr><td>商品番号</td><td>商品名</td><td>サイズ</td><td>個数</td><td>値段(税抜)</td></tr>
 		<tr><td>AA-1234-A</td><td>スニーカー</td><td>S</td><td>3</td><td>¥15,000</td></tr>
	</table>

	<br><br>

	<br>
	・配送日　2016年07月01日
    
    <div id="button1">
		<button type="button" name="ok" value="ok">
			<font size="4">確定</font>
		</button>
	</div>
</div>

<div id="under2">
	<a href="inputuserdata.html">前に戻る</a>
	<a href="top.html">Topに戻る</a>
</div>

</body>
</html>
