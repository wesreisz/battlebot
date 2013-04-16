<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Weapons</title>
	<link rel="stylesheet" type="text/css" href="/battlebot-web/resources/styles/style.css" media="screen" />
</head>
<body>
	<article id="divPage">
		<section id="divHeader">
			<jsp:include page="/partials/header.jsp"></jsp:include>
		</section>	
		<section id="divContent">
			<aside id="divNav"><jsp:include page="/partials/nav.jsp"></jsp:include></aside>
			<h3>Weapons</h3>
			
			<form:form method="post" action="/battlebot-web/weapons/addWeapon">
				 <table>
				    <tr>
				        <td><form:label path="weaponName">Weapon Name:</form:label></td>
				        <td><form:input path="weaponName" /></td> 
				    </tr>
				    <tr>
				        <td><form:label path="weaponDescription">Weapon Description:</form:label></td>
				        <td><form:input path="weaponDescription" /></td> 
				    </tr>
				    <tr>
				        <td><form:label path="weaponTypes">Weapon Type:</form:label></td>
				        <td><form:select path="weaponTypes" items="${weaponTypes}" multiple="false"/></td> 
				    </tr>
				     <tr>
				        <td><form:label path="weaponTypes">Weapon Effects:</form:label></td>
				        <td><form:select path="weaponEffects" items="${weaponEffects}" multiple="true"/></td>
				    </tr>
				    <tr>
				        <td colspan="2">
				            <input type="submit" value="Add Weapon"/>
				        </td>
				    </tr>
				 </table>
			</form:form>
			
		</section>	
		<section id="divFooter">
			<jsp:include page="/partials/footer.jsp"></jsp:include>
		</section>
	</article>		
</body>
</html>
