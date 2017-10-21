<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="id" required="true"%>
<%@ attribute name="dateFormat" required="true"%>
<script type="text/javascript" src="./js/lib/jquery-1.12.1.js"></script>
<script type="text/javascript" src="./js/lib/jquery-ui.js"></script>
<link type="text/css" rel="stylesheet" href="./css/jquery-ui.css" />
<script>
jQuery(function($) {
    $("#${id}").datepicker({ dateFormat: "${dateFormat}" });
});
</script>
<input type="text" id="${id}" name="${name}" />