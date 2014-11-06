<!DOCTYPE html>
<html lang="en" ng-app="app" id="ng-app" ng-controller="AppCtrl">

<% String root = request.getContextPath() + "/app"; %>
<% boolean devMode = System.getProperty("devMode") != null && System.getProperty("devMode").equals("Y"); %>

<head>
    <link rel="stylesheet" type="text/css" href="<%=root%>/vendor/foundation/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="<%=root%>/vendor/foundation/css/foundation.css" />

    <% if (!devMode) { %>
    <link rel="stylesheet" type="text/css" href="<%=root%>/styles/app.css"/>
    <% } else { %>
    <!--[if lte IE 8]>
    <link rel="stylesheet" type="text/css" href="<%=root%>/styles/app.css"/>
    <![endif]-->
    <!--[if gte IE 9]><!-->
    <link rel="stylesheet/less" type="text/css" href="<%=root%>/styles/app.less"/>
    <script src="<%=root%>/vendor/less/dist/less-1.7.5.min.js"></script>
    <!--<![endif]-->
    <% } %>

    <script src="<%=root%>/vendor/jquery/dist/jquery.min.js"></script>
    <script src="<%=root%>/vendor/angular/angular.min.js"></script>
    <script src="<%=root%>/vendor/angular-route/angular-route.min.js"></script>
    <script src="<%=root%>/vendor/angular-foundation/mm-foundation-tpls.min.js"></script>

    <% if (!devMode) { %>
        <script src="<%=root%>/release.js"></script>
    <% } else { %>
        <%@ include file="./scripts.jsp" %>
        <%= getFiles("/app/scripts", "app.js", null, request) %>
        <%= getFiles("/app/scripts", ".js", "app.js", request) %>
    <% }%>

    <title>{{getPageTitle()}}</title>
</head>

<body>
<div class="row">
    <header ng-include="'<%=root%>/scripts/header.tpl.html'" class="large-12 medium-12 columns"></header>

    <div class="main-content large-12 medium-12 columns">
        <div ng-view></div>
    </div>

    <footer ng-include="'<%=root%>/scripts/footer.tpl.html'"></footer>
</div>
</body>
</html>
