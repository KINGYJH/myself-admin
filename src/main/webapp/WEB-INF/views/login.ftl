<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="YJH">
        <link rel="shortcut icon" href="[@spring.url '/resources/images/favicon.ico' /]" type="image/x-icon"/>

        <title>myself - 登录</title>

	    <link href="[@spring.url '/resources/css/font-awesome.min.css'/]" rel="stylesheet" type="text/css" />
	    <link href="[@spring.url 'resources/css/bootstrap.min.css'/]" rel="stylesheet" type="text/css" />
	    <link href="[@spring.url 'resources/css/templatemo-style.css'/]" rel="stylesheet" type="text/css" />
	    
        <script src="[@spring.url '/resources/js/html5shiv.min.js'/]" type="text/javascript"></script>
	    <script src="[@spring.url '/resources/js/respond.min.js'/]" type="text/javascript"></script>
	</head>
	<body class="light-gray-bg">
		<div class="templatemo-content-widget templatemo-login-widget white-bg">
			<header class="text-center">
	          <div class="square"></div>
	          <h1>myself Admin</h1>
	        </header>
	        <form action="index.ftl" class="templatemo-login-form">
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-user fa-fw"></i></div>	        		
		              	<input type="text" class="form-control" placeholder="">
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>	        		
		              	<input type="password" class="form-control" placeholder="">
		          	</div>	
	        	</div>	          	
	          	<div class="form-group">
				    <div class="checkbox squaredTwo">
				        <input type="checkbox" id="c1" name="cc" />
						<label for="c1"><span></span>记住我</label>
				    </div>				    
				</div>
				<div class="form-group">
					<button type="submit" class="templatemo-blue-button width-100">登录</button>
				</div>
	        </form>
		</div>
	</body>
</html>