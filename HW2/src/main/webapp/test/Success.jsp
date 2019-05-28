<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>15-29歲青年勞工就業狀況調查</title>
</head>
<body>
	<table border="1" bgcolor='#DEFFFF'>
		<thead>
			<tr>
				<th height="60" colspan="2" align="center">${memberBean.item}的資料${success}成功</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td width="200" height="40">統計項目別:</td>
				<td width="250" height="40">${param.statisticalItem}</td>
			</tr>
			<tr>
				<td width="200" height="40">樣本數（人）:</td>
				<td width="250" height="40">${param.samples}</td>
			</tr>
			<tr>
				<td width="200" height="40">未滿2萬元（%）:</td>
				<td width="250" height="40">${param.under2w}</td>
			</tr>
			<tr>
				<td width="200" height="40">2萬~未滿3萬元（%）:</td>
				<td width="250" height="40">${param.over2w}</td>
			</tr>
			<tr>
				<td width="200" height="40">3萬~未滿4萬元（%）:</td>
				<td width="250" height="40">${param.over3w}</td>
			</tr>
			<tr>
				<td width="200" height="40">4萬~未滿5萬元（%）:</td>
				<td width="250" height="40">${param.over4w}</td>
			</tr>
			<tr>
				<td width="200" height="40">5萬元及以上（%）:</td>
				<td width="250" height="40">${param.over5w}</td>
		</tbody>
	</table>

</body>
</html>