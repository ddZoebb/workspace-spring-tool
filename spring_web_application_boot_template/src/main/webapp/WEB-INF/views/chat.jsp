<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script src="js/chat.js"></script>
</head>
<body>
<div class="container">
		<h1 class="page-header">Chat</h1>

		<table class="table table-bordered">
			<tr>
				<td><input type="text" name="user" id="user"
					class="form-control" placeholder="유저명"></td>
				<td>
					<button type="button" class="btn btn-default" id="btnConnect">연결</button>
					<button type="button" class="btn btn-default" id="btnDisconnect"
						>부르기</button>
				</td>
			</tr>
			<tr>
				<td colspan="2"><div id="list"></div></td>
				<td colspan="2"><div id="send_ment">보낸 메세지</div>
				<div id="receive_ment">받은 메세지</div>
				</td>
				<td colspan="2"><div id="content"></div></td>
				
				
			</tr>
			<tr>
				<td colspan="2"><input type="text" name="msg" id="msg"
					placeholder="대화 내용을 입력하세요." class="form-control" >
					<button type="button" class="btnSend" id="btnSend">전송</button></td>
			</tr>
		</table>
	</div>
</body>
</html>