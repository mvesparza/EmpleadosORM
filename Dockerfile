# Usar una imagen base de OpenJDK 17 (porque tu proyecto está usando Java 17)
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR compilado desde el directorio 'target' de tu proyecto al contenedor
COPY target/empleado-0.0.1-SNAPSHOT.jar /app/empleado.jar

# Exponer el puerto en el que el servicio estará disponible (puerto 8080 por defecto, cambia si es necesario)
EXPOSE 8083

# Definir el comando para ejecutar la aplicación cuando el contenedor se inicie
ENTRYPOINT ["java", "-jar", "empleados.jar"]
