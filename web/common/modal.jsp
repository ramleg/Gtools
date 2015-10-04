    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog modal-sm">
          <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4><span class="glyphicon glyphicon-lock"></span>Login</h4>
                </div>
                <div class="modal-body"> 
                    <form role="form" action="login" id="frm-modal">
                        <div class="form-group">
                            <label for="email">User:</label>
                            <input type="text" class="form-control" id="txt-usr" placeholder="Username">
                        </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" id="txt-pwd" placeholder="Password">
                            </div>
                        <button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-log-in"></span> Login</button>
                    </form>     
                </div>
            </div>
        </div>
    </div>
    <!-- Fin Modal -->