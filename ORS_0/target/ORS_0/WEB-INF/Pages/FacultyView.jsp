<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
$(function() {
	$("#date").datepicker({
		/*  beforeShowDay:DisableSunday, */
		changeMonth : true,
		changeYear : true,
		yearRange : '1980:2001',
		/* dateFormat : 'dd-mm-yy',
 */	    /*minDate:0 */
	});
});
</script>
<style type="text/css">
 body {
	background-image: url("/ORS_0/resources/img/yellow-orange-pink-and-blue-coloring-pens-on-white-notebook-998591.jpg");
    background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
} 
</style>
</head>
<body>
<sf:form method="post" modelAttribute="form">
<div class="container-fluid" align="center"  >

<aside class="col-sm-4">

<div class="card shadow"  align="center">
<article class="card-body">

<c:choose>
<c:when test="${form.id==0}"><h4 class="card-title text-center mb-4 mt-1" style="color: #C71585;"><s:message code="label.addfaculty" /></h4>
</c:when>
<c:otherwise>
<h4 class="card-title text-center mb-4 mt-1" style="color: #C71585;"><s:message code="label.updatefaculty"></s:message></h4>
</c:otherwise>
</c:choose> 



			<hr>
	
						 <c:if test="${success != null}">
  <div class="alert alert-success alert-dismissible fade show">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <b>${success}</b>
  </div>
  </c:if>
 
 <c:if test="${error != null}">
   <div class="alert alert-danger alert-dismissible fade show">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
     <b>${error}</b>
  </div>
  </c:if>
  
   <sf:hidden path="id" />
				<sf:hidden path="createdBy" />
				<sf:hidden path="modifiedBy" />
				<sf:hidden path="createdDatetime" />
				<sf:hidden path="modifiedDatetime" />
    
 	
	<div class="form-group"> 
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.firstName" />
				<span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fas fa-user"></i> </span></div>
		  
  <!--   <input type="text" name="fname" class="form-control" placeholder="first name" value="">
	 -->	
	 <sf:label path="firstName">
						<c:set var="firstNameErrors">
								</c:set>
					<c:if test="${not empty firstNameErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tfirstName')"
							onmouseout="hideError('tfirstName')"></i>
					</c:if>
	</sf:label>
				<sf:input path="firstName" class="form-control"
					placeholder="${enterfirstName}" />

	 </div>
	<div align="left"><font style="color: red" ><sf:errors path="firstName" />
			</font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.lastName" />
				<span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-user"></i></i> </span></div>
		 
  
	<sf:label path="lastName">
						<c:set var="lastNameErrors">
								</c:set>
					<c:if test="${not empty lastNameErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tlastName')"
							onmouseout="hideError('tlastName')"></i>
					</c:if>
								</sf:label>
				<sf:input path="lastName" class="form-control"
					placeholder="${enterLastName}"/>
				
		
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="lastName" />
			</font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.gender"/>
			<span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class='fas fa-venus-double'></i></span></div>
		 
  <sf:label path="gender">
							<c:set var="genderErrors">
								</c:set>
					<c:if test="${not empty genderErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tgender')"
							onmouseout="hideError('tgender')"></i>
					</c:if>
						</sf:label>
				<sf:select path="gender" class="form-control">
					<sf:option value=""><s:message code="label.selectgender"/></sf:option>
					<sf:option value="M" label="Male"></sf:option>
					<sf:option value="F" label="Female"></sf:option>
				</sf:select> 
				
		
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="gender"/>
			</font></div>
	
	</div>
		
	<div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.emailId" />
				<span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-envelope"></i> </span></div>
		 
    <sf:label path="emailId">
						<c:set var="emailIdErrors">
							</c:set>
					<c:if test="${not empty emailIdErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('temailId')"
							onmouseout="hideError('temailId')"></i>
					</c:if>
								</sf:label>
				<sf:input path="emailId" class="form-control"
					placeholder="${enteremail}" />
			
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="emailId"/>
				</font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.dob" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class='fas fa-calendar-alt'></i></span></div>
		 
   <sf:label path="dob">
					
					<c:set var="dobErrors">
						
					</c:set>
					<c:if test="${not empty dobErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tdob')" onmouseout="hideError('tdob')"></i>
					</c:if>
									</sf:label>
				<sf:input path="dob" class="form-control" id="date" readonly="readonly"
					placeholder="${enterdob}" autocomplete="off" />
		
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="dob" /></font></div>
	
	</div>
	<div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.mobileNo" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class='fas fa-mobile-alt'></i></span></div>
	<sf:label path="mobileNo">
					
					<c:set var="mobileNoErrors">
						
					</c:set>
					<c:if test="${not empty mobileNoErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tmobileNo')"
							onmouseout="hideError('tmobileNo')"></i>
					</c:if>
						</sf:label>
				<sf:input path="mobileNo" class="form-control"
					placeholder="${enterMobile}" />
				</div>
	<div align="left"><font style="color: red" ><sf:errors path="mobileNo" /></font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.college"/>
				<span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fa fa-university"></i> </span></div>
		 
    <sf:label path="collegeId">
						<c:set var="collegeIdErrors">
									</c:set>
					<c:if test="${not empty collegeIdErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tcollegeId')"
							onmouseout="hideError('tcollegeId')"></i>
					</c:if>
								</sf:label>
				<sf:select path="collegeId" class="form-control">
					<sf:option value="0"><s:message code="label.selectcollege"/></sf:option>
					<sf:options items="${collegeList}" itemValue="id" itemLabel="name"/>
				</sf:select> 
			
	 </div>
	<div align="left"><font style="color: red" ><sf:errors path="collegeId"/>
		</font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.course"/><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fa fa-book"></i> </span></div>
		 
  <sf:label path="courseId">
					
					<c:set var="courseIdErrors">
							</c:set>
					<c:if test="${not empty courseIdErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tcourseId')"
							onmouseout="hideError('tcourseId')"></i>
					</c:if>
							</sf:label>
				<sf:select path="courseId" class="form-control">
					<sf:option value="0"><s:message code="label.selectcourse"/></sf:option>
					<sf:options items="${courseList}" itemValue="id" itemLabel="name"/>
				</sf:select> 
			</div>
	<div align="left"><font style="color: red" ><sf:errors path="courseId"/>
				</font></div>
	
	</div>
	
	
	<div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.subject"/>
			<span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fa fa-copy"></i> </span></div>
		 
    <sf:label path="subjectId">
							<c:set var="subjectIdErrors">
						
					</c:set>
					<c:if test="${not empty subjectIdErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tsubjectId')"
							onmouseout="hideError('tsubjectId')"></i>
					</c:if>
								</sf:label>
				<sf:select path="subjectId" class="form-control">
					<sf:option value="0"><s:message code="label.selectsubject"/></sf:option>
					<sf:options items="${subjectList}" itemValue="id" itemLabel="name"/>
				</sf:select> 
				
			 	
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="subjectId"/></font></div>
	
	</div>
		
	<c:choose>
              		<c:when test="${form.id==0}"> 
				
	 <button type="submit" name="operation" style="float: left;width: 80px; margin-left: 50px;"  value="save"  class="btn btn-primary btn-block button2 msgBtn" ><s:message code="label.save"/></button>
		 
	
	<button type="submit" name="operation" style="width: 80px;margin-left: 150px;" value="reset"  class="btn btn-primary btn-block button2" ><s:message code="label.reset"/></button>
	
	</c:when>
						<c:otherwise>
						
	 <button type="submit" name="operation" style="float: left;width: 80px; margin-left: 50px;"  value="save"  class="btn btn-primary btn-block button2 msgBtn" ><s:message code="label.update"/></button>
		 
	
	<button type="submit" name="operation" style="width: 80px;margin-left: 150px;" value="Cancel"  class="btn btn-primary btn-block button2" ><s:message code="label.cancel"/></button>
	</c:otherwise>
				</c:choose>
	
	
	
		 
		
   </article>
</div>

	</aside>
</div> 



</sf:form>
</body>
<br><br><br>
</html>