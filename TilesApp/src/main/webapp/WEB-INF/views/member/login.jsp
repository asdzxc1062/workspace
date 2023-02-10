<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>현재 페이지는 loginForm.do의 결과 login.jsp 입니다.</h3>

<script>
	let msg = '${result }';
	if(msg != '') alert(msg)
	
</script>

<form action="login.do" method="post">
  <table class="table">
    <tr>
      <th>ID</th><td><input type="text" name="mid"></td>
    </tr>
    <tr>
      <th>Pass</th><td><input type="password" name="mpw"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="로그인">
        <input type="reset" value="취소">
      </td>
    </tr>
  </table>
</form>    
