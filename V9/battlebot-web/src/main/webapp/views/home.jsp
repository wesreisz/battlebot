<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="/battlebot-web/resources/styles/style.css" media="screen" />
</head>
<body>
	<article id="divPage">
		<section id="divHeader">
			<jsp:include page="/partials/header.jsp"></jsp:include>
		</section>	
		<section id="divContent">
			<aside id="divNav"><jsp:include page="/partials/nav.jsp"></jsp:include></aside>
			Content goes here...
			
		</section>	
		<section id="divFooter">
			<jsp:include page="/partials/footer.jsp"></jsp:include>
		</section>
	</article>		
</body>
</html>
