<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.AttributeConst"%>

<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" />
            <br />
        </c:forEach>




    </div>
</c:if>
<fmt:parseDate value="${report.reportDate}" pattern="yyyy-MM-dd"
    var="reportDay" type="date" />
<label for="${AttributeConst.REP_DATE.getValue()}">日付</label>
<br />
<input type="date" name="${AttributeConst.REP_DATE.getValue()}"
    id="${AttributeConst.REP_DATE.getValue()}"
    value="<fmt:formatDate value='${reportDay}' pattern='yyyy-MM-dd' />" />
<br />
<br />

<label>氏名</label>
<br />
<c:out value="${sessionScope.login_employee.name}" />
<br />
<br />

<label for="${AttributeConst.REP_TITLE.getValue()}">タイトル</label>
<br />
<input type="text" name="${AttributeConst.REP_TITLE.getValue()}"
    id="${AttributeConst.REP_TITLE.getValue()}" value="${report.title}" />
<br />
<br />


<fmt:parseDate value="${report.attendanceAtwork}"
    pattern="yyyy-MM-dd'T'HH:mm" var="attendanceAtworkDay" type="date" />
<label for="${AttributeConst.REP_ATTENDANCEATWORK.getValue()}">出勤</label>
<br />

<input type="datetime-local"
    name="${AttributeConst.REP_ATTENDANCEATWORK.getValue()}"
    id="${AttributeConst.REP_ATTENDANCEATWORK.getValue()}"
    value="<fmt:formatDate value="${attendanceAtworkDay}"
                            pattern="yyyy-MM-dd HH:mm" />" />
<br />
<br />


<fmt:parseDate value="${report.leavingWork}"
    pattern="yyyy-MM-dd'T'HH:mm" var="leavingWorkDay" type="date" />

<label for="${AttributeConst.REP_LEAVINGWORK.getValue()}">退勤</label>
<br />
<input type="datetime-local"
    name="${AttributeConst.REP_LEAVINGWORK.getValue()}"
    id="${AttributeConst.REP_LEAVINGWORK.getValue()}"
    value="<fmt:formatDate value="${leavingWorkDay}"
                            pattern="yyyy-MM-dd HH:mm" />" />
<br />
<br />


<label for="${AttributeConst.REP_CONTENT.getValue()}">内容</label>
<br />
<textarea name="${AttributeConst.REP_CONTENT.getValue()}"
    id="${AttributeConst.REP_CONTENT.getValue()}" rows="10" cols="50">${report.content}</textarea>
<br />
<br />
<input type="hidden" name="${AttributeConst.REP_ID.getValue()}"
    value="${report.id}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}"
    value="${_token}" />
<button type="submit">投稿</button>