package edu.kh.yummy.notice.model.vo;

public class Pagination {
	
	private int currentPage;		// 목록상 현재 페이지
	private int listCount;			// 게시글 전체 수 
	
	private int limit = 7;				// 한 페이지에 보여질 게시글 수
	private int pageSize = 5;			// 보여질 페이지 번호 개수
	
	private int maxPage;				// 게시글 목록의 마지막 페이지 번호
	private int startPage;				// 보여지는 페이지 번호 중 시작 번호
	private int endPage;				// 보여지는 페이지 번호 중 끝 번호
	
	private int prevPage;				// 이전 페이지 번호 목록 중 끝 번호
	private int nextPage;				// 다음 페이지 번호 목록 중 시작 번호
	
	private String boardName;			// 게시판 이름

	public Pagination(int currentPage, int listCount) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;

		
		makePagination();
		// 매개변수생성자, 값있는 생성자 빼고 마지막 메소드로 만ㄴ들어서 다 들어가짐 여기에
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		
		makePagination();
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
		
		makePagination();
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
		
		makePagination();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
		makePagination();
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
				+ ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + ", boardName=" + boardName + "]";
	}
	
	// 페이징 처리에 필요한 값을 계산하는 메소드
	private void makePagination() {
		
		// maxPage -- 마지막페이지 == 총 페이지 수
		
		maxPage = (int)Math.ceil( (double)listCount / limit );
		// (int)Math.ceil ( 35 / 7 ) == 5
		// (int)Math.ceil ( 50 / 7 ) == 7.14 == 8
		
		// startPage == 페이지 번호 목록 시작 번호
		// ex) 1, 6, 11, 16, ....
		startPage = (currentPage - 1) / pageSize * pageSize + 1;
		// 현재 페이지 : 3
		// 1 2 [3] 4 5
		// (2) / 5 * 5 + 1 
		// 0 * 5 + 1 
		// 1 
		
		// endPage == 페이지 번호 목록 끝 번호
		// ex) 5, 10, 15, 20 ....
		endPage = startPage + pageSize - 1;
		// 1 + 5 - 1; == 5
		
		// ** 보여지는 페이지 번호 목록의 끝번호가 maxPage보다 클 경우
		// 현재 페이지 : 4
		// 페이지 번호 목록 : 1 2 3 4 5
		// 끝 페이지 : 5
		// 페이지 번호 목록 : 1 2 3 4
		if(endPage > maxPage) {
			endPage = maxPage;
			// 5 > 4 일 경우 endPage에 4를 대입 
		}
		
		// 이전, 다음 페이지 번호 목록으로 이동(그 페이지의 그룹?)
		if(currentPage < 7) prevPage = 1;
		else				prevPage = (currentPage - 1) / pageSize * pageSize;
		// (3 - 1) / 5 * 5 
		// 2 / 5 
		
		nextPage = (currentPage + pageSize - 1) / pageSize * pageSize + 1;
		
		if(nextPage > maxPage) {
			nextPage = maxPage;
		}
		
		
	}
	
	
	

}
