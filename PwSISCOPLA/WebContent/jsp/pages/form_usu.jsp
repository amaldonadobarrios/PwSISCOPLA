<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="card">
                    <div class="card-body wizard-content">
                        <h4 class="card-title">${breadcrumb}</h4>
                        
                        <c:if test="${msg!=null}">
					<div class="alert alert-info" align="center">
						<strong>${msg}</strong> 
					</div>
				</c:if>
                        <h6 class="card-subtitle"></h6>
                        <form id="example-form" action="SUsuario" class="m-t-40" method="post"> 
                            <div>
                                <h3>Cuenta</h3>
                                <section>
                                	<input id="hdEvento" name="hdEvento" type="hidden" value="AGREGAR_USUARIO">
                                 	<input id="idusu" name="txtid" type="hidden" value="${Usuario.idUsuario}">
                                    <label for="userName">N° de CIP *</label>
                                    <input id="userName" name="txtcip" type="text" class="required form-control" maxlength="8" value="${Usuario.cip}">
                                    <label for="password">Password *</label>
                                    <input id="password" name="password" type="password" class="required form-control" maxlength="8" value="${Usuario.password}">
                                    <label for="confirm">Confirm Password *</label>
                                    <input id="confirm" name="confirm" type="password" class="required form-control" value="${Usuario.password}">
                                    <label for="address">Perfil</label>
                                    <input type="hidden" id="txtperfil" value="${Usuario.perfil}">
                                    <select id="perfil" name="perfil" class="required  form-control">
                                    <option data-tokens="ketchup mustard" value="" >Seleccione</option>
									<option data-tokens="ketchup mustard" value="1">Usuario</option>
									<option data-tokens="ketchup mustard" value="2">Administrador</option>
									</select>
									<label for="address">Estado</label>
									<input type="hidden" id="txtestado" value="${Usuario.estado}">
                                    <select id="estado" name="estado" class="required  form-control">
                                    <option data-tokens="ketchup mustard" value="1" >Activo</option>
									<option data-tokens="ketchup mustard" value="2">Desactivado</option>
									</select>
                                    <p>(*) Obligatorio</p>
                                </section>
                                <h3>Datos Personales</h3>
                                <section>
                                    <label for="name">Apellido Paterno</label>
                                    <input id="name" name="apepat" type="text" class="required form-control" value="${Usuario.apepat}">
                                    <label for="surname">Apellido Materno</label>
                                    <input id="surname" name="apemat" type="text" class="required form-control" value="${Usuario.apemat}">
                                    <label for="email">Nombres</label>
                                    <input id="email" name="nombre" type="text" class="required  form-control" value="${Usuario.nombres}">
                                    <label for="address">Grado</label>
                                    <input type="hidden" id="txtgrado" value="${Usuario.grado}">
                                    <select id="grado" name="grado" class="required  form-control">
                                    <option data-tokens="ketchup mustard" value="" >Seleccione</option>
									<option data-tokens="ketchup mustard" value="CRNL PNP">CRNL PNP</option>
									<option data-tokens="ketchup mustard" value="CMDTE PNP">CMDTE PNP</option>
									<option data-tokens="ketchup mustard" value="MAY PNP">MAY PNP</option>
									<option data-tokens="ketchup mustard" value="SS PNP">SS PNP</option>
									<option data-tokens="ketchup mustard" value="SB PNP">SB PNP</option>
									<option data-tokens="ketchup mustard" value="ST1 PNP">ST1 PNP</option>
									<option data-tokens="ketchup mustard" value="ST2 PNP">ST2 PNP</option>
									<option data-tokens="ketchup mustard" value="ST3 PNP">ST3 PNP</option>
									<option data-tokens="ketchup mustard" value="S1 PNP">S1 PNP</option>
									<option data-tokens="ketchup mustard" value="S2 PNP">S2 PNP</option>
									<option data-tokens="ketchup mustard" value="S3 PNP">S3 PNP</option>
									</select>
                                    <p>(*) Obligatorio</p>
                                </section>
                            </div>
						</form>
                    </div>
                
                </div>
                <div class="card-body" align="center">
                <a href="SPage?action=regusu"><input  class="button" type="button" value="NUEVO USUARIO"></a> </div>
<div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Lista de Usuarios</h5>
                                <div class="table-responsive">
                                    <table id="zero_config" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Apellidos y Nombres</th>
                                                <th>Grado</th>
                                                <th>CIP</th>
                                                <th>Perfil</th>
                                                <th>Estado</th>
                                                <th>Opciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                           <c:forEach items="${lista}" var="element">    
											  <tr>
											    <td>${element.apepat}</td>
											    <td>${element.grado}</td>
											    <td>${element.cip}</td>
											    <td>
											    <c:choose>
											      <c:when test="${element.perfil==1}">
											      Usuario
											     </c:when>
											      <c:otherwise>Administrador
											      </c:otherwise>
											    </c:choose>
											    </td>
											    <td>
											    <c:choose>
											      <c:when test="${element.estado==1}">
											      Activo
											     </c:when>
											      <c:otherwise>Desactivado
											      </c:otherwise>
											    </c:choose>
											    </td>
											    <td><a href="SUsuario?hdEvento=BUSCAR_USUARIO&idusu=${element.idUsuario}">Seleccionar</a></td>
											  </tr>
											</c:forEach>
                                        </tbody>
<!--                                         <tfoot> -->
<!--                                             <tr> -->
<!--                                                 <th>Name</th> -->
<!--                                                 <th>Position</th> -->
<!--                                                 <th>Office</th> -->
<!--                                                 <th>Age</th> -->
<!--                                                 <th>Start date</th> -->
<!--                                             </tr> -->
<!--                                         </tfoot> -->
                                    </table>
                                </div>

                            </div>
                        </div>
                        
<script>
function formSubmit()
{
	var idusu=$( "#idusu" ).val();
   if (idusu!='') {
	   $( "#hdEvento" ).val('MODIFICAR_USUARIO'); 
	}
	document.getElementById("example-form").submit();
} 
window.onload = function() {
document.getElementById("perfil").value= document.getElementById("txtperfil").value;
document.getElementById("estado").value= document.getElementById("txtestado").value;
document.getElementById("grado").value= document.getElementById("txtgrado").value;
}


</script>                        