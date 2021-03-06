<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div>
	<ul class="breadcrumb">
		<li>
			<a href="${ctx}/">Home</a> <span class="divider">/ trip / 行程清单</span>
		</li>
	</ul>
</div>
<c:if test="${not empty message}">
	<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
</c:if>

<div class="row-fluid sortable ui-sortable">	
	<div class="box span12">
		<div class="box-header well" data-original-title="">
			<form action="${ctx}/trip/tripitem" method="post">
			<h2>
				<span class="ajax-link btn btn-primary" action="${ctx}/trip/tripitem/create"><i class="icon-plus"></i> 行程清单</span>
				<span id="form_submit" class="btn btn-primary"><i class="icon-search"></i> Search</span>&nbsp;
			</h2>
			<input placeholder="创建开始时间" class="input-small datepicker" name="search_GT_created" value="${param.search_GT_created}" type="text">
			<input placeholder="创建结束时间" class="input-small datepicker" name="search_LT_created" value="${param.search_LT_created}" type="text">
			</form>
		</div>
		<div class="box-content">
		<table class="table table-bordered table-striped table-condensed">
			<thead>
				<tr role="row">
					<!-- 排序时为th增加sortColumn即可 -->
					<th sortColumn="trip" >行程</th>
					<th sortColumn="view_spot" >景点</th>
					<th sortColumn="sort" >sort</th>
					<th sortColumn="trip_date" >行程日期</th>
					<th sortColumn="type" >类型 1 景点 2 酒店 3 饭店</th>
					<th sortColumn="created" >created</th>
					<th sortColumn="modified" >modified</th>
					<th>操作</th>
				</tr>
			</thead>   
			<tbody>
			<c:forEach items="${page.content}" var="item" varStatus="status">
				<tr <c:if test="${status.index % 2 == 0}">class="even"</c:if>
					<c:if test="${status.index % 2 == 1}">class="odd"</c:if>>
					
					
					<td class="center">${item.trip}</td>
					<td class="center">${item.viewSpot}</td>
					<td class="center">${item.sort}</td>
					<td class="center"><fmt:formatDate value="${item.tripDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td class="center">${item.type}</td>
					<td class="center"><fmt:formatDate value="${item.created}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td class="center"><fmt:formatDate value="${item.modified}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td class="center ">
						<shiro:hasPermission name="tripitem:edit">
							<a class="btn btn-info ajax-link" style="padding: 0;"
								action="${ctx}/trip/tripitem/update/${item.id}" title="编辑">
								<i class="icon-edit icon-white"></i> </a>
							<a class="btn btn-danger ajax-link" style="padding: 0;"
								action="${ctx}/trip/tripitem/delete/${item.id}" title="删除">
								<i class="icon-trash icon-white"></i> </a>
						</shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
			</tbody>
	   </table>
	   <tags:pagination page="${page}" paginationSize="5" action="${ctx}/trip/tripitem" />
	</div>
	</div><!--/span-->
</div>

<!-- public common.js -->
<script src="${ctx}/static/js/charisma.js"></script>