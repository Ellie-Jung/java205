
package guest.domain;

import java.util.List;

public class MessageListView {

	private List<Message> messageList; 	// 게시물 Message 객체 3개
	private int messageTotalCount; 		// 전체 게시물의 개수
	private int currentPagenumber; 		// 현재 페이지 번호
	private int pageTotalCount; 		// 페이지의 개수
	private int messageCountPerpage; 	// 한 페이지에 표현할 메시지의 개수
	private int firstRow; 				// DB 게시물의 시작 위치
	private int endRow; 				// 마지막 위치

	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPagenumber,
			int messageCountPerpage, int firstRow, int endRow) {
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPagenumber = currentPagenumber;
		this.messageCountPerpage = messageCountPerpage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calpageTotalCount();
	}

	private void calpageTotalCount() {
		
		if(this.messageTotalCount == 0) {
			this.pageTotalCount = 0;
		} else {
			// 10 / 3 -> 3    10%3 >0 -> 3+1
			//전체게시물 갯수에서 한페이지당 갯수 나눠주기. // 전체 10개고 3개씩 처리할떄 10/3 -> 3, 10%3 >0 -> 3+1페이지필요
			this.pageTotalCount = this.messageTotalCount / this.messageCountPerpage;
			if(this.messageTotalCount % this.messageCountPerpage > 0) {
				this.pageTotalCount++;
			}
		}
	}

	 //변경되면 안되는 데이터 겟터만 세팅한다.
	public List<Message> getMessageList() {
		return messageList;
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPagenumber() {
		return currentPagenumber;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerpage() {
		return messageCountPerpage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	@Override
	public String toString() {
		return "MessageListView [messageList=" + messageList + ", messageTotalCount=" + messageTotalCount
				+ ", currentPagenumber=" + currentPagenumber + ", pageTotalCount=" + pageTotalCount
				+ ", messageCountPerpage=" + messageCountPerpage + ", firstRow=" + firstRow + ", endRow=" + endRow
				+ "]";
	}
	
	
	

}
