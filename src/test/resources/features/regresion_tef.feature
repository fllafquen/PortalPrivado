# language: es
Característica: Validación de TEF en portal privado

  necesitamos validar variantes de pruebas en TEF

  @Regresion
  Escenario: Validar TEF a tercero en portal Privado
    Dado Que Francisco entra a portal privado Coopeuch QA
    Cuando Francisco hace logIn con rut: 167241530 y pass: P43210
    Y Francisco ingresa al modulo TEF
    Y Francisco selecciona primer destinatario terceros
    Y Francisco presiona boton continuar
    Y Francisco ingresa monto: 1500 con mensaje: Test
    Y Francisco autoriza con coordenadas de cliente: 167241530
    Entonces Francisco deberia ver el comprobante de la transaccion
