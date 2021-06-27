<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
<link rel="stylesheet" href="${contextPath}/resources/css/notice/noticeDetail.css" type="text/css"/>
</head>
<body>
   <!-- header.jsp 동적 include -->
   <jsp:include page="../common/header.jsp"/>
   
   <!-- search.jsp 동적 include -->
   <jsp:include page="../common/search.jsp"/>
   
     <div class="container">
        <div class="content">

          <div class="sub-top">
            <h3 id="page-title"> 공지사항</h3>
            <br>
            <hr>
          </div>

          <table class="table table-bordered" id="notice-detail">
            <tbody>
              <tr>
                <th scope="col">제목</th>
                <td colspan="5">6월 정기 서비스 점검으로 인한 사용 제한 안내</td>
              </tr>
              <tr>
                <th scope="col">작성일</th>
                <td colspan="5">2021-06-03</td>
              </tr>
              <tr>
                <th scope="col">내용</th>
                <td colspan="5">
                  <div class="textarea-area">
                    <p>안녕하세요. 야미입니다.</p>
                    <p>항상 저희 야미를 이용해주시는 고객 여러분께 깊이 감사 드립니다.</p>
                    <p>더 나은 서비스 제공을 위해 정기 서비스 점검을 시행할 예정입니다.</p>
                    <p>아래와 같이 서비스 사용이 일시 중단되오니 서비스 이용에 참고하시기 바랍니다.</p>
                    <p>※ 작업 일시 : 2021년 6월 4일(금) 새벽 2:00 ~ 4:00 (약 2시간)</p>
                    <p>※ 작업 영향 : 주문하기 서비스 중단</p>
                    <p>※ 작업 일시 : 점검 소요 시간은 작업 상황에 따라 변경될 수 있습니다.</p>
                    <p>더 좋은 서비스를 제공하기 위해 항상 노력하겠으며, 고객님의 양해 부탁드립니다.</p>

                  </div>
                </td>
              </tr>
            </tbody>
          </table>
          <div class="previous">
            <button type="submit" class="btn btn-light" id="pre-btn" onclick="history.back()">이전으로</button>
          </div>
          
        </div>
  </div>
  
  	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>