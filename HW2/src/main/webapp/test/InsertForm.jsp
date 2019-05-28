<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>15-29歲青年勞工就業狀況調查</title>

<style>
form {
	margin: 0 auto;
	width: 550px;
}

.allpage {
	width: 1248px;
	height: 900PX;
	margin: auto;
	background-color: #EEFFBB;
}

footer {
	background-color: #BBFFEE;
	border-bottom-left-radius: 20px;
	border-bottom-right-radius: 20px;
	text-align: right;
	color: #AAAAAA;
	font-size: 18px;
	width: 1248px;
	margin: auto;
	list-style-type: none;
}
</style>

</head>

<body onload="javascript:document.insertMemberFormA.statisticalItem.focus();">
	<div class="allpage">
		<header>
			<img src="/HW2/test/images/logo.jpg" alt="logo" width="1248">
		</header>	
		<form name="insertMemberFormA" action=" <c:url value='' />" method="POST">
			<table border="1" bgcolor='#DEFFFF'>
				<thead>
					<tr>
						<th height="60" colspan="2" align="center">15-29歲 青年勞工就業狀況調查</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="200" height="40">統計項目別:</td>
						<td width="350" height="40" align="left">
						<input name="statisticalItem" value="${param.statisticalItem}" 
								type="text" size="22"  id="idSi" placeholder="必須為中文">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.statisticalItem}</div>
						<span id="idSiSp"></span></td>
					</tr>
					<tr>
						<td width="200" height="40">細項:</td>
						<td width="350" height="40" align="left">
						<input name="item" value="${param.item}"
						 		type="text" size="22" id="idItem" placeholder="必須為中文">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.item}</div>
						<span id="idItemSp"></span></td>
					</tr>
					<tr>
						<td width="200" height="40">樣本數（人）:</td>
						<td width="350" height="40" align="left">
						<input name="samples" value="${param.samples}" 
								type="text" size="22" id="idSamples" placeholder="必須為三位數字以上" pattern="[1-9]{1}[0-9]{2,}">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.samples}${ErrorMsg.samplesBlank}</div>
						<span id="idSamplesSp"></span></td>
					</tr>
					<tr>
						<td width="200" height="40">未滿2萬元（%）:</td>
						<td width="350" height="40" align="left">
						<input name="under2w" value="${param.under2w}"
								 type="text" size="15" id="idUnder2w" placeholder="例 : 99.9">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.under2w}${ErrorMsg.under2wBlank}</div>
						<span id="idUnder2wSp"></span></td>
					</tr>
					<tr>
						<td width="200" height="40">2萬~未滿3萬元（%）:</td>
						<td width="350" height="40" align="left">
						<input name="over2w" value="${param.over2w}"
								 type="text" size="15" id="idOver2w" placeholder="例 : 99.9">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.over2w}${ErrorMsg.over2wBlank}</div>
						<span id="idOver2wSp"></span></td>
					</tr>

					<tr>
						<td width="200" height="40">3萬~未滿4萬元（%）:</td>
						<td width="350" height="40" align="left">
						<input name="over3w" value="${param.over3w}"
								 type="text" size="15" id="idOver3w" placeholder="例 : 99.9">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.over3w}${ErrorMsg.over3wBlank}</div>
						<span id="idOver3wSp"></span></td>
					</tr>
					<tr>
						<td width="200" height="40">4萬~未滿5萬元（%）:</td>
						<td width="400" height="40" align="left">
						<input name="over4w" value="${param.over4w}" 
								type="text" size="15" id="idOver4w" placeholder="例 : 99.9">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.over4w}${ErrorMsg.over4wBlank}</div>
						<span id="idOver4wSp"></span></td>
					</tr>
					<tr>
						<td width="200" height="40">5萬元及以上（%）:</td>
						<td width="400" height="40" align="left">
						<input name="over5w" value="${param.over5w}" 
								type="text" size="15" id="idOver5w" placeholder="例 : 99.9">
						<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.over5w}${ErrorMsg.over5wBlank}</div>
						<span id="idOver5wSp"></span></td>
					</tr>
					<tr>
						<td height="50" colspan="2" align="center"><input
							type="submit" value="新增" onclick="insertData()"> <input
							type="button" value="修改" onclick="updateData()"> <input
							type="button" value="刪除" onclick="deleteData()"> <input
							type="button" value="查詢" onclick="selectOneData()"> <input
							type="reset" value="清除"></td>
					</tr>
				</tbody>
			</table>
			<div style="color: #FF0000; display: inline">${ErrorMsg.exception}</div>
		</form>
	</div>
	<footer> EEIT10732 詹岷錠 &nbsp; &copy; 20190523 &nbsp; </footer>
</body>

