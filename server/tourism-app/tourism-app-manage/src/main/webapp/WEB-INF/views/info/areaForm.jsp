<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div>
	<ul class="breadcrumb">
		<li>
			<a href="${ctx}/">Home</a> <span class="divider">/ info / Area</span>
		</li>
	</ul>
</div>

<div class="row-fluid">
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-edit"></i> Form Elements</h2>
		</div>
		<div class="box-content">
			<form action="${ctx}/info/area/update" modelAttribute="area" method="post" class="form-horizontal">
				<fieldset>					
					<input type="hidden" id="id" name="id" value="${area.id}"/>

					<div class="control-group">
						<label class="control-label" for="name">name</label>
						<div class="controls">
							<input class="input-large required" id="name" name="name" type="text" value="${area.name}">
							<span class="help-inline"><form:errors path="name"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="fullName">fullName</label>
						<div class="controls">
							<input class="input-large required" id="fullName" name="fullName" type="text" value="${area.fullName}">
							<span class="help-inline"><form:errors path="fullName"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="sort">排序 越大优先级越高</label>
						<div class="controls">
							<input class="input-large" id="sort" name="sort" type="text" value="${area.sort}">
							<span class="help-inline"><form:errors path="sort"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="parent">parent</label>
						<div class="controls">
							<input class="input-large" id="parent" name="parent" type="text" value="${area.parent}">
							<span class="help-inline"><form:errors path="parent"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="treePath">树路径                                     1(,)                           2(,1,)         3(,1,)                    4(,1,2,)                   5(,1,3,)</label>
						<div class="controls">
							<input class="input-large" id="treePath" name="treePath" type="text" value="${area.treePath}">
							<span class="help-inline"><form:errors path="treePath"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="created">created</label>
						<div class="controls">
							<input class="input-large datepicker " id="created" name="created" readonly="readonly"
								type="text" value="<fmt:formatDate value='${area.created}' pattern='yyyy-MM-dd HH:mm:ss'/>">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="modified">modified</label>
						<div class="controls">
							<input class="input-large datepicker " id="modified" name="modified" readonly="readonly"
								type="text" value="<fmt:formatDate value='${area.modified}' pattern='yyyy-MM-dd HH:mm:ss'/>">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="description">关于旅游城市的描述</label>
						<div class="controls">
							<input class="input-large" id="description" name="description" type="text" value="${area.description}">
							<span class="help-inline"><form:errors path="description"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="star">星级， 达到固定星级的应该在默认选择页面上 出现热门城市</label>
						<div class="controls">
							<input class="input-large" id="star" name="star" type="text" value="${area.star}">
							<span class="help-inline"><form:errors path="star"/></span>
						</div>
					</div>
					<div class="form-actions">
						<span id="form_submit" class="btn btn-primary">Save changes</span>
						<input type="reset" class="btn" value="Reset" />
					</div>
				</fieldset>
			</form>   
		</div>
	</div><!--/span-->

</div><!--/row-->

<!-- public common.js -->
<script src="${ctx}/static/js/charisma.js"></script>
