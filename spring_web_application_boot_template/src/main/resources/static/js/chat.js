

//DOM Tree 생성 후 connect WS 실행 

var socket=null;
var loginId=null;
var loginName=null;
var yourId=null;
var mImage=null;

var c_room_no=null;
var contextPath=getContextPath();

var jsonData={
	code:null,
	url:null,
	msg:null,
	your_id:null, // 상대 아이디 
	data:null //chat_contents 
	
};

function getContextPath(){
   var lastIndexCount = location.href.lastIndexOf('/');
   var ctx = location.href.substr(0,lastIndexCount).replace('http', 'ws');
   return ctx;
}


//채팅 페이지 열릴 때 

$(document).ready(function(){
	
	//$('#content').html('$(document)ready 성공');
	
	
	console.log('$(document)ready 성공');
	
	//소켓 연결 
	$('#btnConnect').click(function(){
		console.log('연결 버튼 클릭');
		loginId=$('#user').val();
		connectWS();
		message_send_function();
	});
	
	
});




//채팅 부르기 

$(document).on('click','#btnDisconnect',function(e){
$.ajax({
		url:"chat_detail_rest",
		method:"GET",
		
		
		success:function(jsonResult){
			var chatContentArray=jsonResult.data;
			console.log(chatContentArray[0]);
			$('#content').html('채팅 불러오기 성공');
		}
		
	});
	});
	

//메세지 전송 

function message_send_function(){
	$('#btnSend').click(function(e){
		console.log("send 버튼 클릭");
		timestamp = new Date().getTime();
		e.preventDefault();
		//제이슨데이터 만들기 
		// 임시 데이터 test
		
		jsonData.mId=loginId;
		
		yourId="carrot3";
		c_room_no="3";
		/*****상대방 아이디 / 채팅방 데이터 받아와야 함  */
		jsonData.your_id=yourId;
		jsonData.msg="메세지 전송(socket.send)";
		jsonData.code="1";
		jsonData.data=[{
			c_content_no:"",
			c_content:$('#msg').val(),
			send_time:"",
			c_read:"0",
			user_id:loginId,
			c_room_no:c_room_no
		}]
		

			
		
		console.log("json데이터만들기 끝")
		
		
		
		$('#msg').val("");
	
		
			
		message_sendDB(jsonData);
		console.log("DB 전송")		
		
	
	
	});
}

/*
function getLoginId(){
	$.ajax({
		url:"sessionCheck",
		method:"POST",
		dataType:'text',
		success:function(msg){
			loginId=msg.split(",")[0];
			loginName=msg.split(",")[1];
		}
	})
}*/



	function message_sendDB(jsonData){
				$.ajax({
				url:'chat_message_rest',
    			data: JSON.stringify(jsonData.data[0]), //전송 데이터
    			
    			type: "POST", //전송 타입
    			async: true, //비동기 여부
    			//timeout: 5000, //타임 아웃 설정
    				
    			contentType: "application/json; charset=utf-8", //헤더의 Content-Type을 설정
    			dataType: "JSON", //응답받을 데이터 타입 (XML,JSON,TEXT,HTML,JSONP)    			
    			    			
    			// [응답 확인 부분 - json 데이터를 받습니다] -보낸 클라이언트가 자기한테 받는 거 (?)
    			success: function(response) {
    				console.log("성공");
    				console.log(" 내가 보낸 것 [requestPostBodyJson] : [response] : " + JSON.stringify(response));    				
    				console.log("");
    				jsonData.data[0].send_time=response.send_time;
    				console.log(JSON.stringify(jsonData));    	
    				
    				socket.send(JSON.stringify(jsonData));		
    					console.log("socket 전송")	;	
    			},
    			error:function(xhr){
						console.log("error");
				}
    			
    			});
			}



	

function connectWS(){
	
	var url="ws://localhost:80/spring_web_application_boot_template/replyEcho?"+loginId;
	var ws=new WebSocket(url);
	socket=ws;
	
	ws.onopen = function(evt) {
			console.log(loginId+'서버 연결 성공');
		
	    };
	ws.onerror=function(evt){
		console.log('에러');
	}
	
	ws.onmessage=function(result){
		//var onMsg=JSON.parse(evt);
		console.log(result.data);
		var onMsg=JSON.parse(result.data);
		console.log('메세지 얻기');
		console.log(onMsg.data[0]);
		
		if(onMsg.data[0].user_id!=loginId){
		$('#list').append("상대방:"+onMsg.data[0].c_content+"["+onMsg.data[0].send_time+"]");
		}else if(onMsg.data[0].user_id==loginId){
		$('#list').append("나:"+onMsg.data[0].c_content+"["+onMsg.data[0].send_time+"]");

		}
	}
	
	ws.onclose=function(evt){
		console.log('소켓 닫기');
	}
}
			
			
/*
function connectWS() {
   var url="ws://192.168.15.22:80/spring_web_application_boot_template/replyecho";
   var ws = new WebSocket(url);
   socket = ws;
   
   
   
   ws.onopen = function() { // connection이 open 되었을때 실행
     
      // connection 이 close 되었을때 실행
      ws.onclose = function(event) { 
      setTimeout(function() {
               connectWS();
         }, 1000);
      };
      // connection 이 error가 나왔을때
   ws.onerror = function(event) { 
      };
      
      //
      ws.onmessage = function(event) { // socket.send() 후 ReplyEchoHandler가 handleTextMessage메소드로부터 메시지를 받아옴                                 
    	 var senderId = (event.data).split(',')[0];
    	 var mIdYou = (event.data).split(",")[1];
    	 var dmNo = (event.data).split(",")[4];
    	
    	
    	 if($('.main-conversation-box h3').text() == senderId){
            
             message_receive(event);
    	 }
    	
    	
    	 message_receive_noty(event);
        
        
        
         let socketAlert = $('a#socketAlert');
         socketAlert.text("메세지가 도착했습니다.");
         socketAlert.css('display', 'block');
         setTimeout(function() {
            socketAlert.css('display', 'none');
         },3000);	 
      };
   };
   } 
   */
   

