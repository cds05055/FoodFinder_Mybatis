<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>공지사항</title>
        <link rel="stylesheet" href="/resources/css/notice/notice.css">
        <link rel="stylesheet" href="/resources/css/reset/reset.css">
    </head>
    <body>
        <div id="container">
            <header>
                <div id="logo-box">
                    <a href="/index.jsp">
                        <img src="/resources/images/mainPage/main_logo.png" alt="메인 로고" id="hd-main-logo">
                    </a>
                </div>
                <div id="search">
                    <div id="search-box">
                        <img src="/resources/images/userIcon/search-icon.png" alt="검색 아이콘" id="search-icon">
                        <input type="text" id="input-search">
                    </div>
                </div>
                <div id="id-category">
                        <div id="food-category" class="category"><a href="#">식사</a></div>
                        <div id="dessert-category" class="category"><a href="#">디저트</a></div>
                        <div id="more-category" class="category">더보기
                            <div id="more-list">
                                <ul id="more-menu">
                                    <li>공지사항</li>
                                    <li>이벤트</li>
                                    <li>1:1문의</li>
                                </ul>
                            </div>
                        </div>
                </div>
                <div id="user-login">
                        <div id="user-info-box">
                            <div id="user-profile">
                                <img src="/resources/images/userIcon/circle-user.png" alt="유저 프로필 이미지" width="80px" height="80px">
                            </div>
                            <div id="user-nick-logout">
                                <div id="user-info">
                                    <a href="/user/edit.do">${sessionScope.userNickname} 님</a>
                                </div>
                                <div id="logout">
                                    <a href="/user/logout.do">
                                        로그아웃 >
                                    </a>
                                </div>
                            </div>
                            <div id="user-alarm">
                                <a href="#">
                                    <img src="/resources/images/userIcon/bell-ring.png" alt="알람" width="80px" height="80px">
                                </a>
                            </div>
                        </div>
                </div>
            </header>

            <main>
                <div id="user-info-menu">
                    <div id="info-menu">
                        <div id="profile-img-box">
                            <div id="profile-img">
                                <img src="/resources/images/userIcon/circle-user.png" alt="프로필 사진" width="100px" height="100px">
                            </div>
                            <div id="info-edit">
                                <p>${sessionScope.userNickname} 님, 안녕하세요.</p>
                                <a href="/user/info.do">
                                    <div id="info-edit-btn">
                                        회원 정보 수정
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div id="line"></div>
                        <div id="user-edit-list">
                            <ul>
                                <li><a href="/user/like.do">나의 관심점포</a></li>
                                <li><a href="/user/edit.do">내 리뷰 관리</a></li>
                                <li><a href="#">공지사항</a></li>
                                <li><a href="/user/changOption.do?userId=${sessionScope.userId }">환경설정</a></li>
                                <li><a href="#">고객센터</a></li>
                                <li><a href="#">신고</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div id="user-info-edit-box">
                    <div id="user-shop">
                        <table>
			<colgroup>
				<col width="10%">
				<col width="35%">
				<col width="10%">
				<col width="25%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="notice" items="${requestScope.nList }">
					<tr>
						<th>${notice.noticeNo }</th>
						<th><a href="/notice/detail.do?noticeNo=${notice.noticeNo }">${notice.noticeSubject }</a></th>
						<th>${notice.noticeWriter }</th>
						<th>${notice.noticeDate }</th>
						<th>${notice.viewCount }</th>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="center">
						${pageNavi }
<!-- 						<a href="#">1</a> -->
<!-- 						<a href="#">2</a> -->
<!-- 						<a href="#">3</a> -->
<!-- 						<a href="#">4</a> -->
<!-- 						<a href="#">5</a> -->
					</td>
				</tr>
			</tbody>
		</table>
                    </div>
                </div>
            </main>

            <footer>
                <div id="footer-nav">
                    <ul id="footer-nav-info">
                        <li><a href="#">회사소개</a></li>
                        <li><a href="#">인재채용</a></li>
                        <li><a href="#">이용약관</a></li>
                        <li><a href="#">고객센터</a></li>
                        <li><a href="#">개인정보처리방침</a></li>
                        <li><a href="#">위치기반서비스이용약관</a></li>
                        <li><a href="#">제휴문의</a></li>
                    </ul>
                </div>
            </footer>
        </div>
        <script src="/resources/js/main/mainPage.js"></script>
    </body>
</html>