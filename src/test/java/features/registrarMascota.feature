Feature: Pruebas del API PET STORE

  @smokeTest
  Scenario: Registrar nueva mascota en la tienda
    Then Validar el servicio del registro de una mascota
      | body                | exp | escenario       |
      | agregarMascota.json | 200 | Agregar Mascota |

  @smokeTest
  Scenario: Registrar nueva mascota en la tienda y validar el response
    Then Verifico los mandatorios del request del servicio
      | body                | exp | escenario           | status |
      | agregarMascota.json | 200 | Registro de Mascota | sold   |

