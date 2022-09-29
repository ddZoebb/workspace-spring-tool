

//DOM Tree 생성 후 connect WS 실행 

var socket=null;
var loginId=null;
var loginName=null;
var mImage=null;
var contextPath=getContextPath();

var jsonData={
	mId:null,
	yourId:null,
	contents:null,
	sendtime:null,
	c_room_no:null,
	chat_read:null
	
};

function getContextPath(){
   var lastIndexCount = location.href.lastIndexOf('/');
   var ctx = location.href.substr(0,lastIndexCount).replace('http', 'ws');
   return ctx;
}


$(document).ready(function(){
	
	//$('#content').html('$(document)ready 성공');
	
	
	console.log('$(document)ready 성공');
	
	$('#btnConnect').click(function(){
		console.log('연결 버튼 클릭');
		connectWS();
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
}

//메세지 전송시 작동 
function message_send_function(target){
	$('#btnSend').on('click',function(e){
		e.preventDefault();
		//제이슨데이터 만들기 
		// 임시 데이터 test
		jsonData.mId="carrot3";
		jsonData.yourId="carrot2";
		jsonData.contents="다시 연락드립니다!!";
		jsonData.sendtime=null;
		jsonData.c_room_no="3";
		jsonData.chat_read="0";
		if(jsonData.contents!=null && jsonData.contents!="" && jsonData.contents!='&nbsp'){
			socket.send(JSON.stringify); //소켓 전송 
			$('#msg').val("");
			// 메세지 저장 & 다시 받기 
			message_sendDB(jsonData);
		}
	
	});
}

	function message_sendDB(jsonData){
				$.ajax({
				url:'chat_message',
    			data: JSON.stringify(jsonData), //전송 데이터
    			type: "POST", //전송 타입
    			async: true, //비동기 여부
    			timeout: 5000, //타임 아웃 설정
    			dataType: "JSON", //응답받을 데이터 타입 (XML,JSON,TEXT,HTML,JSONP)    			
    			contentType: "application/json; charset=utf-8", //헤더의 Content-Type을 설정
    			    			
    			// [응답 확인 부분 - json 데이터를 받습니다] -보낸 클라이언트가 자기한테 받는 거 (?)
    			success: function(response) {
    				console.log("");
    				console.log(" 내가 보낸 것 [requestPostBodyJson] : [response] : " + JSON.stringify(response));    				
    				console.log("");    				
    			}
    			});
			}


*/
	

function connectWS(){
	var loginId="carrot1";
	var url="ws://localhost:80/spring_web_application_boot_template/replyEcho?mId="+loginId;
	var ws=new WebSocket(url);
	socket=ws;
	
	ws.onopen = function(evt) {
			console.log('서버 연결 성공');
		
	    };
	ws.onerror=function(evt){
		console.log('에러');
	}
	
	ws.onmessage=function(evt){
		console.log('메세지 얻기');
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
   

