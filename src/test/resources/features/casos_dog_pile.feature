# language: es
Característica: Validación de Login en portal privado

   necesitamos validar variantes de pruebas en Login

  @Regresion
  Escenario: Validar Login en portal Privado
    Dado Que Francisco entra a portal privado Coopeuch QA
    Cuando Francisco ingresa rut: 167241530
    Y Francisco ingresa password: Coop0432
    Y Francisco presiona boton Ingresar
    Entonces Francisco deberia ver el mensaje de Bienvenida





