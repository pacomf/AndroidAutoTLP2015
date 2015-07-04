# Android Auto TLP2015
Aplicación de Mensajería de ejemplo para el Taller de Android Auto

<a href="http://www.gdgtenerife.com">
  <p align="center">
    <img alt="Android Auto" src="https://upload.wikimedia.org/wikipedia/commons/3/3e/Android_Auto_logo.png" />
  </p>
</a>

<a href="http://www.gdgtenerife.com">
  <p align="center">
    <img alt="GDG Tenerife" src="http://andensinlimite.org/wp-content/uploads/2014/11/unnamed.png" />
  </p>
</a>

<a href="http://tlp-tenerife.com/tlpinnova/desarrolladores/">
  <p align="center">
    <img alt="TLP" src="http://elcholloinformatico.com/wp-content/uploads/2015/05/TLP_vertical.png" height="535" width="390" />
  </p>
</a>


## Configuración

En caso de que no se tenga un dispositivo Android Auto real, se deberá instalar el simulador de Android Auto en el mismo dispositivo que se vaya a utilizar esta app. Este apk a instalar (el simulador) está dentro de la carpeta (<sdk>/extras/google/simulators/messaging-simulator.apk). 
Para más info: https://developer.android.com/training/auto/start/index.html

## Funcionamiento

- Se arranca el simulador de Android Auto (en caso de que se use el simulador)
- Se arranca la app (este proyecto), y se generarán las notificaciones de forma automatica.
- Se vuelve a lanzar el simulador (en caso de que se use el simulador)
- Se pueden observar las notificaciones de la app en Android Auto. Si se pincha en ellas se podrá escuchar una voz que las leerá.
- Se puede pulsar el botón de responder y se enviará una respuesta preconfigurada a la app desde el Simulador. Si es el dispositivo real, se podrá responder mediante la voz.
- La app empezará a leer la respuesta lanzada desde Android Auto