<script>
	function insertData() {
		window.document.insertMemberFormA.action = 'insert.do';
		window.document.insertMemberFormA.submit();
	}
	function selectOneData() {
		window.document.insertMemberFormA.action = 'selectOne.do';
		window.document.insertMemberFormA.submit();
	}
	function updateData() {
		window.document.insertMemberFormA.action = 'update.do';
		window.document.insertMemberFormA.submit();
	}
	function deleteData() {
		window.document.insertMemberFormA.action = 'delete.do';
		window.document.insertMemberFormA.submit();
	}

	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("idSi").addEventListener("blur",chkStatisticalItem);
	})
	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("idItem").addEventListener("blur", chkItem);
	})
	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("idSamples").addEventListener("blur",chkSamples);
	})
	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("idUnder2w").addEventListener("blur",chkUnder2w);
	})
	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("idOver2w").addEventListener("blur",chkOver2w);
	})
	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("idOver3w").addEventListener("blur",chkOver3w);
	})
	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("idOver4w").addEventListener("blur",chkOver4w);
	})
	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("idOver5w").addEventListener("blur",chkOver5w);
	})
	
	//檢查是否為中文
	let re1 = /^[\u4e00-\u9fff]{1,}$/;
	//檢查是否為小數後兩位	
	let re2 = /^[0-9]{1,2}(\.[0-9]{1,2})?$/;
	
	function chkStatisticalItem() {
		let theSi = document.getElementById("idSi").value;	
		if (theSi == "")
			document.getElementById("idSiSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>不可為空白</span>`;
		else if (re1.test(theSi))
			document.getElementById("idSiSp").innerHTML = `<span class='a2'>格式正確</span>`;
		else
			document.getElementById("idSiSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>格式錯誤</span>`;
	}
	function chkItem() {
		let theItem = document.getElementById("idItem").value;
		if (theItem == "")
			document.getElementById("idItemSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>不可為空白</span>`;
		else if (re1.test(theItem))
			document.getElementById("idItemSp").innerHTML = `<span class='a2'>格式正確</span>`;
		else
			document.getElementById("idItemSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>格式錯誤</span>`;
	}
	function chkSamples() {
		let theSamples = document.getElementById("idSamples").value;
		let re = /^[1-9]{1}[0-9]{2,}$/;
		if (theSamples == "")
			document.getElementById("idSamplesSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>請輸入樣本數</span>`;
		else if (re.test(theSamples))
			document.getElementById("idSamplesSp").innerHTML = `<span class='a2'>格式正確</span>`;
		else
			document.getElementById("idSamplesSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>格式錯誤</span>`;
	}
	function chkUnder2w() {
		let theSamples = document.getElementById("idUnder2w").value;		
		if (theSamples == "")
			document.getElementById("idUnder2wSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>請輸入數值</span>`;
		else if (re2.test(theSamples))
			document.getElementById("idUnder2wSp").innerHTML = `<span class='a2'>格式正確</span>`;
		else
			document.getElementById("idUnder2wSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>格式錯誤</span>`;
	}
	function chkOver2w() {
		let theSamples = document.getElementById("idOver2w").value;
		if (theSamples == "")
			document.getElementById("idOver2wSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>請輸入數值</span>`;
		else if (re2.test(theSamples))
			document.getElementById("idOver2wSp").innerHTML = `<span class='a2'>格式正確</span>`;
		else
			document.getElementById("idOver2wSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>格式錯誤</span>`;
	}	
	function chkOver3w() {
		let theSamples = document.getElementById("idOver3w").value;
		if (theSamples == "")
			document.getElementById("idOver3wSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>請輸入數值</span>`;
		else if (re2.test(theSamples))
			document.getElementById("idOver3wSp").innerHTML = `<span class='a2'>格式正確</span>`;
		else
			document.getElementById("idOver3wSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>格式錯誤</span>`;
	}
	function chkOver4w() {
		let theSamples = document.getElementById("idOver4w").value;
		if (theSamples == "")
			document.getElementById("idOver4wSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>請輸入數值</span>`;
		else if (re2.test(theSamples))
			document.getElementById("idOver4wSp").innerHTML = `<span class='a2'>格式正確</span>`;
		else
			document.getElementById("idOver4wSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>格式錯誤</span>`;
	}
	function chkOver5w() {
		let theSamples = document.getElementById("idOver5w").value;
		if (theSamples == "")
			document.getElementById("idOver5wSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>請輸入數值</span>`;
		else if (re2.test(theSamples))
			document.getElementById("idOver5wSp").innerHTML = `<span class='a2'>格式正確</span>`;
		else
			document.getElementById("idOver5wSp").innerHTML = `<img src="/HW2/test/images/nasshi.png"><span>格式錯誤</span>`;
	}	
</script>
</html>