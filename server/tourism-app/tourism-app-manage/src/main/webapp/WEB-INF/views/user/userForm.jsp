<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div>
	<ul class="breadcrumb">
		<li>
			<a href="${ctx}/">Home</a> <span class="divider">/ user / 用户</span>
		</li>
	</ul>
</div>

<div class="row-fluid">
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-edit"></i> Form Elements</h2>
		</div>
		<div class="box-content">
			<form action="${ctx}/user/user/update" modelAttribute="user" method="post" class="form-horizontal">
				<fieldset>					
					<input type="hidden" id="id" name="id" value="${user.id}"/>

					<div class="control-group">
						<label class="control-label" for="loginName">loginName</label>
						<div class="controls">
							<input class="input-large required" id="loginName" name="loginName" type="text" value="${user.loginName}">
							<span class="help-inline"><form:errors path="loginName"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">password</label>
						<div class="controls">
							<input class="input-large required" id="password" name="password" type="text" value="${user.password}">
							<span class="help-inline"><form:errors path="password"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="salt">salt</label>
						<div class="controls">
							<input class="input-large" id="salt" name="salt" type="text" value="${user.salt}">
							<span class="help-inline"><form:errors path="salt"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="mobile">mobile</label>
						<div class="controls">
							<input class="input-large" id="mobile" name="mobile" type="text" value="${user.mobile}">
							<span class="help-inline"><form:errors path="mobile"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="sex">sex</label>
						<div class="controls">
							<input class="input-large" id="sex" name="sex" type="text" value="${user.sex}">
							<span class="help-inline"><form:errors path="sex"/></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="nickName">nickName</label>
						<div class="controls">
							<input class="input-large" id="nickName" name="nickName" type="text" value="${user.nickName}">
							<span class="help-inline"><form:errors path="nickName"/></span>
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
