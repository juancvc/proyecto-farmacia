<head>
      <title></title>
    <!-- AÑADIDO -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src='js_propio/cookies.js'></script>
      <script src='js_propio/funciones.js'></script>
      <script src='js_propio/eventos.js'></script>
    
     
      <meta name="viewport" content="width=device-width, initial-scale=1">
    
      <link rel="stylesheet" type="text/css" href="assets/css/vendor.css">
      <link rel="stylesheet" type="text/css" href="assets/css/flat-admin.css">
    
      <!-- Theme -->
      <link rel="stylesheet" type="text/css" href="assets/css/theme/blue-sky.css">
      <link rel="stylesheet" type="text/css" href="assets/css/theme/blue.css">
      <link rel="stylesheet" type="text/css" href="assets/css/theme/red.css">
      <link rel="stylesheet" type="text/css" href="assets/css/theme/yellow.css">
    
    </head>
    <body>
    <div class="row" id="datosCita">
        <div class="col-md-12">
          <div class="card">
            <div class="card-header">
              Rellene los siguientes datos
            </div>
            <div class="card-body">
              <div class="row"> 
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input class="form-control" id="date" name="date" placeholder="DD/MM/YYYY" type="text"/>
                </div>
              </div>     
              
            </div>
          </div>
            </div>
          </div>
        </div>
        <div class="col-md-12">
          <div class="form-footer">
            <div class="form-group">
              <div class="col-md-9 col-md-offset-3">
                <button type="submit" class="btn btn-primary">Confirmar cita</button>
                <button type="button" class="btn btn-default">Cancelar</button>
              </div>
            </div>
          </div>
        </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    
      </div>
      
      <script type="text/javascript" src="assets/js/vendor.js"></script>
      <script type="text/javascript" src="assets/js/app.js"></script>
       <script src='js_propio/cookies.js'></script>
    
    <!-- Include Date Range Picker -->
    
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <script src="js/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/locales/bootstrap-datepicker.es.min.js"></script>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    
    
    <script>
    
    $(document).ready(function(){
    	  var date_input=$('input[name="date"]'); //our date input has the name "date"
    	  var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    	  date_input.datepicker({
    	    format: 'mm/dd/yyyy',
    	    container: container,
    	    todayHighlight: true,
    	    autoclose: true,
    	    language: 'es'

    	  })
    	})
    </script>