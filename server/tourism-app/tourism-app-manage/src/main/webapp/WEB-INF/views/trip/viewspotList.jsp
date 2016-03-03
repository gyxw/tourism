<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div>
	<ul class="breadcrumb">
		<li>
			<a href="${ctx}/">Home</a> <span class="divider">/ trip / 旅游景点</span>
		</li>
	</ul>
</div>
<c:if test="${not empty message}">
	<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
</c:if>

<div class="row-fluid sortable ui-sortable">	
	<div class="box span12">
		<div class="box-header well" data-original-title="">
			<form action="${ctx}/trip/viewspot" method="post">
			<h2>
				<span class="ajax-link btn btn-primary" action="${ctx}/trip/viewspot/create"><i class="icon-plus"></i> 旅游景点</span>
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
					<th sortColumn="name" >景点名</th>
					<th sortColumn="picture" >picture</th>
					<th sortColumn="area" >area</th>
					<th sortColumn="title" >title</th>
					<th sortColumn="description" >description</th>
					<th sortColumn="parent" >parent</th>
					<th sortColumn="clicked" >点击数（热度）</th>
					<th sortColumn="star" >星级（名气）</th>
					<th sortColumn="longitude" >经度</th>
					<th sortColumn="latitude" >纬度</th>
					<th sortColumn="created" >created</th>
					<th sortColumn="modified" >modified</th>
					<th sortColumn="visit_start_time" >可参观开始时间</th>
					<th sortColumn="visit_end_time" >可参观截止时间</th>
					<th>操作</th>
				</tr>
			</thead>   
			<tbody>
			<c:forEach items="${page.content}" var="item" varStatus="status">
				<tr <c:if test="${status.index % 2 == 0}">class="even"</c:if>
					<c:if test="${status.index % 2 == 1}">class="odd"</c:if>>
					
					
					<td class="center">${item.name}</td>
					<td class="center">${item.picture}</td>
					<td class="center">${item.area}</td>
					<td class="center">${item.title}</td>
					<td class="center">${item.description}</td>
					<td class="center">${item.parent}</td>
					<td class="center">${item.clicked}</td>
					<td class="center">${item.star}</td>
					<td class="center">${item.longitude}</td>
					<td class="center">${item.latitude}</td>
					<td class="center"><fmt:formatDate value="${item.created}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td class="center"><fmt:formatDate value="${item.modified}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td class="center"><fmt:formatDate value="${item.visitStartTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td class="center"><fmt:formatDate value="${item.visitEndTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td class="center ">
						<shiro:hasPermission name="viewspot:edit">
							<a class="btn btn-info ajax-link" style="padding: 0;"
								action="${ctx}/trip/viewspot/update/${item.id}" title="编辑">
								<i class="icon-edit icon-white"></i> </a>
							<a class="btn btn-danger ajax-link" style="padding: 0;"
								action="${ctx}/trip/viewspot/delete/${item.id}" title="删除">
								<i class="icon-trash icon-white"></i> </a>
						</shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
			</tbody>
	   </table>
	   <tags:pagination page="${page}" paginationSize="5" action="${ctx}/trip/viewspot" />
	</div>
	</div><!--/span-->
</div>

<!-- public common.js -->
<script src="${ctx}/static/js/charisma.js"></script>