Paula Natalia Paez Vega

Manuel Felipe Barrera Barrera

Andres Felipe Rodriguez Chaparro

•	DESCIPCIÓN PROYECTO

Se creo un proyecto con MAVEN utilizando los siguientes comandos

![image](https://github.com/user-attachments/assets/b0bdab74-91e1-4848-b666-d6977e1272cf)
![image](https://github.com/user-attachments/assets/27d3869c-952a-40ce-ac1d-56e58de1bbb1)
 
•	AGREGAR DEPENDENCIA JUNIT5

Se verificó la versión de Java en el dispositivo donde se realiza el proyecto, en este caso el dispositivo tiene la versión 22.0.2 de Java, esto con el objetivo de colocar la versión correcta en el pom.xml y no generar ningún conflicto en su ejecución.

![image](https://github.com/user-attachments/assets/8795c02a-832b-4ee4-a854-3ee753ba665d)
![image](https://github.com/user-attachments/assets/7c9a557f-0057-4875-ae0d-eb392464380b)

Al compilarlo correctamente nos mostrará estos mensajes.

![image](https://github.com/user-attachments/assets/7dc95701-a32e-4adf-b077-ec455b8e7265)

•	AGREGAR ESQUELETO DEL RPOYECTO

Se crean los paquetes correspondientes del proyecto y sus clases.

![image](https://github.com/user-attachments/assets/f2a5db32-d3d0-45c3-9842-743b5d4414b9)

Dentro de estas se generan las pruebas y el código correspondiente para que se ejecuten correctamente.

![image](https://github.com/user-attachments/assets/b17c0fba-3852-4a3a-a901-96b4259fb9f4)

Se realiza el Pull Request

![image](https://github.com/user-attachments/assets/ebc600ab-18c0-4cfb-af68-c5ce4d0886cf)

•	CREAR CLASE DE PRUEBA

![image](https://github.com/user-attachments/assets/6a150dad-d193-4b3b-83f8-5df8f42c5c9b)

Explore los links del reporte en el cual le muestra que partes del código tienen prueba y cuales no.
 
![image](https://github.com/user-attachments/assets/b62a8166-3e98-495f-9c4c-8e49a5573524)
![image](https://github.com/user-attachments/assets/c82f49bf-581d-4435-8c5b-e318f64f2741)
![image](https://github.com/user-attachments/assets/d933253a-8505-4ef4-be67-27246258a91c)
![image](https://github.com/user-attachments/assets/77a03e48-df94-4c15-af4d-91b87c5d0353)
 
•	SONARQUBE

Se ingresó a http://localhost:9000 e ingresamos usuario:admin, contraseña:admin, esto ya que estamos ingresando por primera vez

![image](https://github.com/user-attachments/assets/af59a62f-cca5-46df-a197-610d7c80bd13)

Se genera el Token de tipo Global Analysis Token, se escogió este tipo ya que puede ser utilizado por todos los usuarios y es generalmente utilizado para integraciones automáticas y de infraestructura.
Este hay que copiarlo y guardarlo en un lugar seguro, ya que al salir de la pestaña no se volverá a mostrar.

![image](https://github.com/user-attachments/assets/1a5f900b-4739-43f1-920d-b382047d638b)
![image](https://github.com/user-attachments/assets/16d91dc9-a927-4399-988b-bf6b66011e9f)

Se genera la integración con sonar.
![image](https://github.com/user-attachments/assets/7f8acaa6-7f27-4a55-8cc3-537cd2b2ea8e)

Acá podemos observar que todo funcionó correctamente.
![image](https://github.com/user-attachments/assets/e89fe23b-5b1a-44e4-a91f-eaa473c0f032)
