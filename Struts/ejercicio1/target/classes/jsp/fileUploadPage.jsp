<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Ejercicio1 - Upload de ficheros</title>
</head>
<body>

<div id="carta">									
	<h1>Ejercicio1 - Upload de ficheros</h1>
	<s:form method="post" action="UploadFileAction" enctype="multipart/form-data">
		<s:file name="fileUpload" label="Fichero"/>
		<s:submit value="Subir Fichero"/>
	</s:form>
	
</div>
</body>
</html>
