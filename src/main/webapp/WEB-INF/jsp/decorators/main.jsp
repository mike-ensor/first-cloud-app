<%@include file="/WEB-INF/jsp/common/page-includes.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title><decorator:title default="Default Title" /></title>
        <meta name="abstract" content="main"/>
        <link href="${pageContext.request.contextPath}/site/styles/base.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/site/styles/blueprint/screen.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="${pageContext.request.contextPath}/site/styles/blueprint/plugins/link-icons/screen.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="${pageContext.request.contextPath}/site/styles/blueprint/plugins/buttons/screen.css" rel="stylesheet" type="text/css" media="screen" />
        <decorator:head/>
    </head>
    <body class="container">
        <div id="header"><h1>Header Goes Here</h1></div>
        <div id="content-body">
            <decorator:body/>
        </div>
        <div id="footer">&copy;2011 | <a href="http://www.dynacrongroup.com" target="_blank">Dynacron Group</a> | <a href="http://www.ensor.cc" target="_blank">Cool Blog</a></div>
    </body>
</html>