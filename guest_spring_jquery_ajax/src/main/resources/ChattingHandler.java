import org.springframework.web.socket.handler.TextWebSocketHandler;

@Log4j
public class ChattingHandler extends TextWebSocketHandler{
private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		log.info("#ChattingHandler, afterConnectionEstablished");
		sessionList.add(session);
		
		log.info(session.getPrincipal().getName() + "님이 입장하셨습니다.");
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		log.info("#ChattingHandler, handleMessage");
		log.info(session.getId() + ": " + message);
		
		for(WebSocketSession s : sessionList) {
			s.sendMessage(new TextMessage(session.getPrincipal().getName() + ":" + message.getPayload()));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		log.info("#ChattingHandler, afterConnectionClosed");

		sessionList.remove(session);
		
		log.info(session.getPrincipal().getName() + "님이 퇴장하셨습니다.");
	}
}
