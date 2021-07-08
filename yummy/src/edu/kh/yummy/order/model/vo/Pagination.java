package edu.kh.yummy.order.model.vo;

public class Pagination {

	private int currentPage; // 목록상 현재 페이지
	private int listCount; // 게시글 전체 수

	private int limit = 10; // 한페이지에 보여질 게시글 수
	private int pageSize = 10; // 보여질 페이지 번호 개수

	private int maxPage; // 게시글 목록의 마지막 페이지 번호
	private int startPage; // 보여지는 페이지 번호 중 시작 번
	private int endPage; // 보여지는 페이지 번호 중 끝 번호

	private int prevPage; // 이전 페이지 번호 목록 중 끝 번호
	private int nextPage; // 다음 페이지 번호 목록 중 시작 번호

	private int listType; // 게시판 타입 번호
	private String listName;// 게시판 이름

	
	
	

	public Pagination(int currentPage, int listCount) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		
		makePagination();
	}



	public Pagination(int currentPage, int listCount, int listType, String listName) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.listType = listType;
		this.listName = listName;
		
		makePagination();
		
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



		public int getlistType() {
			return listType;
		}



		public void setlistType(int listType) {
			this.listType = listType;
		}



		public String getlistName() {
			return listName;
		}



		public void setlistName(String listName) {
			this.listName = listName;
		}



		@Override
		public String toString() {
			return "Pagination [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
					+ ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
					+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + ", listType=" + listType
					+ ", listName=" + listName + "]";
		}
		
		
		private void makePagination() {
			//maxPage == 마지막페이지 ==총페이지수 
			
			maxPage= (int)Math.ceil((double)listCount /limit );
			//(int)Math.ceil(500.0/10)
			
			//startPage == 페이지 번호 목록 시작 번호 
			// ex)1,11,21,31........
			startPage= (currentPage-1)/pageSize*pageSize + 1;
			//endPage == 페이지 번호 목록 끝 번호
			// ex)10,20,30,40;....
			endPage= startPage + pageSize -1;
			
			
			//** 보여지는 페이지 번호 목록의 끝 번호가 maxPage보다 클경우 
			//현재 페이지  : 52
			// 페이지 번호 목록 : 51 52 53 54 55 56 57 58 59 60
			// 끝 페이지 : 55
			if(endPage > maxPage) {
				endPage =maxPage;
			}
			// 이전, 다음 페이지 번호 목록으로 이동
			if(currentPage<10) prevPage=1;
			else				prevPage = (currentPage-1)/ pageSize*pageSize;
			
			nextPage= (currentPage + pageSize -1)/ pageSize * pageSize+1;
			//(16+9)/10*10+1 ==>>>21
			
			
			
			
			
			
			
		}
		
		
		
}
