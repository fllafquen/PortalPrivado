# language: es
Característica: Validación de DAP en portal privado

  necesitamos validar la toma de DAP en portal privado

  @Regresion
  Escenario: Validar DAP en portal Privado
    Dado Que Francisco entra a portal privado Coopeuch QA
    Cuando Francisco hace logIn con rut: 167241530 y pass: P43210
    Y Francisco ingresa al modulo DAP
    Y Francisco simula DAP con monto: 20000 en un plazo de: 7
    Y Francisco valida el resultado y continua con el proceso
    Y Francisco valida detalle y presiona boton invertir
    Y Francisco confirma la toma de DAP ingresando la pass: Coop0432
    Entonces Francisco deberia ver el mensaje de Exito


  @Regresion
  Escenario: Validar btn Volver paso uno en DAP
    Dado Que Francisco entra a portal privado Coopeuch QA
    Cuando Francisco hace logIn con rut: 167241530 y pass: P43210
    Y Francisco ingresa al modulo DAP
    Y Francisco presiona el boton volver
    Entonces Francisco deberia ver menu de DAP