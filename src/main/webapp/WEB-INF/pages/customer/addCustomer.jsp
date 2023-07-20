

<div class="modal fade" id="addCustomerModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Add Customer</h5>
                <button class="close" data-bs-dismiss="modal"><span>&times;</span>
            </div>
            <form action="${pageContext.request.contextPath}/ServletController?action=create" method="post" class="was-validated" >
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" name="name" required>                        
                    </div>
                    <div class="form-group">
                        <label for="surname">Surname</label>
                        <input type="text" class="form-control" name="surname" required>                        
                    </div>
                    <div class="form-group">
                        <label for="email">e-mail</label>
                        <input type="email" class="form-control" name="email" required>                        
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="tel" class="form-control" name="phone" required>                        
                    </div>
                    <div class="form-group">
                        <label for="balance">Balance</label>
                        <input type="number"  class="form-control" name="balance" required>                        
                    </div>                    
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>