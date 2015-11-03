<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="page" type="org.springframework.data.domain.Page" required="true"%>
<%@ attribute name="paginationSize" type="java.lang.Integer" required="true"%>
<%@ attribute name="action" type="java.lang.String" required="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
if(page == null)
	return;
int current =  page.getNumber() + 1;
int pageSize = page.getSize();
int begin = Math.max(1, current - paginationSize/2);
int end = Math.min(begin + (paginationSize - 1), page.getTotalPages());

request.setAttribute("current", current);
request.setAttribute("begin", begin);
request.setAttribute("end", end);
request.setAttribute("pageSize", pageSize);
%>

<div id="page" class="pagination pagination-centered">
	<div id="DataTables_Table_0_length" class="dataTables_length span3">
		<label>
			<select size="1" id="page_select">
			</select> 
		</label>records per page
	</div>
	<ul class="span9">
		 <% if (page.hasPreviousPage()){%>
               	<li><a href="javascript:pageTo(1)">&lt;&lt;</a></li>
                <li><a href="javascript:pageTo(${current-1})">&lt;</a></li>
         <%}else{%>
                <li class="disabled"><a href="#nogo">&lt;&lt;</a></li>
                <li class="disabled"><a href="#nogo">&lt;</a></li>
         <%} %>
 
		<c:forEach var="i" begin="${begin}" end="${end}">
            <c:choose>
                <c:when test="${i == current}">
                    <li class="active"><a href="#nogo">${i}</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="javascript:pageTo(${i})">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
	  
	  	 <% if (page.hasNextPage()){%>
               	<li><a href="javascript:pageTo(${current+1})">&gt;</a></li>
                <li><a href="javascript:pageTo(${page.totalPages})">&gt;&gt;</a></li>
         <%}else{%>
                <li class="disabled"><a href="#nogo">&gt;</a></li>
                <li class="disabled"><a href="#nogo">&gt;&gt;</a></li>
         <%} %>
	</ul>
</div>

<script>
var pages = [10, 20, 50, 100];
var pageSize = '${pageSize}';
var page = '${current}';
var pageSizeName = 'page.size';
var pageName = 'page';

var $form = $('#content').find('form');
console.log('pagination form action: ' + $form.attr('action'));
var $page = $form.children('#' + pageName);
var $pageSize = $form.children('#' + pageSizeName);
function pageTo(p) {
	$page.val(p);
	$('#form_submit').click();
}
function checkDom() {
	if(!$form[0]) {
		//   用法错了么  必须有form提交的才可以 ?
		console.log('必须有form 表单 才可以嵌套pagination.tag');
		return false;
	}
	
	if(!$page[0]) {
		$page = $('<input type="hidden" id="' + pageName + '" name="' + pageName + '" value="' + page + '">');
		$form.append($page);
	}
	
	if(!$pageSize[0]) {
		$pageSize = $('<input type="hidden" id="' + pageSizeName + '" name="' + pageSizeName + '" value="' + pageSize + '">');
		$form.append($pageSize);
	}
	return true;
}

function init() {
	if(!checkDom()) return;
	
	for(var i in pages) {
		var cp = pages[i];
		var $item = $('<option value="' + cp + '" ' + (cp == pageSize ? 'selected="selected"' : '') + '>' + cp + '</option>');
		$('#page_select').append($item);
	}
	$('#page_select').change(function() {
		var selectedPageSize = $(this).children('option:selected').val();
		$pageSize.val(selectedPageSize);
		$('#form_submit').click();
	})
}

$(function() {
	init();
})
</script>
