<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 전체보기</title>
<link rel="stylesheet" href="${contextPath}/resources/css/notice/noticeAll.css" type="text/css"/>
</head>
<body>
   <!-- header.jsp 동적 include -->
   <jsp:include page="../common/header.jsp"/>
   
   <!-- search.jsp 동적 include -->
   <jsp:include page="../common/search.jsp"/>
         <div class="container">
        <div class="content">
          <div class="sub-top">
            <h3 id="page-title">공지사항</h3>
            <hr>
          </div>

        <table class="table" id="tbl-box">
          <thead>
            <tr>
              <th class="col-2 tb-num">글번호</th>
              <th class="col-7 tb-title">제목</th>
              <th class="col-3 tb-date">작성일</th>
            </tr>
          </thead>

          <tbody>
            <tr>
              <th class="tb-num">1</th>
              <td><a class="notice-title" href="${contextPath}/notice/NoticeDetail">야미 이용약관 일부 변경 공지</a></td>
              <td class="tb-date">2021-05-27</td>
            </tr>
            <tr>
              <th class="tb-num">2</th>
              <td>개인정보처리방침 일부 변경 안내</td>
              <td class="tb-date">2021-05-14</td>
            </tr>
            <tr>
              <th class="tb-num">3</th>
              <td>야미 서비스 점검 안내 (4/30)</td>
              <td class="tb-date">2021-04-28</td>
            </tr>
            <tr>
              <th class="tb-num">4</th>
              <td>야미 위치기반서비스 이용약관 개정 안내</td>
              <td class="tb-date">2021-04-03</td>
            </tr>
            <tr>
              <th class="tb-num">5</th>
              <td>최대 60% 타임 할인을 잡아라!</td>
              <td class="tb-date">2021-03-25</td>
            </tr>
            <tr>
              <th class="tb-num">6</th>
              <td>이물 신고 방법 안내</td>
              <td class="tb-date">2021-03-20</td>
            </tr>
            <tr>
              <th class="tb-num">7</th>
              <td>야미 이용약관 일부 변경 안내</td>
              <td class="tb-date">2021-03-09</td>
            </tr>
          </tbody>

        </table>
          <div class="content-btn">
            <button class="btn" id="btn-register"><a href="${contextPath}/notice/NoticeRegister">작성하기</a></button>
          </div>
        
        <div class="paging-area">
          <nav class="paging">
            <ul class="pagination">
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                  <span aria-hidden="true">&lt;</span>
                </a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                  <span aria-hidden="true">&gt;</span>
                </a>
              </li>
            </ul>
          </nav>
       </div>


        </div>


      </div>
   
   
   <jsp:include page="../common/footer.jsp"/>

</body>
</html>