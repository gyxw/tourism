<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div>
	<ul class="breadcrumb">
		<li>
			<a href="${ctx}/">Home</a> <span class="divider">/ trip / 旅游景点</span>
		</li>
	</ul>
</div>

<div class="row-fluid">
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-edit"></i> Form Elements</h2>
		</div>
		<div class="box-content">
			<form action="${ctx}/trip/viewspot/update" modelAttribute="viewSpot" method="post" class="form-horizontal">
				<fieldset>					
					<input type="hidden" id="id" name="id" value="${viewSpot.id}"/>

					<div class="control-group">
						<label class="control-label" for="name">景点名</label>
						<div class="controls">
							<input class="input-large" id="name" name="name" type="text" value="${viewSpot.name}">
							<span class="help-inline"><form:errors path="name"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="picture">picture</label>
						<div class="controls">
							<input class="input-large" id="picture" name="picture" type="text" value="${viewSpot.picture}">
							<span class="help-inline"><form:errors path="picture"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="area">area</label>
						<div class="controls">
							<input class="input-large required" id="area" name="area" type="text" value="${viewSpot.area}">
							<span class="help-inline"><form:errors path="area"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="title">title</label>
						<div class="controls">
							<input class="input-large required" id="title" name="title" type="text" value="${viewSpot.title}">
							<span class="help-inline"><form:errors path="title"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="description">description</label>
						<div class="controls">
							<input class="input-large" id="description" name="description" type="text" value="${viewSpot.description}">
							<span class="help-inline"><form:errors path="description"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="parent">parent</label>
						<div class="controls">
							<input class="input-large" id="parent" name="parent" type="text" value="${viewSpot.parent}">
							<span class="help-inline"><form:errors path="parent"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="clicked">点击数（热度）</label>
						<div class="controls">
							<input class="input-large" id="clicked" name="clicked" type="text" value="${viewSpot.clicked}">
							<span class="help-inline"><form:errors path="clicked"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="star">星级（名气）</label>
						<div class="controls">
							<input class="input-large" id="star" name="star" type="text" value="${viewSpot.star}">
							<span class="help-inline"><form:errors path="star"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="longitude">经度</label>
						<div class="controls">
							<input class="input-large" id="longitude" name="longitude" type="text" value="${viewSpot.longitude}">
							<span class="help-inline"><form:errors path="longitude"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="latitude">纬度</label>
						<div class="controls">
							<input class="input-large" id="latitude" name="latitude" type="text" value="${viewSpot.latitude}">
							<span class="help-inline"><form:errors path="latitude"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="created">created</label>
						<div class="controls">
							<input class="input-large datepicker " id="created" name="created" readonly="readonly"
								type="text" value="<fmt:formatDate value='${viewSpot.created}' pattern='yyyy-MM-dd HH:mm:ss'/>">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="modified">modified</label>
						<div class="controls">
							<input class="input-large datepicker " id="modified" name="modified" readonly="readonly"
								type="text" value="<fmt:formatDate value='${viewSpot.modified}' pattern='yyyy-MM-dd HH:mm:ss'/>">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="visitStartTime">可参观开始时间</label>
						<div class="controls">
							<input class="input-large datepicker " id="visitStartTime" name="visitStartTime" readonly="readonly"
								type="text" value="<fmt:formatDate value='${viewSpot.visitStartTime}' pattern='yyyy-MM-dd HH:mm:ss'/>">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="visitEndTime">可参观截止时间</label>
						<div class="controls">
							<input class="input-large datepicker " id="visitEndTime" name="visitEndTime" readonly="readonly"
								type="text" value="<fmt:formatDate value='${viewSpot.visitEndTime}' pattern='yyyy-MM-dd HH:mm:ss'/>">
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
