<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div>
	<ul class="breadcrumb">
		<li>
			<a href="${ctx}/">Home</a> <span class="divider">/ trip / 行程</span>
		</li>
	</ul>
</div>

<div class="row-fluid">
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-edit"></i> Form Elements</h2>
		</div>
		<div class="box-content">
			<form action="${ctx}/trip/trip/update" modelAttribute="trip" method="post" class="form-horizontal">
				<fieldset>					
					<input type="hidden" id="id" name="id" value="${trip.id}"/>

					<div class="control-group">
						<label class="control-label" for="startDate">行程开始日期</label>
						<div class="controls">
							<input class="input-large datepicker " id="startDate" name="startDate" readonly="readonly"
								type="text" value="<fmt:formatDate value='${trip.startDate}' pattern='yyyy-MM-dd HH:mm:ss'/>">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="endDate">行程结束日期</label>
						<div class="controls">
							<input class="input-large datepicker " id="endDate" name="endDate" readonly="readonly"
								type="text" value="<fmt:formatDate value='${trip.endDate}' pattern='yyyy-MM-dd HH:mm:ss'/>">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="user">user</label>
						<div class="controls">
							<input class="input-large" id="user" name="user" type="text" value="${trip.user}">
							<span class="help-inline"><form:errors path="user"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="created">created</label>
						<div class="controls">
							<input class="input-large datepicker " id="created" name="created" readonly="readonly"
								type="text" value="<fmt:formatDate value='${trip.created}' pattern='yyyy-MM-dd HH:mm:ss'/>">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="modified">modified</label>
						<div class="controls">
							<input class="input-large datepicker " id="modified" name="modified" readonly="readonly"
								type="text" value="<fmt:formatDate value='${trip.modified}' pattern='yyyy-MM-dd HH:mm:ss'/>">
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
