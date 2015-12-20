<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>DataTables example - Ajax sourced data</title>
	<link rel="shortcut icon" type="image/png" href="/media/images/favicon.png">
	<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<style type="text/css" class="init">
		#tabs { 
    padding: 0px; 
    background: none; 
    border-width: 0px; 
} 
#tabs .ui-tabs-nav { 
    padding-left: 0px; 
    background: transparent; 
    border-width: 0px 0px 1px 0px; 
    -moz-border-radius: 0px; 
    -webkit-border-radius: 0px; 
    border-radius: 0px; 
} 
#tabs .ui-tabs-panel { 
    background: #f5f3e5 url(http://code.jquery.com/ui/1.8.23/themes/south-street/images/ui-bg_highlight-hard_100_f5f3e5_1x100.png) repeat-x scroll 50% top; 
    border-width: 0px 1px 1px 1px; 
}
	</style>
        

 <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
      <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
      
	<script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-1.11.3.min.js">
	</script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js">
	</script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js">
	</script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>



	<script type="text/javascript" class="init">



$( "#searchcontainer" ).load("http://localhost:8080/diamondback/upload");
$(function() {
    $( "#tabs" ).tabs();
  });

var processSearch = function(){



  $('#example').DataTable( {
  			"ajax": 'http://localhost:8080/diamondback/search'
		} );

}

	</script>

</head>
<body>



<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Web Query</a></li>
    <li><a href="#tabs-2">Upload Script</a></li>
    <li><a href="#tabs-3">Execute Script</a></li>
  </ul>
  <div id="tabs-1">
    <div class="container">
     <h2>Web Query</h2>
  
    <div class="form-group">
      <label for="email">Hospital:</label>
      <input type="text" class="form-control" id="email" placeholder="Hospital">
    </div>
    <div class="form-group">
      <label for="workstation">Workstation:</label>
      <input type="text" class="form-control" id="pwd" placeholder="Workstation">
    </div>
    <div class="form-group">
	      <label for="procedure_id">Procedure ID:</label>
	      <input type="text" class="form-control" id="pwd" placeholder="Procedure ID">
    </div>
    <div class="form-group">
	      <label for="datetime">Date Time:</label>
	      <input type="workstation" class="form-control" id="pwd" placeholder="Date Time">
    </div>
    <div class="form-group">
		<button type="submit" class="btn btn-default" onclick="processSearch()">Submit</button>
    </div>

     <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
					<thead>
						<tr>
						    <th>ID</th>
							<th>Hospital</th>
							<th>Workstation</th>
							<th>Procedure ID</th>
							<th>Date</th>
							
						</tr>
					</thead>
					<tfoot>
						<tr>
						    <th>ID</th>
							<th>Hospital</th>
							<th>Workstation</th>
							<th>Procedure ID</th>
							<th>Date</th>
							
						</tr>
					</tfoot>
		</table>

     </div>
    
  </div>
  <div id="tabs-2">
     <div id="searchcontainer" class="container"></div>
  </div>
  <div id="tabs-3">
    <h2>Execute Scripts</h2>
    
  </div>
  
</div>




 
</body>
</html>