Feature: Pruebas del servicio Negocio descripcion del feature

  # POST /api/users
  Scenario: Validar servicio NE producto POST crear usuario
    Then Validar servicio NE producto POST crear usuario
      | body                                 | exp | escenario       |
      | {"name": "morpheus","job": "leader"} | 201 | Creando usuario |
