# Usa la imagen base oficial de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR generado en la carpeta del contenedor
COPY target/*.jar app.jar

# Exponer el puerto en el que el servicio está escuchando
# Asegúrate de que coincida con el puerto configurado en tu aplicación
EXPOSE 8082

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
