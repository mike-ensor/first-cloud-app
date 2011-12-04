<%@include file="/WEB-INF/jsp/common/page-includes.jspf" %>
<html>
    <head>
        <title><spring:message code="home.browser.title"/></title>
        <%@include file="/WEB-INF/jsp/common/common-head-elements.jspf" %>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty users}">
                <c:forEach items="${users}" var="user" varStatus="i">
                    <c:if test="${i.first}"><h3>Existing Users:</h3><ul></c:if>

                    <li>${user.firstName} ${user.lastName} (${user.email})</li>

                    <c:if test="${i.last}"></ul></c:if>
                </c:forEach>
            </c:when>
        </c:choose>

        <h3>New User</h3>
        <form:form modelAttribute="model" method="post">
            <fieldset>
                <p>
                    <form:errors path="email" element="div" cssClass="error"/>
                    <form:label path="email">Email Address:</form:label>
                    <form:input path="email" cssErrorClass="fieldError"/>
                </p>

                <p>
                    <form:errors path="firstName" element="div" cssClass="error"/>
                    <form:label path="firstName">First Name:</form:label>
                    <form:input path="firstName" cssErrorClass="fieldError"/>
                </p>

                <p>
                    <form:errors path="lastName" element="div" cssClass="error"/>
                    <form:label path="lastName">Last Name:</form:label>
                    <form:input path="lastName" cssErrorClass="fieldError"/>
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