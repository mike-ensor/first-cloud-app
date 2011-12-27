<%@include file="/WEB-INF/jsp/common/page-includes.jspf" %>
<html>
    <head>
        <title><spring:message code="home.browser.title"/></title>
        <%@include file="/WEB-INF/jsp/common/common-head-elements.jspf" %>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty article.articles}">
                <c:forEach items="${article.articles}" var="article" varStatus="i">
                    <c:if test="${i.first}"><h3>Subject:</h3><ul></c:if>

                    <li>${article.subject} Date:${article.entryDate}, from ${article.fromSource}</li>

                    <c:if test="${i.last}"></ul></c:if>
                </c:forEach>
            </c:when>
        </c:choose>

        <h3>New Blog Article</h3>
        <form:form modelAttribute="article" method="post">
            <form:hidden path="type" value="blog"/>
            <fieldset>
                <p>
                    <form:errors path="subject" element="div" cssClass="error"/>
                    <form:label path="subject">Subject:</form:label>
                    <form:input path="subject" cssErrorClass="fieldError"/>
                </p>

                <p>
                    <form:errors path="fromSource" element="div" cssClass="error"/>
                    <form:label path="fromSource">From (source):</form:label>
                    <form:input path="fromSource" cssErrorClass="fieldError"/>
                </p>

            </fieldset>
            <p>
                <button type="submit" class="button positive">
                    <img src="${pageContext.request.contextPath}/site/styles/blueprint/plugins/buttons/icons/tick.png" alt=""/> Submit
                </button>

                <button type="reset" class="button negative">
                    <img src="${pageContext.request.contextPath}/site/styles/blueprint/plugins/buttons/icons/cross.png" alt=""/> Reset
                </button>

                <br class="clear"/>
            </p>
        </form:form>


    </body>
</html>