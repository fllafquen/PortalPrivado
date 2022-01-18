# language: es
Característica: Validación de DAP en portal privado

   necesitamos validar variantes de pruebas en toma de DAP

  @Regresion
  Escenario: Validar Login en portal Privado
    Dado Que Francisco entra a portal privado Coopeuch QA
    Cuando Francisco ingresa rut: 167241530
    Y Francisco ingresa password: P12345
    Y Francisco presiona boton Ingresar
    Entonces Francisco deberia ver el mensaje de Bienvenida

  Escenario: Validar Login en portal Privado con Clave incorrecta
    Dado Que Francisco entra a portal privado Coopeuch QA
    Cuando Francisco ingresa rut: 167241530
    Y Francisco ingresa password: asd432fgb
    Y Francisco presiona boton Ingresar
    Entonces Francisco deberia ver el mensaje de Error




