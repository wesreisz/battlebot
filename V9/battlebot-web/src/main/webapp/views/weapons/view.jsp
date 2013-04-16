<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			
			<a href="/battlebot-web/weapons/add">Add</a>
			<table>
				<tr>
					<th>WeaponID</th>
					<th>Weapon Name</th>
					<th>Last Modified Date</th>
				<tr>
				
				<c:forEach items="${weaponsList}" var="weapon">
				<tr>
					<td>${weapon.weaponId}</td> 
					<td>${weapon.name}</td> 
					<td>${weapon.lastModifiedDate}</td>
					<td>
						[<em><a href="/battlebot-web/weapons/edit?id=${weapon.weaponId}">Edit</a></em>] &nbsp;
						[<em><a href="/battlebot-web/weapons/del?id=${weapon.weaponId}">Del</a></em>]
					</td>
				</tr>	
				</c:forEach>
				
			</table>
			
		</section>	
		<section id="divFooter">
			<jsp:include page="/partials/footer.jsp"></jsp:include>
		</section>
	</article>		
</body>
</html>
