
<form action="${pageContext.request.contextPath}/ServletController?action=update&idCustomer=${customer.idCliente}" method="post" class="was-validated" >
    <jsp:include page="/WEB-INF/pages/commons/NavButtonsEdit.jsp"/>
    <section id="details">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-header">
                            <h3>Edit Customer</h3>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" name="name" value="${customer.nombre}" required>                        
                            </div>
                            <div class="form-group">
                                <label for="surname">Surname</label>
                                <input type="text" class="form-control" name="surname" value="${customer.apellido}" required>                        
                            </div>
                            <div class="form-group">
                                <label for="email">e-mail</label>
                                <input type="email" class="form-control" name="email" value="${customer.email}" required>                        
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone</label>
                                <input type="tel" class="form-control" name="phone" value="${customer.telefono}" required>                        
                            </div>
                            <div class="form-group">
                                <label for="balance">Balance</label>
                                <input type="number"  class="form-control" name="balance" value="${customer.saldo}" required step="any">
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>                                
        </div>
    </section>
</form>
