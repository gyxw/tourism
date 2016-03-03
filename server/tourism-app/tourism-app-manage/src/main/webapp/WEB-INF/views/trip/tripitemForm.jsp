<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div>
	<ul class="breadcrumb">
		<li>
			<a href="${ctx}/">Home</a> <span class="divider">/ trip / 行程清单</span>
		</li>
	</ul>
</div>

<div class="row-fluid">
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-edit"></i> Form Elements</h2>
		</div>
		<div class="box-content">
			<form action="${ctx}/trip/tripitem/update" modelAttribute="tripItem" method="post" class="form-horizontal">
				<fieldset>					
					<input type="hidden" id="id" name="id" value="${tripItem.id}"/>

					<div class="control-group">
						<label class="control-label" for="trip">行程</label>
						<div class="controls">
							<input class="input-large" id="trip" name="trip" type="text" value="${tripItem.trip}">
							<span class="help-inline"><form:errors path="trip"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="viewSpot">景点</label>
						<div class="controls">
							<input class="input-large" id="viewSpot" name="viewSpot" type="text" value="${tripItem.viewSpot}">
							<span class="help-inline"><form:errors path="viewSpot"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="sort">sort</label>
						<div class="controls">
							<input class="input-large" id="sort" name="sort" type="text" value="${tripItem.sort}">
							<span class="help-inline"><form:errors path="sort"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="tripDate">行程日期</label>
						<div class="controls">
							<input class="input-large datepicker " id="tripDate" name="tripDate" readonly="readonly"
								type="text" value="<fmt:formatDate value='${tripItem.tripDate}' pattern='yyyy-MM-dd HH:mm:ss'/>">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="type">类型 1 景点 2 酒店 3 饭店</label>
						<div class="controls">
							<input class="input-large" id="type" name="type" type="text" value="${tripItem.type}">
							<span class="help-inline"><form:errors path="type"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="created">created</label>
						<div class="controls">
							<input class="input-large datepicker " id="created" name="created" readonly="readonly"
								type="text" value="<fmt:formatDate value='${tripItem.created}' pattern='yyyy-MM-dd HH:mm:ss'/>">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="modified">modified</label>
						<div class="controls">
							<input class="input-large datepicker " id="modified" name="modified" readonly="readonly"
								type="text" value="<fmt:formatDate value='${tripItem.modified}' pattern='yyyy-MM-dd HH:mm:ss'/>">
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
