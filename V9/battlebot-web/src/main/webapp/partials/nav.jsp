<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
  <c:when test="${selectedTab eq 'MAIN'}">
    <strong>Home</strong> &nbsp;|&nbsp;
    <a href="/battlebot-web/weapons">Weapons</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/armor">Armor</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/player">Players</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/battle">Battle</a>
  </c:when>
  <c:when test="${selectedTab eq 'WEAPONS'}">
    <a href="/battlebot-web/">Home</a> &nbsp;|&nbsp;
	<strong>Weapon</strong> &nbsp;|&nbsp;
	<a href="/battlebot-web/armor">Armor</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/player">Players</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/battle">Battle</a>
  </c:when>
  <c:when test="${selectedTab eq 'ARMOR'}">
    <a href="/battlebot-web/">Home</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/weapons">Weapons</a> &nbsp;|&nbsp;
	<strong>Armor</strong> &nbsp;|&nbsp;
	<a href="/battlebot-web/player">Players</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/battle">Battle</a>
  </c:when>
  <c:when test="${selectedTab eq 'PLAYERS'}">
    <a href="/battlebot-web/">Home</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/weapons">Weapons</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/armor">Armor</a> &nbsp;|&nbsp;
	<strong>Players</strong> &nbsp;|&nbsp;
	<a href="/battlebot-web/battle">Battle</a>
  </c:when>
  <c:when test="${selectedTab eq 'BATTLE'}">
    <a href="/battlebot-web/">Home</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/weapons">Weapons</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/armor">Armor</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/player">Players</a> &nbsp;|&nbsp;
	<strong>Battle</strong> &nbsp;|&nbsp;
  </c:when>
  <c:otherwise>
    <strong>Home</strong> &nbsp;|&nbsp;
    <a href="/battlebot-web/weapons">Weapons</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/armor">Armor</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/player">Players</a> &nbsp;|&nbsp;
	<a href="/battlebot-web/battle">Battle</a>
  </c:otherwise>
</c:choose>
<br /><br />
