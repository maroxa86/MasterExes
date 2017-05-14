<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
	<body>
		<h1>Ejercicio1 - Upload de ficheros</h1>
		<h4>
			Nombre del fichero : <s:property value="fileUploadFileName" />
		</h4>
		<h4>
			Contenido del fichero : <s:property value="fileUploadContentType" />
		</h4>
		<h4>
			Fichero : <s:property value="fileUpload" />
		</h4>
	</body>
</html>