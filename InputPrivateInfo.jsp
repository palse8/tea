<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入力画面</title>
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
		<p>　下記に個人情報と購入に使用するカードの情報を入力してください</p>

	　・個人情報
		<table>
			<tr>
				<td>氏名</td>
				<td><input type="text" size="15" maxlength="20" name="name" value=""></td>
			</tr>

			<tr>
				<td>氏名(フリガナ)</td>
				<td><input type="text" size="15" maxlength="20" name="name_kana" value=""></td>
			</tr>

			<tr>
				<td>郵便番号</td>
				<td><input type="text" size="10" maxlength="7" name="yubin" value=""></td>
			</tr>

			<tr>
				<td>住所</td>
				<td><input type="text" size="50" maxlength="100" name="address" value=""></td>
			</tr>

			<tr>
				<td>住所(フリガナ)</td>
				<td><input type="text" size="50" maxlength="100" name="address_kana" value=""></td>
			</tr>

			<tr>
				<td>電話番号</td>
				<td><input type="text" size="20" maxlength="11" name="tel" value=""></td>
			</tr>
		</table>

		<br>
　
		・カード情報
		<table>
			<tr>
				<td>カードブランド名</td>
					<td><input type="checkbox" name="brand" value="1">JCB
                    <input type="checkbox" name="brand" value="2">Amex
                    <input type="checkbox" name="brand" value="3">VISA
                    <input type="checkbox" name="brand" value="4">Master Card
				</td>
			</tr>

			<tr>
				<td>カード番号</td>
				<td><input type="text" size="20" maxlength="16" name="card_number" value=""></td>
			</tr>

			<tr>
				<td>セキュリティコード</td>
				<td><input type="text" size="10" maxlength="4" name="security" value=""></td>
			</tr>

			<tr>
				<td>有効期限(月/年)</td>
				<td><input type="text" size="10" maxlength="2" name="remit" value="">/<input type="text" size="10" maxlength="2" name="remit" value=""></td>
			</tr>
		</table>

		<div id="setting1">
			<p>届け先が異なる場合は下の同上を選択してください<br>
				異なる場合は入力欄に届け先情報を入力して下さい<br><br>

				<input type="checkbox" name="todoke" value="same">同上<br>
			</p>
		</div>

		<table>
			<tr>
				<td>氏名</td>
				<td><input type="text" size="15" maxlength="20" name="name" value=""></td>
			</tr>

			<tr>
				<td>氏名(フリガナ)</td>
				<td><input type="text" size="15" maxlength="20" name="name_kana" value=""></td>
			</tr>

			<tr>
				<td>郵便番号</td>
				<td><input type="text" size="10" maxlength="7" name="yubin" value=""></td>
			</tr>

			<tr>
				<td>住所</td>
				<td><input type="text" size="50" maxlength="100" name="address" value=""></td>
			</tr>

			<tr>
				<td>住所(フリガナ)</td>
				<td><input type="text" size="50" maxlength="100" name="address_kana" value=""></td>
			</tr>

			<tr>
				<td>電話番号</td>
				<td><input type="text" size="20" maxlength="11" name="tel" value=""></td>
			</tr>
		</table>

		<br>
		　希望配送日を本日より3日以降の日にちで入力して下さい<br>
		
        <div id="setting2">
			年：<input type="text" size="4" maxlength="4" name="year" value="">　　　
            月：<input type="text" size="2" maxlength="2" name="month" value="">　　　
            日：<input type="text" size="2" maxlength="2" name="day" value="">
		</div>

		<br>
        <br>

		<div id="button2">
        	<button type="button" name="next" value="next">
				<font size="4">次へ</font>
			</button>
		</div>

	</div>

		<div id="under2">
			<a href=".html">前に戻る</a>
			<a href="top.html">Topに戻る</a>
		</div>

</body>
</html>
